package com.common;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.struts.util.Constants;

@SuppressWarnings("serial")
public class LoginFilter extends HttpServlet implements Filter
{

    private static final String LOGIN_URI = "LOGIN_URI";

    private static final String HOME_URI = "HOME_URI";

    private String login_page;

    private String home_page;

    public void destroy()
    {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException
    {
        // TODO Auto-generated method stub
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setContentType("text/html");
        httpServletResponse.setCharacterEncoding("UTF-8");
        HttpSession session = httpServletRequest.getSession();
        PrintWriter out = httpServletResponse.getWriter();
        // 得到用户请求的URI
        String request_uri = httpServletRequest.getRequestURI();
        // 得到web应用程序的上下文路径
        String ctxPath = httpServletRequest.getContextPath();
        // 去除上下文路径，得到剩余部分的路径
        String uri = request_uri.substring(ctxPath.length());
        // 判断用户访问的是否是登录页面
        if (login_page.equals(uri) || home_page.equals(uri))
        {
            chain.doFilter(request, response);
            return;
        } else
        {
            // 如果访问的不是登录页面，则判断用户是否已经登录
            if (session.getAttribute(Constants.OPERATORSID_KEY) != ""
                    && session.getAttribute(Constants.OPERATORSID_KEY) != null && !"/".equals(uri))
            {
                chain.doFilter(request, response);
                return;
            } else
            {
            	// 如果访问的是注册页面
            	if ("/register_init.action".equals(uri) || "/register_user.action".equals(uri))
            	{
            		chain.doFilter(request, response);
            	}else
            	{
	                out.println("<script language=\"javaScript\">"
	                        + "parent.location.href='" + ctxPath + login_page + "'"
	                        + "</script>");
            	}
                return;
            }
        }
    }

    public void init(FilterConfig config) throws ServletException
    {
        // TODO Auto-generated method stub
        // 从部署描述符中获取登录页面和首页的URI
        login_page = config.getInitParameter(LOGIN_URI);
        home_page = config.getInitParameter(HOME_URI);
        if (null == login_page || null == home_page)
        {
            throw new ServletException("No found login or index page!");
        }
    }
}
