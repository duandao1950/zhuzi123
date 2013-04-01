package com.hibernate.bo;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.Asset;
import com.hibernate.bo.ibo.IAssetBo;
import com.hibernate.dao.AssetDAO;

public class AssetBo extends BaseHibernateBo implements IAssetBo
{
	private AssetDAO assetDAO;

	
	public AssetDAO getAssetDAO() {
		return assetDAO;
	}


	public void setAssetDAO(AssetDAO assetDAO) {
		this.assetDAO = assetDAO;
	}


	public List<T> findAllByCondition(Class<Asset> class1,
			Asset asset) throws Exception 
	{
		return assetDAO.findAllByCondition(class1, asset);
	}

}
