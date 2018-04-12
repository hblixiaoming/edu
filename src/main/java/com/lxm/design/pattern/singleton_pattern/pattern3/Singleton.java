package com.lxm.design.pattern.singleton_pattern.pattern3;

/**
 *
 *  not lazy loading
 *
 *  ���ַ�ʽ����classloder���Ʊ����˶��̵߳�ͬ�����⣬
 *  ������instance����װ��ʱ��ʵ��������Ȼ������װ�ص�ԭ���кܶ��֣�
 *  �ڵ���ģʽ�д�������ǵ���getInstance������
 *  ����Ҳ����ȷ���������ķ�ʽ�����������ľ�̬������������װ�أ�
 *  ��ʱ���ʼ��instance��Ȼû�дﵽlazy loading��Ч��
 * Created by LXM on 2016/8/26.
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton (){}
    public static Singleton getInstance() {
        return instance;
    }
}
