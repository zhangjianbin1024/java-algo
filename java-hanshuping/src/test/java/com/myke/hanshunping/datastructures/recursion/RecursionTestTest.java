package com.myke.hanshunping.datastructures.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionTestTest {

    @Test
    public void print() {
        //ͨ����ӡ���⣬�ع˵ݹ���û���
        RecursionTest.print(4);
    }

    @Test
    public void factorial() {
        int res = RecursionTest.factorial(3);
        System.out.println("res=" + res);
    }
}