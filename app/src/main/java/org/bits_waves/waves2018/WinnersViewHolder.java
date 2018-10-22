package org.bits_waves.waves2018;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.bits_waves.waves2018.ListItems.WinnersItem;

public class WinnersViewHolder extends RecyclerView.ViewHolder {

    private TextView eventName;
    private TextView data;

    public WinnersViewHolder(View itemView) {
        super(itemView);
        eventName = itemView.findViewById(R.id.winners_rv_item_eventname);
        data = itemView.findViewById(R.id.winners_rv_item_data);
    }

    public void populate(WinnersItem winnersItem) {
        eventName.setText(winnersItem.getEventName());
        data.setText(winnersItem.getData());
    }
}
