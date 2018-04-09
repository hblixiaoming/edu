package com.lxm.algorithm.apriori;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class InputData {
	//���������洢�������ݵ��ļ�
	private  File file=new File("dataMax.csv");
	//����һ���ַ������������������������ʱ�洢���ļ��ж�ȡ��������
	public  CharBuffer buffer;
	//����һ���ļ�������channel
	private FileChannel inChannel;
	//����һ�����ֽ�����ת��Ϊ�ַ������ݵĽ��뼯
	private  Charset charset=Charset.forName("GBK");
	//���������洢���ݵĶ�ά����
	private String[][] strRe;
	//����һ�������У�������֮��ķָ���
	private final static String ROW_SPLIT="\r\n";
	//�����������֮��ķָ���
	private final static String COLUMN_SPLIT=" ";
	
	public  CharBuffer FileInPut(){
		try {
			//���ļ����������л�ȡһ��channel
			inChannel=new FileInputStream(file).getChannel();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//����map�����������ļ�����ӳ�䵽buff��ȥ
			MappedByteBuffer buff=inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//����һ�����������ֽ����ݽ���Ϊ�ַ�����
			buffer=charset.newDecoder().decode(buff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				inChannel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return buffer;
	}
	public  String[][] getData(){
		//������һ����������������ת��Ϊ��һ��buffer��ȥ
		FileInPut();
		//�����buffer�е��ַ�����ת��Ϊ�ַ�������
		String str=buffer.toString();
		//����һ��һά������������Իس���Ϊ�ָ���
		String[] sFirst = str.split(ROW_SPLIT);
		strRe = new String[sFirst.length][]; //һά�ĳ���
		for(int i=0;i<sFirst.length;i++) {
			String[] sSecond = sFirst[i].split(COLUMN_SPLIT); //��һά�������Ϊ��ά������
			strRe[i] = new String[sSecond.length]; //��ά�ĳ���
			for(int j=0;j<sSecond.length;j++) {
				strRe[i][j] = sSecond[j]; 
			}
		}
		return strRe;
	}	
}
