package com.hanul.springstudy.lombok;




public class LombokTestClassMain {
	
	
	public static void main(String[] args) {
		LombokTestClass ltc01 = new LombokTestClass("ha", "jfk", 18, 'M', true, 172.5);
		LombokTestClass ltc02 = new LombokTestClass();
		
		System.out.println(ltc01.toString());
		System.out.println(ltc02.toString());
	}
}
