package com.example.admin.practice;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MyDevice extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    public LinearLayoutManager layoutManager;
    public TextView emptyView;
    public ArrayList<Device> arrayList = new ArrayList<>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_device);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        emptyView = (TextView)findViewById(R.id.empty_view);
        layoutManager = new LinearLayoutManager(this);
        DatabaseHelper db = new DatabaseHelper(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();
        Cursor cursor = db.getInformation(sqLiteDatabase);
        cursor.moveToFirst();
        if(cursor != null && cursor.getCount()>0){
            do{
                Device device = new Device(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7));
                arrayList.add(device);
            }
            while(cursor.moveToNext());
            db.close();
            adapter = new RecyclerAdapter(arrayList,this);
            recyclerView.setAdapter(adapter);}
        else{
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);}



    }


}
