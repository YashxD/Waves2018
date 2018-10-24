package org.bits_waves.waves2018.Activities;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.bits_waves.waves2018.Fragments.EventsEventsFragment;
import org.bits_waves.waves2018.Fragments.EventsFragment;
import org.bits_waves.waves2018.Fragments.EventsFragmentSimple;
import org.bits_waves.waves2018.Fragments.HomeFragmentOld;
import org.bits_waves.waves2018.Fragments.SpotOnFragment;
import org.bits_waves.waves2018.Fragments.WinnersFragment;
import org.bits_waves.waves2018.R;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements EventsFragment.UpdateEvents{

    Boolean twoFragments = false;
    FrameLayout secondaryFrameLayout;   //Used for Events Tab
    Fragment selectedFragment = null;
    Fragment selectedSecondaryFragment = null;

    BottomNavigationView bottomNav;
    ImageView appbarImageview;
    TextView appbarTextView;
    ImageButton csrImageButton, ourTeamImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav);
        appbarImageview = (ImageView) findViewById(R.id.main_activity_appbar_imageview);
        appbarTextView = (TextView) findViewById(R.id.main_activity_appbar_textview);
        secondaryFrameLayout = (FrameLayout) findViewById(R.id.main_activity_secondary_frame_layout);
        csrImageButton = (ImageButton) findViewById(R.id.main_activity_appbar_csr);
        ourTeamImageButton = (ImageButton) findViewById(R.id.main_activity_appbar_ourteam);

        ourTeamImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OurTeamActivity.class);
                startActivity(intent);
            }
        });

        bottomNav.setSelectedItemId(R.id.bottom_nav_home);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.bottom_nav_events:
                        /*selectedSecondaryFragment = EventsEventsFragment.newInstance();
                        selectedFragment = EventsFragment.newInstance();
                        twoFragments = true;*/
                        selectedFragment = EventsFragmentSimple.newInstance();
                        twoFragments = false;
                        appbarImageview.setVisibility(View.GONE);
                        appbarTextView.setVisibility(View.VISIBLE);
                        appbarTextView.setText("Events");
                        break;
                    case R.id.bottom_nav_home:
                        selectedFragment = HomeFragmentOld.newInstance();
                        twoFragments = false;
                        appbarImageview.setVisibility(View.VISIBLE);
                        appbarTextView.setVisibility(View.GONE);
                        break;
                    case R.id.bottom_nav_spoton:
                        selectedFragment = SpotOnFragment.newInstance();
                        twoFragments = false;
                        appbarImageview.setVisibility(View.GONE);
                        appbarTextView.setVisibility(View.VISIBLE);
                        appbarTextView.setText("Spot On");
                        break;
                    case R.id.bottomnav_winners:
                        selectedFragment = WinnersFragment.newInstance();
                        twoFragments = false;
                        appbarImageview.setVisibility(View.GONE);
                        appbarTextView.setVisibility(View.VISIBLE);
                        appbarTextView.setText("Winners");
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if(twoFragments) {
                    secondaryFrameLayout.setVisibility(View.VISIBLE);
                    transaction.replace(R.id.main_activity_frame_layout, selectedFragment);
                    transaction.replace(R.id.main_activity_secondary_frame_layout, selectedSecondaryFragment);
                }
                else {
                    secondaryFrameLayout.setVisibility(View.GONE);
                    transaction.replace(R.id.main_activity_frame_layout, selectedFragment);
                }
                transaction.commit();
                return true;
            }
        });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_activity_frame_layout, HomeFragmentOld.newInstance());
        transaction.commit();
    }

    @Override
    public void updateEvents(int i) {
        String tag = "android:switcher:" + R.id.main_activity_secondary_frame_layout + ":" + 1;
        EventsEventsFragment ef = (EventsEventsFragment) getSupportFragmentManager().findFragmentById(R.id.main_activity_secondary_frame_layout);
        ef.updateEventsSecondary(i);
    }
}
