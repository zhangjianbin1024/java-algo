package com.myke.hanshunping.datastructures.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSortTest {

    @Test
    public void bubbleSort0() {

        int arr[] = {3, 9, -1, 10, -2};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        int temp = 0; // 临时变量

        // 第一趟排序，就是将第一大的数排在倒数第一位,即放到最后一位
        for (int j = 0; j < arr.length - 1; j++) { // -1 是因为经过一趟循环后，就会确定一个最大的元素，最大的元素要放到最后，所以循环到 arr.length - 1 个位置的元素即可
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第二趟排序，就是将第二大的数排在倒数第二位
        for (int j = 0; j < arr.length - 1 - 1; j++) { // -1 是因为第一趟已经将最大的排在了最后一位，所以第二趟时就不用再排了
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));


        // 第三趟排序，就是将第三大的数排在倒数第三位
        for (int j = 0; j < arr.length - 1 - 2; j++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第四趟排序，就是将第4大的数排在倒数第4位

        for (int j = 0; j < arr.length - 1 - 3; j++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void bubbleSort1() {
        int arr[] = {3, 9, -1, 10, -2};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));

        //测试冒泡排序
        BubbleSort.bubbleSort(arr);

        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void bubbleSort2() {
        //为了容量理解，我们把冒泡排序的演变过程，给大家展示

        //测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        BubbleSort.bubbleSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }

}