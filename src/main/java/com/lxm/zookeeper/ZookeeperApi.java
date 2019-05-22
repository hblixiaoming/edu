package com.lxm.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.ACL;

import java.util.List;

public interface ZookeeperApi {
    boolean createNode(String nodeName, String data, List<ACL> acls, CreateMode createMode) throws Exception;

    boolean deleteNode(String nodeName) throws Exception;

    Object getNode(String nodeName) throws Exception;

    boolean updateNode(String nodeName, String data) throws Exception;
}
