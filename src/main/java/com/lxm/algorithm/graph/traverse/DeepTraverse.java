package com.lxm.algorithm.graph.traverse;

import graph.matrix.Graph;
import graph.matrix.GraphKind;
import graph.matrix.NodeType;

/**
 * ������ȱ����㷨
 * �ڽӾ����ʵ��
 * �㷨˼�룺
 * 1 ��ͼ������ѡȡһ���ڵ��������
 * 2 �����������ڽӵ���η��ʣ��������Ѿ������ʵĵ�ʱ
 * 3 ���´�δ�����ʵĵ���ѡһ����ִ�в���2ֱ�����е��ѱ�����
 * Created by LXM on 2017/1/6.
 */
public class DeepTraverse {
    //�ڵ��Ƿ��Ѿ������ʱ�־����
    //1:�Ѿ������ʣ�0:��δ������
    int[] visit;


    public void traverse(Graph graph){
        //��ʼ����־����
        visit=new int[graph.getNodeNum()];
        //��ʼ�����ʱ�־����
        for(int i=0;i<graph.getNodeNum();i++){
            visit[i]=0;
        }
        //ѭ���������нڵ㣬������δ�����ʵĽڵ�
        for(int i=0;i<graph.getNodeNum();i++){
            //�����i���ڵ㻹û�б����ʹ�����������޸����־λ
            if(visit[i]==0){
                dfs(graph,i);
            }
        }
    }

    //���ʵ�i���ڵ�
    private void dfs(Graph graph,int i){
        //�������ڵ��Ѿ������ʹ�
        visit[i]=1;
        //�ȷ�������ڵ�
        visit(graph.getNodes()[i]);
        //�õ���һ���ڵ���±ֱ꣬�����һ���ڵ㣬���ϵı�������ڵ���ӽڵ�
        for(int w=this.getLast(graph,i,0);w>=0;w=this.getLast(graph,i,w)){
            if(visit[w]==0){
                dfs(graph,w);
            }
        }
    }


    /**
     * �õ���i���ڵ�ĵ�j�������һ���ڽӵ�
     * @param i �ڵ�i�������±�
     * @param j �ڵ�j�������±�
     * @return
     */
    public int getLast(Graph graph,int i,int j){
        for(int s=j+1;s<graph.getNodeNum();s++){
            if(!"#".equals(graph.getVerticals()[i][s].getEdgeInfo())){
                return s;
            }
        }
        return -1;
    }

    //���ʽڵ�
    private void visit(NodeType node){
        System.out.print(node.getNodeInfo()+" ");
    }


    public static void main(String[] args){
        Graph graph=new Graph();
        graph.createGraph(GraphKind.UDN);
        DeepTraverse traverse=new DeepTraverse();
        traverse.traverse(graph);
    }
}
