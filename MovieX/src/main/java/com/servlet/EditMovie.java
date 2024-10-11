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
import com.dto.Movie;

/**
 * Servlet implementation class EditMovie
 */

public class EditMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovie() {
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
		try {
            int id = Integer.parseInt(request.getParameter("id"));
            String movieTitle = request.getParameter("movieTitle");
            String movieGenre = request.getParameter("movieGenre");
            String movieYear = request.getParameter("movieYear");
            String urlYoutube = request.getParameter("urlYoutube");

            Movie b = new Movie();
            b.setMovieId(id);
            b.setMovieTitle(movieTitle);
            b.setMovieGenre(movieGenre);
            b.setMovieYear(movieYear);
            b.setUrlYoutube(urlYoutube);

            MovieDAO dao = new MovieDAO(DBConnect.getConnection());
            boolean f = dao.updateEditMovies(b);

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
