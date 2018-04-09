package com.lxm.algorithm.graph.multipleList;

import graph.comm.BaseNode;

/**
 * ��������ݽṹ
 * ��ʾһ������
 * Created by LXM on 2017/1/6.
 */
public class VexBox extends BaseNode{
    //���������
    String data;
    //ָ��ǰ����ĵ�һ����
    EBox firstEdge;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public EBox getFirstEdge() {
        return firstEdge;
    }

    public void setFirstEdge(EBox firstEdge) {
        this.firstEdge = firstEdge;
    }

    @Override
    public String getNodeInfo() {
        return this.data;
    }
}
