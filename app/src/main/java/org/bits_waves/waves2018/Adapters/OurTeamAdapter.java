package org.bits_waves.waves2018.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
    Context context;

    public OurTeamAdapter(List<OurTeamItem> ourTeamItems, Context context) {
        this.ourTeamItems = ourTeamItems;
        this.context = context;
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
        final OurTeamItem ourTeamItem1 = ourTeamItems.get(position*2);
        final OurTeamItem ourTeamItem2 = ourTeamItems.get(position*2+1);
        holder.populate(ourTeamItem1,ourTeamItem2);
        holder.info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse(ourTeamItem1.getInfo()));
                context.startActivity(intent);
            }
        });
        holder.info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse(ourTeamItem2.getInfo()));
                context.startActivity(intent);
            }
        });
        holder.mail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL,ourTeamItem1.getMail());
                context.startActivity(intent);
            }
        });
        holder.mail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL,ourTeamItem2.getMail());
                context.startActivity(intent);
            }
        });
        holder.call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("tel:" + ourTeamItem1.getCall()));
                context.startActivity(intent);
            }
        });
        holder.call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("tel:" + ourTeamItem2.getCall()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ourTeamItems.size()/2;
    }
}
