package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSortTest {

    /**
     * ��������ĺ���˼��ʱ���������Ԫ����������Ԫ�ص����һ��Ԫ���ȱȽϣ�
     * ���С����������Ԫ�ؼ����͵����ڶ���Ԫ�رȽϣ��������ƣ��ҵ����ʵĲ���λ��
     */
    @Test
    public void insertSort0() {
        int[] arr = {101, 34, 119, 1};
        //ʹ�����Ƶ��ķ�ʽ�����⣬�������
        //��1�� {101, 34, 119, 1};  => {34, 101, 119, 1}


        //{101, 34, 119, 1}; => {101,101,119,1} // �� 34 Ԫ���ѱ�������ʱ�������� insertVal
        //������������
        int insertVal = arr[1];
        int insertIndex = 1 - 1; //��arr[1]��ǰ����������±�

        //��insertVal �ҵ������λ��
        //˵��
        //1. insertIndex >= 0 ��֤�ڸ�insertVal �Ҳ���λ�ã���Խ��
        //2. insertVal < arr[insertIndex] insertValС����ǰ���Ԫ�أ�˵�� �������������û���ҵ�����λ��
        //3. ����Ҫ�� arr[insertIndex] ����
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
            insertIndex--; // Ϊ��ʵ��insertVal ������ǰ���Ԫ�ؽ��в��ϵıȽϣ��ҵ����ʵĲ���λ��
        }
        //���˳�whileѭ��ʱ��˵�������λ���ҵ�, insertIndex + 1
        //��������ⲻ�ˣ�����һ�� debug
        arr[insertIndex + 1] = insertVal;

        System.out.println("��1�ֲ���");
        System.out.println(Arrays.toString(arr));

        //��2��
        insertVal = arr[2];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;
        System.out.println("��2�ֲ���");
        System.out.println(Arrays.toString(arr));


        //��3��
        insertVal = arr[3];
        insertIndex = 3 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;
        System.out.println("��3�ֲ���");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void insertSort() {
        int[] arr = {101, 34, 119, 1, -1, 89};

        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));

        InsertSort.insertSort(arr); //���ò��������㷨

        System.out.println("�����");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void insertSort2() {
        // ����Ҫ��80000�������������
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }

        System.out.println("��������ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        InsertSort.insertSort(arr); //���ò��������㷨

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
    }
}