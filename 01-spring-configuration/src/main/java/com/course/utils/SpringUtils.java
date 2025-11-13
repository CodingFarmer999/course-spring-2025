package com.course.utils;

public class SpringUtils {

	// 2. 私有靜態的欄位，用來存放單例實體
	private static SpringUtils instance;
	
	// 1. 私有建構式，不讓外部程式 new
	private SpringUtils() {
		
	}
	
	// 3. 公有靜態的方法，來獲得單例實體
	public static SpringUtils getInstance() {
		if (instance == null) {
			// 首次呼叫才產生物件
			instance = new SpringUtils();
		}
		return instance;
	}
	
	// 此單例物件提供的方法
	public void doSomething() {
		System.out.println(instance);
	}
}
