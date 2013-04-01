package com.hibernate.bo.ibo;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.Config;


public interface IConfigBo 
{
	public List<T> findAllByCondition(Class<Config> class1,
			Config config) throws Exception;
}
