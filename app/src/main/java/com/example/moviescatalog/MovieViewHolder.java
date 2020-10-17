package com.example.moviescatalog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView movie_name;
    private TextView movie_year;
    private TextView movie_director;
    private TextView movie_Category;
    private RatingBar movie_rating;
    MovieAdapter adapter;
    FragmentManager fm;


    public MovieViewHolder(@NonNull View itemView,MovieAdapter adapter,FragmentManager fm) {
        super(itemView);
        this.movie_name = itemView.findViewById(R.id.textView);
        this.movie_year = itemView.findViewById(R.id.textView2);
        this.movie_director = itemView.findViewById(R.id.textView3);
        this.movie_Category = itemView.findViewById(R.id.textView4);
        this.movie_rating = itemView.findViewById(R.id.ratingBar2);
        itemView.setOnClickListener(this);
        this.adapter=adapter;
        this.fm=fm;
    }

    public void setMovie_name(String name) {
        this.movie_name.setText(name);
    }

    public void setMovie_year(int movie_year) {
        this.movie_year.setText(Integer.toString(movie_year));
    }

    public void setMovie_director(String movie_director) {
        this.movie_director.setText(movie_director);
    }

    public void setMovie_Category(String movie_Category) {
        this.movie_Category.setText(movie_Category);
    }

    public void setMovie_rating(float stars) {
        this.movie_rating.setRating(stars);
        System.out.println("set:"+ stars);
    }

    @Override
    public void onClick(View v) {
        final int position = getAdapterPosition();
        final Movie m;
       // Toast.makeText(v.getContext(), String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
/*
        new AlertDialog.Builder(v.getContext())
                .setTitle("Изтриване на филм")
                .setMessage("Сигурни ле че искате да изтриете този филм?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                            adapter.removeMovie(position);
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_delete)
                .show();*/

        UpdateMovieFragment updateMovieFragment = UpdateMovieFragment.newInstance(position,adapter);
        updateMovieFragment.show(fm, "fragment_update_movie");

    }
}
