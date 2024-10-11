package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.MovieDAO;
import com.db.DBConnect;

/**
 * Servlet implementation class DeleteMovie
 */
@WebServlet("/DeletMovie")
public class DeleteMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

            int id = Integer.parseInt(request.getParameter("id"));

            MovieDAO dao = new MovieDAO(DBConnect.getConnection());
            boolean f = dao.deleteMovies(id);

            HttpSession session = request.getSession();

            if (f) {
                response.sendRedirect("admin.jsp");
            } else {
                session.setAttribute("failedMsg", "Something wrong on server..");
                response.sendRedirect("admin.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	
	

}
