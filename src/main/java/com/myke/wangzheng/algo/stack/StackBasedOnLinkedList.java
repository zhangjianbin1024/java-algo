package com.myke.wangzheng.algo.stack;

/**
 * StackBasedOnLinkedList
 * <p>
 * 基于链表实现的栈
 *
 * @Author: zhangjianbin
 * @Date: 2019/12/11 18:15
 */
public class StackBasedOnLinkedList {

    private Node top = null;

    public void push(int value) {
        Node newNode = new Node(value, null);
        // 判断是否栈空
        if (top == null) {
            top = newNode;
        } else {
            //数据放在栈顶，即 链表的头部
            newNode.next = top;
            top = newNode;
        }
    }

    /**
     * 用-1表示栈中没有数据。
     */
    public int pop() {
        if (top == null) {
            return -1;
        }
        //从栈顶取数据，即链表的头部
        int value = top.data;
        //每取一次数据，就将链表中的下一个节点作为栈顶
        top = top.next;
        return value;
    }


    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String[] args) {
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
