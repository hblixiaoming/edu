package com.lxm.algorithm.graph.traverse;

import com.lxm.algorithm.graph.matrix.Graph;
import com.lxm.algorithm.graph.matrix.GraphKind;
import com.lxm.algorithm.graph.matrix.NodeType;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ������ȱ����㷨
 * �ڽӾ����ʵ��
 * �㷨˼�룺
 * 1 ��ʼ�������
 * 2 �����в�Ϊ�գ������в����ʣ������к�̵������
 * 3 ֱ������Ϊ��Ϊֹ
 * Created by LXM on 2017/1/6.
 */
public class WideTraverse {
    //�ڵ��Ƿ��Ѿ������ʹ��ı�ʶ
    //1:�Ѿ������ʹ���0:��δ�����ʹ�
    int[] visit;


    //������ȱ���ͼ
    public void traverse(Graph graph){
        //��ʼ����־����
        visit=new int[graph.getNodeNum()];
        //��ʼ�����ʱ�־����
        for(int i=0;i<graph.getNodeNum();i++){
            visit[i]=0;
        }
        //����һ��queue�����洢Ԫ��
        Queue<Integer> queue=new ArrayDeque<>();
        //�������нڵ�
        for(int i=0;i<graph.getNodeNum();i++){
            //�����һ���ڵ㻹δ������
            if(visit[i]==0){
                //���õ�һ���ڵ��Ѿ������ʵı�־
                visit[i]=1;
                //���ʵ�һ���ڵ�
                visit(graph.getNodes()[i]);
                //����һ���ڵ������
                queue.offer(i);
                //�����в�Ϊ�յ�����£�������һ��Ԫ�أ����������������й����ڵ������
                while(!queue.isEmpty()){
                    //������һ��Ԫ��
                    int node=queue.poll();
                    //�������Ԫ�ص��������ڽڵ㣬������Щ�ڵ������
                    for(int w=getLast(graph,node,0);w>=0;w=getLast(graph,node,w)){
                        //�����û�б�����������н��з���
                        if(visit[w]==0){
                            //�������Ԫ��
                            visit(graph.getNodes()[w]);
                            //�������Ԫ���Ѿ�������
                            visit[w]=1;
                            queue.offer(w);
                        }

                    }
                }
            }

        }
    }


    /**
     * �õ���i���ڵ�ĵ�j�������һ���ڽӵ�
     * @param i �ڵ�i�������±�
     * @param j �ڵ�j�������±�
     * @return �ڵ������±�
     */
    public int getLast(Graph graph,int i,int j){
        for(int s=j+1;s<graph.getNodeNum();s++){
            if(!"#".equals(graph.getVerticals()[i][s].getEdgeInfo())){
                return s;
            }
        }
        return -1;
    }

    /**
     * ���ʽڵ�
     * @param node �����ʵĽڵ�
     */
    private void visit(NodeType node){
        System.out.print(node.getNodeInfo()+" ");
    }

    public static void main(String[] args){
        Graph graph=new Graph();
        graph.createGraph(GraphKind.UDN);
        WideTraverse traverse=new WideTraverse();
        traverse.traverse(graph);
    }
}
