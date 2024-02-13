package com.basic.rentcar.frontcontroller;

public class ViewResolver {
	public static String makeView(String nextPage) {
		String result = "/WEB-INF/rentcar/" + nextPage + ".jsp";
		System.out.println(result);
		return result;
	}
}
