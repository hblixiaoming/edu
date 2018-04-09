package com.lxm.algorithm.graph.matrix;

import graph.comm.BaseNode;

/**
 * ��
 * Created by LXM on 2016/8/25.
 */
public class NodeType extends BaseNode{
    String info;

    public NodeType(String info){
        this.info=info;
    }


    @Override
    public String toString() {
        return info;
    }

    @Override
    public String getNodeInfo() {
        return this.info;
    }
}
