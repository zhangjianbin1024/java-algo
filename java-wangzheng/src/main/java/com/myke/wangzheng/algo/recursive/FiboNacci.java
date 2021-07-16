package com.myke.wangzheng.algo.recursive;

/**
 * 斐波那契
 * <p>
 * 斐波那契数列指的是这样一个数列 0, 1, 1, 2, 3, 5, 8, 13
 * 特别指出：第0项是0，第1项是第一个1。
 * <p>
 * 这个数列从第三项开始，每一项都等于前两项之和。
 * <p>
 * 参考：
 * https://blog.csdn.net/acecandy/article/details/83864763
 *
 * @Author: zhangjianbin
 * @Date: 2019/12/12 17:25
 */
public class FiboNacci {

    /**
     * 递归
     *
     * @param number
     * @return
     */
    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1)) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    public static void main(String[] args) {
        for (int counter = 0; counter <= 10; counter++) {
            System.out.printf("Fibonacci of %d is: %d\n",
                    counter, fibonacci(counter));
        }
    }
}
