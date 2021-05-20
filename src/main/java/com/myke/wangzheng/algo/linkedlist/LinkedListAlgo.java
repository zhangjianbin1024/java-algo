package com.myke.wangzheng.algo.linkedlist;

/**
 * LinkedListAlgo
 * <p>
 * * 1) 单链表反转
 * * 2) 链表中环的检测
 * * 3) 两个有序的链表合并
 * * 4) 删除链表倒数第n个结点
 * * 5) 求链表的中间结点
 *
 * @Author: zhangjianbin
 * @Date: 2019/11/27 15:33
 */
public class LinkedListAlgo {

    private Node head = null;

    /**
     * 无头结点
     * <p>
     * 表头部插入
     * <p>
     * 这种操作将于输入的顺序相反，逆序
     *
     * @param value
     */
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    /**
     * 节点插入 链表的头部
     *
     * @param newNode
     */
    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            //当前节点的下一个节点引用 指向当前链表中的头节点
            newNode.next = head;
            //当前节点 赋值于 链表中的头节点
            head = newNode;
        }
    }


    /**
     * 单链表反转
     *
     * @param list
     * @return
     */
    public static Node reverse(Node list) {
        Node curr = list, pre = null;
        while (curr != null) {
            //记录下一个结节
            Node next = curr.next;
            //下一个节点指向前一个结点
            curr.next = pre;
            //记录这次循环的前一个结点
            pre = curr;

            //从下次循环的结点
            curr = next;
        }
        return pre;
    }


    /**
     * 链表中环的检测
     *
     * @param list
     * @return
     */
    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }

        Node fast = list.next; //快结点
        Node slow = list; //慢结点

        while (fast != null && fast.next != null) {
            //一次走两步
            fast = fast.next.next;
            //一次走一步
            slow = slow.next;

            if (slow == fast) { //慢指针与快指针相同，则说明有环
                return true;
            }
        }

        return false;
    }


    /**
     * 有序链表合并 1
     *
     * @param la
     * @param lb
     * @return
     */
    public static Node mergeSortedLists1(Node la, Node lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }

        Node p = la;
        Node q = lb;
        Node head;
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;

        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    /**
     * 有序链表合并 2
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode soldier = new ListNode(0); //利用哨兵结点简化实现难度 技巧三
        ListNode p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /**
     * 删除倒数第K个结点
     *
     * @param list
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) {
            return list;
        }

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }


    /**
     * 求中间结点
     *
     * @param list
     * @return
     */
    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }

        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedListAlgo link = new LinkedListAlgo();
        LinkedListAlgo link2 = new LinkedListAlgo();

        int data[] = {1, 2, 5, 3, 1, 8, 5, 10};

        //test1
        for (int i = 0; i < data.length; i++) {
            //表头部插入
            link.insertToHead(data[i]);

            link2.insertToHead(data[i]);
        }
        printAll(link.head);

        System.out.println("有序链表合并");
        printAll(mergeSortedLists1(link.head, link2.head));


        System.out.println("链表中环的检测 " + checkCircle(link.head));

        Node middleNode = findMiddleNode(link.head);
        System.out.println("求中间结点 " + middleNode.getData());

        System.out.println("单链表反转 ");
        Node reverse = reverse(link.head);
        printAll(reverse);

    }


    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Node{");
            sb.append("data=").append(data);
            sb.append(", next=").append(next);
            sb.append('}');
            return sb.toString();
        }
    }
}
