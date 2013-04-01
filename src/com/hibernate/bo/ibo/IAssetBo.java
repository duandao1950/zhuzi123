package com.hibernate.bo.ibo;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.Asset;

public interface IAssetBo 
{
	public List<T> findAllByCondition(Class<Asset> class1,
			Asset asset) throws Exception;

}
