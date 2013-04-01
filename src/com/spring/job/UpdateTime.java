package com.spring.job;

import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
import org.springframework.scheduling.quartz.QuartzJobBean; 

public class UpdateTime extends QuartzJobBean {
	private MyTime myTime;

	/**
	 * 依赖注入myTime
	 * 
	 * @param myTime
	 */
	public void setMyTime(MyTime myTime) {
		this.myTime = myTime;
	}

	/**
	 * 在这个定时任务里面只做打印出当前的时间！
	 */
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		myTime.getTime();
	}
}
