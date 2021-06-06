package com.myke.hanshunping.datastructures.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursionTestTest {

    @Test
    public void print() {
        //通过打印问题，回顾递归调用机制
        RecursionTest.print(4);
    }

    @Test
    public void factorial() {
        int res = RecursionTest.factorial(3);
        System.out.println("res=" + res);
    }
}