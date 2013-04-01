package com.common;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.dispatcher.FilterDispatcher;

import com.struts.util.Constants;
public class DoFilterDispatcher extends FilterDispatcher{
	/**
	 * check if user is timeout
	 * @param request
	 * @return
	 */
	protected boolean isTimeout(HttpServletRequest request) {
		if (request.getSession().getAttribute(Constants.OPERATORSID_KEY) == null) {
			return true;
		} else {
			return false;
		}
	}

	public void doFilter(HttpServletRequest arg0, HttpServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (isTimeout(arg0)){
			 try {
				arg1.sendRedirect("/login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
