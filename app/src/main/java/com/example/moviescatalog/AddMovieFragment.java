package com.example.moviescatalog;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;


public class AddMovieFragment extends DialogFragment implements View.OnClickListener {


    private EditText mname;
    private EditText myear;
    private EditText mcategory;
    private EditText mdirector;
    private RatingBar mrating;
    private Button add;
    MovieListener listener;

    public AddMovieFragment() {
        // Required empty public constructor
    }

    public static AddMovieFragment newInstance() {
        return new AddMovieFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mname = view.findViewById(R.id.editText);
        myear = view.findViewById(R.id.editText2);
        mcategory = view.findViewById(R.id.editText3);
        mdirector = view.findViewById(R.id.editText4);
        mrating = view.findViewById(R.id.ratingBar);
        add = view.findViewById(R.id.button);
        add.setOnClickListener(this);

        // Фокуситане на курсора за писане върху еditText
        mname.requestFocus();
        // Автоматично показване на клавиятурата
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (MovieListener) context;
    }

    @Override
    public void onClick(View v) {
        if(mname.getText().toString().equals("") && myear.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Име и година са задължителни полета!",Toast.LENGTH_LONG).show();
        }
        else{
        Movie m = new Movie(Integer.parseInt(myear.getText().toString()),mname.getText().toString(),mdirector.getText().toString(),mcategory.getText().toString(),mrating.getRating());
        listener.onFinishAddDialog(m);
        dismiss();
        }

    }
}
