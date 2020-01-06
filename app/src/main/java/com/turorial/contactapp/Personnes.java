package com.turorial.contactapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Personnes implements Parcelable {
    private int id ;
    private String name ;
    private String email;
    private String street ;
    private String phone;
    private String city ;

    public Personnes(int id, String name, String email, String street,  String city,String phone) {

        this.id=id ;
        this.name = name;
        this.email = email;
        this.street = street;
        this.city = city;
        this.phone = phone;
    }

    protected Personnes(Parcel in) {
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        street = in.readString();
        city = in.readString();
        phone = in.readString();

    }

    public static final Creator<Personnes> CREATOR = new Creator<Personnes>() {
        @Override
        public Personnes createFromParcel(Parcel in) {
            return new Personnes(in);
        }

        @Override
        public Personnes[] newArray(int size) {
            return new Personnes[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.email);
        parcel.writeString(this.street);
        parcel.writeString(this.city);
        parcel.writeString(this.phone);



    }
}

