package com.lxm.algorithm.graph.list;

import com.lxm.algorithm.graph.comm.BaseNode;

/**
 * �ڵ���б�
 * Created by LXM on 2016/12/2.
 */
public class VNode extends BaseNode{
    /**
     * �ڵ����Ϣ
     */
    String nodeInfo;
    /**
     * ָ������ͷ�ڵ��ָ��
     */
    ArcNode headNode;

    @Override
    public String getNodeInfo() {
        return nodeInfo;
    }

    public void setNodeInfo(String nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    public ArcNode getHeadNode() {
        return headNode;
    }

    public void setHeadNode(ArcNode headNode) {
        this.headNode = headNode;
    }
}
