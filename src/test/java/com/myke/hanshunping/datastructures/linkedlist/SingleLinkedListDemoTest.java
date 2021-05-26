package com.myke.hanshunping.datastructures.linkedlist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SingleLinkedListDemoTest {

    @Test
    public void add() {
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        //����Ҫ������
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //����
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);

        //��ʾһ��
        singleLinkedList.list();
    }

    @Test
    public void addByOrder() {
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        //����Ҫ������
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //���밴�ձ�ŵ�˳��
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //��ʾһ��
        singleLinkedList.list();

    }

    @Test
    public void reversetList() {
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        //����Ҫ������
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //���밴�ձ�ŵ�˳��
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        // ����һ�µ�����ķ�ת����
        System.out.println("ԭ����������~~");
        singleLinkedList.list();

        System.out.println("��ת������~~");

        // ͨ��ͷ�ڵ㷴ת����
        SingleLinkedListDemo.reversetList(singleLinkedList.getHead());
        singleLinkedList.list();
    }

    @Test
    public void reversePrint() {
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        //����Ҫ������
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //���밴�ձ�ŵ�˳��
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        // ����һ�µ�����ķ�ת����
        System.out.println("ԭ����������~~");
        singleLinkedList.list();


        System.out.println("���������ӡ������, û�иı�����Ľṹ~~");
        SingleLinkedListDemo.reversePrint(singleLinkedList.getHead());
    }

    @Test
    public void update() {
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        //����Ҫ������
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //���밴�ձ�ŵ�˳��
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        System.out.println("ԭ����������~~");
        singleLinkedList.list();


        //�����޸Ľڵ�Ĵ���
        HeroNode newHeroNode = new HeroNode(2, "С¬", "������~~");
        singleLinkedList.update(newHeroNode);

        System.out.println("�޸ĺ���������~~");
        singleLinkedList.list();

        //ɾ��һ���ڵ�
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        System.out.println("ɾ������������~~");
        singleLinkedList.list();
    }

    @Test
    public void findLastIndexNode() {
        //�ȴ����ڵ�
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");

        //����Ҫ������
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //���밴�ձ�ŵ�˳��
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        System.out.println("ԭ����������~~");
        singleLinkedList.list();

        //����һ�¿����Ƿ�õ��˵�����K���ڵ�
        HeroNode res = SingleLinkedListDemo.findLastIndexNode(singleLinkedList.getHead(), 3);
        System.out.println("");
        log.info("������{}���ڵ� res={}", 3, res);
    }
}