package com.lxm.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;

import java.io.IOException;
import java.util.List;

public class DefaultZookeeperApiImpl implements ZookeeperApi {
    private String serverHost;
    private Integer timeout = 3000;
    private ZooKeeper zooKeeper;

    public void init() throws IOException {
        zooKeeper = new ZooKeeper(serverHost, timeout, new Watcher() {
            public void process(WatchedEvent event) {
                if (event.getState().equals(Event.KeeperState.SyncConnected)) {
                    System.out.println("");
                }
                System.out.println("接收内容：" + event.toString());
            }
        });
    }

    public boolean createNode(String nodeName, String data, List<ACL> acls, CreateMode createMode) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        String result = zooKeeper.create(nodeName, data.getBytes(), acls, createMode);
        return result.length() > 0;
    }

    public boolean deleteNode(String nodeName) throws Exception {
        return false;
    }

    public Object getNode(String nodeName) throws Exception {
        return null;
    }

    public boolean updateNode(String nodeName, String data) throws Exception {
        return false;
    }
}
