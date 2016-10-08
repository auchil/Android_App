package com.example.admin.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ready extends AppCompatActivity {

    private TextView name,frame,flight_cont,motor,esc,battery,fpv,vtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready);
        name= (TextView)findViewById(R.id.dname);
        frame= (TextView)findViewById(R.id.dframe);
        flight_cont= (TextView)findViewById(R.id.dflight_cont);
        motor= (TextView)findViewById(R.id.dmotor);
        esc= (TextView)findViewById(R.id.desc);
        battery= (TextView)findViewById(R.id.dbattery);
        fpv= (TextView)findViewById(R.id.dfpv);
        vtx= (TextView)findViewById(R.id.dvtx);

        name.setText("Name: " +getIntent().getStringExtra("name"));
        frame.setText("Frame: " +getIntent().getStringExtra("frame"));
        flight_cont.setText("Flight Controller: " +getIntent().getStringExtra("flight_cont"));
        motor.setText("Motor: " +getIntent().getStringExtra("motor"));
        esc.setText("ESC: " +getIntent().getStringExtra("esc"));
        battery.setText("Battery: " +getIntent().getStringExtra("battery"));
        fpv.setText("FPV: " +getIntent().getStringExtra("fpv"));
        vtx.setText("Vtx: " +getIntent().getStringExtra("vtx"));

    }

    public void ready(View v){
        Intent intent = new Intent(Ready.this,Set.class);
        startActivity(intent);
    }
}
