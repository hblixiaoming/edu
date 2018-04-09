package com.lxm.algorithm.sort;

/**
 * ϣ������
 * �㷨˼�룺�Ƚ�����������ļ�¼���зָ��Ϊ���������зֱ����ֱ�Ӳ�������
 * �����������еļ�¼����������ʱ���ٶ�ȫ���¼��������ֱ�Ӳ�������
 * Created by LXM on 2017/5/6.
 */
public class ShellInsertSort {


    private int[] shellInsertSort(int a[], int n, int dk) {
        for(int i= dk; i<n; ++i){
            if(a[i] < a[i-dk]){          //����i��Ԫ�ش���i-1Ԫ�أ�ֱ�Ӳ��롣С�ڵĻ����ƶ����������
                int j = i-dk;
                int x = a[i];           //����Ϊ�ڱ������洢������Ԫ��
                a[i] = a[i-dk];         //���Ⱥ���һ��Ԫ��
                while(j>=0&&x < a[j]){     //�����������Ĳ���λ��
                    a[j+dk] = a[j];
                    j -= dk;             //Ԫ�غ���
                }
                a[j+dk] = x;            //���뵽��ȷλ��
            }
        }
        return a;
    }

    /**
     * �Ȱ�����d��n/2,nΪҪ�������ĸ�������ϣ������
     *
     */
    public int[] shellSort(int a[], int n){

        int dk = n/2;
        while( dk >= 1  ){
            a=shellInsertSort(a, n, dk);
            dk = dk/2;
        }
        return a;
    }
    /**
     * ��������ķ���
     * @param array
     */
    private void traverse(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+",");
        }
    }

    public static void main(String[] args) {
        int[] array = { 2, 4, 1, 6, 7, 3, 9, 8 };
        ShellInsertSort shellInsertSort=new ShellInsertSort();
        shellInsertSort.shellSort(array,array.length);
        shellInsertSort.traverse(array);
    }
}
