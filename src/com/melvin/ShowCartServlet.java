package com.melvin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShowCartServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
	ArrayList<String> list=(ArrayList<String>) session.getAttribute("cart");
	response.setContentType("text/html"); 
	PrintWriter out=response.getWriter();
	out.println("<html");
	out.println("<head>");
	out.println("<title>ShopIt</title>");
	out.println("</head>");
	out.println("<body>");
	out.print("<br><a href='index.html'>Buy More Book</a>");
	out.print("<hr>");

	if(list!=null && list.size()>0){
		for(String e:list){
			out.print("<h2>"+e+" <a href='removeItem?item="+e+"'>Remove</a></h2>");
		}
	}else{
		out.print("<h2>Empty Cart</h2>");
	}
		
	out.println("</body>");
	out.println("</html>");
	}

}
