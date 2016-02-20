package com.android.exam.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by franceriu on 2/20/16.
 */
public class Company implements Parcelable {

    private ArrayList<Address> addresses;
    @SerializedName("contactNo")
    private String contactNumber;
    private String description;
    @SerializedName("entityId")
    private int entity;

    @SerializedName("logos")
    private ArrayList<Logo> logo;
    private String name;
    private String verifyStatus;


    private static class Address implements Parcelable {

        @SerializedName("entityId")
        int entityID;
        String postCode;
        String profile;
        String street;


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.entityID);
            dest.writeString(this.postCode);
            dest.writeString(this.profile);
            dest.writeString(this.street);
        }

        public Address() {
        }

        private Address(Parcel in) {
            this.entityID = in.readInt();
            this.postCode = in.readString();
            this.profile = in.readString();
            this.street = in.readString();
        }

        public static final Creator<Address> CREATOR = new Creator<Address>() {
            public Address createFromParcel(Parcel source) {
                return new Address(source);
            }

            public Address[] newArray(int size) {
                return new Address[size];
            }
        };
    }

    public class Logo implements Parcelable {
        @SerializedName("entityId")
        public int entityID;

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(this.entityID);
        }

        public Logo() {
        }

        private Logo(Parcel in) {
            this.entityID = in.readInt();
        }

        public final Creator<Logo> CREATOR = new Creator<Logo>() {
            public Logo createFromParcel(Parcel source) {
                return new Logo(source);
            }

            public Logo[] newArray(int size) {
                return new Logo[size];
            }
        };

        public int getEntityID() {
            return entityID;
        }

        public void setEntityID(int entityID) {
            this.entityID = entityID;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.addresses);
        dest.writeString(this.contactNumber);
        dest.writeString(this.description);
        dest.writeLong(this.entity);
        dest.writeSerializable(this.logo);
        dest.writeString(this.name);
        dest.writeString(this.verifyStatus);
    }


    private Company(Parcel in) {
        this.addresses = (ArrayList<Address>) in.readSerializable();
        this.contactNumber = in.readString();
        this.description = in.readString();
        this.entity = in.readInt();
        this.logo = (ArrayList<Logo>) in.readSerializable();
        this.name = in.readString();
        this.verifyStatus = in.readString();
    }

    public static final Parcelable.Creator<Company> CREATOR = new Parcelable.Creator<Company>() {
        public Company createFromParcel(Parcel source) {
            return new Company(source);
        }

        public Company[] newArray(int size) {
            return new Company[size];
        }
    };

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEntity() {
        return entity;
    }

    public void setEntity(int entity) {
        this.entity = entity;
    }

    public ArrayList<Logo> getLogo() {
        return logo;
    }

    public void setLogo(ArrayList<Logo> logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(String verifyStatus) {
        this.verifyStatus = verifyStatus;
    }
}
