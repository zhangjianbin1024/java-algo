package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSortTest {

    @Test
    public void bubbleSort0() {

        int arr[] = {3, 9, -1, 10, -2};
        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));

        int temp = 0; // ��ʱ����

        // ��һ�����򣬾��ǽ���һ��������ڵ�����һλ,���ŵ����һλ
        for (int j = 0; j < arr.length - 1; j++) { // -1 ����Ϊ����һ��ѭ���󣬾ͻ�ȷ��һ������Ԫ�أ�����Ԫ��Ҫ�ŵ��������ѭ���� arr.length - 1 ��λ�õ�Ԫ�ؼ���
            // ���ǰ������Ⱥ���������򽻻�
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("��һ������������");
        System.out.println(Arrays.toString(arr));

        // �ڶ������򣬾��ǽ��ڶ���������ڵ����ڶ�λ
        for (int j = 0; j < arr.length - 1 - 1; j++) { // -1 ����Ϊ��һ���Ѿ����������������һλ�����Եڶ���ʱ�Ͳ���������
            // ���ǰ������Ⱥ���������򽻻�
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("�ڶ�������������");
        System.out.println(Arrays.toString(arr));


        // ���������򣬾��ǽ�������������ڵ�������λ
        for (int j = 0; j < arr.length - 1 - 2; j++) {
            // ���ǰ������Ⱥ���������򽻻�
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("����������������");
        System.out.println(Arrays.toString(arr));

        // ���������򣬾��ǽ���4��������ڵ�����4λ

        for (int j = 0; j < arr.length - 1 - 3; j++) {
            // ���ǰ������Ⱥ���������򽻻�
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("����������������");
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void bubbleSort1() {
        int arr[] = {3, 9, -1, 10, -2};
        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));

        //����ð������
        BubbleSort.bubbleSort(arr);

        System.out.println("�����");
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void bubbleSort2() {
        //Ϊ��������⣬���ǰ�ð��������ݱ���̣������չʾ

        //����һ��ð��������ٶ�O(n^2), ��80000�����ݣ�����
        //����Ҫ��80000�������������
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //����һ��[0, 8000000) ��
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        //����ð������
        BubbleSort.bubbleSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("������ʱ����=" + date2Str);
    }

}