package com.hibernate.dao.idao;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.hibernate.beans.WorkRecord;

public interface IWorkRecordDAO {
	public List<T>  findAllByCondition(Class<WorkRecord> class1,
			WorkRecord workRecord) throws Exception;
}
