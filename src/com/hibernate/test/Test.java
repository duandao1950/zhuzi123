package com.hibernate.test;

import java.io.File;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.hibernate.beans.Operator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:\\java—ßœ∞◊ ¡œ\\zhuzi123_last\\WebRoot\\WEB-INF\\lib");
		String[] fileArray = {"","1","","","2"};
		fileArray = (String[])ArrayUtils.removeElement(fileArray, "");
//		Operator oper1 = new Operator();
//		oper1.setOperId("36120");
//		oper1.setOperName("QWE");
//		oper1.setPassword("123456");
//		
//		Operator oper2 = new Operator();
//		oper2.setOperId("36120");
//		oper2.setOperName("WQW");
//		oper2.setPassword("123456");
		
		ArrayUtils.toString(fileArray);
		Timestamp currentTime = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		System.out.println(currentTime.toLocaleString());
	}

}
