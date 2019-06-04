package com.lxm.zookeeper;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public interface ZookeeperApi {
    /**
     * 创建节点
     *
     * @param path
     * @param data
     * @param acls
     * @param createMode
     * @return
     * @throws Exception
     */
    boolean createNode(String path, String data, List<ACL> acls, CreateMode createMode) throws Exception;

    /**
     * 异步创建节点
     *
     * @param path
     * @param data
     * @param acls
     * @param createMode
     * @param callback
     * @param ctx
     * @throws Exception
     */
    void createNodeAsyn(String path, String data, List<ACL> acls, CreateMode createMode, AsyncCallback.StringCallback callback, Object ctx) throws Exception;

    /**
     * 删除节点
     *
     * @param path
     * @param version
     * @throws Exception
     */
    void deleteNode(String path, int version) throws Exception;

    /**
     * 异步删除节点
     *
     * @param path
     * @param version
     * @param callback
     * @param ctx
     * @throws Exception
     */
    void deleteNodeAsyn(String path, int version, AsyncCallback.VoidCallback callback, Object ctx) throws Exception;

    /**
     * 获取节点的数据
     *
     * @param path
     * @param watcher
     * @param stat
     * @return
     * @throws Exception
     */
    byte[] getData(String path, Watcher watcher, Stat stat) throws Exception;

    /**
     * 获取节点的数据
     *
     * @param path
     * @param watcher
     * @param stat
     * @return
     * @throws Exception
     */
    byte[] getData(String path, boolean watcher, Stat stat) throws Exception;

    /**
     * 设置节点数据
     *
     * @param path
     * @param data
     * @param version
     * @return
     * @throws Exception
     */
    Stat setData(String path, byte[] data, int version) throws Exception;

    /**
     * 判断节点是否存在
     *
     * @param path
     * @param watch
     * @return
     * @throws Exception
     */
    Stat exists(String path, boolean watch) throws Exception;

    /**
     * 判断节点是否存在
     *
     * @param path
     * @param watcher
     * @return
     * @throws Exception
     */
    Stat exists(String path, Watcher watcher) throws Exception;

    /**
     * 设置访问权限
     *
     * @param path
     * @param acls
     * @param version
     * @return
     * @throws Exception
     */
    Stat setACLS(String path, List<ACL> acls, int version) throws Exception;

    /**
     * 获得节点权限列表
     *
     * @param path
     * @param stat
     * @return
     * @throws Exception
     */
    List<ACL> getACLS(String path, Stat stat) throws Exception;
}
