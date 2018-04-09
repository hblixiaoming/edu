package com.lxm.algorithm.sort;

/**
 * ��������
 * �㷨˼�룺
 * ��һ����¼���뵽������õ�������У��Ӷ��õ�һ���£���¼����1�������
 * �����Ƚ����еĵ�1����¼������һ������������У�Ȼ��ӵ�2����¼������в��룬ֱ��������������Ϊֹ��
 * Created by LXM on 2017/5/6.
 */
public class InsertSort {
    /**
     * ��������
     * �㷨˼���Ǽٶ�ǰn��Ԫ�ض����Ѿ��Ź����
     * @param array
     * @return
     */
    private int[] insertSort(int[] array){
        for(int j=1;j<array.length;j++){
            for(int i=j-1;i>=0;i--){
                if(array[i]>array[j]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }else{
                    break;
                }
            }
        }
        return array;
    }

    /**
     * ��������
     * @param a ����
     * @param n ���鳤��
     * @return
     */
    private int[] insertSort(int a[], int n) {
        for(int i= 1; i<n; i++){
            if(a[i] < a[i-1]){               //����i��Ԫ�ش���i-1Ԫ�أ�ֱ�Ӳ��롣С�ڵĻ����ƶ����������
                int j= i-1;
                int x = a[i];        //����Ϊ�ڱ������洢������Ԫ��
                a[i] = a[i-1];           //�Ⱥ���һ��Ԫ��
                while(j>=0&&x < a[j]){  //�����������Ĳ���λ��
                    a[j+1] = a[j];
                    j--;         //Ԫ�غ���
                }
                a[j+1] = x;      //���뵽��ȷλ��
            }
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
        InsertSort sort = new InsertSort();
        int[] array = { 2, 4, 1, 6, 7, 3, 9, 8 };
        sort.traverse(sort.insertSort(array));
        sort.traverse(sort.insertSort(array,array.length));
    }
}
