package org.bits_waves.waves2018.ListItems;

public class WinnersItem {
    private String eventName;
    private String data;

    public void WinnersItem(WinnersItem winnersItem){
        this.eventName = winnersItem.eventName;
        this.data = winnersItem.data;
    }

    public WinnersItem(String eventName, String data) {
        this.eventName = eventName;
        this.data = data;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
