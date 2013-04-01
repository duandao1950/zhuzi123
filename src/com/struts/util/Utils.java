package com.struts.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang.time.StopWatch;

import com.common.util.DateUtil;
import com.hibernate.beans.User;

public class Utils {

	/**
	 * 完全填充
	 * @param object 目标对象
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static Object fillObject(Object object) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Method[] methods = object.getClass().getMethods();
		for(int i=0;i<methods.length;i++){
			Method method = methods[i];
			String mname = method.getName();
			if(mname.startsWith("get") && !"getClass".equals(mname)){
				if(method.getParameterTypes().length == 0){
					String setMethodName = "set" + mname.substring(3);
					String type = method.getReturnType().getName();
					Object[] o = new Object[1];
					if ("java.lang.Integer".equals(type)){
						o[0] = RandomUtils.nextInt();
					}else if("java.lang.String".equals(type)){
						o[0] = "" + RandomUtils.nextLong();
					}else if("java.util.Date".equals(type)){
						o[0] = new Date();
					}else if("java.sql.Timestamp".equals(type)){
						o[0] = DateUtil.getCurrentTime();
					}else if("java.lang.Double".equals(type)){
						o[0] = RandomUtils.nextDouble();
					}else if("java.lang.Boolean".equals(type)){
						o[0] = RandomUtils.nextBoolean();
					}else if("java.lang.Long".equals(type)){
						o[0] = RandomUtils.nextLong();
					}else if ("java.lang.Float".equals(type)){
						o[0] = RandomUtils.nextFloat();
					}else if("java.math.BigDecimal".equals(type)){
						o[0] = BigDecimal.valueOf(RandomUtils.nextInt());
					}
					object.getClass().getMethod(setMethodName, new Class[]{method.getReturnType()}).invoke(object, o);
				}
			}
			
			if (mname.startsWith("is",0)){
				if(method.getParameterTypes().length == 0){
					String setMethodName = "set" + mname.substring(2);
					String type = method.getReturnType().getName();
					Object[] o = new Object[1];
					if("boolean".equals(type)){
						o[0] = RandomUtils.nextBoolean();
					}
					object.getClass().getMethod(setMethodName, new Class[]{method.getReturnType()}).invoke(object, o);
				}
			}
		}
		stopWatch.stop();
		System.out.println("随机填充属性耗时: "+stopWatch.getTime()+" 秒");
		return object;
	}
	
	/**
	 * 更新  如果不传isUpdate=true,将是完全填充
	 * @param object 目标对象
	 * @param key 更新键
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static Object fillObject(Object object,boolean isUpdate,String key) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException, NoSuchMethodException{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Method[] methods = object.getClass().getMethods();
		for(int i=0;i<methods.length;i++){
			Method method = methods[i];
			String mname = method.getName();
			if(mname.startsWith("get") && !"getClass".equals(mname)){
				if(method.getParameterTypes().length == 0){
					String methodName = mname.substring(3);
					if(isUpdate && methodName.equalsIgnoreCase(key)){
						continue;
					}
					
					String setMethodName = "set" + methodName;
					
					String type = method.getReturnType().getName();
					Object[] o = new Object[1];
					if ("java.lang.Integer".equals(type)){
						o[0] = RandomUtils.nextInt();
					}else if("java.lang.String".equals(type)){
						o[0] = "" + RandomUtils.nextLong();
					}else if("java.util.Date".equals(type)){
						o[0] = new Date();
					}else if("java.sql.Timestamp".equals(type)){
						o[0] = DateUtil.getCurrentTime();
					}else if("java.lang.Double".equals(type)){
						o[0] = RandomUtils.nextDouble();
					}else if("java.lang.Boolean".equals(type)){
						o[0] = RandomUtils.nextBoolean();
					}else if("java.lang.Long".equals(type)){
						o[0] = RandomUtils.nextLong();
					}else if ("java.lang.Float".equals(type)){
						o[0] = RandomUtils.nextFloat();
					}else if("java.math.BigDecimal".equals(type)){
						o[0] = BigDecimal.valueOf(RandomUtils.nextInt());
					}
					object.getClass().getMethod(setMethodName, new Class[]{method.getReturnType()}).invoke(object, o);
				}
			}
			
			if (mname.startsWith("is",0)){
				if(method.getParameterTypes().length == 0){
					String setMethodName = "set" + mname.substring(2);
					String type = method.getReturnType().getName();
					Object[] o = new Object[1];
					if("boolean".equals(type)){
						o[0] = RandomUtils.nextBoolean();
					}
					object.getClass().getMethod(setMethodName, new Class[]{method.getReturnType()}).invoke(object, o);
				}
			}
		}
		stopWatch.stop();
		System.out.println("随机填充属性耗时: "+stopWatch.getTime()+" 秒");
		return object;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Utils utils = new Utils();
		try {
			User user = new User();
			user.setId(1);
			String id  = BeanUtils.getProperty(user, "id");
			//utils.fillObject(user,true);
			System.out.println(id);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		Address user = new Address();
		Address user2 = new Address();
		user2.setId(1);
		user2.setUsername("111");
		String[] str = new String[]{"Id","UserName"};
		BeanUtils.copyProperties(user2,user,str);
		System.out.println(user.getUsername()+"\n"+user.getId());
		*/
	}

}
