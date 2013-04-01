package com.hibernate.dao.idao;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.PerformanceCRM;

public interface IPerformanceCRMDAO 
{
	public List<T> findAllByCondition(Class<PerformanceCRM> class1,
			PerformanceCRM perCRM)  throws Exception;
	
	public void deleteByCompositeId(String staffId, String inMonth) throws Exception;
	
	/*public PerformanceCRM findByCompositeId(String staffId, String inMonth) throws Exception;*/

}
