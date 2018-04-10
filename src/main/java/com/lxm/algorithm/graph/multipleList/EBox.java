package com.lxm.algorithm.graph.multipleList;

import com.lxm.algorithm.graph.comm.BaseEdge;

/**
 * ������ʾһ����
 * Created by LXM on 2017/1/6.
 */
public class EBox extends BaseEdge{
    //�ߵ�Ȩ��
    String info;
    //�Ƿ񱻷��ʵı�־
    boolean mark;
    //ָ��ǰ�ߵ�һ������
    VexBox ivex;
    //ָ��ǰ�ߵ�һ������
    VexBox jvex;
    //����ivex����һ����
    EBox ilink;
    //����jvex����һ����
    EBox jlink;

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public VexBox getIvex() {
        return ivex;
    }

    public void setIvex(VexBox ivex) {
        this.ivex = ivex;
    }

    public VexBox getJvex() {
        return jvex;
    }

    public void setJvex(VexBox jvex) {
        this.jvex = jvex;
    }

    public EBox getIlink() {
        return ilink;
    }

    public void setIlink(EBox ilink) {
        this.ilink = ilink;
    }

    public EBox getJlink() {
        return jlink;
    }

    public void setJlink(EBox jlink) {
        this.jlink = jlink;
    }



    @Override
    protected String getEdgeInfo() {
        return this.info;
    }
}
