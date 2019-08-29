package com.example.dwindibudimulia.moviecatalogue.activity;



import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dwindibudimulia.moviecatalogue.model.Movie;
import com.example.dwindibudimulia.moviecatalogue.R;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    private TextView tvName;
    private TextView tvRating;
    private TextView tvDescription;
    private TextView tvDate;
    private TextView tvGenre;
    private ImageView imgPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        tvName = findViewById(R.id.txt_name);
        tvRating = findViewById(R.id.txt_rating);
        tvDescription = findViewById(R.id.txt_description);
        tvDate = findViewById(R.id.txt_date);
        tvGenre = findViewById(R.id.txt_genre);
        imgPhoto = findViewById(R.id.img_photo);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);


        tvName.setText(movie.getnameMovie());
        tvRating.setText(movie.getratingMovie());
        tvDescription.setText(movie.getdescriptionMovie());
        tvDate.setText(movie.getdateMovie());
        tvGenre.setText(movie.getgenreMovie());
        imgPhoto.setImageResource(movie.getphotoMovie());
        if (getSupportActionBar() !=null){
            getSupportActionBar().setTitle(movie.getnameMovie());
        }


    }
}

