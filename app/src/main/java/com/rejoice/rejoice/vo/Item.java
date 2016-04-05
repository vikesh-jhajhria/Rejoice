package com.rejoice.rejoice.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    public String title;
    public String detail;
    public boolean selected;

    protected Item(Parcel in) {
        title       =   in.readString();
        detail      =   in.readString();
        selected    =   in.readByte() == 1;
    }

    public Item() {
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(detail);
        dest.writeByte((byte)(selected?1:0));
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
