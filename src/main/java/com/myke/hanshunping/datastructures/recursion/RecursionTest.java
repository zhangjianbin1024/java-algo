package com.myke.hanshunping.datastructures.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //ͨ����ӡ���⣬�ع˵ݹ���û���
        //print(4);

        //int res = factorial(3);
        //System.out.println("res=" + res);
    }

    //��ӡ����.
    public static void print(int n) {
        if (n > 2) {
            print(n - 1);
        } //else {
        System.out.println("n=" + n);
        // }
    }

    //�׳�����
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n; // 1 * 2 * 3
        }
    }


}
