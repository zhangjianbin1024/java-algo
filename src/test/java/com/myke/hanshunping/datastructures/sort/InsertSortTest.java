package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSortTest {

    /**
     * 插入排序的核心思想时，待插入的元素先与有序元素的最后一个元素先比较，
     * 如果小于则待插入的元素继续和倒数第二个元素比较，依次类推，找到合适的插入位置
     */
    @Test
    public void insertSort0() {
        int[] arr = {101, 34, 119, 1};
        //使用逐步推导的方式来讲解，便利理解
        //第1轮 {101, 34, 119, 1};  => {34, 101, 119, 1}


        //{101, 34, 119, 1}; => {101,101,119,1} // 而 34 元素已保存在临时变量里了 insertVal
        //定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1; //即arr[1]的前面这个数的下标

        //给insertVal 找到插入的位置
        //说明
        //1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
        //2. insertVal < arr[insertIndex] insertVal小于它前面的元素，说明 待插入的数，还没有找到插入位置
        //3. 就需要将 arr[insertIndex] 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
            insertIndex--; // 为了实现insertVal 能与它前面的元素进行不断的比较，找到合适的插入位置
        }
        //当退出while循环时，说明插入的位置找到, insertIndex + 1
        //举例：理解不了，我们一会 debug
        arr[insertIndex + 1] = insertVal;

        System.out.println("第1轮插入");
        System.out.println(Arrays.toString(arr));

        //第2轮
        insertVal = arr[2];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;
        System.out.println("第2轮插入");
        System.out.println(Arrays.toString(arr));


        //第3轮
        insertVal = arr[3];
        insertIndex = 3 - 1;

        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
            insertIndex--;
        }

        arr[insertIndex + 1] = insertVal;
        System.out.println("第3轮插入");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void insertSort() {
        int[] arr = {101, 34, 119, 1, -1, 89};

        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        InsertSort.insertSort(arr); //调用插入排序算法

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void insertSort2() {
        // 创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("插入排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        InsertSort.insertSort(arr); //调用插入排序算法

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }
}