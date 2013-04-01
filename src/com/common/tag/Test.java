package com.common.tag;

import java.io.File;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.tools.zip.ZipOutputStream;

import com.common.util.DateUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String[] arrayA = new String[] { "1", "2", "3", "3", "4", "5" };
		String[] arrayB = new String[] { "3", "4", "4", "5", "6", "7" };

		List a = Arrays.asList( arrayA );
		List b = Arrays.asList( arrayB );

		Collection union = CollectionUtils.union( a, b );
		Collection intersection = CollectionUtils.intersection( a, b );
		Collection disjunction = CollectionUtils.disjunction( a, b );
		Collection subtract = CollectionUtils.subtract( a, b );

//		Collections.sort(union);
//		Collections.sort(intersection);
//		Collections.sort(disjunction);
//		Collections.sort(subtract);


		System.out.println( "A: " + ArrayUtils.toString( a.toArray( ) ) );
		System.out.println( "B: " + ArrayUtils.toString( b.toArray( ) ) );
		System.out.println( "Union: " + ArrayUtils.toString( union.toArray( ) ) );
		System.out.println( "Intersection: " + 
		                    ArrayUtils.toString( intersection.toArray( ) ) );
		System.out.println( "Disjunction: " + 
		                    ArrayUtils.toString( disjunction.toArray( ) ) );
		System.out.println( "Subtract: " + ArrayUtils.toString( subtract.toArray( ) ) );
		
		
		/*String[]  ff = new String[3];
		for(int i=0;i<ff.length;i++){
			ff[i] = ""+i;
			//System.out.println(ff[i]);
		}*/
		
		/*SimpleDateFormat g = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		
		
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");   
        SimpleDateFormat myFmt1=new SimpleDateFormat("yy/MM/dd HH:mm");    
        SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()   
        SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");   
        SimpleDateFormat myFmt4=new SimpleDateFormat(   
                "一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");   
        Date now=new Date();   
        System.out.println(myFmt.format(now));   
        System.out.println(myFmt1.format(now));   
        System.out.println(myFmt2.format(now));   
        System.out.println(myFmt3.format(now));   
        System.out.println(myFmt4.format(now));   
        System.out.println(now.toGMTString());   
        System.out.println(now.toLocaleString());   
        System.out.println(now.toString()); */  

//		ff[ff.length-1] = "3";
//		System.out.println(ff[ff.length-1]);
		
//		//定义一个字符串，该字符串的值为上面的dd请求参数的值   
//        String encodeStr = "%CC%E1%BD%BB";   
//        //使用URLDecoder类来处理该dd请求参数值   
//        String decodeStr = URLDecoder.decode(encodeStr ,"GBK");   
//        System.out.println(decodeStr);   
//        //定义一个字符串，该字符串的值为在图7.1中的文本框中输入的内容   
//        String rawStr = "crazyit标志";   
//        //使用URLEncoder类处理该字符串   
//        System.out.println(URLEncoder.encode(rawStr , "GBK"));   
        
//		Test test = new Test();
//		String path = "D:\\Program Files\\Apache Software Foundation\\apache-tomcat-6.0.18\\webapps\\demo\\upload\\011280049.txt";
//		System.out.println(org.apache.commons.lang.RandomStringUtils.randomNumeric(8));
//		String patht = "D:\\Program Files\\Apache Software Foundation\\apache-tomcat-6.0.18\\webapps\\demo\\upload\\";
//		test.zip(patht+org.apache.commons.lang.RandomStringUtils.randomNumeric(8)+".zip",new File(path));
	}

	/*public void zip(String inputFileName) throws Exception {
		
		String zipFileName = "c:\\test.zip";// 打包后文件名字
		System.out.println(zipFileName);
		zip(zipFileName, new File(inputFileName));
	}*/

	private void zip(String zipFileName, File inputFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
				zipFileName));
		zip(out, inputFile, "");
		System.out.println("zip done");
		out.close();
	}

	private void zip(ZipOutputStream out, File f, String base) throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			System.out.println(base);
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
	}
	
	
	public String getContent(){
		StringBuffer content = new StringBuffer();

		content.append("<SCRIPT language=JavaScript>\r");
		content.append("function addMore()\r");
		content.append(" {\r");
		content.append("   var td = document.getElementById(\"more\");\r");
		content.append("   var br = document.createElement(\"br\");\r");
		content.append("   var input = document.createElement(\"input\");\r");
		content.append("   var button = document.createElement(\"input\");\r");
		content.append("   input.type=\"file\";\r");
		content.append("   input.name=\"file\";\r");
		content.append("   button.type=\"button\";\r");
		content.append("   button.value=\"Remove\";\r");
		content.append("   button.onclick = function()\r");
		content.append("   {\r");
		content.append("   td.removeChild(br);\r");
		content.append("   td.removeChild(input);\r");
		content.append("   td.removeChild(button);\r");
		content.append("   }\r");
		content.append("   td.appendChild(br);\r");
		content.append("   td.appendChild(input);\r");
		content.append("   td.appendChild(button);\r");
		content.append("}\r</SCRIPT>\r");
		content.append("<TR><TD>file:</TD>\r");
		content
				.append("<TD>file:</TD><input type=\"file\" name=\"file\"/>"
						+ "<input type=\"button\" value=\"Add More ...\" onClick=\"addMore()\"></TD></TR>\r");

		System.out.println(content.toString());
		return content.toString();
	}
}
