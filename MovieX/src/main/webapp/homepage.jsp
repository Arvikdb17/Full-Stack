<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.dao.MovieDAO" %>
<%@ page import="com.db.DBConnect" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dto.Movie" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Moviex: Home</title>
    <link rel="stylesheet" href="stylesheet/main.css">
    <link rel="icon" href="assets/popcorn.png">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Inter:100,200,300,regular,500,600,700,800,900">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>

<body>

<!-- Main Container -->
<div class="container">
<br>
    <!-- MAIN SECTION START -->
    <main>

        <!-- BANNER SECTION START -->
        <section class="banner">
            <div class="banner-card">
                <img src="assets/GoatPoster.jpg" alt="Goat"
                     class="banner-img">
                <div class="card-content">
                    <div class="card-info">
                        <div class="genre">
                            <span>Action</span>
                        </div>
                        <div class="year">
                            <span>2024</span>
                        </div>
                        <div class="duration">
                            <span>2h 50m</span>
                        </div>
                    </div>
                    <h2 class="card-title">Greatest Of All Time</h2>
                </div>
            </div>
        </section>
        <!-- BANNER SECTION END -->

        <!-- MOVIES SECTION START -->
        <section class="movies">
            <div class="filter-bar">
                <div class="filter-dropdowns">
                    <h1>MOVIEX</h1>
                </div>
                <div class="search-bar">
                    <form action="search.jsp" method="post">
                        <input type="search" placeholder="Search movies..." name="ch">
                        <button type="submit"><i class="fas fa-search"></i></button>
                    </form>
                </div>
                <div class="filter-radios">
                    <input type="radio" name="grade" id="newest">
                    <a href="#" onclick="goBack()">Logout</a>
                </div>

            </div>


            <!-- ACTION SECTION -->
            <h1 style="margin-bottom: 20px">Action</h1>
            <div class="movies-grid">

                <%
                    MovieDAO dao = new MovieDAO(DBConnect.getConnection());
                    List<Movie> list = dao.getActionMovie();

                    for (Movie b : list) {
                %>
                <div class="movie-card">
                    <div class="card-head">

                        <img src="assets/images/<%=b.getImageName()%>" alt="" class="card-img">
                        <a href="<%=b.getUrlYoutube()%>">
                            <div class="play-icon">
                                <i class="fa-solid fa-play"></i>
                            </div>
                        </a>
                    </div>
                    <div class="card-body">
                        <a href="<%=b.getUrlYoutube()%>"><h3 class="card-title"><%=b.getMovieTitle()%>
                        </h3></a>
                        <div class="card-info">
                            <span class="genre"><%=b.getMovieGenre()%></span> <span
                                class="year"><%=b.getMovieYear()%></span>
                        </div>
                    </div>
                </div>
                <%
                    }

                %>
            </div>


            <!-- ADVENTURE SECTION -->
            <h1 style="margin-bottom: 20px">Adventure</h1>
            <div class="movies-grid">
                <%
                    MovieDAO dao2 = new MovieDAO(DBConnect.getConnection());
                    List<Movie> list2 = dao2.getAdventureMovie();

                    for (Movie b : list2) {
                %>
                <div class="movie-card">
                    <div class="card-head">

                        <img src="assets/images/<%=b.getImageName()%>" alt="" class="card-img">
                        <a href="<%=b.getUrlYoutube()%>">
                            <div class="play-icon">
                                <i class="fa-solid fa-play"></i>
                            </div>
                        </a>
                    </div>
                    <div class="card-body">
                        <a href="<%=b.getUrlYoutube()%>"><h3 class="card-title"><%=b.getMovieTitle()%>
                        </h3></a>
                        <div class="card-info">
                            <span class="genre"><%=b.getMovieGenre()%></span> <span
                                class="year"><%=b.getMovieYear()%></span>
                        </div>
                    </div>
                </div>
                <%
                    }

                %></div>

            <!-- FAMILY SECTION -->
            <h1 style="margin-bottom: 20px">Family</h1>
            <div class="movies-grid">
                <%
                    MovieDAO dao3 = new MovieDAO(DBConnect.getConnection());
                    List<Movie> list3 = dao3.getFamilyMovie();

                    for (Movie b : list3) {
                %>
                <div class="movie-card">
                    <div class="card-head">

                        <img src="assets/images/<%=b.getImageName()%>" alt="" class="card-img">
                        <a href="<%=b.getUrlYoutube()%>">
                            <div class="play-icon">
                                <i class="fa-solid fa-play"></i>
                            </div>
                        </a>
                    </div>
                    <div class="card-body">
                        <a href="<%=b.getUrlYoutube()%>"><h3 class="card-title"><%=b.getMovieTitle()%>
                        </h3></a>
                        <div class="card-info">
                            <span class="genre"><%=b.getMovieGenre()%></span> <span
                                class="year"><%=b.getMovieYear()%></span>
                        </div>
                    </div>
                </div>
                <%
                    }

                %></div>

            <!-- HORROR SECTION -->
            <h1 style="margin-bottom: 20px">Horror</h1>
            <div class="movies-grid">
                <%
                    MovieDAO dao4 = new MovieDAO(DBConnect.getConnection());
                    List<Movie> list4 = dao4.getHorrorMovie();

                    for (Movie b : list4) {
                %>
                <div class="movie-card">
                    <div class="card-head">

                        <img src="assets/images/<%=b.getImageName()%>" alt="" class="card-img">
                        <a href="<%=b.getUrlYoutube()%>">
                            <div class="play-icon">
                                <i class="fa-solid fa-play"></i>
                            </div>
                        </a>
                    </div>
                    <div class="card-body">
                        <a href="<%=b.getUrlYoutube()%>"><h3 class="card-title"><%=b.getMovieTitle()%>
                        </h3></a>
                        <div class="card-info">
                            <span class="genre"><%=b.getMovieGenre()%></span> <span
                                class="year"><%=b.getMovieYear()%></span>
                        </div>
                    </div>
                </div>
                <%
                    }

                %></div>

            <!-- THRILLER SECTION -->
            <h1 style="margin-bottom: 20px">Thriller</h1>
            <div class="movies-grid">
                <%
                    MovieDAO dao5 = new MovieDAO(DBConnect.getConnection());
                    List<Movie> list5 = dao5.getThrillerMovie();

                    for (Movie b : list5) {
                %>
                <div class="movie-card">
                    <div class="card-head">

                        <img src="assets/images/<%=b.getImageName()%>" alt="" class="card-img">
                        <a href="<%=b.getUrlYoutube()%>">
                            <div class="play-icon">
                                <i class="fa-solid fa-play"></i>
                            </div>
                        </a>
                    </div>
                    <div class="card-body">
                        <a href="<%=b.getUrlYoutube()%>"><h3 class="card-title"><%=b.getMovieTitle()%>
                        </h3></a>
                        <div class="card-info">
                            <span class="genre"><%=b.getMovieGenre()%></span> <span
                                class="year"><%=b.getMovieYear()%></span>
                        </div>
                    </div>
                </div>
                <%
                    }

                %></div>
        </section>
        <!-- MOVIES SECTION END -->

    </main>
    <!-- MAIN SECTION END -->

</div>
<script>/* Toggle between adding and removing the "responsive" class to topnav when the user clicks on the icon */
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }


}

function goBack() {
    window.location.href = "login.jsp";
    window.history.pushState({}, '', 'login.jsp');

}</script>
<script src="https://kit.fontawesome.com/7c7f68c3e5.js"
        crossorigin="anonymous"></script>
</body>

</html>