package com.lxm.algorithm.search;

/**
 * ���ֲ����㷨
 * Created by LXM on 2017/1/31.
 */
public class BinarySearch {

    /**
     * ���ֲ����㷨
     * @param n �����ҵ�Ԫ��
     * @param array ���飬�Ѿ�����
     * @return ��ѯ�����±�
     */
    public int search(int n,int[] array){
        int low=0;
        int high=array.length-1;
        int mid;
        while (low<high){
            mid=this.getMid(low,high);
            if(n==array[low]){
                return low;
            }else if(n==array[high]){
                return high;
            }else if(array[mid]==n){
                return mid;
            }else if(n<array[mid]){
                high=mid;
            }else if(n>array[mid]){
                low=mid;
            }
        }
        return -1;
    }

    /**
     * �õ��е�Ԫ��
     * @param low ��ָ��
     * @param high ��ָ��
     * @return ��ָ��
     */
    private int getMid(int low,int high){
        return ((int)(high-low)/2)+1;
    }

    public static void main(String[] args){
        int[] array=new int[]{5,13,19,21,37,56,64,75,80,88,92};
        BinarySearch search=new BinarySearch();
        System.out.println(search.search(21,array));
    }

}
