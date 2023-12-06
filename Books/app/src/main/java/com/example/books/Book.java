package com.example.books;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Book implements Parcelable {

    private String title;
    private String author;
    private String comment;
    private float rate;

    protected Book(String title, String author, String comment, float rate) {
        this.title = title;
        this.author = author;
        this.comment = comment;
        this.rate = rate;
    }

    protected Book(Parcel in) {
        title = in.readString();
        author = in.readString();
        comment = in.readString();
        rate = in.readFloat();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int i) {
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(comment);
        dest.writeFloat(rate);
    }

    //Getters
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getComment() {
        return comment;
    }
    public float getRate() {
        return rate;
    }
}
