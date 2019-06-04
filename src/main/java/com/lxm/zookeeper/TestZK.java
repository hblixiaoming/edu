package com.lxm.zookeeper;


import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class TestZK {

    private void testCreate(ZookeeperApi zookeeper) throws Exception {
        boolean createResult = zookeeper.createNode("/test/hello/world", "test", ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("创建结果：" + createResult);
    }

    private void testGet(ZookeeperApi zookeeper) throws Exception {
        byte[] data = zookeeper.getData("/test", true, null);
        System.out.println("节点数据为：" + new String(data, "UTF-8"));
    }

    private void testSet(ZookeeperApi zookeeper) throws Exception {
        Stat stat = zookeeper.setData("/test", "hello".getBytes(), -1);
        System.out.println("设置数据返回：" + stat);
    }

    private void testExists(ZookeeperApi zookeeper) throws Exception {
        Stat stat = zookeeper.exists("/test", false);
        System.out.println("检查节点是否存在" + stat);
    }

    private void testAcl(ZookeeperApi zookeeper) throws Exception {
        Stat stat = zookeeper.setACLS("/test", ZooDefs.Ids.CREATOR_ALL_ACL, -1);
        System.out.println("设置节点权限" + stat);
    }

    private void testGetAcl(ZookeeperApi zookeeper) throws Exception {
        List<ACL> acls = zookeeper.getACLS("/test", null);
        System.out.println("获得节点权限" + acls);
    }

    public static void main(String[] args) throws Exception {
        TestZK testZK = new TestZK();
        ZookeeperApi zookeeper = new DefaultZookeeperApiImpl("127.0.0.1:2181");
        testZK.testCreate(zookeeper);
//        testZK.testGet(zookeeper);
//        testZK.testSet(zookeeper);
//        testZK.testGet(zookeeper);
//        testZK.testExists(zookeeper);
//        testZK.testAcl(zookeeper);
//        testZK.testGetAcl(zookeeper);
    }
}
