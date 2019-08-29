package com.example.dwindibudimulia.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private int photoTv;
    private String nameTv;
    private String ratingTv;
    private String descriptionTv;
    private String dateTv;
    private String genreTv;


    public String getgenreTv() {
        return genreTv;
    }

    public void setgenreTv(String genreTv) {

        this.genreTv = genreTv;
    }

    public String getratingTv() {
        return ratingTv;
    }

    public void setratingTv(String ratingTv) {
        this.ratingTv = ratingTv;
    }

    public int getphotoTv() {
        return photoTv;
    }

    public void setphotoTv(int photoTv) {
        this.photoTv = photoTv;
    }

    public String getnameTv() {
        return nameTv;
    }

    public void setnameTv(String nameTv) {
        this.nameTv = nameTv;
    }

    public String getdescriptionTv() {
        return descriptionTv;
    }

    public void setdescriptionTv(String descriptionTv) {
        this.descriptionTv = descriptionTv;
    }

    public String getdateTv() {
        return dateTv;
    }

    public void setdateTv(String dateTv) {
        this.dateTv = dateTv;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photoTv);
        dest.writeString(this.nameTv);
        dest.writeString(this.ratingTv);
        dest.writeString(this.descriptionTv);
        dest.writeString(this.dateTv);
        dest.writeString(this.genreTv);
    }

    public TvShow() {
    }

    protected TvShow(Parcel in) {
        this.photoTv = in.readInt();
        this.nameTv = in.readString();
        this.ratingTv = in.readString();
        this.descriptionTv = in.readString();
        this.dateTv = in.readString();
        this.genreTv = in.readString();
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
