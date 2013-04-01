package com.hibernate.bo.ibo;

import java.util.List;

import com.hibernate.beans.Operators;

public interface IOperatorsBo {

	public boolean isValid(final String username, final String password);

	public boolean isExist(String username);

	public void insertOperator(Operators Operator);

	public Operators getOperator(String operatorID);

	public List getOperators();

	public void deleteOperator(String operatorID);
}
