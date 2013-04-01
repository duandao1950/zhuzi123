package com.hibernate.bo;

import java.util.List;

import com.hibernate.beans.Operators;
import com.hibernate.bo.ibo.IOperatorsBo;
import com.hibernate.dao.OperatorsDAO;

public class OperatorsBo extends BaseHibernateBo implements IOperatorsBo {

	private OperatorsDAO operatorsDAO;
	public void setOperatorsDAO(OperatorsDAO operatorsDAO) {
		this.operatorsDAO = operatorsDAO;
	}
	
	public boolean isValid(final String username, final String password) {
		return operatorsDAO.isValid(username, password);
	}

	public boolean isExist(final String username) {
		return operatorsDAO.isExist(username);
	}

	public void insertOperator(Operators operator) {
		operatorsDAO.insertOperator(operator);
	}

	public Operators getOperator(String operatorID) {
		return operatorsDAO.getOperator(operatorID);
	}

	public List getOperators() {
		return operatorsDAO.getOperators();
	}

	public void deleteOperator(String operatorID) {
		operatorsDAO.deleteOperator(operatorID);
	}
}
