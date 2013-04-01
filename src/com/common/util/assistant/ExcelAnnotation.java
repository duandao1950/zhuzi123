package com.common.util.assistant;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAnnotation {
	// excel����ʱ������ʾ�����֣����û������Annotation���ԣ������ᱻ�����͵���
	public String exportName();
}
