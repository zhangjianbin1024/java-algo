package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSortTest {

    @Test
    public void radixSort() {
        int arr[] = {53, 3, 542, 748, 14, 214};
        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));
        RadixSort.radixSort(arr);
        System.out.println("�����");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void radixSort2() {
        //80000000 * 11 * 4 / 1024 / 1024 / 1024 = 3.3 G
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }

        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        RadixSort.radixSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
    }
}