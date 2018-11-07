package com.example.deva_.week2daily3;

import android.os.Parcel;
import android.os.Parcelable;

public class Save implements Parcelable {
    private static String mValue;
    private static String mKey;

    public Save(String value, String key) {
        this.mValue = value;
        this.mKey = key;
    }

    public static String getmValue() { return mValue; }
    public static void setmValue(String mValue) { Save.mValue = mValue; }
    public static String getmKey() {  return mKey; }
    public static void setmKey(String mKey) {  Save.mKey = mKey;  }

    protected Save(Parcel in) {
        mValue = in.readString();
        mKey = in.readString();
    }

    public static final Creator<Save> CREATOR = new Creator<Save>() {
        @Override
        public Save createFromParcel(Parcel in) {
            return new Save(in);
        }

        @Override
        public Save[] newArray(int size) {
            return new Save[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mValue);
        parcel.writeString(mKey);
    }
}
