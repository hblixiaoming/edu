package com.lxm.algorithm.graph.list;

import graph.comm.BaseEdge;

/**
 * ����ڵ�
 * Created by LXM on 2016/12/2.
 */
public class ArcNode extends BaseEdge{
    /**
     * �ߵ���Ϣ
     */
    String vInfo;
    /**
     * �ߵ���һ�߽ڵ������
     */
    int nodeIndex;
    /**
     * ָ����һ���ڵ��ָ��
     */
    ArcNode next;

    public String getvInfo() {
        return vInfo;
    }

    public void setvInfo(String vInfo) {
        this.vInfo = vInfo;
    }

    public ArcNode getNext() {
        return next;
    }

    public void setNext(ArcNode next) {
        this.next = next;
    }

    public int getNodeIndex() {
        return nodeIndex;
    }

    public void setNodeIndex(int nodeIndex) {
        this.nodeIndex = nodeIndex;
    }

    @Override
    protected String getEdgeInfo() {
        return this.vInfo;
    }
}
