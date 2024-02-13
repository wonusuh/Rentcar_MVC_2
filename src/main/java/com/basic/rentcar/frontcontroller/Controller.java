package com.basic.rentcar.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String requestHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
