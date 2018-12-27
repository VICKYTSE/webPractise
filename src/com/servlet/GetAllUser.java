package com.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GetAllUser extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException{

		
		System.out.println("Doget all user");

		Writer out = response.getWriter();
		UserDao ud = new UserDaoImpl();
		List<User> userAll = ud.getUserAll();
		
		Gson gson = new Gson();
		out.write(gson.toJson(userAll));
        //response.getOutputStream().write(gson.toJson(userAll).getBytes("UTF-8"));
        response.setContentType("Text/json;charset=UTF-8");
        out.flush();
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doGet(request, response);  
    }  
}
