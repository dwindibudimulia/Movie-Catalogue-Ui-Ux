package com.example.dwindibudimulia.moviecatalogue.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dwindibudimulia.moviecatalogue.activity.TvShowDetailActivity;
import com.example.dwindibudimulia.moviecatalogue.itemClick.CustomOnItemClickListener;
import com.example.dwindibudimulia.moviecatalogue.model.TvShow;
import com.example.dwindibudimulia.moviecatalogue.R;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {

    private Context contextTv;
    private ArrayList<TvShow> tvShow;

    public void setcontextTv(Context contextTv) {

        this.contextTv = contextTv;
    }

    public ArrayList<TvShow> gettvShow() {
        return tvShow;
    }

    public void settvShow(ArrayList<TvShow> tvShow) {
        this.tvShow = tvShow;
    }

    public TvShowAdapter(Context contextTv) {
        this.contextTv = contextTv;
        tvShow = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tv_show, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final TvShow tvShowAdapter = tvShow.get(i);

        Glide.with(contextTv)
                .load(tvShowAdapter.getphotoTv())
                .into(holder.ImgPhotoTv);

        holder.txtNameTv.setText(tvShowAdapter.getnameTv());
        holder.txtRatingTv.setText(tvShowAdapter.getratingTv());
        holder.txtDateTv.setText(tvShowAdapter.getdateTv());
        holder.txtGenreTv.setText(tvShowAdapter.getgenreTv());

        holder.cardViewTv.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(int positon) {
                Intent intent = new Intent(contextTv, TvShowDetailActivity.class);
                intent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW, tvShow.get(positon));
                contextTv.startActivity(intent);
            }
        }));

        holder.ImgPhotoTv.setAnimation(AnimationUtils.loadAnimation(contextTv, R.anim.fade_animation_transition));
        holder.cardViewTv.setAnimation(AnimationUtils.loadAnimation(contextTv, R.anim.fade_scale_animation));
        //  holder.btnDetailTv.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //    public void onClick(View view) {
        //         Intent i = new Intent(contextTv, TvShowDetailActivity.class);
        //         i.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW, tvShowAdapter);
        //        contextTv.startActivity(i);
        //    }
        //  });
    }

    @Override
    public int getItemCount() {
        return gettvShow().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ImgPhotoTv;
        TextView txtNameTv;
        TextView txtRatingTv;
        TextView txtDateTv;
        TextView txtGenreTv;
        CardView cardViewTv;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ImgPhotoTv = itemView.findViewById(R.id.img_photo_tv);
            txtNameTv = itemView.findViewById(R.id.txt_name_tv);
            txtRatingTv = itemView.findViewById(R.id.txt_rating_tv);
            txtDateTv = itemView.findViewById(R.id.txt_date_tv);
            txtGenreTv = itemView.findViewById(R.id.txt_genre_tv);
            cardViewTv = itemView.findViewById(R.id.card_tv_show);
            // btnDetailTv = itemView.findViewById(R.id.btn_detail_tv);
        }
    }
}
