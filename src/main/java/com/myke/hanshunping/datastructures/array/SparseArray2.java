package com.myke.hanshunping.datastructures.array;

/**
 * 二维数据转稀疏数组
 *
 * @Author zhangjianbin
 * @Date 2021/5/19 11:24
 */
public class SparseArray2 {

    public static void main(String[] args) {

        int[][] twoArray = new int[10][10];
        twoArray[0][1] = 4;
        twoArray[1][5] = 7;
        twoArray[6][5] = 9;

        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray[i].length; j++) {
                System.out.printf("%d\t", twoArray[i][j]);
            }
            System.out.println("");
        }

        System.out.println("*****************************************");

        int sum = 0;
        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray[i].length; j++) {
                if (twoArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("*****************************************");


        int cout = 0;
        int[][] res = new int[sum + 1][3];
        res[0][0] = twoArray.length;
        res[0][1] = twoArray[0].length;
        res[0][2] = sum;

        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray[i].length; j++) {
                if (twoArray[i][j] != 0) {
                    cout++;
                    res[cout][0] = i;
                    res[cout][1] = j;
                    res[cout][2] = twoArray[i][j];
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.printf("%d\t", res[i][j]);
            }
            System.out.println("");
        }


        int[][] arr2 = new int[res[0][0]][res[0][1]];
        //for (int i = 0; i < arr2.length; i++) {
        //    for (int j = 0; j < arr2[i].length; j++) {
        //        System.out.printf("%d\t", arr2[i][j]);
        //    }
        //    System.out.println("");
        //}
        System.out.println("*****************************************");
        for (int i = 1; i < res.length; i++) {
            int row = res[i][0];
            int col = res[i][1];
            arr2[row][col] = res[i][2];
        }

        System.out.println("*****************************************");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.printf("%d\t", arr2[i][j]);
            }
            System.out.println("");
        }


    }

}