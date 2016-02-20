package com.android.exam.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by franceriu on 2/20/16.
 */
public class Product implements Parcelable {

    private String description;
    private int entityId;
    private String averagePrice;
    @SerializedName("productName")
    private String name;
    private String price;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.description);
        dest.writeInt(this.entityId);
        dest.writeString(this.averagePrice);
        dest.writeString(this.name);
        dest.writeString(this.price);
    }

    public Product() {
    }

    private Product(Parcel in) {
        this.description = in.readString();
        this.entityId = in.readInt();
        this.averagePrice = in.readString();
        this.name = in.readString();
        this.price = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };


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

    public String getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(String averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
