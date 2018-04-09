package com.lxm.algorithm.graph.matrix;

import java.util.Arrays;

/**
 * ͼ�����ݵ����ݽṹ
 * �ڽӾ���洢
 * �ʺϴ洢�߶����ͼ=��
 * Created by LXM on 2016/8/25.
 */
public class Graph {
    //�������
    final static int MAX_NODE_NUM=10;
    //���߸���
    final static int MAX_VERTICAL_NUM=45;
    //��ļ���
    NodeType[] nodes;
    //�ߵļ���
    Vertical[][] verticals;
    //��ĸ���
    int nodeNum;
    //�ߵĸ���
    int verticalNum;
    //ͼ������
    GraphKind graphKind;

    public Graph(int nodeNum,int verticalNum,GraphKind graphKind){
        this.nodes=new NodeType[nodeNum];
        this.verticals=new Vertical[nodeNum][nodeNum];
        this.graphKind=graphKind;
    }

    public Graph(){
        this(MAX_NODE_NUM,MAX_VERTICAL_NUM,GraphKind.UDG);
    }

    public void createGraph(GraphKind graphKind){
        switch(graphKind){
            case UDN:createUDN();break;
        }
    }

    /*
     * ����һ������ͼ
     */
    private void createUDN(){
        nodes=new NodeType[]{new NodeType("A"),new NodeType("B"),new NodeType("C"),
                new NodeType("D"),new NodeType("E"),new NodeType("F")};
        nodeNum=6;
        verticals=new Vertical[][]{
                {new Vertical("#"),new Vertical("6"),new Vertical("#"),new Vertical("#"),new Vertical("5"),new Vertical("1")},
                {new Vertical("6"),new Vertical("#"),new Vertical("3"),new Vertical("#"),new Vertical("#"),new Vertical("5")},
                {new Vertical("#"),new Vertical("3"),new Vertical("#"),new Vertical("6"),new Vertical("#"),new Vertical("6")},
                {new Vertical("#"),new Vertical("#"),new Vertical("6"),new Vertical("#"),new Vertical("2"),new Vertical("4")},
                {new Vertical("5"),new Vertical("#"),new Vertical("#"),new Vertical("2"),new Vertical("#"),new Vertical("5")},
                {new Vertical("1"),new Vertical("5"),new Vertical("6"),new Vertical("4"),new Vertical("5"),new Vertical("#")}
        };
        verticalNum=10;
    }

    //�������ͼ
    public void tranverse(){
        System.out.println("�ڵ���б�:");
        Arrays.asList(this.nodes).forEach(node->System.out.print(node+","));
        System.out.println();
        //������ά����
        System.out.println("�ڽӾ����б�");
        for(int i=0;i<verticals.length;i++){
            for(int j=0;j<verticals[i].length;j++){
                System.out.print(verticals[i][j]+" ");
            }
            System.out.println();
        }
    }

    public NodeType[] getNodes() {
        return nodes;
    }

    public void setNodes(NodeType[] nodes) {
        this.nodes = nodes;
    }

    public Vertical[][] getVerticals() {
        return verticals;
    }

    public void setVerticals(Vertical[][] verticals) {
        this.verticals = verticals;
    }

    public int getNodeNum() {
        return nodeNum;
    }

    public void setNodeNum(int nodeNum) {
        this.nodeNum = nodeNum;
    }

    public int getVerticalNum() {
        return verticalNum;
    }

    public void setVerticalNum(int verticalNum) {
        this.verticalNum = verticalNum;
    }

    public GraphKind getGraphKind() {
        return graphKind;
    }

    public void setGraphKind(GraphKind graphKind) {
        this.graphKind = graphKind;
    }



    public static void main(String[] args){
        Graph graph=new Graph();
        graph.createUDN();
        graph.tranverse();
    }
}
