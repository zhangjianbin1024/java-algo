package com.myke.hanshunping.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueDemoTest {

    @Test
    public void queueTest() {
        ArrayQueue queue = new ArrayQueue(3);
        queue.addQueue(1);
        queue.addQueue(3);
        queue.addQueue(35);
        queue.showQueue();

        int result = queue.getQueue();
        System.out.printf("出队:%d", result);
        System.out.println("");
        result = queue.getQueue();
        System.out.printf("出队:%d", result);
        System.out.println("");
        result = queue.getQueue();
        System.out.printf("出队:%d", result);
        System.out.println("");
    }

}