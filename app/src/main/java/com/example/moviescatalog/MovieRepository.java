package com.example.moviescatalog;

import java.util.ArrayList;

public class MovieRepository {

    static MovieRepository instance=null;
    ArrayList<Movie> movieArrayListlist = new ArrayList<Movie>();


    public MovieRepository() {
        // TODO Auto-generated constructor stub
       /*
        Movie m = new Movie(2020,"Westworld S03","John","TV series",2);
        Movie m2 = new Movie(2020,"Ozark S03","Michael","TV series",3);
        movieArrayListlist.add(m);
        movieArrayListlist.add(m2);*/
    }


    public static MovieRepository getInstance() {
        if(instance == null)
        {
            instance = new MovieRepository();
        }
        return instance;
    }

    public ArrayList<Movie> getMovieArrayListlist() {
        return movieArrayListlist;
    }

}
