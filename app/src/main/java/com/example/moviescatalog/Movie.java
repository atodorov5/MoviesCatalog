package com.example.moviescatalog;

public class Movie {
    private int movieYear;
    private String movieName;
    private String movieDirector;
    private String movieCategory;
    private float movieRating;
    private int movieID;

    public Movie(int movieYear, String movieName, String movieDirector, String movieCategory, float movieRating) {
        this.movieYear = movieYear;
        this.movieName = movieName;
        this.movieDirector = movieDirector;
        this.movieCategory = movieCategory;
        this.movieRating = movieRating;

        this.movieID=MovieRepository.getInstance().getMovieArrayListlist().size()+1;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public float getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(float movieRating) {
        this.movieRating = movieRating;
    }

    public int getMovieID() {
        return movieID;
    }
}
