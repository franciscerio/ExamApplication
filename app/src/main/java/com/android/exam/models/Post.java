package com.android.exam.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by franceriu on 2/20/16.
 */
public class Post implements Parcelable {

    private Company company;
    private String description;
    private int entityId;
    @SerializedName("images")
    private ArrayList<Image> imageList;
    @SerializedName("products")
    private ArrayList<Product> productList;
    private String title;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.company, 0);
        dest.writeString(this.description);
        dest.writeLong(this.entityId);
        dest.writeSerializable(this.imageList);
        dest.writeSerializable(this.productList);
        dest.writeString(this.title);
    }

    public Post() {
    }

    private Post(Parcel in) {
        this.company = in.readParcelable(Company.class.getClassLoader());
        this.description = in.readString();
        this.entityId = in.readInt();
        this.imageList = (ArrayList<Image>) in.readSerializable();
        this.productList = (ArrayList<Product>) in.readSerializable();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        public Post createFromParcel(Parcel source) {
            return new Post(source);
        }

        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public ArrayList<Image> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<Image> imageList) {
        this.imageList = imageList;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
