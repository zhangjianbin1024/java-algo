package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSortTest {

    @Test
    public void selectSort1() {
        int[] arr = {101, 34, 119, 1};
        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));

        //ʹ�����Ƶ��ķ�ʽ��������ѡ������
        //��1��
        //ԭʼ������ �� 	101, 34, 119, 1
        //��һ������ :   	1, 34, 119, 101
        //�㷨 �ȼ�--�� �����ӣ� ���ǿ��԰�һ�����ӵ��㷨����ֳɼ򵥵�����-���𲽽��

        //��1�֣��ҵ���Сֵ��������Сֵ�ŵ����� 0 ��λ�ã�����0λ�õ�ֵ�ŵ�����λ����
        int minIndex = 0;//��Сֵ������
        int min = arr[0];//�ȼ���� 0 ��Ԫ��Ϊ��С��
        for (int j = 0 + 1; j < arr.length; j++) { // 0+1 ����Ϊ�ȼ���� 0 ��Ԫ��Ϊ��С�ģ�����Ҫ�ӵ� 1��Ԫ�ؿ�ʼ�Ƚ�
            if (min > arr[j]) { //˵���ٶ�����Сֵ����������С
                min = arr[j]; //����min
                minIndex = j; //����minIndex
            }
        }


        //����Сֵ������arr[0], ������
        if (minIndex != 0) {
            // ͨ�� minIndex������Сֵ������λ�õ�ֵ����Ϊ arr[0] ��ֵ
            arr[minIndex] = arr[0];
            // arr[0] ��ֵ����Ϊ�������ҵ�����Сֵ
            arr[0] = min;
        }

        System.out.println("��1�ֺ�~~");
        System.out.println(Arrays.toString(arr));// 1, 34, 119, 101


        //��2��
        minIndex = 1;
        min = arr[1];
        for (int j = 1 + 1; j < arr.length; j++) {
            if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
                min = arr[j]; // ����min
                minIndex = j; // ����minIndex
            }
        }

        // ����Сֵ������arr[0], ������
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }

        System.out.println("��2�ֺ�~~");
        System.out.println(Arrays.toString(arr));// 1, 34, 119, 101

        //��3��
        minIndex = 2;
        min = arr[2];
        for (int j = 2 + 1; j < arr.length; j++) {
            if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
                min = arr[j]; // ����min
                minIndex = j; // ����minIndex
            }
        }

        // ����Сֵ������arr[0], ������
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("��3�ֺ�~~");
        System.out.println(Arrays.toString(arr));// 1, 34, 101, 119 */

    }

    @Test
    public void selectSort2() {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println("����ǰ");
        System.out.println(Arrays.toString(arr));
        SelectSort.selectSort(arr);
        System.out.println("�����");
        System.out.println(Arrays.toString(arr));


    }

    @Test
    public void selectSort3() {
        //����Ҫ��80000�������������
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        SelectSort.selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
    }
}