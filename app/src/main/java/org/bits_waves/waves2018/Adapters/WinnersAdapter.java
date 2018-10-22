package org.bits_waves.waves2018.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.bits_waves.waves2018.ListItems.WinnersItem;
import org.bits_waves.waves2018.R;
import org.bits_waves.waves2018.WinnersViewHolder;

import java.util.ArrayList;
import java.util.List;

public class WinnersAdapter extends RecyclerView.Adapter<WinnersViewHolder> {

    List<WinnersItem> winnersItems = new ArrayList<>(0);

    @NonNull
    @Override
    public WinnersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_winners_rv, parent, false);
        WinnersViewHolder holder = new WinnersViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WinnersViewHolder holder, int position) {
        WinnersItem winnersItem = winnersItems.get(position);
        holder.populate(winnersItem);
    }

    @Override
    public int getItemCount() {
        return winnersItems.size();
    }
}
