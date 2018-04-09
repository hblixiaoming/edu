package com.lxm.algorithm.apriori;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class OutputData {
	//���ܽ���ĵ��ļ�
	private  File file=new File("dataout500.txt");
	//��ӡ��
	private  PrintWriter print;
	
	public OutputData(){
		try {
			//�ô�ӡ����װһ���ļ������
			print=new PrintWriter(new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�����ɵ�Ƶ���������ļ���ȥ
	public void fileOutput(Map<List<String>,Integer> map,int k){
		print.println(k+"�Ϊ");
		for(Map.Entry<List<String>, Integer> it:map.entrySet()){
			print.println(it.getKey()+":"+it.getValue());
		}
		print.flush();
	}
	//�����ɵ�Ƶ�����������ƶ���
	public void consoleOutput(Map<List<String>,Integer> map,int k){
		System.out.println(k+"�Ϊ");
		for(Map.Entry<List<String>, Integer> it:map.entrySet()){
			System.out.println(it.getKey()+":"+it.getValue());
		}
	}
	//�����ɵĹ�������������ļ���ȥ
	public void filePutRelations(List<String> str){
		print.println("-------��������Ϊ------");
		for(String s:str){
			print.println(s);
		}
		print.flush();
	}
	//�����ɵĹ���������������ƶ���
	public void consolePutRelations(List<String> str){
		System.out.println("------��������Ϊ------");
		for(String s:str){
			System.out.println(s);
		}
	}
}
