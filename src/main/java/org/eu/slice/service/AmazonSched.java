package org.eu.slice.service;

import static org.quartz.JobBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AmazonSched implements InitializingBean, DisposableBean {

	private static Logger logger = LoggerFactory.getLogger(AmazonSched.class);

	private Scheduler sched = null;

	public static void main(String[] args) throws Exception {
		AmazonSched example = new AmazonSched();
		example.afterPropertiesSet();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("start quartz: AmazonSched");
		
		// 通过SchedulerFactory获取一个调度器实例
		SchedulerFactory sf = new StdSchedulerFactory();
		sched = sf.getScheduler();

		JobDetail job = newJob(AmazonJob.class).withIdentity("amazonjob", "group1")
				.build();

		job.getJobDataMap().put("items", AmazonJob.readItemsFromFile());

		CronTrigger trigger = newTrigger().withIdentity("amazontrigger", "group1")
				// .withSchedule(cronSchedule("26-30 58 * * * ?"))
				.withSchedule(cronSchedule("0 0/5 * * * ?")).forJob(job)
				.build();

		// 注册并进行调度
		sched.scheduleJob(job, trigger);

		// 启动调度器
		sched.start();
	}
	
	@Override
	public void destroy() throws Exception {
		logger.info("stop quartz: AmazonSched");
		
		// 调度器停止运行		
		if (sched != null)
			sched.shutdown(true);
	}
}
