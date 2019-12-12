package com.myke.algo.queue;

/**
 * CircularQueue
 * <p>
 * 循环对队
 *
 * @Author: zhangjianbin
 * @Date: 2019/12/12 15:56
 */
public class CircularQueue {
    // 数组：items，
    private String[] items;

    //数组大小：n
    private int n = 0;

    // head表示队头下标，
    private int head = 0;

    //tail表示队尾下标
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {

        // 队列满了
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;

        // 队尾索引向后移一位，即占空位，更新 队尾的索引位置
        tail = (tail + 1) % n;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }

        String ret = items[head];

        //队头索引向后移一位，更新 队头的索引位置
        head = (head + 1) % n;
        return ret;
    }

    public void printAll() {
        if (0 == n) {
            return;
        }
        for (int i = head; i % n != tail; i = (i + 1) % n) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(4);

        //入队
        circularQueue.enqueue("10");
        circularQueue.enqueue("11");
        circularQueue.enqueue("12");

        //队列已满
        circularQueue.enqueue("13");


        System.out.println("队列数据：");
        circularQueue.printAll();

        //出队
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());

        System.out.println("队列数据：");
        circularQueue.printAll();
    }
}
