package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergetSortTest {

    @Test
    public void mergeSort1() {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2,0,90}; //
        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));

        int temp[] = new int[arr.length]; //�鲢������Ҫһ������ռ�
        MergetSort.mergeSort(arr, 0, arr.length - 1, temp);


        System.out.println("�����");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void mergeSort2() {
        //���Կ��ŵ�ִ���ٶ�
        // ����Ҫ��80000�������������
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }
        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        int temp[] = new int[arr.length]; //�鲢������Ҫһ������ռ�
        MergetSort.mergeSort(arr, 0, arr.length - 1, temp);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
    }

}