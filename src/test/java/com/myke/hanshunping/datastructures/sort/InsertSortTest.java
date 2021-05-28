package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSortTest {

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