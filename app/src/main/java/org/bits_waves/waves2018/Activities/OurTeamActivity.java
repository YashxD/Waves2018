package org.bits_waves.waves2018.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.bits_waves.waves2018.Adapters.OurTeamAdapter;
import org.bits_waves.waves2018.ListItems.OurTeamItem;
import org.bits_waves.waves2018.R;

import java.util.ArrayList;
import java.util.List;

public class OurTeamActivity extends AppCompatActivity {

    List<OurTeamItem> ourTeam = new ArrayList<>(0);
    RecyclerView recyclerView;

    private void fillData(){
        //Enter data inside ourTeam.
        ourTeam.add(new OurTeamItem("Yash Jain", "Head Developer", "https://www.linkedin.com/in/yashxd/", "+91-8130297010","yashjain.1999@gmail.com" , R.drawable.ourteam_yash));
        ourTeam.add(new OurTeamItem("Aryan Agarwal", "Developer", "https://www.linkedin.com/in/aryan-agarwal-a9524812a/", "+91-9521382950","aryanagarwal15@gmail.com" , R.drawable.ourteam_yash));
        ourTeam.add(new OurTeamItem("Sai Bharadwaj", "Designer", "www.linkedin.com/in/sai-bharadwaj-a0877614a", "+91-9491542661","sarangulasaibharadwaj@gmail.com" , R.drawable.ourteam_sai));
        ourTeam.add(new OurTeamItem("Parambir Singh", "Designer", "https://www.linkedin.com/in/parambir-singh-96042b14a/", "+91- 9769598595","parambir.1710@gmail.com" , R.drawable.ourteam_parambir));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_team);

        fillData();
        recyclerView = (RecyclerView) findViewById(R.id.our_team_rv);
        OurTeamAdapter ourTeamAdapter = new OurTeamAdapter(ourTeam, getApplicationContext());
        recyclerView.setAdapter(ourTeamAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }
}
