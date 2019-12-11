package com.myke.algo.stack;

import java.util.Stack;

/**
 * StackCalculateExpression
 * <p>
 * 思路：
 * 表达式里面有两种元素，一种是符号元素，一种是数字元素。而优先级则是 "（）"  >  " *和/ "  >  " +和- "
 * 所以我们每次操作需要一个运算符和两个数字。遇到括号优先执行。
 * 所以设计了操作数栈和运算符栈，遇到右括号就弹出，如果没有遇到右括号则往对应的栈内压入元素。
 * <p>
 * <p>
 * 处理：
 * <1>.操作数只能压入操作数栈、运算符只能压入运算符栈。
 *
 * <2>.遇到右括号，运算符栈弹出运算符，操作数栈弹出够操作的操作数。
 * 将计算结果压入操作数栈。没有遇到右括号，
 * 执行<1>处理。
 *
 * @Author: zhangjianbin
 * @Date: 2019/12/11 19:03
 */
public class StackCalculateExpression {
    public static void calculate(char[] cArr) {
        //定义一个运算符栈
        Stack<String> ops = new Stack<String>();

        //定义一个操作数栈
        Stack<Integer> vals = new Stack<Integer>();

        //遍历出所有的操作数和运算符
        for (char c : cArr) {
            String str = String.valueOf(c);
            if (str.equals("(")) {
                continue;
            } else if (str.equals("+")) {
                ops.push(str);
            } else if (str.equals("-")) {
                ops.push(str);
            } else if (str.equals("*")) {
                ops.push(str);
            } else if (str.equals("/")) {
                ops.push(str);
            } else if (str.equals(")")) {

                //运算符栈
                String op = ops.pop();

                //操作数栈
                Integer v = vals.pop();

                //运算符情况处理
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                }
                vals.push(v);
            } else {
                vals.push(Integer.parseInt(str));
            }
        }
        System.out.println(vals.pop());
    }

    public static void main(String[] args) {
        String str = "(1+((1+3)*(2*3)))";
        calculate(str.toCharArray());
    }
}
