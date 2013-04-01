package com.struts.actions;

import java.util.List;
import org.apache.log4j.Logger;

import com.hibernate.beans.Asset;
import com.hibernate.bo.AssetBo;
import com.struts.util.Constants;

@SuppressWarnings("serial")
public class AssetAction extends BaseAction
{
	Logger log = Logger.getLogger(this.getClass());
	
	protected Integer id = null;
	
	protected String staffId = null;//员工号
	
    protected String deviceNo = null;//设备号
	
    protected String comDisplayNo = null;//显示器编号
    
    protected String comHostNo = null;//主机编号
	
    protected String ipAddress = null;//ip地址
	
    protected String deviceAddress = null;//设备存放地
    
    protected String status = null;// 状态 0闲置 1使用中
    
    protected String remark = null;//备注
    
    private Asset asset_obj = null;
    
    protected AssetBo assetBo;

	public AssetBo getAssetBo() {
		return assetBo;
	}

	public void setAssetBo(AssetBo assetBo) {
		this.assetBo = assetBo;
	}

	public Asset getAsset_obj() {
		return asset_obj;
	}

	public void setAsset_obj(Asset asset_obj) {
		this.asset_obj = asset_obj;
	}

	public String getStaffId() 
	{
		return staffId;
	}

	public void setStaffId(String staffId) 
	{
		this.staffId = staffId;
	}

	public String getDeviceNo() 
	{
		return deviceNo;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public void setDeviceNo(String deviceNo) 
	{
		this.deviceNo = deviceNo;
	}

	public String getComDisplayNo() 
	{
		return comDisplayNo;
	}

	public void setComDisplayNo(String comDisplayNo) 
	{
		this.comDisplayNo = comDisplayNo;
	}

	public String getDeviceAddress() 
	{
		return deviceAddress;
	}

	public void setDeviceAddress(String deviceAddress) 
	{
		this.deviceAddress = deviceAddress;
	}

	public String query() throws Exception
	{
		return Constants.QUERY_KEY;
	}
	
	@Override
	public String add() throws Exception 
	{
		// TODO Auto-generated method stub
		return Constants.ADD_KEY;
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
		String id = request.getParameter("id");
		if(null == id && "".equals(id))
		{
			this.addActionMessage(this.getText("message.delete.notexist"));
			return Constants.FAILURE_KEY;
		}
		baseHibernateBo.delete(Asset.class, Integer.valueOf(id));
		
		return Constants.LIST_KEY;
	}

	@SuppressWarnings("unchecked")
	public String edit() throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		if(null == id && "".equals(id))
		{
			this.addActionMessage(this.getText("message.delete.notexist"));
		}
		Asset asset = (Asset)baseHibernateBo.findById(Asset.class, Integer.valueOf(id));
		this.asset_obj = asset;
		return Constants.EDIT_KEY;
	}

	@SuppressWarnings("unchecked")
	public List findBeanList() throws Exception 
	{
		Asset asset = new Asset();
		asset.setStaffId(this.staffId);
		asset.setComDisplayNo(this.comDisplayNo);
		asset.setComHostNo(this.comHostNo);
		asset.setDeviceAddress(this.deviceAddress);
		asset.setDeviceNo(this.deviceNo);
		asset.setIpAddress(this.ipAddress);
		asset.setStatus(this.status);
		return assetBo.findAllByCondition(Asset.class, asset);
	}

	@SuppressWarnings("unchecked")
	public String insert() throws Exception 
	{
		Asset asset = new Asset();
		asset.setId(this.id);
		asset.setStaffId(this.staffId);
		asset.setComDisplayNo(this.comDisplayNo);
		asset.setComHostNo(this.comHostNo);
		asset.setDeviceAddress(this.deviceAddress);
		asset.setDeviceNo(this.deviceNo);
		asset.setIpAddress(this.ipAddress);
		asset.setRemark(this.remark);
		asset.setStatus(this.status);
		//insert object
		baseHibernateBo.save(asset);
		this.addActionMessage(this.getText("message.add.success"));
		
		return Constants.LIST_KEY;
	}

	@SuppressWarnings("unchecked")
	public String update() throws Exception 
	{
		Asset asset = new Asset();
		asset.setId(this.getId());
		asset.setStaffId(this.getStaffId());
		asset.setComDisplayNo(this.comDisplayNo);
		asset.setComHostNo(this.comHostNo);
		asset.setDeviceAddress(this.deviceAddress);
		asset.setDeviceNo(this.deviceNo);
		asset.setIpAddress(this.ipAddress);
		asset.setRemark(this.remark);
		asset.setStatus(this.status);
		//update object
        baseHibernateBo.saveOrUpdate(asset);
		
		// save messages
		this.addActionMessage(this.getText("message.edit.success"));
		
		return Constants.LIST_KEY;
	}

	public String getComHostNo() {
		return comHostNo;
	}

	public void setComHostNo(String comHostNo) {
		this.comHostNo = comHostNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
