package com.leeup.javase.day27.test;

import java.lang.reflect.Field;

public class Tool {

	//此方法可将obj对象中名为propertyName的属性值设置为value
	public void setProperty(Object obj,String propertyName,Object value) throws Exception {
		Class clazz = obj.getClass();	//获取字节码对象
		Field field = clazz.getDeclaredField(propertyName);	//暴力反射获取字段
		field.setAccessible(true);
		field.set(obj, value);
	}
}
