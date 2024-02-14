package com.basic.rentcar.frontcontroller;

public class ViewResolver {
	public static String makeView(String nextPage) {
		return "/WEB-INF/rentcar/" + nextPage + ".jsp";
	}
}
