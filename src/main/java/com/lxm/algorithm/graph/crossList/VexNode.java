package com.lxm.algorithm.graph.crossList;

import graph.comm.BaseEdge;

/**
 * ������ݽṹ
 * Created by LXM on 2017/1/6.
 */
public class VexNode extends BaseEdge{
    //������Ϣ
    String info;
    //�Ե�ǰ���Ϊͷ�ĵ�һ����
    ArcNode firstIn;
    //�Ե�ǰ�ڵ�Ϊβ�ĵ�һ����
    ArcNode firstOut;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArcNode getFirstIn() {
        return firstIn;
    }

    public void setFirstIn(ArcNode firstIn) {
        this.firstIn = firstIn;
    }

    public ArcNode getFirstOut() {
        return firstOut;
    }

    public void setFirstOut(ArcNode firstOut) {
        this.firstOut = firstOut;
    }

    @Override
    protected String getEdgeInfo() {
        return this.getInfo();
    }
}
