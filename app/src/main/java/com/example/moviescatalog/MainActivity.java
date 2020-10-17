package com.example.moviescatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MovieListener {
    RecyclerView recyclerView;
    MovieAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.recyclerView);

      //  ArrayList<Movie> movieArrayListlist = new ArrayList<Movie>();


        MovieRepository.getInstance().getMovieArrayListlist();
        FragmentManager fm2 = getSupportFragmentManager();
        adapter = new MovieAdapter(MovieRepository.getInstance().getMovieArrayListlist(),fm2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Movie m = new Movie(2020,"Westworld S03","John","TV series",2);
        Movie m2 = new Movie(2020,"Ozark S03","Michael","TV series",3);
        MovieRepository.getInstance().getMovieArrayListlist().add(m);
        MovieRepository.getInstance().getMovieArrayListlist().add(m2);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                AddMovieFragment addmovieFragment = AddMovieFragment.newInstance();
                addmovieFragment.show(fm, "fragment_add_movie");
            }
        });

        Toast.makeText(this, "За редактиране натиснете върху филм!",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onFinishAddDialog(Movie m) {
        adapter.addMovie(m);
    }

    @Override
    public void onUpdate(Movie m, int p) {
        adapter.updateMovie(m,p);
    }
}
