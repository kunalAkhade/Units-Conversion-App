package com.example.unitsconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Science extends Fragment{

private Button pressure;
private Button force;
private Button Work;
private Button power;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_science, container, false);
        pressure=view.findViewById(R.id.pressure);
        force=view.findViewById(R.id.force);
        Work=view.findViewById(R.id.work);
        power=view.findViewById(R.id.power);
        pressure.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment fragment=new Pressure();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.ScienceFragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });
        force.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment fragment=new Force();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.ScienceFragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });
        Work.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment fragment=new Work();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.ScienceFragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });
        power.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment fragment=new Power();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.ScienceFragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });
        return view;
    }
}