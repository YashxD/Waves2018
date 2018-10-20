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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_team);

        recyclerView = (RecyclerView) findViewById(R.id.our_team_rv);
        OurTeamAdapter ourTeamAdapter = new OurTeamAdapter(ourTeam);
        recyclerView.setAdapter(ourTeamAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }
}
