package com.android.exam.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by franceriu on 2/20/16.
 */
public class Image implements Parcelable {

    private String caption;
    private int entityId;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.caption);
        dest.writeInt(this.entityId);
    }

    public Image() {
    }

    private Image(Parcel in) {
        this.caption = in.readString();
        this.entityId = in.readInt();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }
}
