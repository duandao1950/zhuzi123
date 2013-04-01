package com.hibernate.beans;

import java.io.Serializable;

/**
 * @author lkf12998
 *
 */
public class PerformanceCRM extends AbstractCommonBean implements Serializable 
{	
	
	private Integer id;
	
	private String staffId;//员工ID
	
	private String staffName;//员工名称
	
	private Integer requirmentAnalyze;//需求分析
	
	private Integer coding;//开发
	
	private Integer problemCounts;//处理问题单
	
	private Integer checkCode;//编译、静态检查、注释
	
	private Integer codeConfirm;//代码走查
	
	private Integer workAttitude;//工作态度
	
	private Integer training;//培训
	
	private Integer teamContribute;//团队贡献
	
	private Integer dailyWork;//日常工作
	
	private String inMonth;//月份
	
	private Integer other;//其他
	
	public Integer getId() 
	{
		return id;
	}
	public void setId(Integer id) 
	{
		this.id = id;
	}
	
	public String getStaffId() 
	{
		return staffId;
	}

	public void setStaffId(String staffId) 
	{
		this.staffId = staffId;
	}

	public String getStaffName() 
	{
		return staffName;
	}

	public void setStaffName(String staffName) 
	{
		this.staffName = staffName;
	}

	public Integer getRequirmentAnalyze() 
	{
		return requirmentAnalyze;
	}

	public void setRequirmentAnalyze(Integer requirmentAnalyze) 
	{
		this.requirmentAnalyze = requirmentAnalyze;
	}

	public Integer getCoding() 
	{
		return coding;
	}

	public void setCoding(Integer coding) 
	{
		this.coding = coding;
	}

	public Integer getProblemCounts() 
	{
		return problemCounts;
	}

	public void setProblemCounts(Integer problemCounts) 
	{
		this.problemCounts = problemCounts;
	}

	public Integer getCheckCode() 
	{
		return checkCode;
	}

	public void setCheckCode(Integer checkCode) 
	{
		this.checkCode = checkCode;
	}

	public Integer getCodeConfirm() 
	{
		return codeConfirm;
	}

	public void setCodeConfirm(Integer codeConfirm) 
	{
		this.codeConfirm = codeConfirm;
	}

	public Integer getWorkAttitude()
	{
		return workAttitude;
	}

	public void setWorkAttitude(Integer workAttitude) 
	{
		this.workAttitude = workAttitude;
	}

	public Integer getTraining() 
	{
		return training;
	}

	public void setTraining(Integer training) 
	{
		this.training = training;
	}

	public Integer getTeamContribute() 
	{
		return teamContribute;
	}

	public void setTeamContribute(Integer teamContribute) 
	{
		this.teamContribute = teamContribute;
	}

	public Integer getDailyWork() 
	{
		return dailyWork;
	}

	public void setDailyWork(Integer dailyWork) 
	{
		this.dailyWork = dailyWork;
	}

	public String getInMonth() 
	{
		return inMonth;
	}

	public void setInMonth(String inMonth) 
	{
		this.inMonth = inMonth;
	}

	public Integer getOther() 
	{
		return other;
	}

	public void setOther(Integer other) 
	{
		this.other = other;
	}
	

}
