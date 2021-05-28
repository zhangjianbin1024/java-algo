package com.myke.hanshunping.datastructures.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class ArrayStackDemoTest {

    @Test
    public void add() {
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.list();

        log.info("********************************");
        stack.pop();

        stack.list();
    }

}