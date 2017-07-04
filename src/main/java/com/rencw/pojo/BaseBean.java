package com.rencw.pojo;

import java.io.Serializable;
import java.lang.reflect.Field;

public class BaseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append(this.getClass().getSimpleName()).append("{");
		
		Field[] fields = this.getClass().getDeclaredFields();
		if(fields != null) {
			for(Field field : fields) {
				try {
					if(!"serialVersionUID".equals(field.getName())) {
						field.setAccessible(true);
						msg.append(",").append(field.getName()).append("=").append(field.get(this));
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return msg.append("}").toString();
	}
}
