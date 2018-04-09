package com.lxm.algorithm.sort;

public class Sort {
	/**
	 * ѡ��������㷨ʵ��
	 */
	private int[] selectSort(int[] array) {
		int temp=0;
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]>array[j]){
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		return array;
	}

	/**
	 * ð������
	 * @param array
	 * @return
	 */
	private int[] bubbleSort(int[] array){
		for(int i=array.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(array[j]>array[j+1]){
					int temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
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
		Sort sort = new Sort();
		int[] array = { 2, 4, 1, 6, 7, 3, 9, 8 };
//		sort.traverse(sort.selectSort(array));
//		System.out.println();
//		System.out.println();
//		sort.traverse(sort.bubbleSort(array));
	}
}
