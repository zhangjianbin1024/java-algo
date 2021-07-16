package com.myke.hanshunping.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleArrayQueueDemoTest {

    @Test
    public void circleArrayQueue() {
        // 创建一个环形队列
        CircleArray queue = new CircleArray(6); //说明设置4, 其队列的有效数据最大是3
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);//队列满，不能加入数据
        queue.showQueue();
        int result = queue.getQueue();
        result = queue.getQueue();
        result = queue.getQueue();
        System.out.printf("出队:%d", result);
        System.out.println("");
        queue.addQueue(5);
        queue.showQueue();
    }

    @Test
    public void test1() {
        int max = 6;
        int start = 3;
        int end = 5;
        int restul = (end + max - start) % max;
        System.out.println(restul);
    }

    @Test
    public void test2() {
        int max = 5;
        for (int i = 10; i < 20; i++) {
            System.out.println(i % max);
        }
        System.out.println("*********************");
        for (int i = 0; i < 10; i++) {
            System.out.println((i + max) % max);
        }
    }

    @Test
    public void test3(){
        System.out.println(-7%4); // 取余
        System.out.println(7%4);

        // Math.floorMod方法的功能是向下取模
        System.out.println(Math.floorMod(-7, 4));
    }
}