package org.bits_waves.waves2018.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.bits_waves.waves2018.Adapters.SpotOnAdapter;
import org.bits_waves.waves2018.ListItems.SpotOnItem;
import org.bits_waves.waves2018.R;

import java.util.ArrayList;
import java.util.List;

public class SpotOnFragment extends Fragment {

    RecyclerView recyclerView;
    List<SpotOnItem> spotOnItems = new ArrayList<>(0);

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference myRef = database.getReference().child("spotOn");

    public static SpotOnFragment newInstance(){
        SpotOnFragment fragment = new SpotOnFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_spoton, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_spoton_rv);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        final SpotOnAdapter spotOnAdapter = new SpotOnAdapter(spotOnItems);
        recyclerView.setAdapter(spotOnAdapter);
        recyclerView.setHasFixedSize(false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                SpotOnItem spotOnItem = dataSnapshot.getValue(SpotOnItem.class);
                Log.v("SpotOn data retrieval", "onChildAdded " + spotOnItem.getEventName());
                //Add the item to the starting of the data list
                spotOnItems.add(0,spotOnItem);
                spotOnAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                SpotOnItem spotOnItem = dataSnapshot.getValue(SpotOnItem.class);
                Log.v("SpotOn data retrieval", "onChildChanged " + spotOnItem.getEventName());
                int spotOnItemIndex = spotOnItems.indexOf(spotOnItem);
                if(spotOnItemIndex > -1) { //Exists in the list
                    spotOnItems.set(spotOnItemIndex,spotOnItem);
                    spotOnAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                SpotOnItem spotOnItem = dataSnapshot.getValue(SpotOnItem.class);
                Log.v("SpotOn data retrieval", "onChildRemoved " + spotOnItem.getEventName());
                int spotOnItemIndex = spotOnItems.indexOf(spotOnItem);
                spotOnItems.remove(spotOnItemIndex);
                spotOnAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                SpotOnItem spotOnItem = dataSnapshot.getValue(SpotOnItem.class);
                Log.v("SpotOn data retrieval", "onChildMoved " + spotOnItem.getEventName());
                //Not needed.
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("SpotOn data retrieval", "Problem here!");
                Toast.makeText(getContext(),"Error while loading SpotOn. Please try again later!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
