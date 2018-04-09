package com.lxm.algorithm.search;
/**
 * �����������㷨
 * (1)��������������Ϊ�գ��������������е�ֵ��С�����ĸ��ڵ��ֵ
 * (2)���������������գ��������������н���ֵ���������ĸ��ڵ��ֵ
 * (3)������������Ҷ�ֱ�Ϊ����������
 * Created by LXM on 2017/2/1.
 */
public class BinarySearchTree {

    /**
     * �����������Ĳ����㷨
     * ������ҳɹ��򷵻�true��pָ�򱻲��ҵ�Ԫ��
     * �������ʧ���򷵻�false,pָ�����·���ϵ����һ���ڵ�
     * @param rootNode ���ڵ��ָ��
     * @param n Ҫ���ҵ�Ԫ��n
     * @return ���ҳɹ�����true,����ʧ�ܷ���false
     */
    public static BinaryTreeNode searchBST(BinaryTreeNode rootNode,int n){
        if(rootNode==null){
            return null;
        }
        if(rootNode.getData()==n){
            return rootNode;
        }else if(n<rootNode.getData()){
            return searchBST(rootNode.getlChild(),n);
        }else{
            return searchBST(rootNode.getrChild(),n);
        }
    }

    /**
     * ����һ�Ŷ���������
     * ���Ȳ��ң��������ʧ�ܣ������ָ��Ľڵ��Ƿ�Ϊ���Լ����������Ĵ�С����
     * �����µĽڵ�
     * @param rootNode ���ĸ��ڵ�
     * @param e Ҫ�����Ԫ��
     */
    public static BinaryTreeNode insertBST(BinaryTreeNode rootNode,int e){
        if(rootNode==null){
            //�¹���һ�����������
            return new BinaryTreeNode(e);
        }
        if(rootNode.getData()>e) {
            //������ڵ�
            BinaryTreeNode temp=insertBST(rootNode.lChild,e);
            temp.parent=rootNode;
            rootNode.lChild = temp;
        } else if(rootNode.getData()<e) {
            //�����ҽڵ�
            BinaryTreeNode temp=insertBST(rootNode.rChild,e);
            temp.parent=rootNode;
            rootNode.rChild = temp;
        }
        return rootNode;
    }

    /**
     * ����������ɾ��һ���ڵ�
     * @param rootNode ���ĸ��ڵ�
     * @param e Ҫɾ����Ԫ��
     * @return
     */
    public static BinaryTreeNode removeNode(BinaryTreeNode rootNode,int e){
        if(rootNode == null)
            return null;//û���ҵ�,doNothing
        if(rootNode.getData()<e) {
            rootNode.rChild = removeNode(rootNode.rChild, e);
        } else if(rootNode.getData()>e) {
            rootNode.lChild = removeNode(rootNode.lChild, e);
        } else if(rootNode.lChild!=null&&rootNode.rChild!=null) {
            //�������ϵ���С�ڵ������滻ɾ���Ľڵ�
            BinaryTreeNode minNode=findMin(rootNode.rChild);
            //��ɾ���ڵ�ĸ��ڵ�
            BinaryTreeNode parentNode=rootNode.parent;
            //�����С�ڵ�С�ڸ��ڵ��Ȩ������λ��������
            if(minNode.getData()<parentNode.getData())
                parentNode.lChild=minNode;
            //����λ��������
            else
                parentNode.rChild=minNode;
            //����С�ڵ�����ֵܣ�Ų��ԭ���ڵ��λ��
            minNode.parent.lChild=minNode.parent.rChild;
            //�ҽڵ���Ϊ��
            minNode.parent.rChild=null;
            //��Ҫɾ���ڵ�����Һ��Ӷ��ŵ������Ľڵ���
            minNode.lChild=rootNode.lChild;
            minNode.rChild=rootNode.rChild;
            //�����ڵ����Һ��ӵĸ��ڵ�ָ����С�ڵ�
            rootNode.lChild.parent=rootNode.rChild.parent=minNode;
            //�õ�ǰ����parentָ�򸸽ڵ�
            minNode.parent=parentNode;
            //���Ƴ��ڵ�����Һ��Ӷ���Ϊ��
            rootNode.lChild=rootNode.rChild=null;
        } else if(rootNode.lChild!=null){
            rootNode.parent = rootNode.lChild;
            rootNode.lChild.parent=rootNode.parent;
        }else if(rootNode.rChild!=null){
            rootNode.parent = rootNode.rChild;
            rootNode.rChild.parent=rootNode.parent;
        }else if(rootNode.getData()<rootNode.parent.getData()){
            rootNode.parent.lChild=null;
        }else if(rootNode.getData()>rootNode.parent.getData()){
            rootNode.parent.rChild=null;
        }
        return rootNode;
    }


    //������������С�ڵ�
    private static BinaryTreeNode findMin(BinaryTreeNode rootNode){
        BinaryTreeNode minData=rootNode;
        while(rootNode!=null){
            if(rootNode.getData()<minData.getData()){
                minData=rootNode;
            }
            rootNode=rootNode.lChild;
        }
        return minData;
    }


    public static void main(String[] args){
        int[] eles=new int[]{45,3,24,37,12,52,100,61,90,78};
        BinaryTreeNode rootNode=null;
        for(int i=0;i<eles.length;i++){
            rootNode=insertBST(rootNode,eles[i]);
        }
        BinaryTreeNode removeNode=removeNode(rootNode,3);
        System.out.println(removeNode.getData());
    }

}