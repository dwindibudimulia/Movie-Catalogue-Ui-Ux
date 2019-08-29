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

import com.example.dwindibudimulia.moviecatalogue.activity.TvShowDetailActivity;
import com.example.dwindibudimulia.moviecatalogue.adapter.TvShowAdapter;
import com.example.dwindibudimulia.moviecatalogue.model.TvShow;
import com.example.dwindibudimulia.moviecatalogue.R;

import java.util.ArrayList;

public class TvShowFragment extends Fragment {
    private RecyclerView rvTvShow;
    private String[] txtNameTvShow;
    private String[] txtRating;
    private String[] txtDateTvShow;
    private String[] txtGenreTv;
    private String[] txtDescriptionTv;
    private TypedArray imgPhotoTvShow;
    private TvShowAdapter tvShowAdapter;
    private ArrayList<TvShow> tvShows;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       rvTvShow = view.findViewById(R.id.rv_tvshow);
       rvTvShow.setHasFixedSize(true);

       showRecylerList();
    }

    private void showRecylerList(){
        rvTvShow.setLayoutManager(new LinearLayoutManager(this.getContext()));
        tvShowAdapter = new TvShowAdapter(this.getContext());

        prepareTvShow();
        addItemTvShow();
        rvTvShow.setAdapter(tvShowAdapter);

    }

    private void showSelectedTvShow(TvShow tvShow){
        Intent intent = new Intent(getContext(), TvShowDetailActivity.class);
        intent.putExtra(TvShowDetailActivity.EXTRA_TV_SHOW, tvShow);
        startActivity(intent);
    }

    private void addItemTvShow(){
        tvShows = new ArrayList<>();
        for (int i=0; i<txtNameTvShow.length; i++){
            TvShow tvShowAdapter = new TvShow();
            tvShowAdapter.setphotoTv(imgPhotoTvShow.getResourceId(i, -1));
            tvShowAdapter.setnameTv(txtNameTvShow[i]);
            tvShowAdapter.setratingTv(txtRating[i]);
            tvShowAdapter.setdateTv(txtDateTvShow[i]);
            tvShowAdapter.setgenreTv(txtGenreTv[i]);
            tvShowAdapter.setdescriptionTv(txtDescriptionTv[i]);
            tvShows.add(tvShowAdapter);
        }
        tvShowAdapter.settvShow(tvShows);
    }

    private void prepareTvShow(){
        imgPhotoTvShow = getResources().obtainTypedArray(R.array.tv_show_photo);
        txtNameTvShow = getResources().getStringArray(R.array.tv_show_name);
        txtRating = getResources().getStringArray(R.array.rating_tv_show);
        txtDateTvShow = getResources().getStringArray(R.array.tv_show_date);
        txtGenreTv = getResources().getStringArray(R.array.genre_tv);
        txtDescriptionTv = getResources().getStringArray(R.array.tv_show_description);
    }

}
