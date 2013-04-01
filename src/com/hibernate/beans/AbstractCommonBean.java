package com.hibernate.beans;

import java.io.Serializable;
import java.lang.reflect.Method;

public class AbstractCommonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8094024051958027898L;

	public AbstractCommonBean() {
	}

	public String toString() {
		String result = "";
		try {
			Class c = this.getClass();
			Method[] ms = c.getMethods();
			for (int i = 0; i < ms.length; i++) {
				Method m = ms[i];
				String mname = m.getName();
				if (mname.startsWith("get", 0) && !"getClass".equals(mname)) {
					if (m.getParameterTypes().length == 0) {
						String fname = mname.substring(3);
						Object tmp = m.invoke(this, new Object[] {});
						String value = null;
						if (tmp == null) {
							value = "";
						} else {
							value = m.invoke(this, new Object[] {}).toString();
						}

						result += fname + "=" + value + "\n";
					}
				}

				if (mname.startsWith("is", 0)) {
					if (m.getParameterTypes().length == 0) {
						Object tmp = m.invoke(this, new Object[] {});
						String value = null;
						if (tmp == null) {
							value = "";
						} else {
							value = m.invoke(this, new Object[] {}).toString();
						}

						result += mname + "=" + value + "\n";
					}
				}

			}
		} catch (Exception ex) {
		}
		return result;
	}
}
