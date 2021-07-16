package com.myke.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EncodingUtil {


    /**
     * 将原正确编码的字符串src，转化为编码为destCharet的字符串
     * <p>
     * 前提是：确保原字符串的编码是无损（完整的）. 无需知道原字符串的具体编码，
     * 转化为目标编码的字符串由java库自动实现，无需自己手动实现。
     * <p>
     * 如果原编码字符串不能转化为目标编码，将会抛出UnsupportedEncodingException
     *
     * @param src
     * @param destCharet
     *
     * @return 转换后的字符串
     *
     * @throws UnsupportedEncodingException
     */
    public static String convertEncoding_Str(String src, String destCharet)
            throws UnsupportedEncodingException {
        byte[] bts = src.getBytes(destCharet);
        return new String(bts, destCharet);
    }


    /**
     * 将编码为srcCharset的字节数组src转化为编码为destCharet的字节数组
     *
     * @param src
     * @param srcCharset
     * @param destCharet
     *
     * @return
     *
     * @throws UnsupportedEncodingException
     */
    public static byte[] convertEncoding_ByteArr(byte[] src, String srcCharset, String destCharet)
            throws UnsupportedEncodingException {
        String s = new String(src, srcCharset);
        return s.getBytes(destCharet);
    }


    /**
     * 将字节数组byteArr转化为2位16进制字符串,每个16进制之间用空格分割
     *
     * @param byteArr
     *
     * @return
     */
    public static String byteToHex(byte... byteArr) {
        if (null == byteArr || byteArr.length == 0)
            return "";
        StringBuffer sb = new StringBuffer();
        String tmp = null;

        for (byte b : byteArr) {

            tmp = Integer.toHexString(b);
            // 切记：byte进行运算时，会自动转化为int，否则可能会出错
            if (b >>> 31 == 1) { // 最高位为1，负数
                sb.append(tmp.substring(6));
            } else { // 最高位为0，正数
                if (tmp.length() < 2)
                    sb.append('0');
                sb.append(tmp);
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1); // delete last space
        return sb.toString();
    }


    // BOM UTF-8编码 ： EF BB BF
    public static boolean isUTF8Encoding_BOM(String path) throws IOException {

        FileInputStream fis = new FileInputStream(path);

        int count = 0;
        int data = 0;

        boolean result = false;
        int bn = 2;

        try {
            while ((data |= fis.read() << bn * 8) != -1) {
                ++count;
                --bn;
                if (count >= 3)
                    break;
            }

            if (count >= 3)
                if (data == 0xEFBBBF) //bom
                    result = true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw e;
        } finally {
            try {
                fis.close();
                fis = null;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 文件编码的转换工具
     *
     * @param srcFilePath
     * @param srcCharset
     * @param destFilePath
     * @param destCharset
     * @param isDeleteSrc
     *
     * @return
     *
     * @throws IOException
     */
    public static int convertFileEncoding(String srcFilePath, String srcCharset,
                                          String destFilePath, String destCharset,
                                          boolean isDeleteSrc) throws IOException {
        if (srcFilePath == null || srcFilePath.length() == 0)
            throw new IllegalArgumentException("srcFilePath is empty.");
        if (destFilePath == null || destFilePath.length() == 0)
            throw new IllegalArgumentException("destFilePath is empty.");
        if (srcFilePath.equalsIgnoreCase(destFilePath))
            throw new IllegalArgumentException("srcFilePath is the same as destFilePath");

        if (srcCharset == null || srcCharset.length() == 0)
            throw new IllegalArgumentException("srcCharset is empty.");
        if (destCharset == null || destCharset.length() == 0)
            throw new IllegalArgumentException("destCharset is empty.");

        if (srcCharset.equalsIgnoreCase(destCharset)) // 编码相同，无需转换
            return 0;

        File srcFile = new File(srcFilePath);

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;

        try {
            fis = new FileInputStream(srcFile);
            isr = new InputStreamReader(fis, srcCharset);

            // BufferedReader中defaultCharBufferSize = 8192.
            // 即：8192 × 2 byte = 16k
            // 若是utf-8,中文占3个字节，16K / 3  = 5461，即只要每行中文字符数 < 5461,读取的行数就是准确的，
            // 否则，可能会截断一行，多写入'\n',但这种情况一般不存在。
            // 如果源文件中最后一行没有换行符，转码后的文件最后会多写入一个换行符
            br = new BufferedReader(isr);

            // 以UTF-8格式写入文件,file.getAbsolutePath()即该文件的绝对路径,false代表不追加直接覆盖,true代表追加文件
            fos = new FileOutputStream(destFilePath, false);
            osw = new OutputStreamWriter(fos, destCharset);

            String str = null;

            // 创建StringBuffer字符串缓存区
            StringBuffer sb = new StringBuffer();
            int lines = 0;

            // 通过readLine()方法遍历读取文件
            while ((str = br.readLine()) != null) {
                // 使用readLine()方法无法进行换行,需要手动在原本输出的字符串后面加"\n"或"\r"
                sb.append(str).append('\n');
                osw.write(sb.toString());
                osw.flush();
                lines++;
            }

            if (isDeleteSrc) {
                if (srcFile.delete())
                    System.out.println(srcFile.getAbsolutePath() + " file is already deleted.");
                else
                    System.out.println(srcFile.getAbsolutePath() + " file delete fail.");
            }

//		System.out.println(lines);
            return lines;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
//		e.printStackTrace();
            throw e;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            throw e;
        } catch (IOException e) {
            // TODO: handle exception
            throw e;
        } finally {
            // 与同一个文件关联的所有输出流(输入流)，只需关闭一个即可
            if (null != fis)
                try {
                    fis.close();
                    fis = null;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            if (null != fos)
                try {
                    fos.close();
                    fos = null;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }

    /**
     * 获取路径下的所有文件/文件夹
     *
     * @param directoryPath  需要遍历的文件夹路径
     * @param isAddDirectory 是否将子文件夹的路径也添加到list集合中
     *
     * @return
     */
    public static List<String> getAllFile(String directoryPath, boolean isAddDirectory) {
        List<String> list = new ArrayList<String>();
        File baseFile = new File(directoryPath);
        if (baseFile.isFile() || !baseFile.exists()) {
            return list;
        }
        File[] files = baseFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                if (isAddDirectory) {
                    list.add(file.getAbsolutePath());
                }
                list.addAll(getAllFile(file.getAbsolutePath(), isAddDirectory));
            } else {
                list.add(file.getAbsolutePath());
            }
        }
        return list;
    }
}

