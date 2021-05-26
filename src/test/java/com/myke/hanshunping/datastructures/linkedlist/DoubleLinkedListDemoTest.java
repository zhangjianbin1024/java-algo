package com.myke.hanshunping.datastructures.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListDemoTest {

    @Test
    public void add() {
        // ����
        System.out.println("˫������Ĳ���");
        // �ȴ����ڵ�
        HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
        HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
        HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
        HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
        // ����һ��˫������
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
    }


    @Test
    public void update() {
        // ����
        System.out.println("˫������Ĳ���");
        // �ȴ����ڵ�
        HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
        HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
        HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
        HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
        // ����һ��˫������
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        // �޸�
        HeroNode2 newHeroNode = new HeroNode2(4, "����ʤ", "������");
        doubleLinkedList.update(newHeroNode);
        System.out.println("�޸ĺ���������");
        doubleLinkedList.list();

        // ɾ��
        doubleLinkedList.del(4);
        System.out.println("ɾ������������~~");
        doubleLinkedList.list();
    }

}