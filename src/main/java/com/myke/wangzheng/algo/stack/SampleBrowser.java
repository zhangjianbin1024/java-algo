package com.myke.wangzheng.algo.stack;

/**
 * SampleBrowser
 * <p>
 * 使用前后栈实现浏览器的前进后退
 *
 * @Author: zhangjianbin
 * @Date: 2019/12/11 18:22
 */
public class SampleBrowser {

    private String currentPage;

    /**
     * 后退 栈
     */
    private LinkedListBasedStack backStack;

    /**
     * 向前 栈
     */
    private LinkedListBasedStack forwardStack;

    public SampleBrowser() {
        this.backStack = new LinkedListBasedStack();
        this.forwardStack = new LinkedListBasedStack();
    }

    /**
     * 打开的 url
     *
     * @param url
     */
    public void open(String url) {

        //当前页面压栈
        if (this.currentPage != null) {
            this.backStack.push(this.currentPage);
            this.forwardStack.clear();
        }
        showUrl(url, "Open");
    }

    public boolean canGoBack() {
        return this.backStack.size() > 0;
    }

    public boolean canGoForward() {
        return this.forwardStack.size() > 0;
    }

    /**
     * 后退
     *
     * @return
     */
    public String goBack() {
        if (this.canGoBack()) {

            //当前页面入栈
            this.forwardStack.push(this.currentPage);

            //后退栈中 出栈,即回到当前页面的上一个页面
            String backUrl = this.backStack.pop();

            //当前页面 url
            showUrl(backUrl, "Back");
            return backUrl;
        }

        System.out.println("* Cannot go back, no pages behind.");
        return null;
    }

    /**
     * 前进
     *
     * @return
     */
    public String goForward() {
        if (this.canGoForward()) {
            //当前页面入栈
            this.backStack.push(this.currentPage);

            //向前 栈 中出栈，即当前页面的下一个页面
            String forwardUrl = this.forwardStack.pop();
            showUrl(forwardUrl, "Foward");
            return forwardUrl;
        }

        System.out.println("** Cannot go forward, no pages ahead.");
        return null;
    }


    /**
     * 打印 url
     *
     * @param url
     * @param prefix
     */
    public void showUrl(String url, String prefix) {
        this.currentPage = url;
        System.out.println(prefix + " page == " + url);
    }

    public void checkCurrentPage() {
        System.out.println("Current page is: " + this.currentPage);
    }


    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();//后退操作
        browser.goBack();//后退操作

        browser.goForward();//前进操作
        browser.open("http://www.qq.com");

        browser.goForward();//前进操作,结果：Cannot go forward, no pages ahead.

        browser.goBack();//后退操作
        browser.goForward();//后退操作

        browser.goBack();//后退操作
        browser.goBack();
        browser.goBack();
        browser.goBack();

        browser.checkCurrentPage();//当前页
    }


    /**
     * 链表实现的 栈 结构
     */
    public static class LinkedListBasedStack {

        private int size;//栈的个数
        private Node top;

        static Node createNode(String data, Node next) {
            return new Node(data, next);
        }

        /**
         * 清空栈
         */
        public void clear() {
            this.top = null;
            this.size = 0;
        }

        public void push(String data) {
            Node node = createNode(data, this.top);
            this.top = node;
            this.size++;
        }

        public String pop() {
            Node popNode = this.top;
            if (popNode == null) {
                System.out.println("Stack is empty.");
                return null;
            }
            this.top = popNode.next;
            if (this.size > 0) {
                this.size--;
            }
            return popNode.data;
        }

        /**
         * 栈顶数据
         *
         * @return
         */
        public String getTopData() {
            if (this.top == null) {
                return null;
            }
            return this.top.data;
        }

        public int size() {
            return this.size;
        }

        //public static void main(String[] args) {
        //    LinkedListBasedStack stack = new LinkedListBasedStack();
        //    stack.push("A");
        //    stack.push("B");
        //
        //    stack.push("C");
        //    stack.pop(); // 删除 C
        //
        //    stack.push("D");
        //
        //    stack.push("E");
        //    stack.pop(); // 删除 E
        //
        //    stack.push("F");
        //    stack.print();
        //
        //    String data = stack.getTopData();
        //    System.out.println("Top data == " + data);
        //}


        /**
         * print stack
         * <p>
         * 从链表头部开始遍历
         */
        public void print() {
            System.out.println("Print stack:");
            Node currentNode = this.top;
            while (currentNode != null) {
                String data = currentNode.getData();
                System.out.print(data + "\t");
                currentNode = currentNode.next;
            }
            System.out.println();
        }

        public static class Node {

            private String data;
            private Node next;

            public Node(String data) {
                this(data, null);
            }

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            public void setData(String data) {
                this.data = data;
            }

            public String getData() {
                return this.data;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getNext() {
                return this.next;
            }
        }

    }
}
