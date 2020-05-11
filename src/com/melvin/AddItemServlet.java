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


public class AddItemServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item=request.getParameter("item");
		HttpSession session=request.getSession();
		ArrayList<String> list=(ArrayList<String>) session.getAttribute("cart");
		if(list==null){
			list=new ArrayList<>();
			session.setAttribute("cart", list);	
		}
		list.add(item);	
		response.setContentType("text/html"); //MIME
		PrintWriter out=response.getWriter();
		out.println("<html");
		out.println("<head>");
		out.println("<title>ShopIt</title>");
		out.println("</head>");
		out.println("<body>");
		out.print("Item Added Successfully!");
		out.print("<br><br><a href='index.html'>Buy More Book</a>");
		out.print("<br><br><a href='showCart'>Show My Cart</a>");
		out.println("</body>");
		out.println("</html>");
		
		}
}
