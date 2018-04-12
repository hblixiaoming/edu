package com.lxm.design.pattern.singleton_pattern.pattern6;

/**
 * ���ַ�ʽͬ��������classloder�Ļ�������֤��ʼ��instanceʱֻ��һ���̣߳�
 * ���������ֺ͵����ַ�ʽ��ͬ���ǣ���ϸ΢�Ĳ�𣩣�
 * �����ֺ͵����ַ�ʽ��ֻҪSingleton�౻װ���ˣ�
 * ��ôinstance�ͻᱻʵ������û�дﵽlazy loadingЧ������
 * �����ַ�ʽ��Singleton�౻װ���ˣ�
 * instance��һ������ʼ����
 * ��ΪSingletonHolder��û�б�����ʹ�ã�
 * ֻ����ʾͨ������getInstance����ʱ��
 * �Ż���ʾװ��SingletonHolder�࣬
 * �Ӷ�ʵ����instance������һ�£�
 * ���ʵ����instance��������Դ�����������ӳټ��أ�
 * ����һ���棬�Ҳ�ϣ����Singleton�����ʱ��ʵ������
 * ��Ϊ�Ҳ���ȷ��Singleton�໹�����������ĵط�������ʹ�ôӶ������أ�
 * ��ô���ʱ��ʵ����instance��Ȼ�ǲ����ʵġ����ʱ��
 * ���ַ�ʽ��ȵ����͵����ַ�ʽ���Եúܺ���
 * Created by LXM on 2016/8/26.
 */
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton (){}

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
