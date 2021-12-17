package com.example.unitsconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Living extends Fragment{
private Button currency;
private Button temp;
private Button time;
private Button speed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_living, container, false);
        currency=view.findViewById(R.id.pressure);
        temp=view.findViewById(R.id.force);
        time=view.findViewById(R.id.work);
        speed=view.findViewById(R.id.power);

        currency.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment fragment=new Currency();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.ScienceFragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        temp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment fragment=new Temp();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.ScienceFragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        time.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment fragment=new Time();

                FragmentManager fragmentManager=getParentFragmentManager();


                FragmentTransaction transaction =fragmentManager.beginTransaction();
                transaction.replace(R.id.ScienceFragment, fragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        speed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Fragment fragment=new Speed();

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