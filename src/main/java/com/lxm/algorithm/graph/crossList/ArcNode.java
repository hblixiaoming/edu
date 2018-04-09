package com.lxm.algorithm.graph.crossList;

import graph.comm.BaseEdge;

/**
 * �������ݽṹ��ʾһ���߻���һ����
 * Created by LXM on 2017/1/6.
 */
public class ArcNode extends BaseEdge{
    //����Ȩ����Ϣ
    String info;
    //������ͬ����һ����
    ArcNode hlink;
    //β����ͬ����һ����
    ArcNode tlink;
    //��β�ڵ�������±�
    VexNode tailVex;
    //��ͷ�ڵ�������±�
    VexNode headVex;


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArcNode getHlink() {
        return hlink;
    }

    public void setHlink(ArcNode hlink) {
        this.hlink = hlink;
    }

    public ArcNode getTlink() {
        return tlink;
    }

    public void setTlink(ArcNode tlink) {
        this.tlink = tlink;
    }

    public VexNode getHeadVex() {
        return headVex;
    }

    public void setHeadVex(VexNode headVex) {
        this.headVex = headVex;
    }

    public VexNode getTailVex() {
        return tailVex;
    }

    public void setTailVex(VexNode tailVex) {
        this.tailVex = tailVex;
    }

    @Override
    protected String getEdgeInfo() {
        return this.info;
    }
}
