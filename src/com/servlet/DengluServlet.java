package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

public class DengluServlet extends HttpServlet{
	/**
	 * 登录
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
					throws ServletException,IOException {
		doPost(request , response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException,IOException{
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		UserDao ud = new UserDaoImpl();
		
		if(ud.login(name, pwd)) {
			request.setAttribute("xiaoxi", "欢迎用户"+name);
			request.getRequestDispatcher("/success.jsp").forward(request, response);//转发到成功页面
		}else {
			response.sendRedirect("index.jsp"); //重定向到首页
		}
	}
}
