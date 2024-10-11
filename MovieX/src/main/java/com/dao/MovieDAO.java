package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.Movie;

public class MovieDAO {
	private Connection conn;

    public MovieDAO(Connection conn) {
        super();
        this.conn = conn;
    }

    
    public boolean addMovies(Movie b) {
        // TODO Auto-generated method stub

        boolean f = false;

        try {

            String sql = "INSERT INTO tbl_movies (movie_title, movie_genre, movie_year, image, url_youtube) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, b.getMovieTitle());
            ps.setString(2, b.getMovieGenre());
            ps.setString(3, b.getMovieYear());
            ps.setString(4, b.getImageName());
            ps.setString(5, b.getUrlYoutube());

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    
    public List<Movie> getAllMovies() {
        List<Movie> list = new ArrayList<Movie>();
        Movie b = null;

        try {
            String sql = "SELECT * FROM tbl_movies order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b = new Movie();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));

                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    public Movie getMovieById(int id) {
    	Movie b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b = new Movie();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }

    
    public boolean updateEditMovies(Movie b) {
        boolean f = false;

        try {
            String sql = "UPDATE tbl_movies set movie_title=?, movie_genre=?, movie_year=?, url_youtube=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, b.getMovieTitle());
            ps.setString(2, b.getMovieGenre());
            ps.setString(3, b.getMovieYear());
            ps.setString(4, b.getUrlYoutube());
            ps.setInt(5, b.getMovieId());

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public boolean deleteMovies(int id) {
        boolean f = false;

        try {
            String sql = "DELETE FROM tbl_movies WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    
    public List<Movie> getActionMovie() {

        List<Movie> list = new ArrayList<Movie>();
        Movie b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_genre=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Action");
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next() && i <= 18) {
                b = new Movie();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    public List<Movie> getAdventureMovie() {

        List<Movie> list = new ArrayList<Movie>();
        Movie b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_genre=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Adventure");
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next() && i <= 18) {
                b = new Movie();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    public List<Movie> getMovieBySearch(String ch) {
        List<Movie> list = new ArrayList<Movie>();
        Movie b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_title LIKE ? OR movie_genre LIKE ? or movie_year LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ch + "%");
            ps.setString(2, "%" + ch + "%");
            ps.setString(3, "%" + ch + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b = new Movie();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    public List<Movie> getFamilyMovie() {
        List<Movie> list = new ArrayList<Movie>();
        Movie b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_genre=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Family");
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next() && i <= 18) {
                b = new Movie();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    public List<Movie> getHorrorMovie() {
        List<Movie> list = new ArrayList<Movie>();
        Movie b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_genre=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Horror");
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next() && i <= 18) {
                b = new Movie();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    public List<Movie> getThrillerMovie() {
        List<Movie> list = new ArrayList<Movie>();
        Movie b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_genre=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Thriller");
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next() && i <= 18) {
                b = new Movie();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
