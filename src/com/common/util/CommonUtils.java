package com.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

public class CommonUtils {
	/**
     * 将格式字浮转换成sql.Date
     * @param date
     * @return
     */
    public static Date  str2SQLDate(String date){
        Date dt=null;
        SimpleDateFormat  format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        if(date==null||"".equals(date)){
            return  new java.sql.Date(System.currentTimeMillis());
        }
        try{
            dt=new java.sql.Date(format.parse(date).getTime());
        }catch(ParseException pe){
            //TODO
        }
        return dt;
    }
	
	/**
     * 将格式字浮转换成sql.Date
     * @param date
     * @return
     */
    public static String  str2SQLDateNoDefault(String date){
        Date dt=null;
        SimpleDateFormat  format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        if(date==null||"".equals(date)){
            return  "";
        }
        try{
            dt=new java.sql.Date(format.parse(date).getTime());
        }catch(ParseException pe){
            //TODO
        }
        return dt.toString();
    }

    //上传文件
    public static String pathSplit(String timeStr, String o, String n)
    {
        StringBuffer sb = new StringBuffer();
        for (String a : timeStr.split(o))
        {
            sb.append(a);
            sb.append(n);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    /**
     * 获取默认语言
     * @return
     */
    public static String getDefaultLanguage()
    {
    	String language = Locale.getDefault().getLanguage();
    	return StringUtils.isNotBlank(language) ? language : "EN";
    }
    
    /**
     * 获取PrintWriter ajax传值所用
     * @return
     * @throws IOException 
     */
    public static void outPrintWriterToResult(HttpServletResponse response,String result) throws IOException
    {
    	PrintWriter out = null;
    	try{
	    	response.reset();
	    	response.setContentType("text/plain; charset=UTF-8");
	        out = response.getWriter();
	        out.flush();
	        out.print(result);
	        out.flush();
    	}finally{
    		out.close();
    	}
    }
    
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
