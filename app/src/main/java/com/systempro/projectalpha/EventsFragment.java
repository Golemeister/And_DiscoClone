package com.systempro.projectalpha;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EventsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ScrollView svRoot = (ScrollView) inflater.inflate(R.layout.fragment_events, container, false);
        LinearLayout llEventList = (LinearLayout) svRoot.findViewById(R.id.llEvents);

        llEventList.addView(addEvent("test","Nikola Spava","16.12.2017","Saturday")); // Unnecessary



        RelativeLayout[] event1 = addEventsForDay("12,12,12", "pon");
        for(RelativeLayout r1: event1){llEventList.addView(r1);} //foreach u javi
        RelativeLayout[] event2 = addEventsForDay("12,12,12", "pon");
        RelativeLayout[] event3 = addEventsForDay("13,12,12", "pon");
        RelativeLayout[] event4 = addEventsForDay("14,12,12", "pon");
        RelativeLayout[] event5 = addEventsForDay("15,12,12", "pon");

        return svRoot;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private RelativeLayout addEvent(String title, String description, String date, String dow){

        RelativeLayout rlEvent= new RelativeLayout(getContext());
        LinearLayout.LayoutParams lllp= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpToPx(200));
        rlEvent.setBackgroundColor(Color.GRAY);
        rlEvent.setLayoutParams(lllp);

        LinearLayout llDate=new LinearLayout(getContext());
        llDate.setId(R.id.llDate);
        RelativeLayout.LayoutParams rllp= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpToPx(30));
        llDate.setBackgroundColor(Color.BLACK);
        llDate.setLayoutParams(rllp);

        TextView tvDayOfTheWeek = new TextView(getContext());
        tvDayOfTheWeek.setText(dow);
        lllp= new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        lllp.weight=1;

        TextView tvDate=new TextView(getContext());
        tvDate.setText(date);
        tvDate.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        tvDayOfTheWeek.setLayoutParams(lllp);
        tvDate.setLayoutParams(lllp);

        llDate.addView(tvDayOfTheWeek);
        llDate.addView(tvDate);
        rlEvent.addView(llDate);

        ImageView ivEvent= new ImageView(getContext());
        ivEvent.setId(R.id.ivEvent);
        rllp = new RelativeLayout.LayoutParams(dpToPx(150), dpToPx(150));
        rllp.addRule(RelativeLayout.RIGHT_OF,R.id.ivEvent);
        rllp.addRule(RelativeLayout.BELOW,R.id.llDate);
        rllp.addRule(RelativeLayout.ALIGN_PARENT_START);
        rllp.setMargins(dpToPx(8),dpToPx(8),dpToPx(8),dpToPx(8));
        ivEvent.setLayoutParams(rllp);
        ivEvent.setBackgroundColor(Color.RED);
        rlEvent.addView(ivEvent);

        TextView tvEventTitle= new TextView(getContext());
        tvEventTitle.setId(R.id.tvEventTitle);
        tvEventTitle.setText(title);
        tvEventTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        rllp= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rllp.addRule(RelativeLayout.RIGHT_OF,R.id.ivEvent);
        rllp.addRule(RelativeLayout.ALIGN_PARENT_END);
        rllp.addRule(RelativeLayout.BELOW,R.id.llDate);
        rllp.setMargins(dpToPx(0),dpToPx(5),dpToPx(0),dpToPx(0));
        tvEventTitle.setLayoutParams(rllp);
        rlEvent.addView(tvEventTitle);

        TextView tvEventDescription = new TextView(getContext());
        tvEventDescription.setId(R.id.tvEventDescription);
        tvEventDescription.setText(description);
        tvEventDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        rllp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        rllp.addRule(RelativeLayout.RIGHT_OF,R.id.ivEvent);
        rllp.addRule(RelativeLayout.ALIGN_PARENT_END);
        rllp.addRule(RelativeLayout.BELOW,R.id.tvEventTitle);
        rllp.setMargins(dpToPx(8),0,dpToPx(8),dpToPx(8));
        tvEventDescription.setLayoutParams(rllp);
        rlEvent.addView(tvEventDescription);

        Button btnTables = new Button(getContext());
        btnTables.setId(R.id.btnTables);
        btnTables.setText("Tables");
        btnTables.setAllCaps(true);
        btnTables.setBackgroundResource(R.drawable.background_border);
        rllp = new RelativeLayout.LayoutParams(dpToPx(80),ViewGroup.LayoutParams.WRAP_CONTENT);
        rllp.addRule(RelativeLayout.RIGHT_OF,R.id.ivEvent);
        //rllp.addRule(RelativeLayout.BELOW,R.id.tvEventDescription);//
        rllp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rllp.setMargins(0,0,dpToPx(12),dpToPx(12));
        btnTables.setLayoutParams(rllp);
        rlEvent.addView(btnTables);

        Button btnGuest = new Button(getContext());
        btnGuest.setText("GuestList");
        btnGuest.setId(R.id.btnGuest);
        btnGuest.setBackgroundResource(R.drawable.background_border);
        rllp = new RelativeLayout.LayoutParams(dpToPx(80),ViewGroup.LayoutParams.WRAP_CONTENT);
        rllp.addRule(RelativeLayout.RIGHT_OF,R.id.btnTables);
        //rllp.addRule(RelativeLayout.BELOW,R.id.tvEventDescription);
        rllp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rllp.setMargins(0,0,dpToPx(12),dpToPx(12));
        btnGuest.setLayoutParams(rllp);
        rlEvent.addView(btnGuest);

        Button btnTickets = new Button(getContext());
        btnTickets.setText("Tickets");
        btnTickets.setBackgroundResource(R.drawable.background_border);
        rllp = new RelativeLayout.LayoutParams(dpToPx(80),ViewGroup.LayoutParams.WRAP_CONTENT);
        rllp.addRule(RelativeLayout.RIGHT_OF,R.id.btnGuest);
        //rllp.addRule(RelativeLayout.BELOW,R.id.tvEventDescription);
        rllp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        rllp.setMargins(0,0,dpToPx(12),dpToPx(12));
        btnTickets.setLayoutParams(rllp);
        rlEvent.addView(btnTickets);
        return rlEvent;

    }

    private RelativeLayout[] addEventsForDay(String date, String dow) {

        LinearLayout llDate=new LinearLayout(getContext());
        llDate.setId(R.id.llDate);
        RelativeLayout.LayoutParams rllp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpToPx(30));
        llDate.setBackgroundColor(Color.BLACK);
        llDate.setLayoutParams(rllp);

        TextView tvDayOfTheWeek = new TextView(getContext());
        tvDayOfTheWeek.setText(dow);
        lllp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        lllp.weight = 1;

        TextView tvDate = new TextView(getContext());
        tvDate.setText(date);
        tvDate.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        tvDayOfTheWeek.setLayoutParams(lllp);
        tvDate.setLayoutParams(lllp);

        llDate.addView(tvDayOfTheWeek);
        llDate.addView(tvDate);

        // ^ Check the above code.

        RelativeLayout[] eventsToday = new RelativeLayout[5];

        eventsToday[0] = addEvent("test1", "Please");
        eventsToday[1] = addEvent("test1", "Please");
        eventsToday[2] = addEvent("test1", "Please");
        eventsToday[3] = addEvent("test1", "Please");
        eventsToday[4] = addEvent("test1", "Please");
        eventsToday[5] = addEvent("test1", "Please");


        for(int i = 0; i < 5; i++){

        }

        return eventsToday;
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}