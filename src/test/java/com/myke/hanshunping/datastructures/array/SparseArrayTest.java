package com.myke.hanshunping.datastructures.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SparseArrayTest {
    @Test
    public void arrayToSparseArray() {
        // ����һ��ԭʼ�Ķ�ά���� 11 * 11
        // 0: ��ʾû�����ӣ� 1 ��ʾ ���� 2 ������
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        SparseArray.arrayToSparseArray(chessArr1);
    }
}