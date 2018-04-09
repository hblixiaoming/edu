package com.lxm.algorithm.graph.matrix;

import graph.comm.BaseEdge;

/**
 * ��
 * Created by LXM on 2016/8/25.
 */
public class Vertical extends BaseEdge{
    String info;

    public Vertical(String info){
        this.info=info;
    }

    @Override
    public String toString() {
        return info;
    }

    @Override
    public String getEdgeInfo() {
        return this.info;
    }
}
