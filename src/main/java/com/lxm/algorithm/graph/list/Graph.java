package com.lxm.algorithm.graph.list;

/**
 * �ڽӱ�Ĵ洢
 * �ʺϴ洢����ͼ�����ʺϴ洢����ͼ
 * Created by LXM on 2016/12/2.
 */
public class Graph {
    /**
     * ���������
     */
    VNode[] nodes;
    /**
     * �ߵĸ���
     */
    int vexNum;
    /**
     * ��ĸ���
     */
    int arcNum;

    public VNode[] getNodes() {
        return nodes;
    }

    public void setNodes(VNode[] nodes) {
        this.nodes = nodes;
    }

    public int getVexNum() {
        return vexNum;
    }

    public void setVexNum(int vexNum) {
        this.vexNum = vexNum;
    }

    public int getArcNum() {
        return arcNum;
    }

    public void setArcNum(int arcNum) {
        this.arcNum = arcNum;
    }
}
