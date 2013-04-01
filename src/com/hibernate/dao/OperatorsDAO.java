package com.hibernate.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import com.hibernate.beans.Operators;
import com.hibernate.dao.idao.IOperatorsDAO;

public class OperatorsDAO extends BaseHibernateDAO implements IOperatorsDAO {

	public boolean isValid(final String operatorsID, final String password) {
		List list = (List) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						List result = session.createCriteria(Operators.class)
								.add(Restrictions.eq("operId", operatorsID))
								.add(Restrictions.eq("password", password))
								.add(Restrictions.eq("isValid", "1")).list();
								//.add(Restrictions.between("cancelTime",new Date(), DateUtils.addYears(new Date(), 999))).list();
						return result;
					}
				});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isExist(final String operatorsID) {
		List list = (List) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						List result = session.createCriteria(Operators.class)
								.add(Restrictions.eq("operId", operatorsID))
								.list();
						return result;
					}
				});
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void insertOperator(Operators operator) {
		getHibernateTemplate().saveOrUpdate(operator);
	}

	public Operators getOperator(String operatorID) {
		return (Operators) getHibernateTemplate().get(Operators.class,
				new Integer(operatorID));
	}

	public List getOperators() {
		return getHibernateTemplate().find("from Operators where 1=1 order by isValid");
	}

	public void deleteOperator(String operatorID) {
		Object p = getHibernateTemplate().load(Operators.class,
				new Integer(operatorID));
		getHibernateTemplate().delete(p);
	}
}
