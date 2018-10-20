package org.bits_waves.waves2018.ListItems;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable{
    private String name;
    private String description;
    private String rules;
    private String imgRes;

    public Event() {
        this.name =  "Def";
        this.description = "Def";
        this.rules = "Def";
        this.imgRes = "Def";
    }

    public Event(Event event){
        this.name =  event.name;
        this.description = event.description;
        this.rules = event.rules;
        this.imgRes = event.imgRes;
    }

    //Constructor to read from parcel
    public Event(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.rules = in.readString();
        this.imgRes = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //To write to parcel
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(rules);
        parcel.writeString(imgRes);
    }

    //Necessary creator to implement Parcelable
    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public String getImgRes() {
        return imgRes;
    }

    public String getName() {
        return name;
    }

    public String getRules() {
        return rules;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setImgRes(String imgRes) {
        this.imgRes = imgRes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }
}
