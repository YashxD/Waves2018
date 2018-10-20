package org.bits_waves.waves2018.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.bits_waves.waves2018.ListItems.OurTeamItem;
import org.bits_waves.waves2018.OurTeamViewHolder;
import org.bits_waves.waves2018.R;

import java.util.List;

public class OurTeamAdapter extends RecyclerView.Adapter<OurTeamViewHolder> {

    List<OurTeamItem> ourTeamItems;

    public OurTeamAdapter(List<OurTeamItem> ourTeamItems) {
        this.ourTeamItems = ourTeamItems;
    }

    @NonNull
    @Override
    public OurTeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_ourteam_rv, parent, false);
        OurTeamViewHolder holder = new OurTeamViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OurTeamViewHolder holder, int position) {
        OurTeamItem ourTeamItem1 = ourTeamItems.get(position*2);
        OurTeamItem ourTeamItem2 = ourTeamItems.get(position*2+1);
        holder.populate(ourTeamItem1,ourTeamItem2);
    }

    @Override
    public int getItemCount() {
        return ourTeamItems.size();
    }
}
