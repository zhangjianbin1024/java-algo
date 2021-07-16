package com.myke.wangzheng.algo.queue;

/**
 * DynamicArrayQueue
 * <p>
 * 用数组实现的队列，并动态扩容
 *
 * @Author: zhangjianbin
 * @Date: 2019/12/12 16:20
 */
public class DynamicArrayQueue {
    // 数组：items，
    private String[] items;

    //数组大小：n
    private int n = 0;

    // head表示队头下标，
    private int head = 0;

    //tail表示队尾下标
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队操作，将item放入队尾
    public boolean enqueue(String item) {
        // tail == n表示队列末尾没有空间了
        if (tail == n) {
            // tail ==n && head==0，表示整个队列都占满了
            if (head == 0) {
                System.out.println("队列都占满了，当前值：" + item);
                return false;
            }

            // 数据搬移
            for (int i = head; i < tail; ++i) {
                items[i - head] = items[i];
            }

            // 搬移完之后重新更新head和tail
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        tail++;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }

        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArrayQueue dynamicArrayQueue = new DynamicArrayQueue(4);

        //入队
        dynamicArrayQueue.enqueue("10");
        dynamicArrayQueue.enqueue("11");
        dynamicArrayQueue.enqueue("12");
        dynamicArrayQueue.enqueue("13");
        dynamicArrayQueue.enqueue("14");//队列都占满了

        System.out.println("队列数据：");
        dynamicArrayQueue.printAll();


        // 出队
        System.out.println(dynamicArrayQueue.dequeue());
        System.out.println(dynamicArrayQueue.dequeue());
        System.out.println(dynamicArrayQueue.dequeue());
        System.out.println(dynamicArrayQueue.dequeue());
        System.out.println(dynamicArrayQueue.dequeue());
    }
}
