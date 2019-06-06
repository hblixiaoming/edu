package com.lxm.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.CronCalendar;

public class TestQuartzSimple {
    public void test1() {
        try {
            //通过schedulerFactory获取一个调度器

            SchedulerFactory schedulerfactory = new StdSchedulerFactory("D:\\workspace\\edu\\src\\main\\java\\com\\lxm\\quartz\\quartz.properties");
            Scheduler scheduler = null;
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();

            // 创建jobDetail实例，绑定Job实现类
            // 指明job的名称，所在组的名称，以及绑定job类
            JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("JobName", "JobGroupName").build();

            //  corn表达式  每五秒执行一次
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("CronTrigger1", "CronTriggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                    .startNow().build();

            // 把作业和触发器注册到任务调度中
            scheduler.scheduleJob(job, trigger);

            // 启动调度
            scheduler.start();

            Thread.sleep(10000);

            // 停止调度
            scheduler.shutdown();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestQuartzSimple test = new TestQuartzSimple();
        test.test1();
    }
}
