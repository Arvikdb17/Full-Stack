package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.dao.MovieDAO;
import com.db.DBConnect;
import com.dto.Movie;

/**
 * Servlet implementation class AddMovie
 */
@WebServlet(name = "AddMovie", value = "/AddMovie")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
maxFileSize = 1024 * 1024 * 50,
maxRequestSize = 1024 * 1024 * 100)

public class AddMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovie() {
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
            String movieTitle = request.getParameter("movieTitle");
            String movieGenre = request.getParameter("movieGenre");
            String movieYear = request.getParameter("movieYear");
            String urlYoutube = request.getParameter("urlYoutube");

            Part part = request.getPart("photo");
            String fileName = part.getSubmittedFileName();

            Movie b = new Movie(movieTitle, movieGenre, movieYear, fileName, "admin", urlYoutube);

            MovieDAO dao = new MovieDAO(DBConnect.getConnection());

            boolean f = dao.addMovies(b);

            HttpSession session = request.getSession();

            if (f) {
                //Old Code for image uploading
                /*String tempDirectory = getServletContext().getRealPath("") + File.separator + "temp";
                File tempFile = new File(tempDirectory, fileName);
                part.write(tempFile.getAbsolutePath());

               
               // String destinationDirectory = "C:\\Users\\mraur\\intellij_project\\demo\\src\\main\\webapp\\assets\\images";
                String destinationDirectory = "C:\\Users\\tamilmani\\Desktop\\MovieX\\MovieX\\src\\main\\webapp\\assets\\images";
                File destinationFile = new File(destinationDirectory, fileName);
                Files.move(tempFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING); */
               
            	 String uploadPath = getServletContext().getRealPath("") + File.separator + "assets" + File.separator + "images";
            	 
            	 // Ensure the directory exists
                 File uploadDir = new File(uploadPath);
                 if (!uploadDir.exists()) {
                     uploadDir.mkdirs();
                 }

                 // Write the file to the target location
                 String filePath = uploadPath + File.separator + fileName;
                 try (InputStream input = part.getInputStream()) {
                     Files.copy(input, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
                 }
                 
                response.sendRedirect("admin.jsp");
            } else {
                session.setAttribute("failedMsg", "Something went wrong on the server");
                response.sendRedirect("admin.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
