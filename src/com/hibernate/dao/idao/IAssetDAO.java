package com.hibernate.dao.idao;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.Asset;

public interface IAssetDAO 
{
	public List<T>  findAllByCondition(Class<Asset> class1,
			Asset asset) throws Exception;

}
