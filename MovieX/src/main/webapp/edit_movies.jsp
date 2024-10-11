<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.dao.MovieDAO" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="com.dto.Movie" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Moviex: Edit Movies</title>
    <link rel="stylesheet" href="stylesheet/login.css"/>
    <link rel="icon" href="assets/popcorn.png">
    <style>
        .form-group select {
            padding: 10px;
            font-size: 16px;
            border-radius: 4px;
            border: none;
            width: 100%;
        }
    </style>
</head>
<body>

<div class="background"></div>
<div class="container">
    <div class="content">
        <h1>Edit Movies</h1>


        <%
            int id = Integer.parseInt(request.getParameter("id"));
            MovieDAO dao = new MovieDAO(DBConnect.getConnection());
            Movie b = dao.getMovieById(id);
        %>


        <form action="EditMovie" method="post">
            <input type="hidden" name="id" value="<%=b.getMovieId()%>">
            <div class="form-group">
                <label for="title">Title</label> <input type="text" name="movieTitle"
                                                        id="title" placeholder="Movie Title"
                                                        value="<%=b.getMovieTitle()%>" required>
            </div>
            <div class="form-group">
                <label for="genre">Genre</label>
                <select name="movieGenre" id="genre" required>
                    <option value="" disabled selected>Select Genre</option>
                    <option value="Action" <% if (b.getMovieGenre().equals("Action")) { %>selected<% } %>>Action
                    </option>
                    <option value="Adventure" <% if (b.getMovieGenre().equals("Adventure")) { %>selected<% } %>>
                        Adventure
                    </option>
                    <option value="Family" <% if (b.getMovieGenre().equals("Family")) { %>selected<% } %>>
                        Family
                    </option>
                    <option value="Horror" <% if (b.getMovieGenre().equals("Horror")) { %>selected<% } %>>
                        Horror
                    </option>
                    <option value="Thriller" <% if (b.getMovieGenre().equals("Thriller")) { %>selected<% } %>>
                        Thriller
                    </option>
                </select>
            </div>

            <div class="form-group">
                <label for="year">Year</label> <input type="text" name="movieYear"
                                                      id="year" placeholder="Released Year"
                                                      value="<%=b.getMovieYear()%>" required>
            </div>
            <div class="form-group">
                <label for="year">Trailer URL</label> <input type="url" name="urlYoutube"
                                                      id="url" placeholder="Link of Trailer"
                                                      value="<%=b.getUrlYoutube()%>" required>
            </div>
            <input type="submit" value="Edit">
        </form>
    </div>
</div>

</body>
</html>