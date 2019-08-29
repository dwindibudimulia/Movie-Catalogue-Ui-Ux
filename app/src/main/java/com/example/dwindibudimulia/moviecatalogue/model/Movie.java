package com.example.dwindibudimulia.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int photoMovie;
    private String nameMovie;
    private String ratingMovie;
    private String descriptionMovie;
    private String dateMovie;
    private String genreMovie;

    public String getgenreMovie() {
        return genreMovie;
    }

    public void setgenreMovie(String genreMovie) {
        this.genreMovie = genreMovie;
    }

    public String getratingMovie() {
        return ratingMovie;
    }

    public void setratingMovie(String ratingMovie) {
        this.ratingMovie = ratingMovie;
    }

    public String getdateMovie() {
        return dateMovie;
    }

    public void setdateMovie(String dateMovie) {
        this.dateMovie = dateMovie;
    }

    public int getphotoMovie() {
        return photoMovie;
    }

    public void setphotoMovie(int photoMovie) {
        this.photoMovie = photoMovie;
    }

    public String getnameMovie() {
        return nameMovie;
    }

    public void setnameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }


    public String getdescriptionMovie() {
        return descriptionMovie;
    }

    public void setdescriptionMovie(String descriptionMovie) {
        this.descriptionMovie = descriptionMovie;
    }


    public Movie() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photoMovie);
        dest.writeString(this.nameMovie);
        dest.writeString(this.ratingMovie);
        dest.writeString(this.descriptionMovie);
        dest.writeString(this.dateMovie);
        dest.writeString(this.genreMovie);
    }

    protected Movie(Parcel in) {
        this.photoMovie = in.readInt();
        this.nameMovie = in.readString();
        this.ratingMovie = in.readString();
        this.descriptionMovie = in.readString();
        this.dateMovie = in.readString();
        this.genreMovie = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
