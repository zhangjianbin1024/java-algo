package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSortTest {

    @Test
    public void quickSort() {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        QuickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void quickSort2() {
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

        QuickSort.quickSort(arr, 0, arr.length - 1);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }
}