package com.example.moviescatalog;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;


public class UpdateMovieFragment extends DialogFragment implements View.OnClickListener{

    private EditText mname;
    private EditText myear;
    private EditText mcategory;
    private EditText mdirector;
    private RatingBar mrating;
    private Button update;
    private Button remove;
    MovieListener listener;
    private static int position;
    static MovieAdapter adapter;

    public UpdateMovieFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static UpdateMovieFragment newInstance(int p,MovieAdapter a) {
        UpdateMovieFragment fragment = new UpdateMovieFragment();
        position=p;
        adapter=a;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mname = view.findViewById(R.id.editText5);
        myear = view.findViewById(R.id.editText6);
        mcategory = view.findViewById(R.id.editText7);
        mdirector = view.findViewById(R.id.editText8);
        mrating = view.findViewById(R.id.ratingBar3);
        update = view.findViewById(R.id.button2);
        remove = view.findViewById(R.id.button3);
        update.setOnClickListener(this);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.removeMovie(position);
                dismiss();
            }
        });


        Movie m = MovieRepository.getInstance().getMovieArrayListlist().get(position);
        mname.setText(m.getMovieName());
        myear.setText(String.valueOf(m.getMovieYear()));
        mcategory.setText((m.getMovieCategory()));
        mdirector.setText(m.getMovieDirector());
        mrating.setRating(m.getMovieRating());

        // Автоматично показване на клавиятурата
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (MovieListener) context;

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void onClick(View v) {
        Movie m = new Movie(Integer.parseInt(myear.getText().toString()),mname.getText().toString(),mdirector.getText().toString(),mcategory.getText().toString(),mrating.getRating());
        listener.onUpdate(m,position);
        dismiss();

    }
}
