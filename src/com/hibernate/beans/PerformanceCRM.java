package com.hibernate.beans;

import java.io.Serializable;

/**
 * @author lkf12998
 *
 */
public class PerformanceCRM extends AbstractCommonBean implements Serializable 
{	
	
	private Integer id;
	
	private String staffId;//Ա��ID
	
	private String staffName;//Ա������
	
	private Integer requirmentAnalyze;//�������
	
	private Integer coding;//����
	
	private Integer problemCounts;//�������ⵥ
	
	private Integer checkCode;//���롢��̬��顢ע��
	
	private Integer codeConfirm;//�����߲�
	
	private Integer workAttitude;//����̬��
	
	private Integer training;//��ѵ
	
	private Integer teamContribute;//�Ŷӹ���
	
	private Integer dailyWork;//�ճ�����
	
	private String inMonth;//�·�
	
	private Integer other;//����
	
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
