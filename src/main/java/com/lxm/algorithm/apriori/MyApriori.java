package com.lxm.algorithm.apriori;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class MyApriori {
	//���������洢ȫ����Ķ�ά����
	private static String[][] srcData;
	//���������洢��ǰѡ�������ߺ�ѡ��������������ݽṹ
	private static HashMap<List<String>,Integer> map=new LinkedHashMap<List<String>, Integer>();
	//����һ�������洢Map��List�����List�д洢������Ƶ����ļ���
	private static List<HashMap> dataList=new ArrayList<HashMap>();
	//���List�����洢���ɵĹ�����ϵ
	private static List<String> outList=new ArrayList();
	//������С֧�ֶ���ֵ
	private static int MIN_SUP=2;
	//������С�����Ŷ�
	private static double MIN_COF=0.2;
	//�㷨����Ҫ�������Ƚ��г�ʼ���������õ�һ���Ȼ��ѭ���Ľ��и������ͳ�Ƹ�������
	public void  aprioriM(){
		InputData input=new InputData();
		OutputData output=new OutputData();
		//��ʼ�����������飬Ҳ���Խ��������Ϊ����
		srcData=input.getData();
		//��ʼ������������Ƶ��һ�
		init();
		dataList.add(map);
		//�ڿ��ƶ�������
		output.consoleOutput(map, 1);
		output.fileOutput(map, 1);
		for(int k=2;;k++){
		//����������Ҫ�������Ӻͼ�֦����������һ����ѡ��K�
			apriori_gen();
		  //ͳ�Ƽ�����ѡ����ȥ����������С��ֵ���
			countNumber();
			dataList.add(map);
			output.consoleOutput(map, k);
			output.fileOutput(map, k);
			//���mapΪ�����˳�ѭ��
			if(map.isEmpty()){
				break;
			}
		}
		//���ɹ�������ķ���
		getRelations();
		//�ֱ���console�˺��ļ��������������ķ���
		output.consolePutRelations(outList);
		output.filePutRelations(outList);
	}
	
	//�ҳ�Ƶ��һ��ļ���,�õ������������������浽map��ȥ
	public void init(){
		//�����洢ÿ����ĳ��ִ���
		int count=0;
		int number=0;

		List<String> set=new MyList();
		//�����񼯵ĵ�һ����뵽set��ȥ
		set.add(srcData[0][0]);
		//�����set���뵽map��ȥ������������Ϊ0����������Ϊ0����Ϊ����һ��
		//�������񼯵�ʱ�򻹻��������Ϊ�˱����ظ���������������Ϊ0
		map.put(set,0);
		//ѭ��������������
		for(String[] i:srcData){
			for(String j:i){
				//ѭ����������map�������Ԫ��j�������map��Ϊ���Ӧ��valueֵ��1��������뵽map��ȥ
				for(Entry<List<String>, Integer> temp : map.entrySet()){
					//���������map����Ϊ��value��1,����number++ͳ�Ƽ���
					if(temp.getKey().contains(j)){
						count=temp.getValue();
						count++;
						temp.setValue(count);
						//������tempֵ��Ҫ�˳���ǰѭ��
						break;
					}else{
						//number++��Ŀ����:Ϊ��һ���ж�,�ǲ��ǽ�����map��������һ��
						number++;
					}
				}
				//����number��ֵ���ж����Ԫ���Ƿ���map��
				//���number��ֵ������map�Ĵ�С��˵����ǰԪ�ز���map��
				if(number>=map.size()){
					set=new MyList();
					set.add(j);
					map.put(set, 1);
				}
				//��number����
				number=0;
			}
		}
		//�ٴα�������mapɾ����������С֧�ֶȵ���
		Iterator<Entry<List<String>, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()){
			if(it.next().getValue()<MIN_SUP){
				it.remove();
			}
		}
	}

	//��������Ҫ�������Ӻͼ�֦����
	public  void apriori_gen(){
		//Ϊ�˲��ƻ�ԭ����map�¶���һ��map�����洢���������ɵĺ�ѡ��
		HashMap<List<String>,Integer> newMap=new LinkedHashMap<List<String>,Integer>();
		//�õ�map�����е�key��ɵļ���,Ҳ����������ļ���(���������ǵļ���)
		Set<List<String>> set1=map.keySet();
		Set<List<String>> set2=map.keySet();
		MyList tempSet;
		//ѭ������������set���𲽽������Ӻͼ�֦����
		for(List<String> a:set1){
			for(List<String> b:set2){
				//�õ���ǰList���һ��Ԫ�ص��±�
				int lastIndex=a.size()-1;
			    //����������Ӽ���ǰn-1���ȣ�����ǰһ��������һ��С�ں�һ��������һ����������Ӳ���
				if(a.subList(0, lastIndex).equals(b.subList(0,lastIndex))&&a.get(lastIndex).compareTo(b.get(lastIndex))<0){
					//�������������Ѱ�������������,���ɺ�ѡ
					tempSet=new MyList();
					//�����߶�������ʱ��List��ȥ
					tempSet.addAll(a);
					tempSet.addAll(b);
					//����ʱ��tempSet��ӵ������ɵ�Map��ȥ
					Collections.sort(tempSet);
					newMap.put(tempSet, 0);
					//��������Ҫ�жϺ�ѡ���Ƿ������������ʣ����������ͽ����map��ɾ��
					//Ҳ�����ж�k���K-1���Ӽ��ǲ��Ƕ���C(K-1)���ѡ����,��������������������ʸ���ɾ��
					if(hasInfrequentSubset(tempSet,set1)){
						newMap.remove(tempSet);
					}
				}
			}
		}
		//��newMap�����ø�ֵ��ԭ����map
		map=newMap;
		newMap=null;
		tempSet=null;
		set1=null;
		set2=null;
	}
	//������������ж����Ӻ����ɵĺ�ѡ���Ƿ�������������
	public boolean hasInfrequentSubset(List<String> a,Set<List<String>> b){
		List<String> c=new MyList();
		int count=0;
		//�𲽱���k�a�����������k-1���Ӽ�c
		for(String i:a){
			for(String j:a){
				if(!i.equals(j)){
					c.add(j);
				}
			}
			//�������һ��k-1���Ӽ�������k-1��Ƶ�������ҵ���˵��k�a��������������
			if(!b.contains(c)){
				return true;
			}
			//Ϊc���·���һ���ռ�
			c=new MyList();
		}
		c=null;
		return false;
	}
	//�����������ͳ�Ƹ�����������г��ִ�������ɸѡ����Щ��������С��ֵ���
	//�Ӷ����ղ���Ƶ����
	public void countNumber(){
		int count=0;
		//ѭ����������
		for(String[] str:srcData){
			//ѭ����������map
			for(Entry<List<String>, Integer> temp :map.entrySet()){
				//�����ǰ��Ԫ�ذ����ڵ�ǰ�������У�����valueֵ��1
				if(judgeContains(temp.getKey(),str)){
					count=temp.getValue();
					count++;
					temp.setValue(count);
				}
			}
		}
		//ѭ����������mapȥ����Щ��������С��ֵ���
		Iterator<Entry<List<String>, Integer>> it=map.entrySet().iterator();
		while(it.hasNext()){
			if(it.next().getValue()<MIN_SUP){
				it.remove();
			}
		}
	}
	//����÷����ж�a����ÿ��Ԫ���Ƿ�����b�������ҵ�
	public boolean judgeContains(List<String> a,String[] b){
		int count=0;
		//ѭ������a��b
		for(String i:a){
			for(String j:b ){
				//�������a�е�Ԫ����b���ҵ���������ȵ���
				//�˳��ڲ�ѭ����Ѱ��a����һ��Ԫ��,ͬʱͳ�Ƽ���
				if(i.equals(j)){
					count++;
					break;
				}	
			}
		}
		//���count��ֵ���ڵ���a�Ĵ�С��˵��a������Ԫ�ض��ұ���
		//����˵��a�е�Ԫ�ض�����b���ҵ�
		if(count>=a.size()){
			return true;
		}else{
			return false;
		}
	}
	//�õ���������ķ���
	public void getRelations(){
		//����һ��map�����洢Ƶ��������ļ��ϣ�������������������
		Map<List<String>,Integer> lastMap=dataList.get(dataList.size()-2);
		//����һ����ʱ��List��������ʱ�洢������������������
		List<String> tempList;
		//���list�����洢tempListȥ��һ�����Ӽ�
		List<String> subTempList = new MyList();
		//���list�����洢tempListȥ������һ��ļ���
		List<String> oneList=new MyList();
		//�����洢�����ļ���
		double number=0.0;
		//�����洢�����Ӽ��ļ���
		double subNumber=0.0;
		//�����洢��������Ŷ�ֵ
		NumberFormat format=NumberFormat.getPercentInstance();
		double rate=0.0;
		for(Entry<List<String>, Integer> s:lastMap.entrySet()){
			//�õ���ߵ��
			tempList=s.getKey();
			//�õ������
			number=s.getValue();
			//���������ȥ��һ�����Ӽ�
			for(String i:tempList){
				for(String j:tempList){
					if(!i.equals(j)){
						subTempList.add(j);
					}else{
						//����һ�
						oneList.add(j);
					}
				}
				Collections.sort(subTempList);
				//�õ����Ӽ��ļ���
				subNumber=getSubsetNumber(subTempList);
				rate=number/subNumber;
				//���������С���Ŷ�����������list��ȥ
				if(rate>MIN_COF){
					outList.add(subTempList+"---->"+oneList+","+"  "+"confidence="+number+"/"+subNumber+"="+format.format(rate));
				}
				subTempList=new MyList();
				oneList=new MyList();
			}	
		}
	}
	public double getSubsetNumber(List<String> temp){
		//����һ��map�����洢���һ���ǰһ���
		Map<List<String>,Integer> afterMap=dataList.get(dataList.size()-3);
		double number=0.0;
		//ͨ������ǰһ����ϵķ����ҵ����Ӽ��ļ���
		for(Entry<List<String>, Integer> s:afterMap.entrySet()){
			if(s.getKey().equals(temp)){
				number=s.getValue();
				break;
			}
		}
		return number;
	}
	public static void main(String[] args) throws FileNotFoundException{
		long first=System.currentTimeMillis();
		//��map���洢�������ɵ�����������
		MyApriori myApriori=new MyApriori();
		myApriori.aprioriM();
		System.out.println(System.currentTimeMillis()-first);
	}
	//����һ�����Ա�֤Ԫ�ز��ظ���list
	class MyList extends ArrayList<String>{
		//ѭ��������ǰ��List,����һ����ʶ��ʼ��Ϊtrue
		//��������ظ����򽫱�ʶ����Ϊfalse;
		//�жϱ�ʶ�������ʶΪtrue��˵�������Ԫ�ز����ڣ����ø��෽���������
		public boolean add(String str){
			int i;
			boolean flag=true;
			for(i=0;i<this.size();i++){
				if(this.get(i).equals(str)){
					flag=false;
					break;
				}
			}
			if(flag==true){
				super.add(str);
			}
			return flag;
		}
		//��һ�����ϵ�Ԫ�ز��뵽��ǰ��list��ȥ
		public boolean addAll(List<String> list){
			for(String str:list){
				this.add(str);
			}
			return true;
		}
	}
}
