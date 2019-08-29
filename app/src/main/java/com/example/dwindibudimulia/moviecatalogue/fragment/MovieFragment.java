package com.example.dwindibudimulia.moviecatalogue.fragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dwindibudimulia.moviecatalogue.activity.MovieDetailActivity;
import com.example.dwindibudimulia.moviecatalogue.adapter.MovieAdapter;
import com.example.dwindibudimulia.moviecatalogue.model.Movie;
import com.example.dwindibudimulia.moviecatalogue.R;

import java.util.ArrayList;

public class MovieFragment extends Fragment {

    private RecyclerView rvMovie;
    private String[] txtName;
    private String[] txtRating;
    private String[] txtDate;
    private String[] txtGenre;
    private String[] txtDescription;
    private TypedArray imgPhoto;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movies;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvMovie.setLayoutManager(new LinearLayoutManager(this.getContext()));
        movieAdapter = new MovieAdapter(this.getContext());
        prepareMovie();
        addItemMovie();

        rvMovie.setAdapter(movieAdapter);

    }

    private void showSelectedMovie(Movie movie) {
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie);
        startActivity(intent);
    }

    private void addItemMovie() {
        movies = new ArrayList<>();
        for (int i = 0; i < txtName.length; i++) {
            Movie movie = new Movie();
            movie.setphotoMovie(imgPhoto.getResourceId(i, -1));
            movie.setnameMovie(txtName[i]);
            movie.setratingMovie(txtRating[i]);
            movie.setdateMovie(txtDate[i]);
            movie.setdescriptionMovie(txtDescription[i]);
            movie.setgenreMovie(txtGenre[i]);
            movies.add(movie);
        }
        movieAdapter.setmovies(movies);
    }

    private void prepareMovie() {
        txtName = getResources().getStringArray(R.array.movie_name);
        txtRating = getResources().getStringArray(R.array.rating_movie);
        txtDate = getResources().getStringArray(R.array.movie_date);
        imgPhoto = getResources().obtainTypedArray(R.array.movie_photo);
        txtGenre = getResources().getStringArray(R.array.genre_movie);
        txtDescription = getResources().getStringArray(R.array.movie_description);

    }
}
