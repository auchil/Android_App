package com.example.admin.practice;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddDevice extends Fragment  {

    Button addButton;
    View view;
    private EditText name, frame, motor, flight_cont, esc, fpv, vtx, battery;



    public AddDevice() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_add_dev,container,false);
        addButton = (Button)view.findViewById(R.id.button);

        name = (EditText)view.findViewById(R.id.editText8);
        frame=(EditText)view.findViewById(R.id.editText);
        motor=(EditText)view.findViewById(R.id.editText3);
        flight_cont=(EditText)view.findViewById(R.id.editText2);
        esc=(EditText)view.findViewById(R.id.editText4);
        fpv=(EditText)view.findViewById(R.id.editText6);
        vtx=(EditText)view.findViewById(R.id.editText7);
        battery=(EditText)view.findViewById(R.id.editText5);






        addButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(getActivity());

                String s_name =name.getText().toString();
                String s_frame =frame.getText().toString();
                String s_motor =motor.getText().toString();
                String s_flight_cont =flight_cont.getText().toString();
                String s_esc =esc.getText().toString();
                String s_fpv =fpv.getText().toString();
                String s_vtx =vtx.getText().toString();
                String s_battery =battery.getText().toString();

                boolean isInserted = db.insertData(s_name,s_frame,s_flight_cont,s_motor,s_esc,s_battery,s_fpv,s_vtx);
                    if(isInserted == true){
                    Toast.makeText(getActivity(), "Device Added", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(),MainActivity.class);
                    startActivity(i);}else{
                        Toast.makeText(getActivity(), "Device Not Added", Toast.LENGTH_SHORT).show();
                    }




            }
        });
        return view;
    }











}

