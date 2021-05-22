package com.prakpapb2.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class Pahlawan implements Parcelable {

    private int id;
    private String photoPahlawan;
    private String namaPahlawan;
    private String deskripsiPahlawan;

    public Pahlawan() {
    }

    public Pahlawan(int id, String photoPahlawan, String namaPahlawan, String deskripsiPahlawan) {
        this.id = id;
        this.photoPahlawan = photoPahlawan;
        this.namaPahlawan = namaPahlawan;
        this.deskripsiPahlawan = deskripsiPahlawan;
    }

    protected Pahlawan(Parcel in) {
        id = in.readInt();
        photoPahlawan = in.readString();
        namaPahlawan = in.readString();
        deskripsiPahlawan = in.readString();
    }

    public static final Creator<Pahlawan> CREATOR = new Creator<Pahlawan>() {
        @Override
        public Pahlawan createFromParcel(Parcel in) {
            return new Pahlawan(in);
        }

        @Override
        public Pahlawan[] newArray(int size) {
            return new Pahlawan[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhotoPahlawan() {
        return photoPahlawan;
    }

    public void setPhotoPahlawan(String photoPahlawan) {
        this.photoPahlawan = photoPahlawan;
    }

    public String getNamaPahlawan() {
        return namaPahlawan;
    }

    public void setNamaPahlawan(String namaPahlawan) {
        this.namaPahlawan = namaPahlawan;
    }

    public String getDeskripsiPahlawan() {
        return deskripsiPahlawan;
    }

    public void setDeskripsiPahlawan(String deskripsiPahlawan) {
        this.deskripsiPahlawan = deskripsiPahlawan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(photoPahlawan);
        dest.writeString(namaPahlawan);
        dest.writeString(deskripsiPahlawan);
    }
}
