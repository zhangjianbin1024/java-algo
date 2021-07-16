package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergetSortTest {

    @Test
    public void mergeSort1() {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2,0,90}; //
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        MergetSort.mergeSort(arr, 0, arr.length - 1, temp);


        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void mergeSort2() {
        //测试快排的执行速度
        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        MergetSort.mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }

}