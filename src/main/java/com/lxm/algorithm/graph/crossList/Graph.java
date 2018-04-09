package com.lxm.algorithm.graph.crossList;

/**
 * ʮ������
 * �ʺϴ洢����ͼ
 * Created by LXM on 2016/12/2.
 */
public class Graph {
    //���������
    VexNode[] vexNodes;
    //��ĸ���
    int vexnum;
    //�ߵĸ���
    int arcnum;

    public VexNode[] getVexNodes() {
        return vexNodes;
    }

    public void setVexNodes(VexNode[] vexNodes) {
        this.vexNodes = vexNodes;
    }

    public int getVexnum() {
        return vexnum;
    }

    public void setVexnum(int vexnum) {
        this.vexnum = vexnum;
    }

    public int getArcnum() {
        return arcnum;
    }

    public void setArcnum(int arcnum) {
        this.arcnum = arcnum;
    }
}
