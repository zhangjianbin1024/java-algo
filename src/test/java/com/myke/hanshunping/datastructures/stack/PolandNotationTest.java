package com.myke.hanshunping.datastructures.stack;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

@Slf4j
public class PolandNotationTest {

    @Test
    public void getListString() {

        //�ȶ�����沨�����ʽ
        //(30+4)��5-6  => 30 4 + 5 �� 6 - => 164
        // 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +

        //˵��Ϊ�˷��㣬�沨�����ʽ �����ֺͷ���ʹ�ÿո����
        String suffixExpression = "30 4 + 5 * 6 -";
        //String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; // 76
        //˼·
        //1. �Ƚ� "3 4 + 5 �� 6 - " => �ŵ�ArrayList��
        //2. �� ArrayList ���ݸ�һ������������ ArrayList ���ջ ��ɼ���

        List<String> list = PolandNotation.getListString(suffixExpression);
        System.out.println("rpnList=" + list);

        int res = PolandNotation.calculate(list);
        System.out.println("����Ľ����=" + res);
    }

    @Test
    public void parseSuffixExpreesionList() {
        //��ɽ�һ����׺���ʽת�ɺ�׺���ʽ�Ĺ���
        //˵��
        //1. 1+((2+3)��4)-5 => ת��  1 2 3 + 4 �� + 5 �C
        //2. ��Ϊֱ�Ӷ�str ���в����������㣬��� �Ƚ�  "1+((2+3)��4)-5" =�� ��׺�ı��ʽ��Ӧ��List
        //   �� "1+((2+3)��4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. ���õ�����׺���ʽ��Ӧ��List => ��׺���ʽ��Ӧ��List
        //   �� ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =�� ArrayList [1,2,3,+,4,*,+,5,�C]

        String expression = "1+((2+3)*4)-5";//��׺���ʽ,ע����ʽ
        System.out.println("��׺���ʽ=" + expression);
        List<String> infixExpressionList = PolandNotation.toInfixExpressionList(expression);
        System.out.println("��׺���ʽ��Ӧ��List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        // ��׺���ʽ תΪ ��׺���ʽ
        List<String> suffixExpreesionList = PolandNotation.parseSuffixExpreesionList(infixExpressionList);
        System.out.println("��׺���ʽ��Ӧ��List" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,�C]
    }

}