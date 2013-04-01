package com.struts.actions;

import java.util.List;

import org.apache.log4j.Logger;

import com.hibernate.beans.PerformanceCRM;
import com.hibernate.bo.PerformanceCRMBo;
import com.struts.util.Constants;

public class PerformanceCRMAction extends BaseAction
{

	Logger log = Logger.getLogger(this.getClass());
	
	protected Integer id;
	
	protected String staffId;//员工ID
	
	protected String staffName;//员工名称
	
	protected Integer requirmentAnalyze;//需求分析
	
	protected Integer coding;//开发
	
	protected Integer problemCounts;//处理问题单
	
	protected Integer checkCode;//编译、静态检查、注释
	
	protected Integer codeConfirm;//代码走查
	
	protected Integer workAttitude;//工作态度
	
	protected Integer training;//培训
	
	protected Integer teamContribute;//团队贡献
	
	protected Integer dailyWork;//日常工作
	
	protected String inMonth;//月份
	
	protected Integer other;//其他
	
	protected PerformanceCRM perCRM_obj;
	
	private PerformanceCRMBo perCRMBo;
	
	public PerformanceCRM getPerCRM_obj() 
	{
		return perCRM_obj;
	}

	public void setPerCRM_obj(PerformanceCRM perCRM_obj) 
	{
		this.perCRM_obj = perCRM_obj;
	}

	public PerformanceCRMBo getPerCRMBo() 
	{
		return perCRMBo;
	}

	public void setPerCRMBo(PerformanceCRMBo perCRMBo) 
	{
		this.perCRMBo = perCRMBo;
	}
	
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

	@Override
	public String add() throws Exception 
	{
		// TODO Auto-generated method stub
		return Constants.ADD_KEY;
	}
	
	public String query() throws Exception
	{
		return Constants.QUERY_KEY;
	}

	@Override
	public String back() throws Exception 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public String delete() throws Exception 
	{
		String staffId = request.getParameter("staffId");
		String inMonth = request.getParameter("inMonth");
		if((null == staffId || "".equals(staffId)) || (null == inMonth || "".equals(inMonth)))
		{
			this.addActionMessage(this.getText("message.delete.notexist"));
			return Constants.FAILURE_KEY;
		}
		
		perCRMBo.deleteByCompositeId(staffId, inMonth);
		
		/*request.setAttribute("resultCode", "");
		request.setAttribute("result","SUCCESS" );
		request.setAttribute("return_action","perCRM_list.action?method=list");
		
		return Constants.DELETE_SUCCESS_KEY;*/
		
		return Constants.LIST_KEY;
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception 
	{
		String staffId = request.getParameter("staffId");
		String inMonth = request.getParameter("inMonth");
		if((null == staffId || "".equals(staffId)) || (null == inMonth || "".equals(inMonth)))
		{
			this.addActionMessage(this.getText("message.delete.notexist"));
			return Constants.FAILURE_KEY;
		}
		PerformanceCRM perCRM = new PerformanceCRM();
		perCRM.setStaffId(staffId);
		perCRM.setInMonth(inMonth);
		List list = perCRMBo.findAllByCondition(PerformanceCRM.class, perCRM);
		if(list.size() > 0 )
		{
			this.perCRM_obj  = (PerformanceCRM) list.get(0);
		}
		return Constants.EDIT_KEY;
	}

	@SuppressWarnings("unchecked")
	public List findBeanList() throws Exception 
	{
		PerformanceCRM perCRM = new PerformanceCRM();
		perCRM.setStaffId(this.staffId);
		perCRM.setStaffName(this.staffName);
		return perCRMBo.findAllByCondition(PerformanceCRM.class, perCRM);
	}

	@SuppressWarnings("unchecked")
	public String insert() throws Exception 
	{
		PerformanceCRM perCRM = new PerformanceCRM();
		perCRM.setStaffId(this.staffId);
		perCRM.setStaffName(this.staffName);
		perCRM.setRequirmentAnalyze(this.requirmentAnalyze);
		perCRM.setCoding(this.coding);
		perCRM.setProblemCounts(this.problemCounts);
		perCRM.setCheckCode(this.checkCode);
		perCRM.setCodeConfirm(this.codeConfirm);
		perCRM.setWorkAttitude(this.workAttitude);
		perCRM.setTraining(this.training);
		perCRM.setTeamContribute(this.teamContribute);
		perCRM.setDailyWork(this.dailyWork);
		perCRM.setInMonth(this.inMonth);
		perCRM.setOther(this.other);
		//insert object
		baseHibernateBo.save(perCRM);
		this.addActionMessage(this.getText("message.add.success"));
		
		/*request.setAttribute("resultCode", "");
		request.setAttribute("result","SUCCESS" );
		request.setAttribute("return_action","perCRM__list.action?method=list");
		
		return Constants.INSERT_SUCCESS_KEY;*/
		return Constants.LIST_KEY;
	}

	@SuppressWarnings("unchecked")
	public String update() throws Exception 
	{
		PerformanceCRM perCRM = new PerformanceCRM();
		perCRM.setStaffId(this.staffId);
		perCRM.setStaffName(this.staffName);
		perCRM.setRequirmentAnalyze(this.requirmentAnalyze);
		perCRM.setCoding(this.coding);
		perCRM.setProblemCounts(this.problemCounts);
		perCRM.setCheckCode(this.checkCode);
		perCRM.setCodeConfirm(this.codeConfirm);
		perCRM.setWorkAttitude(this.workAttitude);
		perCRM.setTraining(this.training);
		perCRM.setTeamContribute(this.teamContribute);
		perCRM.setDailyWork(this.dailyWork);
		perCRM.setInMonth(this.inMonth);
		perCRM.setOther(this.other);
		//update object
        baseHibernateBo.saveOrUpdate(perCRM);
		
		// save messages
		this.addActionMessage(this.getText("message.edit.success"));
		
		/*request.setAttribute("resultCode", "");
		request.setAttribute("result","SUCCESS" );
		request.setAttribute("return_action","perCRM_list.action?method=list");

		return Constants.UPDATE_SUCCESS_KEY;*/
		return Constants.LIST_KEY;
	}



}
