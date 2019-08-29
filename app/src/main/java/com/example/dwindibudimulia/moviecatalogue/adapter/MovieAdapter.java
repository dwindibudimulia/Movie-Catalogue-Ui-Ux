package com.example.dwindibudimulia.moviecatalogue.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dwindibudimulia.moviecatalogue.activity.MovieDetailActivity;
import com.example.dwindibudimulia.moviecatalogue.itemClick.CustomOnItemClickListener;
import com.example.dwindibudimulia.moviecatalogue.model.Movie;
import com.example.dwindibudimulia.moviecatalogue.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context contextMovie;
    private ArrayList<Movie> movies;


    public MovieAdapter(Context contextMovie) {
        this.contextMovie = contextMovie;
        movies = new ArrayList<>();
    }

    public ArrayList<Movie> getmovies() {
        return movies;
    }

    public void setmovies(ArrayList<Movie> movies) {

        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final Movie movie = movies.get(i);

        Glide.with(contextMovie)
                .load(movie.getphotoMovie())
                .into(holder.imgPhoto);

        holder.txtName.setText(movie.getnameMovie());
        holder.txtRating.setText(movie.getratingMovie());
        holder.txtDate.setText(movie.getdateMovie());
        holder.txtGenre.setText(movie.getgenreMovie());

        holder.cardView.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(int positon) {
                Intent intent = new Intent(contextMovie, MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movies.get(positon));
                contextMovie.startActivity(intent);
            }
        }));

        holder.imgPhoto.setAnimation(AnimationUtils.loadAnimation(contextMovie, R.anim.fade_animation_transition));
        holder.cardView.setAnimation(AnimationUtils.loadAnimation(contextMovie, R.anim.fade_scale_animation));

        // holder.btnDetail.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //    public void onClick(View view) {
        //       Intent intent = new Intent(contextMovie, MovieDetailActivity.class);
        //       intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, movie);
        //       contextMovie.startActivity(intent);
        //     }
        //  });


    }

    @Override
    public int getItemCount() {
        return getmovies().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView txtName;
        TextView txtRating;
        TextView txtDate;
        TextView txtGenre;
        CardView cardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            txtName = itemView.findViewById(R.id.txt_name);
            txtRating = itemView.findViewById(R.id.txt_rating);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtGenre = itemView.findViewById(R.id.txt_genre);
            cardView = itemView.findViewById(R.id.card_movie);
            // btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
