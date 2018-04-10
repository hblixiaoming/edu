package com.lxm.algorithm.graph.minimumTree;

import com.lxm.algorithm.graph.matrix.Graph;
import com.lxm.algorithm.graph.matrix.GraphKind;
import com.lxm.algorithm.graph.matrix.Vertical;

/**
 * ��������ķ�㷨������С������
 * �ڽӾ����
 * �㷨˼��
 * ���弸��������U,V,T
 * U�������յõ�����С�������ĵ㼯��V�����������ĵ㵫������U�ĵ�ļ���
 * T������С�������ߵļ��ϡ�
 * 1 �ȴ�ͼ�����ѡȡһ������뵽U��
 * 2 �Ӷ�������U��V�����б���ѡȡȨ����С�ı߼���T��ͬʱV�е��Ǹ��������U��
 * 3 �ظ�2����ֱ��U�е�ĸ�������ͼ�ĵ������
 * Created by LXM on 2017/1/9.
 */
public class PrimAlgorithem {
    //�����洢��С�������ߵ�Ȩ�أ�������±��ʾ�ߵ��յ�
    int[] closedge;
    //�����±��closedge�������±����Ӧ�������ֵ��ʾ��С�������ߵ����
    int[] adjVex;
    //��ʼ������±�
    int INIT_NODE_NUM=1;

    //��ʼ����������ʼ����������Ϊ-1
    private void init(int n){
        //��������������
        closedge=new int[n];
        adjVex=new int[n];
        for(int i=0;i<n;i++){
            closedge[i]=Integer.MAX_VALUE;
            adjVex[i]=INIT_NODE_NUM;
        }
    }

    public void minimumTree_Prim(Graph graph,int n){
        //��ʼ������
        init(n);
        int sum=0;
        //�õ��ڽӾ���
        Vertical[][] verticals=graph.getVerticals();
        //���г�ʼ��
        for(int i=0;i<verticals[INIT_NODE_NUM].length;i++){
            //�����Ȩ����
            if(!"#".equals(verticals[INIT_NODE_NUM][i].getEdgeInfo())){
                adjVex[i]=INIT_NODE_NUM;
                closedge[i]=Integer.parseInt(verticals[INIT_NODE_NUM][i].getEdgeInfo());
            }
        }
        closedge[INIT_NODE_NUM]=0;
        //��û����ȫ��ʱ��ѭ����
        for(int i=0;i<n;i++){
            //�õ���С����һ��Ԫ��
            int k=this.getMinimum(closedge);
            //�����-1����closedge��adjVex,nodes
            if(k!=-1){
                sum+=closedge[k];
                //�����������
                printf(graph,k);
                //���ϱ��˵��������Ѿ����ҵ���
                closedge[k]=0;
                //����closedge
                for(int j=0;j<closedge.length;j++){
                    //�����Ȩ��ͬʱ�¼����ֵС��ԭ��������и���
                    String kInfo=verticals[k][j].getEdgeInfo();
                    if(!"#".equals(kInfo)&&closedge[j]>Integer.parseInt(kInfo)&&closedge[j]!=0){
                        adjVex[j]=k;
                        closedge[j]=Integer.parseInt(kInfo);
                    }
                }
            }
        }
        System.out.println("��СȨ�غ�Ϊ��"+sum);
    }

    /**
     * �����СȨ�ص��±�
     * @param closedge
     * @return
     */
    private int getMinimum(int[] closedge){
        if(closedge.length>0){
            int min=Integer.MAX_VALUE;
            int minSuffix=-1;
            for(int i=0;i<closedge.length;i++){
                int closedgeInt=closedge[i];
                if(closedgeInt<min&&closedgeInt!=0){
                    min=closedgeInt;
                    minSuffix=i;
                }
            }
            return minSuffix;
        }else{
            return -1;
        }
    }

    private void printf(Graph graph,int k){
        int start=adjVex[k];
        int end=k;
        String info=graph.getVerticals()[start][end].getEdgeInfo();
        System.out.println("��С��������:"+graph.getNodes()[start]+"-"+graph.getNodes()[end]+" Ȩ�أ�"+info);
    }


    public static void main(String[] args){
        Graph graph=new Graph();
        graph.createGraph(GraphKind.UDN);
        PrimAlgorithem prim=new PrimAlgorithem();
        prim.minimumTree_Prim(graph,graph.getNodeNum());
    }
}
