package org.bits_waves.waves2018.ListItems;

import android.content.Context;

public class OurTeamItem {
    private String name;
    private String position;
    private String info;
    private String call;
    private String mail;
    private int imgResInt;

    public OurTeamItem(String name, String position, String info, String call, String mail, int imgResInt) {
        this.name = name;
        this.position = position;
        this.info = info;
        this.call = call;
        this.mail = mail;
        this.imgResInt = imgResInt;
    }

    public OurTeamItem(OurTeamItem ourTeamItem) {
        this.name = ourTeamItem.name;
        this.position = ourTeamItem.position;
        this.info = ourTeamItem.info;
        this.call = ourTeamItem.call;
        this.mail = ourTeamItem.mail;
        this.imgResInt = ourTeamItem.imgResInt;
    }

    public int getImgResInt() {
        return imgResInt;
    }

    public void setImgResInt(int imgResInt) {
        this.imgResInt = imgResInt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
