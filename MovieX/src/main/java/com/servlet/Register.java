package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.RegisterDAO;
import com.dto.Member;

/**
 * Servlet implementation class Register
 */
//@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String uname = request.getParameter("username");
        String password = request.getParameter("password");
        String subscription = request.getParameter("subscription"); // Get subscription value

        Member member = new Member(email, uname, password);
        member.setSubscription(subscription); // Set the subscription value

        RegisterDAO rDao = new RegisterDAO();
        String result = rDao.insert(member);

        // Set the result message as a request attribute
        request.setAttribute("result", result);

        // Forward the request to registration.jsp
        request.getRequestDispatcher("login.jsp").forward(request, response);
		doGet(request, response);
	}

}
