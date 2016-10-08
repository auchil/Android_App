package com.example.admin.practice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Admin on 27-Sep-16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<Device> arrayList = new ArrayList<>();
    Context ctx;
    RecyclerAdapter(ArrayList<Device> arrayList, Context ctx){
        this.arrayList = arrayList;
        this.ctx = ctx;
    }





    @Override
    public RecyclerViewHolder onCreateViewHolder (ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view,ctx,arrayList);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Device device = arrayList.get(position);
        holder.name.setText(device.getName());
        holder.frame.setText(device.getFrame());
        holder.flight_cont.setText(device.getFlight_cont());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements RecyclerView.OnClickListener{
       TextView frame , flight_cont, name;
       ArrayList<Device> arrayList = new ArrayList<Device>();
       Context ctx;

        public RecyclerViewHolder(View view, Context ctx, ArrayList<Device> arrayList){
            super(view);
            this.arrayList = arrayList;
            this.ctx = ctx;
            view.setOnClickListener(this);
            name = (TextView)view.findViewById(R.id.rdevicename);
            frame = (TextView)view.findViewById(R.id.rframe);
            flight_cont = (TextView)view.findViewById(R.id.rflight_cont);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Device device = this.arrayList.get(position);
            Intent intent = new Intent(this.ctx,Ready.class);
            intent.putExtra("name",device.getName());
            intent.putExtra("frame",device.getFrame());
            intent.putExtra("flight_cont",device.getFlight_cont());
            intent.putExtra("motor",device.getMotor());
            intent.putExtra("esc",device.getEsc());
            intent.putExtra("battery",device.getBattery());
            intent.putExtra("fpv",device.getFpv());
            intent.putExtra("vtx",device.getVtx());
            this.ctx.startActivity(intent);

        }
    }
}
