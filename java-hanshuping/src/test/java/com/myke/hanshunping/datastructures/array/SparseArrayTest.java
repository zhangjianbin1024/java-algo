package com.myke.hanshunping.datastructures.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
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

        log.info("{}","ww");
    }
}