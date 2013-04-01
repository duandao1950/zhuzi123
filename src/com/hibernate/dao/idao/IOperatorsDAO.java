package com.hibernate.dao.idao;

import java.util.List;
import com.hibernate.beans.Operators;

public interface IOperatorsDAO {

	public boolean isValid(final String operatorsID, final String password);

	public boolean isExist(String operatorsID);

	public void insertOperator(Operators operator);

	public Operators getOperator(String operatorsID);

	public List getOperators();

	public void deleteOperator(String operatorsID);
}
