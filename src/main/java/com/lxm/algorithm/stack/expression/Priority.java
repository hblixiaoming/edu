package com.lxm.algorithm.stack.expression;

import java.util.HashMap;
import java.util.Map;
/**
 * ���������ȼ��࣬����������������������ȼ�
 * @author LXM
 *
 */
public class Priority {
	private static Map<String,Integer> priority;
	
	
	static{
		init();
	}
	
	/**
	 * ��ʼ�����ȼ�
	 */
	public static void init(){
		priority=new HashMap<String,Integer>();
		priority.put(Priority.generateKey("#", "#"), 0);
		priority.put(Priority.generateKey("#", "+"), -1);
		priority.put(Priority.generateKey("#", "-"), -1);
		priority.put(Priority.generateKey("#", "*"), -1);
		priority.put(Priority.generateKey("#", "/"), -1);
		priority.put(Priority.generateKey("#", "("), -1);
		priority.put(Priority.generateKey("#", ")"), 2);
		priority.put(Priority.generateKey("+", "#"), 1);
		priority.put(Priority.generateKey("+", "+"), 1);
		priority.put(Priority.generateKey("+", "-"), 1);
		priority.put(Priority.generateKey("+", "*"), -1);
		priority.put(Priority.generateKey("+", "/"), -1);
		priority.put(Priority.generateKey("+", "("), -1);
		priority.put(Priority.generateKey("+", ")"), 1);
		priority.put(Priority.generateKey("-", "#"), 1);
		priority.put(Priority.generateKey("-", "+"), 1);
		priority.put(Priority.generateKey("-", "-"), 1);
		priority.put(Priority.generateKey("-", "*"), -1);
		priority.put(Priority.generateKey("-", "/"), -1);
		priority.put(Priority.generateKey("-", "("), -1);
		priority.put(Priority.generateKey("-", ")"), 1);
		priority.put(Priority.generateKey("*", "#"), 1);
		priority.put(Priority.generateKey("*", "+"), 1);
		priority.put(Priority.generateKey("*", "-"), 1);
		priority.put(Priority.generateKey("*", "*"), 1);
		priority.put(Priority.generateKey("*", "/"), 1);
		priority.put(Priority.generateKey("*", "("), -1);
		priority.put(Priority.generateKey("*", ")"), 1);
		priority.put(Priority.generateKey("/", "#"), 1);
		priority.put(Priority.generateKey("/", "+"), 1);
		priority.put(Priority.generateKey("/", "-"), 1);
		priority.put(Priority.generateKey("/", "*"), 1);
		priority.put(Priority.generateKey("/", "/"), 1);
		priority.put(Priority.generateKey("/", "("), -1);
		priority.put(Priority.generateKey("/", ")"), 1);
		priority.put(Priority.generateKey("(", "#"), 2);
		priority.put(Priority.generateKey("(", "+"), -1);
		priority.put(Priority.generateKey("(", "-"), -1);
		priority.put(Priority.generateKey("(", "*"), -1);
		priority.put(Priority.generateKey("(", "/"), -1);
		priority.put(Priority.generateKey("(", "("), -1);
		priority.put(Priority.generateKey("(", ")"), 0);
		priority.put(Priority.generateKey(")", "#"), 1);
		priority.put(Priority.generateKey(")", "+"), 1);
		priority.put(Priority.generateKey(")", "-"), 1);
		priority.put(Priority.generateKey(")", "*"), 1);
		priority.put(Priority.generateKey(")", "/"), 1);
		priority.put(Priority.generateKey(")", "("), 2);
		priority.put(Priority.generateKey(")", ")"), 1);
	}
	
	/**
	 * �õ����������ɵ�key
	 * @param opA
	 * @param opB
	 * @return
	 */
	public static String generateKey(String opA,String opB){
		return opA+"_"+opB;
	}
	
	/**
	 * �Ƚ�����������֮������ȼ�
	 * @return a>b 1,a=b 0,a<b -1 无效2
	 */
	public static int comparePriority(String opA,String opB){
		if(Priority.priority==null){
			Priority.init();
		}
		return priority.get(Priority.generateKey(opA, opB));
	}
	
}
