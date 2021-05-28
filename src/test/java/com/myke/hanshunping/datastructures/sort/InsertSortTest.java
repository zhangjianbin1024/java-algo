package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSortTest {

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