package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSortTest {

    @Test
    public void t0() {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));

        int temp = 0;
        // ϣ������ĵ�1������
        // ��Ϊ��1�������ǽ�10�����ݷֳ��� 5��
        for (int i = 5; i < arr.length; i++) {
            // �������������е�Ԫ��(��5�飬ÿ����2��Ԫ��), ����5
            for (int j = i - 5; j >= 0; j -= 5) {
                // �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        System.out.println("ϣ������1�ֺ�=" + Arrays.toString(arr));//


        // ϣ������ĵ�2������
        // ��Ϊ��2�������ǽ�10�����ݷֳ��� 5/2 = 2��
        for (int i = 2; i < arr.length; i++) {
            // �������������е�Ԫ��(��5�飬ÿ����2��Ԫ��), ����5
            for (int j = i - 2; j >= 0; j -= 2) {
                // �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }

        System.out.println("ϣ������2�ֺ�=" + Arrays.toString(arr));//

        // ϣ������ĵ�3������
        // ��Ϊ��3�������ǽ�10�����ݷֳ��� 2/2 = 1��
        for (int i = 1; i < arr.length; i++) {
            // �������������е�Ԫ��(��5�飬ÿ����2��Ԫ��), ����5
            for (int j = i - 1; j >= 0; j -= 1) {
                // �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("ϣ������3�ֺ�=" + Arrays.toString(arr));//
    }

    @Test
    public void shellSort() {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));

        ShellSort.shellSort(arr); //����ʽ

        System.out.println("�����");
        System.out.println(Arrays.toString(arr));

    }


    @Test
    public void shellSort2() {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));

        ShellSort.shellSort2(arr);//��λ��ʽ

        System.out.println("�����");
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void t3() {
        // ����Ҫ��80000�������������
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        ShellSort.shellSort(arr); //����ʽ
        //ShellSort.shellSort2(arr);//��λ��ʽ

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);

    }
}