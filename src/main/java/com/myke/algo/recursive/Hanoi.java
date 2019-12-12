package com.myke.algo.recursive;

/**
 * Hanoi
 * <p>
 * 汉诺塔
 * <p>
 * 1.有三根杆子A,B,C。A杆上有若干碟子
 * 2.每次移动一块碟子,小的只能叠在大的上面
 * 3.把所有碟子从A杆全部移到C杆上
 * <p>
 * 参考：
 * https://blog.csdn.net/nzfxx/article/details/51584204
 *
 * @Author: zhangjianbin
 * @Date: 2019/12/12 17:41
 */
public class Hanoi {

    /**
     * 汉诺塔
     *
     * @param n n个盘子
     * @param a 起始柱子
     * @param b 中转柱子
     * @param c 目标柱子
     */
    public static void doTowers(int n, char a, char b, char c) {

        //只有一个时,A把("第"n)个移动到C
        //只有一个时,原柱子->目标柱子
        if (n == 1) {
            System.out.println(a + "---->" + c);
        } else {

            //1.A借C把("共"n-1个)移动到B
            //多个:原柱子->辅助柱子
            //C变成辅助,所以排在第二位,B变成目标;
            doTowers(n - 1, a, c, b);
            System.out.println(a + "---->" + c);

            //B借A把("共"n-1)个移动到C
            //多个:辅助柱->目标柱子
            //A是辅助,所以排在第二位置,C变目标;
            doTowers(n - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        int nDisks = 3;
        doTowers(nDisks, 'A', 'B', 'C');
    }

}
