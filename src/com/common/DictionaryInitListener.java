package com.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class DictionaryInitListener implements ServletContextListener
{
	Logger log = Logger.getLogger(this.getClass());

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)
    {
        // TODO Auto-generated method stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletContextsEvent)
    {
        try
        {
        	log.debug("start listener ......");
//            if (!CommonUtils.initDictionary())
//            {
//                throw new Exception("³õÊ¼»¯×Öµä´íÎó");
//            }

        } catch (Exception e)
        {
            log.error(e.getMessage(), e);
        }
    }
}
