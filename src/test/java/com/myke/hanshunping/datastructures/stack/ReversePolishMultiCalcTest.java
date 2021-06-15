package com.myke.hanshunping.datastructures.stack;

import org.junit.Test;

import java.util.List;

public class ReversePolishMultiCalcTest {

    @Test
    public void Calc() {
        //String math = "9+(3-1)*3+10/2";
        String math = "12.8 + (2 - 3.55)*4+10/5.0";
        try {
            List<String> list = ReversePolishMultiCalc.doMatch(math);
            ReversePolishMultiCalc.doCalc(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}