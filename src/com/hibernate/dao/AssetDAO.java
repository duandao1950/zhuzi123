package com.hibernate.dao;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.Asset;
import com.hibernate.dao.idao.IAssetDAO;

public class AssetDAO extends BaseHibernateDAO implements IAssetDAO
{
	public List<T>  findAllByCondition(Class<Asset> class1,
			Asset asset) throws Exception
	{
		if(null == asset)
		{
			return null;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("from Asset where 1=1 ");
	    if(null == asset.getStaffId() && "".equals(asset.getStaffId()))
	    {
	    	sql.append(" and staffId = '")
	    	   .append(asset.getStaffId())
	    	   .append("'");
	    }
		if(null == asset.getDeviceNo() && "".equals(asset.getDeviceNo()))
		{
			sql.append(" and deviceNo = '")
			   .append(asset.getDeviceNo())
			   .append("'");
		}
		if(null == asset.getComDisplayNo() && "".equals(asset.getComDisplayNo()))
		{
			sql.append(" and comDisplayNo = '")
			   .append(asset.getComDisplayNo())
			   .append("'");
		}
		if(null == asset.getIpAddress() && "".equals(asset.getIpAddress()))
		{
			sql.append(" and ipAddress = '")
			   .append(asset.getIpAddress())
			   .append("'");
		}
		if(null == asset.getStatus() && "".equals(asset.getStatus()))
		{
			sql.append(" ans status = '")
			   .append(asset.getStatus())
			   .append("'");
		}
		return super.find(sql.toString(), null);
		
	}

}
