package com.myke.hanshunping.datastructures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackDemoTest {

    @Test
    public void add() {
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.list();
    }

}