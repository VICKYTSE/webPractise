package com.servlet;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;



/**
 * Servlet implementation class SearchUserById
 */
public class SearchUserById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUserById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        

        /**
         * 接收json
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (ServletInputStream) request.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer("");
        String temp;
        while ((temp = br.readLine()) != null) {
            sb.append(temp);
        }
        br.close();
        System.out.println(sb.toString());
        String str = sb.toString();
        JsonObject returnData = new JsonParser().parse(str).getAsJsonObject();
        
       // System.out.println(returnData.get("id"));
        int id = returnData.get("id").getAsInt();
       // System.out.println(id);
        User user = new User();
		UserDao ud = new UserDaoImpl();
		user = ud.searchById(id);
		Gson gson = new GsonBuilder().create();
		String s = gson.toJson(user);
		System.out.println(s);
		
        /**
         * 返回json
         */
        // 转成数据流
        InputStream is = new ByteArrayInputStream(
        		s.getBytes());
        // 输出到画面
    	response.setContentType("text/html;charset=UTF-8");
        ServletOutputStream op = response.getOutputStream();
        int len;
        byte[] buff = new byte[4096];
        while ((len = is.read(buff)) != -1) {
            op.write(buff, 0, len);
            
           
        }
        op.flush();


        //用于接收对方的jsonString
		//response.setContentType("text/html;charset=utf-8");
		//response.setHeader("Access-Control-Allow-Origin", "*");
		//response.setHeader("Access-Control-Allow-Methods", "GET,POST");
 
		//接收json数据
        //BufferedReader reader = request.getReader();
        //String json = reader.readLine();
		//BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
		//StringBuffer sb = new StringBuffer("");
		//String temp;
		//while ((temp = br.readLine()) != null) {
		//sb.append(temp);
		//}
		//br.close();
		//String json = sb.toString();
		//Gson gson = new GsonBuilder().create();
		//System.out.println(gson.toJson(json));
		
		//class UserId{
		//	int id;
		//}
		
		//UserId id = gson.fromJson(json,new TypeToken<UserId>(){}.getType());
		//User user = new User();
		//UserDao ud = new UserDaoImpl();
	//	user = ud.searchById(id.id);
     //   String str = gson.toJson(user);
	//	 String str = gson.toJson(" {\r\n" + 
	//	 		"        \"id\": 3,\r\n" + 
		 //		"        \"name\": \"123\",\r\n" + 
		/// 		"        \"pwd\": \"123\",\r\n" + 
		// 		"        \"sex\": \"123\",\r\n" + 
		// 		"        \"home\": \"123\",\r\n" + 
		// 		"        \"info\": \"123\"\r\n" + 
		// 		"    }");
       // response.getOutputStream().write(str.getBytes("UTF-8"));
       // response.setContentType("Text/json;charset=UTF-8");
		
	}

}
