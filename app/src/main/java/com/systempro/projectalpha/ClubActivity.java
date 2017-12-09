package com.systempro.projectalpha;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class ClubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id",1);

        ImageView ivCover = (ImageView)findViewById(R.id.ivCover);
        if(id==1){
            ivCover.setImageResource(R.drawable.klub1);
        }else if(id==2){
            ivCover.setImageResource(R.drawable.klub2);
        }else{
            ivCover.setImageResource(R.drawable.klub3);
        }

        LinearLayout llRoot=(LinearLayout)findViewById(R.id.rlRoot);
        RelativeLayout rlEvent1 = addEvent("Prvi event","Hesto","4.11.2017","");
        RelativeLayout rlEvent2 = addEvent("Jos nesto","MARIJAN","12.3.2018","");
        llRoot.addView(rlEvent1);
        llRoot.addView(rlEvent2);

    }
    private RelativeLayout addEvent(String title,String description,String date,String dow){







        RelativeLayout rlEvent= new RelativeLayout(this);
        LinearLayout.LayoutParams lllp= new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpToPx(200));
        rlEvent.setBackgroundColor(Color.GRAY);
        rlEvent.setLayoutParams(lllp);

        LinearLayout llDate=new LinearLayout(this);
        llDate.setId(R.id.llDate);
        RelativeLayout.LayoutParams rllp= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,dpToPx(30));
        llDate.setBackgroundColor(Color.BLACK);
        llDate.setLayoutParams(rllp);

        TextView tvDayOfTheWeek = new TextView(this);
        tvDayOfTheWeek.setText(dow);
        lllp= new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        lllp.weight=1;

        TextView tvDate=new TextView(this);
        tvDate.setText(date);
        tvDate.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        tvDayOfTheWeek.setLayoutParams(lllp);
        tvDate.setLayoutParams(lllp);

        llDate.addView(tvDayOfTheWeek);
        llDate.addView(tvDate);
        rlEvent.addView(llDate);

        ImageView ivEvent= new ImageView(this);
        ivEvent.setId(R.id.ivEvent);
        rllp = new RelativeLayout.LayoutParams(dpToPx(150), dpToPx(150));
        rllp.addRule(RelativeLayout.RIGHT_OF,R.id.ivEvent);
        rllp.addRule(RelativeLayout.BELOW,R.id.llDate);
        rllp.addRule(RelativeLayout.ALIGN_PARENT_START);
        rllp.setMargins(dpToPx(8),dpToPx(8),dpToPx(8),dpToPx(8));
        ivEvent.setLayoutParams(rllp);
        ivEvent.setBackgroundColor(Color.RED);
        rlEvent.addView(ivEvent);

        TextView tvEventTitle= new TextView(this);
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

        TextView tvEventDescription = new TextView(this);
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

        Button btnTables = new Button(this);
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

        Button btnGuest = new Button(this);
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

        Button btnTickets = new Button(this);
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
    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
