package com.lxm.algorithm.graph.multipleList;

/**
 * �ڽӶ��ر�
 * ���������洢����ͼ
 * Created by LXM on 2017/1/6.
 */
public class Graph {
    //����ļ���
    VexBox[] vexBoxes;
    //����ĸ���
    int vexnum;
    //�ߵĸ���
    int edgenum;

    public VexBox[] getVexBoxes() {
        return vexBoxes;
    }

    public void setVexBoxes(VexBox[] vexBoxes) {
        this.vexBoxes = vexBoxes;
    }

    public int getEdgenum() {
        return edgenum;
    }

    public void setEdgenum(int edgenum) {
        this.edgenum = edgenum;
    }

    public int getVexnum() {
        return vexnum;
    }

    public void setVexnum(int vexnum) {
        this.vexnum = vexnum;
    }
}
