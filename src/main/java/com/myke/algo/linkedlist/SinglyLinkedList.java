package com.myke.algo.linkedlist;

/**
 * SinglyLinkedList
 * <p>
 * 实现单链表反转
 * <p>
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 * @Author: zhangjianbin
 * @Date: 2019/11/26 13:18
 */
public class SinglyLinkedList {

    private Node head = null;

    /**
     * 根据 value 查询 链表中的节点
     *
     * @param value
     * @return
     */
    public Node findByValue(int value) {
        Node p = head;

        //节点中的 数据 与 value 相同，则说明找到了
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    /**
     * 根据 index 索引 查询 链表中的节点
     *
     * @param index
     * @return
     */
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

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
     * 顺序插入
     * <p>
     * 链表尾部插入
     *
     * @param value
     */
    public void insertTail(int value) {
        Node newNode = new Node(value, null);

        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;

            //找到链表中最后一个节点
            while (q.next != null) {
                q = q.next;
            }

            //将最后的一个节点 赋予 当前节点的下一个节点，这里 q.next 其实为 null
            newNode.next = q.next;

            //现在 节点 newNode 为最后一个节点
            q.next = newNode;
        }
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
     * value 值的节点 插入 p 节点 之后
     *
     * @param p
     * @param value
     */
    public void insertAfter(Node p, int value) {
        //通过 value 构建 新的节点
        Node newNode = new Node(value, null);
        // 新节点 插入 p 节点 之后
        insertAfter(p, newNode);
    }

    /**
     * newNode 节点 插入 到  p 节点之后
     *
     * @param p
     * @param newNode
     */
    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        // 1. 将 newNode 新节点的下一个节点指向 p 节点之后的那个节点
        newNode.next = p.next;
        // 2. p 节点 的一下节点 指向 新节点 newNode
        p.next = newNode;
    }


    /**
     * newNode 节点 插入 到 p 节点之前
     *
     * @param p
     * @param newNode
     */
    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        // p 节点为 头节点时，将 newNode 节点插入 到 头节点之前
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        //从链表头开始遍历,找到 p 节点,即 q.next = p,则说明 q 为 p 的前节点
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        // newNode 节点的一个节点引用 指向 p
        newNode.next = p;
        //前节点 的下一个指向 newNode 节点
        q.next = newNode;

    }

    /**
     * 删除 p 节点
     *
     * @param p
     */
    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }

        if (p == head) {
            //头节点引用 赋值为 null
            head = head.next;
            return;
        }

        //从链表头开始遍历,找到 p 节点,即 q.next = p,则说明 q 为 p 的前节点
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        //q 为 p 的前节点,q 的下一个节点指向 q 节点的下一个的下一个节点,那将 p 节点删除
        q.next = q.next.next;
    }


    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        Node p = head;
        Node q = null;
        // 查询出 value值 节点所在链表中的位置，即 q 节点
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            //删除 value 值 节点后面的哪个节点
            q.next = q.next.next;
        }

        // 可重复删除指定value的代码
        /*
           if (head != null && head.data == value) {
           head = head.next;
           }
           Node pNode = head;
           while (pNode != null) {
           if (pNode.next.data == data) {
           pNode.next = pNode.next.next;
           continue;
           }
           pNode = pNode.next;
           }
         */
    }

    //判断true or false
    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;

        boolean flag = true;
        System.out.println("left_:" + l.data);
        System.out.println("right_:" + r.data);

        //循环判断左右两边是否为回文
        while (l != null && r != null) {
            //节点值相同时
            if (l.data == r.data) {
                l = l.next; // l.next 取的值为 左边的左边
                r = r.next; // r.next 取的值为 右边的右边
                continue;
            } else {
                flag = false;
                break;
            }
        }

        System.out.println("什么结果");
        return flag;
    }


    //　判断是否为回文
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            System.out.println("开始执行找到中间节点");
            Node p = head;
            Node q = head;
            if (p.next == null) {
                System.out.println("只有一个元素");
                return true;
            }

            /**
             * 查找单链表的中间节点;
             *
             * 对于这个问题，我们首先能够想到的就是先遍历一遍整个的链表，然后计算出链表的长度，
             * 进而遍历第二遍找出中间位置的数据。这种方式非常简单
             *
             * 若题目要求只能遍历一次链表，那又当如何解决问题？可以采取建立两个指针，
             * 一个指针一次遍历两个节点，另一个节点一次遍历一个节点，当快指针遍历到空节点时，
             * 慢指针指向的位置为链表的中间位置，这种解决问题的方法称为快慢指针方法
             */
            while (q.next != null && q.next.next != null) {
                //当前节点的下一个节点:慢指针
                p = p.next;
                //当前节点的下一个节点的下一个节点:快指针
                q = q.next.next;

            }

            System.out.println("通过 快慢指针方法 查到中间节点" + p.data);

            System.out.println("开始执行奇数节点的回文判断");
            Node leftLink = null;
            Node rightLink = null;

            if (q.next == null) {// q 快指针 为 最后一个节点
                //　p 慢指针 一定为整个链表的中点，且节点数目为奇数

                rightLink = p.next;//p 慢指针 中间节点的 右节点

                //通过中间节点找到 中间节点的左节点
                leftLink = inverseLinkList(p).next;

                System.out.println("左边第一个节点" + leftLink.data);
                System.out.println("右边第一个节点" + rightLink.data);

            } else {
                //p 慢指针 中间节点
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return TFResult(leftLink, rightLink);

        }
    }


    /**
     * 带结点的链表翻转
     *
     * @param p
     * @return
     */
    public Node inverseLinkList_head(Node p) {
        //　Head　为新建的一个头结点
        Node Head = new Node(9999, null);
        // p　为原来整个链表的头结点,现在Head指向　整个链表头
        Head.next = p;

        /*
         * 带头结点的链表翻转等价于
         * 从第二个元素开始重新头插法建立链表
         */
        Node Cur = p.next;
        p.next = null;
        Node next = null;

        while (Cur != null) {
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            System.out.println("first " + Head.data);

            Cur = next;
        }

        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return Head;

    }


    /**
     * 无头结点的链表翻转
     *
     * @param p
     * @return
     */
    public Node inverseLinkList(Node p) {

        Node pre = null;
        Node r = head;
        System.out.println("z---" + r.data);
        Node next = null;

        while (r != p) {
            //记录下一个节点
            next = r.next;

            //通过变量 pre 记录当前节点
            //r.next 的引用里永远指向前一个节点,当循环完毕后,则就将链表就反翻转了,例如 123 变 为 321
            r.next = pre;
            pre = r;

            //通过变量 r 记录下一个节点,也就是将指针每次循环都向后移动
            r = next;
        }

        // 这时的 r 的节点与 p 节点相同,则 r 为中间节点 , r.next 中保存着 中间节点的前一个节点
        r.next = pre;
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;

    }


    public static Node createNode(int value) {
        return new Node(value, null);
    }


    /**
     * 链表打印
     */
    public void printAll() {
        Node p = head;
        while (p != null) {
            //打印 链表中 节点的值
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }


    /**
     * 链表中的节点
     */
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
    }


    public static void main(String[] args) {

        SinglyLinkedList link = new SinglyLinkedList();
        System.out.println("hello");
        //int data[] = {1};
        //int data[] = {1,2};
        //int data[] = {1,2,3,1};
        //int data[] = {1,2,5};
        //int data[] = {1, 2, 2, 1}; //回文
        // int data[] = {1,2,5,2,1};
        int data[] = {1, 2, 5, 3, 1, 8, 5, 10};
        //int data[] = {1, 2, 5, 3, 1};

        //test1
        for (int i = 0; i < data.length; i++) {
            //表头部插入
            link.insertToHead(data[i]);
            //链表尾部插入
            //link.insertTail(data[i]);
        }
        link.printAll();

        // test1 and test2
        //带结点的链表翻转
        Node p = link.inverseLinkList_head(link.head);
        while (p != null) {
            System.out.println("aa" + p.data);
            p = p.next;
        }

        System.out.println("打印原始:");
        link.printAll();
        if (link.palindrome()) {
            System.out.println("回文");
        } else {
            System.out.println("不是回文");
        }
    }
}
