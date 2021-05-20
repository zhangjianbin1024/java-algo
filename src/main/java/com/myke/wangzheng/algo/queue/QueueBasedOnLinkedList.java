package com.myke.wangzheng.algo.queue;

/**
 * QueueBasedOnLinkedList
 * <p>
 * 基于链表实现的队列
 *
 * @Author: zhangjianbin
 * @Date: 2019/12/12 16:11
 */
public class QueueBasedOnLinkedList {

    // 队列的队首
    private Node head = null;

    //队列的队尾
    private Node tail = null;

    // 入队
    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            // 更新 队尾
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    // 出队
    public String dequeue() {
        if (head == null) {
            return null;
        }

        //更新 队首
        String value = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }


    public static void main(String[] args) {
        QueueBasedOnLinkedList queueLinked = new QueueBasedOnLinkedList();

        //入队
        queueLinked.enqueue("10");
        queueLinked.enqueue("11");
        queueLinked.enqueue("12");
        queueLinked.enqueue("13");

        System.out.println("队列数据：");
        queueLinked.printAll();


        // 出队
        System.out.println(queueLinked.dequeue());
        System.out.println(queueLinked.dequeue());
        System.out.println(queueLinked.dequeue());

    }

}
