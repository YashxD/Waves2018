package org.bits_waves.waves2018.Fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.bits_waves.waves2018.AccessJSON;
import org.bits_waves.waves2018.Adapters.EventsCardFragmentPagerAdapter;
import org.bits_waves.waves2018.Adapters.EventsCardPagerAdapter;
import org.bits_waves.waves2018.ListItems.EventsCardItem;
import org.bits_waves.waves2018.R;
import org.bits_waves.waves2018.ShadowTransformer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class EventsFragment extends Fragment {

    private ViewPager mViewPager;
    static UpdateEvents update;
    Context context;
    static EventsFragment eventsFragment;

    //private boolean mShowingFragments = false;

    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onStart() {
        super.onStart();
        context = getContext();
        EventsCardPagerAdapter mCardAdapter = new EventsCardPagerAdapter();
        mCardAdapter.addCardItem(new EventsCardItem(getResources().getString(R.string.day_0),context));
        mCardAdapter.addCardItem(new EventsCardItem(getResources().getString(R.string.day_1),context));
        mCardAdapter.addCardItem(new EventsCardItem(getResources().getString(R.string.day_2),context));
        mCardAdapter.addCardItem(new EventsCardItem(getResources().getString(R.string.day_3),context));
        EventsCardFragmentPagerAdapter mFragmentCardAdapter = new EventsCardFragmentPagerAdapter(getActivity().getSupportFragmentManager(),
                dpToPixels(2, getContext()));

        ShadowTransformer mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        //ShadowTransformer mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events,container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager_events_fragment);
        TextView textView = (TextView) view.findViewById(R.id.textview_events);
        AccessJSON accessJSON = new AccessJSON();
        //JSONArray jsonArray = accessJSON.readEventJSONArray(getContext());
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            update = (UpdateEvents) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in Events fragments communication");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface CardAdapter {

        int MAX_ELEVATION_FACTOR = 8;

        float getBaseElevation();

        CardView getCardViewAt(int position);

        int getCount();
    }

    public interface UpdateEvents {
        void updateEvents(int i);
    }

    public void updateEvents(int i) {
        //update = (UpdateEvents) getActivity();
        update.updateEvents(i);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            update = (UpdateEvents) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in data transfer");
        }
    }

    public void setEventsFragment(EventsFragment ef){
        eventsFragment = ef;
    }

    public EventsFragment getEventsFragment() {
        return eventsFragment;
    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}
