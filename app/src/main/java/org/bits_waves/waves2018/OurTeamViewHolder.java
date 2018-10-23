package org.bits_waves.waves2018;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.bits_waves.waves2018.ListItems.OurTeamItem;

public class OurTeamViewHolder extends RecyclerView.ViewHolder{

    private ImageView imageView1, imageView2;
    private TextView name1, name2;
    private TextView position1, position2;
    public ImageButton info1, info2;
    public ImageButton call1, call2;
    public ImageButton mail1, mail2;

    public OurTeamViewHolder(View itemView) {
        super(itemView);
        imageView1 = (ImageView) itemView.findViewById(R.id.ourteam_rv_item_imageView);
        imageView2 = (ImageView) itemView.findViewById(R.id.ourteam_rv_item_imageView2);
        name1 = (TextView) itemView.findViewById(R.id.ourteam_rv_item_name);
        name2 = (TextView) itemView.findViewById(R.id.ourteam_rv_item_name2);
        position1 = (TextView) itemView.findViewById(R.id.ourteam_rv_item_position);
        position2 = (TextView) itemView.findViewById(R.id.ourteam_rv_item_position2);
        info1 = (ImageButton) itemView.findViewById(R.id.ourteam_rv_item_info);
        info2 = (ImageButton) itemView.findViewById(R.id.ourteam_rv_item_info2);
        call1 = (ImageButton) itemView.findViewById(R.id.ourteam_rv_item_call);
        call2 = (ImageButton) itemView.findViewById(R.id.ourteam_rv_item_call2);
        mail1 = (ImageButton) itemView.findViewById(R.id.ourteam_rv_item_mail);
        mail2 = (ImageButton) itemView.findViewById(R.id.ourteam_rv_item_mail2);
    }

    public void populate(OurTeamItem ourTeamItem1, OurTeamItem ourTeamItem2) {
        imageView1.setImageResource(ourTeamItem1.getImgResInt());
        imageView2.setImageResource(ourTeamItem2.getImgResInt());
        name1.setText(ourTeamItem1.getName());
        name2.setText(ourTeamItem2.getName());
        position1.setText(ourTeamItem1.getPosition());
        position2.setText(ourTeamItem2.getPosition());
        //Set links for image buttons
    }
}
