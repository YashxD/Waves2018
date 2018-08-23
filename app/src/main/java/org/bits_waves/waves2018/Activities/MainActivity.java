package org.bits_waves.waves2018.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import org.bits_waves.waves2018.Fragments.EventsEventsFragment;
import org.bits_waves.waves2018.Fragments.EventsFragment;
import org.bits_waves.waves2018.Fragments.HomeFragment;
import org.bits_waves.waves2018.R;

public class MainActivity extends AppCompatActivity implements EventsFragment.UpdateEvents{

    Boolean twoFragments = false;
    FrameLayout secondaryFrameLayout;   //Used for Events Tab
    Fragment selectedFragment = null;
    Fragment selectedSecondaryFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav);
        secondaryFrameLayout = (FrameLayout) findViewById(R.id.main_activity_secondary_frame_layout);

        bottomNav.setSelectedItemId(R.id.bottom_nav_home);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.bottom_nav_events:
                        selectedSecondaryFragment = EventsEventsFragment.newInstance();
                        selectedFragment = EventsFragment.newInstance();
                        twoFragments = true;
                        break;
                    case R.id.bottom_nav_home:
                        selectedFragment = HomeFragment.newInstance();
                        twoFragments = false;
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
        transaction.replace(R.id.main_activity_frame_layout, HomeFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void updateEvents(int i) {
        String tag = "android:switcher:" + R.id.main_activity_secondary_frame_layout + ":" + 1;
        EventsEventsFragment ef = (EventsEventsFragment) getSupportFragmentManager().findFragmentById(R.id.main_activity_secondary_frame_layout);
        ef.updateEventsSecondary(i);
    }
}
