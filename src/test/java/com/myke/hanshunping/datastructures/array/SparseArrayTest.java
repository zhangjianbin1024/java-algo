package com.myke.hanshunping.datastructures.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SparseArrayTest {
    @Test
    public void arrayToSparseArray() {
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        SparseArray.arrayToSparseArray(chessArr1);
    }
}