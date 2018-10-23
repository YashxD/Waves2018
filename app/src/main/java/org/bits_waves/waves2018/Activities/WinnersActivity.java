package org.bits_waves.waves2018.Activities;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.bits_waves.waves2018.Adapters.WinnersAdapter;
import org.bits_waves.waves2018.ListItems.WinnersItem;
import org.bits_waves.waves2018.R;

import java.util.ArrayList;
import java.util.List;

public class WinnersActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<WinnersItem> winnersItems = new ArrayList<>(0);

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference myRef = database.getReference().child("winners");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winners);
        recyclerView = (RecyclerView) findViewById(R.id.activity_winners_rv);

        final WinnersAdapter winnersAdapter = new WinnersAdapter(winnersItems);
        recyclerView.setAdapter(winnersAdapter);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                WinnersItem winnersItem = dataSnapshot.getValue(WinnersItem.class);
                Log.v("Winners data retrieval", "onChildAdded " + winnersItem.getEventName());
                //Add the item to the starting of the data list.
                winnersItems.add(0,winnersItem);
                winnersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                WinnersItem winnersItem = dataSnapshot.getValue(WinnersItem.class);
                Log.v("Winners data retrieval", "onChildChanged " + winnersItem.getEventName());
                int winnersItemIndex = winnersItems.indexOf(winnersItem);
                if(winnersItemIndex > -1) {
                    winnersItems.set(winnersItemIndex, winnersItem);
                    winnersAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                WinnersItem winnersItem = dataSnapshot.getValue(WinnersItem.class);
                Log.v("Winners data retrieval", "onChildRemoved " + winnersItem.getEventName());
                int winnersItemIndex = winnersItems.indexOf(winnersItem);
                winnersItems.remove(winnersItemIndex);
                winnersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                WinnersItem winnersItem = dataSnapshot.getValue(WinnersItem.class);
                Log.v("Winners data retrieval", "onChildMoved " + winnersItem.getEventName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("Winners data retrieval", "Problem here!");
                Toast.makeText(getApplicationContext(),"Error while loading Winners. Please try again later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
