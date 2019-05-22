package com.lxm.test;

import org.springframework.beans.factory.annotation.Autowired;

public class UseTest {
    @Autowired
    private ThreadPoolService threadPoolService;
    public void saveLog(String log){
        //主线程任务
        //提交任务
        threadPoolService.submit(new Runnable() {
            @Override
            public void run() {
               //iSysLogApiDao.insert(log);
            }
        });
        //
    }
}
