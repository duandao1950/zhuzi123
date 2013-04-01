package com.common;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

/**
 * 操作与session异常关闭,扩充此类
 * @author Administrator
 *
 */
public class OpenSessionInViewFilter extends org.springframework.orm.hibernate3.support.OpenSessionInViewFilter {

	protected Session getSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException {
		Session session = SessionFactoryUtils.getSession(sessionFactory, true);   
        FlushMode flushMode = session.getFlushMode();   
        if (flushMode != null) {   
        	session.setFlushMode(FlushMode.AUTO);//原来为  session.setFlushMode(flushMode);
        }   
        return session;
	}
	
	protected void closeSession(Session session, SessionFactory sessionFactory) {
		session.flush(); 
	    super.closeSession(session,sessionFactory); 
	}

}
