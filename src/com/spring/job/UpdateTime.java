package com.spring.job;

import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
import org.springframework.scheduling.quartz.QuartzJobBean; 

public class UpdateTime extends QuartzJobBean {
	private MyTime myTime;

	/**
	 * ����ע��myTime
	 * 
	 * @param myTime
	 */
	public void setMyTime(MyTime myTime) {
		this.myTime = myTime;
	}

	/**
	 * �������ʱ��������ֻ����ӡ����ǰ��ʱ�䣡
	 */
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		myTime.getTime();
	}
}
