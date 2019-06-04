package com.lxm.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;

public class DefaultZookeeperApiImpl implements ZookeeperApi {
    private String serverHost;
    private Integer timeout = 3000;
    private ZooKeeper zooKeeper;
    private Watcher watcher = new DefaultWatcher();

    public DefaultZookeeperApiImpl(String serverHost) {
        this.serverHost = serverHost;
    }

    public DefaultZookeeperApiImpl(String serverHost, Watcher watcher) {
        this.serverHost = serverHost;
        this.watcher = watcher;
    }

    public DefaultZookeeperApiImpl(String serverHost, int timeout, Watcher watcher) {
        this.serverHost = serverHost;
        this.timeout = timeout;
        this.watcher = watcher;
    }

    public void init() throws IOException {
        zooKeeper = new ZooKeeper(serverHost, timeout, watcher);
    }

    @Override
    public boolean createNode(String path, String data, List<ACL> acls, CreateMode createMode) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        String result = zooKeeper.create(path, data.getBytes(), acls, createMode);
        return result.length() > 0;
    }


    @Override
    public void createNodeAsyn(String path, String data, List<ACL> acls, CreateMode createMode, AsyncCallback.StringCallback callback, Object ctx) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        zooKeeper.create(path, data.getBytes(), acls, createMode, callback, ctx);
    }

    @Override
    public void deleteNode(String path, int version) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        zooKeeper.delete(path, version);
    }

    @Override
    public void deleteNodeAsyn(String path, int version, AsyncCallback.VoidCallback callback, Object ctx) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        zooKeeper.delete(path, version, callback, ctx);
    }

    @Override
    public byte[] getData(String path, Watcher watcher, Stat stat) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        return zooKeeper.getData(path, watcher, stat);
    }

    @Override
    public byte[] getData(String path, boolean watcher, Stat stat) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        return zooKeeper.getData(path, watcher, stat);
    }

    @Override
    public Stat setData(String path, byte[] data, int version) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        return zooKeeper.setData(path, data, version);
    }

    @Override
    public Stat exists(String path, boolean watcher) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        return zooKeeper.exists(path, watcher);
    }

    @Override
    public Stat exists(String path, Watcher watcher) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        return zooKeeper.exists(path, watcher);
    }

    @Override
    public Stat setACLS(String path, List<ACL> acls, int version) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        return zooKeeper.setACL(path, acls, version);
    }

    @Override
    public List<ACL> getACLS(String path, Stat stat) throws Exception {
        if (zooKeeper == null) {
            init();
        }
        return zooKeeper.getACL(path, stat);
    }

    private class DefaultWatcher implements Watcher {
        @Override
        public void process(WatchedEvent event) {
            System.out.println("收到来自服务器的内容：" + event.toString());
        }
    }
}
