package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSortTest {

    @Test
    public void selectSort1() {
        int[] arr = {101, 34, 119, 1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        //使用逐步推导的方式来，讲解选择排序
        //第1轮
        //原始的数组 ： 	101, 34, 119, 1
        //第一轮排序 :   	1, 34, 119, 101
        //算法 先简单--》 做复杂， 就是可以把一个复杂的算法，拆分成简单的问题-》逐步解决

        //第1轮，找到最小值，并将最小值放到索引 0 的位置，索引0位置的值放到其他位置上
        int minIndex = 0;//最小值的索引
        int min = arr[0];//先假设第 0 个元素为最小的
        for (int j = 0 + 1; j < arr.length; j++) { // 0+1 是因为先假设第 0 个元素为最小的，所以要从第 1个元素开始比较
            if (min > arr[j]) { //说明假定的最小值，并不是最小
                min = arr[j]; //重置min
                minIndex = j; //重置minIndex
            }
        }


        //将最小值，放在arr[0], 即交换
        if (minIndex != 0) {
            // 通过 minIndex，即最小值的索引位置的值设置为 arr[0] 的值
            arr[minIndex] = arr[0];
            // arr[0] 的值设置为从上面找到的最小值
            arr[0] = min;
        }

        System.out.println("第1轮后~~");
        System.out.println(Arrays.toString(arr));// 1, 34, 119, 101


        //第2轮
        minIndex = 1;
        min = arr[1];
        for (int j = 1 + 1; j < arr.length; j++) {
            if (min > arr[j]) { // 说明假定的最小值，并不是最小
                min = arr[j]; // 重置min
                minIndex = j; // 重置minIndex
            }
        }

        // 将最小值，放在arr[0], 即交换
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("第2轮后~~");
        System.out.println(Arrays.toString(arr));// 1, 34, 119, 101

        //第3轮
        minIndex = 2;
        min = arr[2];
        for (int j = 2 + 1; j < arr.length; j++) {
            if (min > arr[j]) { // 说明假定的最小值，并不是最小
                min = arr[j]; // 重置min
                minIndex = j; // 重置minIndex
            }
        }

        // 将最小值，放在arr[0], 即交换
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("第3轮后~~");
        System.out.println(Arrays.toString(arr));// 1, 34, 101, 119 */

    }

    @Test
    public void selectSort2() {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        SelectSort.selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));


    }

    @Test
    public void selectSort3() {
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        SelectSort.selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }
}