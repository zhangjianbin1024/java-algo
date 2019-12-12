package com.myke.algo.stack;

import java.util.Stack;

/**
 * StackCalculateExpression
 * <p>
 * 四则运算表达式解析
 * <p>
 * 四则运算比如：a + b * c + (d - e)
 * <p>
 * 编译器的做法一般是将其解析成 <a href='https://zh.wikipedia.org/wiki/%E9%80%86%E6%B3%A2%E5%85%B0%E8%A1%A8%E7%A4%BA%E6%B3%95'>逆波兰式</a> 之后再进行运算
 * <p>
 * 解析过程如下：
 * <p>
 * 依次取经过四则运算之后的 四则运算表达式 中的各个元素x
 * <p>
 * 分析规则：（需要使用到 一种是符号元素即运算符栈，一种是数字元素即操作数栈也叫结果栈）
 * <p>
 * 1 如果 x 为操作数则直接压入结果栈
 * <p>
 * 2 如果 x 为操作符则分析规则如下：
 * <pre>
 * <p>
 *  a 如果 x 为 "(", 则直接将其压入运算符栈
 * <p>
 *  b 如果 x 为 ")",则将距离其最近的运算符依次取出栈 并将运算符计算结果 压入结果栈中，并将 "(" 丢弃
 * <p>
 *  c 如果 x 不为"("或者")"：
 * <p>
 *      a.如果运算符栈为空，则直接将 x 入运算符栈
 * <p>
 *      b.如果运算符栈非空，若 x 比运算符栈顶运算符的优先级高，则将 x 入栈，
 *      否则将运算符栈中优先级高于x的运算符依次出栈 直到遇到优先级小于 x 的运算符
 * <p>
 *
 *
 * 3 <a href='https://zhuanlan.zhihu.com/p/24556103'>如果到达表达式的末尾，则将运算符栈中的所有运算符依次压入结果栈中</a>
 *
 *
 * <p>
 * 使用栈进行解析。
 * <p>
 * <p>
 * 逆波兰记法中，操作符置于操作数的后面。
 * <p>
 * 例如表达“三加四”时，写作“3 4 +”，而不是“3 + 4”
 * 如果有多个操作符，操作符置于第二个操作数的后面，所以常规中缀记法的“3 - 4 + 5”
 * 在逆波兰记法中写作“3 4 - 5 +”：先3减去4，再加上5
 *
 * @Author: zhangjianbin
 * @Date: 2019/12/12 11:22
 */
public class StackCalculateExpression {

    public static double Cal(String Exp) {
        System.out.println("四则运算表达式解析:" + Exp);
        // 运算符栈
        Stack operator = new Stack();

        // 操作数栈,即结果临时栈
        Stack operand = new Stack();

        // 字符串索引；
        int index = 0;

        // 存放内容
        String op = "";

        // 将 Exp 按照顺序压入栈中
        while (index < Exp.length()) {
            boolean flag = false;

            op += Exp.charAt(index);
            switch (op) {
                case "+":
                case "-":

                    //peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
                    // 运算符栈 不为空 并且 运算符栈 顶不为 (
                    if (!operator.isEmpty() && !operator.peek().equals("(")) {
                        //取出 运算符 和 操作数 做运算
                        Pop(operand, operator);
                    }
                    //运算符入栈
                    operator.push(op);
                    op = "";
                    break;
                case "*":
                case "/":
                    if (operator.peek().equals("*") || operator.peek().equals("/")) {
                        Pop(operand, operator);
                    }
                    operator.push(op);
                    op = "";
                    break;
                case "(":
                    operator.push("(");
                    op = "";
                    break;
                case ")":
                    // 如果运算符为 ) 则从运算栈和操作数栈中取出数据,做运算,直到遇到 ) 停止运算
                    while (!operator.peek().equals("(")) {
                        Pop(operand, operator);
                    }

                    //从运算符中 弹出 ( ,即:将 "(" 丢弃
                    operator.pop();
                    op = "";
                    break;
                default:
                    //说明当前是操作数
                    flag = true;

            }

            //操作数情况
            if (flag) {
                // 最后一个符号
                if (index == Exp.length() - 1) {
                    operand.push(op);
                    while (!operator.isEmpty()) {
                        Pop(operand, operator);
                    }
                    op = "";
                } else if (!Character.isDigit(Exp.charAt(index + 1)) && Exp.charAt(index + 1) != '.') {
                    // isDigit() 方法用于判断指定字符是否为数字。
                    // Exp 字符串中下一个字符非数字 且 非小数点，说明 op 是完整的操作数
                    // 操作数入栈
                    operand.push(op);
                    op = "";
                }
            }
            index++;
        }

        // 对没有括号的,则迭代 运算栈和 操作数栈,直到 运算符栈为空时,停止计算
        while (!operator.isEmpty()) {
            Pop(operand, operator);
        }

        //取出 栈中的计算结果
        return Double.valueOf(operand.peek().toString());
    }

    /**
     * 将操作数栈  和  运算符栈  做运算
     *
     * @param operand
     * @param operator
     */
    private static void Pop(Stack operand, Stack operator) {
        //操作数
        double p2 = Double.valueOf(operand.pop().toString());
        double p1 = Double.valueOf(operand.pop().toString());

        //运算符
        switch (operator.pop().toString()) {
            case "+":
                //将计算结果 入栈,存入操作数栈顶
                operand.push(String.valueOf(p1 + p2));
                break;
            case "-":
                operand.push(String.valueOf(p1 - p2));
                break;
            case "/":
                operand.push(String.valueOf(p1 / p2));
                break;
            case "*":
                operand.push(String.valueOf(p1 * p2));
                break;
        }
    }

    public static void main(String[] args) {
        double ret = 0D;
        ret = StackCalculateExpression.Cal("3+0.5*(5*(6+6*9+16))"); // 结果 193.0
        //ret = StackCalculateExpression2.Cal("1+(9+2*3)"); //结果 16
        System.out.println("结果:" + ret);
    }
}
