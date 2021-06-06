package com.myke.hanshunping.datastructures.recursion;

/**
 * 8�ʺ��ǻ��ݵľ����㷨
 */
public class Queue8 {

    //����һ��max��ʾ���ж��ٸ��ʺ�
    int max = 8;
    //��������array, ����ʺ����λ�õĽ��,���� arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    // arr[i] ��ֵ�����У��� i ������
    // arr[i]=val : val ��ʾ�� i + 1 ���ʺ󣬷��� �� i + 1 �еĵ� val + 1 ��

    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        //����һ�� �� 8�ʺ��Ƿ���ȷ
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("һ����%d�ⷨ", count);
        System.out.printf("һ���жϳ�ͻ�Ĵ���%d��", judgeCount); // 1.5w

    }


    //��дһ�����������õ�n���ʺ�
    //�ر�ע�⣺ check �� ÿһ�εݹ�ʱ�����뵽check�ж���  for(int i = 0; i < max; i++)����˻��л���
    // ����:�Ƚ�n�ӵ�һ�е�һ�п�ʼ�����ߵ����һ�к��ҵ����,�ٽ�n�ӵ�һ�еڶ��п�ʼ�����ε����һ�У�
    // ����һ�е����нⶼ�õ�ʱ���ٴӵڶ��п�ʼ���
    // ����Ҳ���� check(n + 1); n ����һ��ͨ�� for ѭ��ʵ�ִӵ�1�е����һ�в��ж�λ���Ƿ���n�µ�λ���Ƿ��ͻ���õ��µĽ�
    private void check(int n) {
        if (n == max) {  //n = 8 , ��ʵ8���ʺ�ͼ�Ȼ�ź�
            print();
            return;
        }

        //���η���ʺ󣬲��ж��Ƿ��ͻ
        for (int i = 0; i < max; i++) {//i������,ͨ�� i ���ϵ������һ�п��Ƿ��ͻ
            //�Ȱѵ�ǰ����ʺ� n ��nҲ����ڼ��У�, �ŵ����еĵ�1�У��ȴӵ�һ�п�ʼ����������
            array[n] = i;
            //�жϵ����õ�n���ʺ�i��ʱ���Ƿ��ͻ
            if (judge(n)) { // ����ͻ
                //���ŷ�n+1��Ҳ������һ�У����ʺ�,����ʼ�ݹ�
                check(n + 1); //����
            }
            //�����ͻ���ͼ���ִ�� array[n] = i; ������n���ʺ󣬷����ڱ��в����Ƶ�һ��λ�ã�Ҳ���� i �еı仯
        }
    }

    //�鿴�����Ƿ��õ�n���ʺ�, ��ȥ���ûʺ��Ƿ��ǰ���Ѿ��ڷŵĻʺ��ͻ

    /**
     * �жϻʺ��λ���Ƿ��ͻ
     *
     * @param n ��ʾ��n���ʺ�
     * @return
     */
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            // ˵��
            //1. array[i] == array[n]  ��ʾ�ж� ��n���ʺ��Ƿ��ǰ���n-1���ʺ���ͬһ��
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) ��ʾ�жϵ�n���ʺ��Ƿ�͵�i�ʺ��Ƿ���ͬһб��
            // n = 1 ʱ ���õ� 2 ��
            // n = 1 ʱ ��array[n] ���� array[1] = 1
            // Math.abs(1-0) == 1
            // Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1
            //3. �ж��Ƿ���ͬһ��, û�б�Ҫ��n Ҳ������,n ÿ�ζ��ڵ���
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //дһ�����������Խ��ʺ�ڷŵ�λ�����
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
