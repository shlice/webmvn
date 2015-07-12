package org.eu.slice.service;

import static org.quartz.JobBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class YunSignSched implements InitializingBean, DisposableBean {

	private static Logger logger = LoggerFactory.getLogger(YunSignSched.class);

	private static Scheduler sched = null;
    private static CronTrigger signtrigger = null;

	public static void main(String[] args) throws Exception {
		YunSignSched example = new YunSignSched();
		example.afterPropertiesSet();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("start quartz: YunSignSched");
		
		// 通过SchedulerFactory获取一个调度器实例
		SchedulerFactory sf = new StdSchedulerFactory();
		sched = sf.getScheduler();

		// 通过过JobDetail封装HelloJob，同时指定Job在Scheduler中所属组及名称
		// JobDetail job = newJob(YunJob.class).withIdentity("job1", "group1")
		// .build();
		JobDetail signjob = newJob(YunJob2.class).withIdentity("signjob", "group1")
				.build();

		// 创建一个Trigger实例，指定该Trigger在Scheduler中所属组及名称。
		// CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1")
		// .withSchedule(cronSchedule("26-30 58 * * * ?")).forJob(job)
		// .build();
		// CronTrigger trigger2 = newTrigger().withIdentity("trigger2",
		// "group1")
		// .withSchedule(cronSchedule("0/10 * * * * ?"))
		// .forJob(job).build();
		signtrigger = newTrigger().withIdentity("signtrigger", "group1")
				 .withSchedule(cronSchedule("0 0 0 * * ?"))
				.build();

        JobDetail syncjob = newJob(YunTimeSync.class).withIdentity("syncjob", "group1")
                .build();
        CronTrigger synctrigger = newTrigger().withIdentity("synctrigger", "group1")
                .withSchedule(cronSchedule("0 30 0 * * ?"))
                .build();
		// Trigger trigger = newTrigger()
		// .withIdentity("trigger1", "group1")
		// .startNow()
		// .withSchedule(simpleSchedule().withIntervalInSeconds(40)
		// .repeatForever())
		// .build();

		// 注册并进行调度
		// sched.scheduleJob(job, trigger);
		// sched.scheduleJob(trigger2);
		sched.scheduleJob(signjob, signtrigger);

        sched.scheduleJob(syncjob, synctrigger);

		// 启动调度器
		sched.start();

        sched.triggerJob(JobKey.jobKey("syncjob", "group1"));

        //
		// try {
		// //当前线程等待65秒
		// Thread.sleep(65L * 1000L);
		// } catch (Exception e) {
		// }
		//
		// // 调度器停止运行
		// sched.shutdown(true);
	}

	@Override
	public void destroy() throws Exception {
		logger.info("stop quartz: YunSingSched");
		
		// 调度器停止运行
		if (sched != null)
			sched.shutdown(true);
	}


    public static void reSchedSignJob(int curDevSeconds)
    {
        String newExpression = "";
        int sec = 0;
        int min = 0;
        int secT = 0;

        // 考虑网络延时，再提前3秒
        curDevSeconds -= 3;
        //

        if(curDevSeconds == 0) {
        }
        else if(curDevSeconds < 0) {
            int t = Math.abs(curDevSeconds) % 60;
            sec = t==0?0:60-t;
            min = (int) (60-Math.ceil((double)Math.abs(curDevSeconds) / 60));
            while(min < 0)
                min += 60;
        }
        else{
            sec = curDevSeconds%60;
            min = curDevSeconds/60;
            while(min >= 60)
                min -= 60;
        }
        secT = sec+4;
        secT = secT>=60?secT-60:secT;
        newExpression += sec+"-"+secT + " " + min + " * * * ?";

        logger.info("new expression is:" + newExpression);

        // 按新的cronExpression表达式重新构建trigger
        signtrigger = signtrigger.getTriggerBuilder().withIdentity("signtrigger", "group1")
                .withSchedule(cronSchedule(newExpression)).startNow().build();//must add startNow. if not, the last job will execute immediately

        // 按新的trigger重新设置job执行
        TriggerKey triggerKey = TriggerKey.triggerKey("signtrigger", "group1");
        try {
            sched.rescheduleJob(triggerKey, signtrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
