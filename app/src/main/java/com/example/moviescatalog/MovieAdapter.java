package com.example.moviescatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private ArrayList<Movie> movies;
    FragmentManager fm;

    public MovieAdapter(ArrayList<Movie> movies,FragmentManager fm) {
        this.movies = movies;
        this.fm=fm;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View mView = inflater.inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(mView,this,fm);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);

        holder.setMovie_name(movie.getMovieName());
        holder.setMovie_Category(movie.getMovieCategory());
        holder.setMovie_director(movie.getMovieDirector());
        holder.setMovie_year(movie.getMovieYear());
        holder.setMovie_rating(movie.getMovieRating());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void addMovie(Movie m){
        movies.add(0,m);
        notifyItemInserted(0);
    }
    public void removeMovie(int position){
       movies.remove(position);
       notifyItemRemoved(position);

    }
    public void updateMovie(Movie m,int p){
        movies.get(p).setMovieName(m.getMovieName());
        movies.get(p).setMovieCategory(m.getMovieCategory());
        movies.get(p).setMovieDirector(m.getMovieDirector());
        movies.get(p).setMovieYear(m.getMovieYear());
        movies.get(p).setMovieRating(m.getMovieRating());
        notifyItemChanged(p);
    }
}
