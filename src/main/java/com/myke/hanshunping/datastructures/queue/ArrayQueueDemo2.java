package com.myke.hanshunping.datastructures.queue;

/**
 * @Author zhangjianbin
 * @Date 2021/5/19 12:39
 */
public class ArrayQueueDemo2 {
    public static void main(String[] args) {
        ArrayQueue2 arrayQueue = new ArrayQueue2(6);
        arrayQueue.add(3);
        arrayQueue.add(4);
        arrayQueue.add(5);
        arrayQueue.add(6);
        arrayQueue.add(7);
        arrayQueue.add(8);
        arrayQueue.add(9);

        arrayQueue.show();


        int i = arrayQueue.get();
        System.out.println(i);
        i = arrayQueue.get();
        System.out.println(i);

        int head = arrayQueue.head();
        System.out.println(head);

        arrayQueue.add(9);
        arrayQueue.show();

    }

}

class ArrayQueue2 {

    private int maxSize;
    private int front;
    private int rear;
    private int[] array;


    public ArrayQueue2(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    //判断是否满
    public boolean isFull() {
        return rear == this.maxSize - 1;
    }

    // 判断是否空
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    // 添加
    public void add(int n) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
        rear++;
        array[rear] = n;
    }

    public int get() {
        if (isEmpty()) {
            System.out.println("isEmpty");
            return -1;
        }
        front++;
        return array[front];
    }

    public void show() {
        System.out.println("");
        if (isEmpty()) {
            System.out.println("isEmpty");
            return;
        }

        for (int i = front + 1; i < array.length; i++) {
            System.out.printf("%d\t", array[i]);
        }

        System.out.println("");
        System.out.println("*******************************");
    }

    public int head() {
        if (isEmpty()) {
            System.out.println("isEmpty");
            return -1;
        }
        return array[front + 1];
    }
}