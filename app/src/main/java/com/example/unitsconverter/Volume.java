package com.example.unitsconverter;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class Volume extends Fragment{
    private ListView volume_list1;
    private AutoCompleteTextView volume_autoText;
    private Button volume_convert;
    private EditText volume_editText;
    private ListView volume_list2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_volume, container, false);
        volume_list1=view.findViewById(R.id.volume_list1);
        volume_autoText=view.findViewById(R.id.volume_autoText);
        volume_convert=view.findViewById(R.id.volume_convert);
        volume_editText=view.findViewById(R.id.volume_editText);
        volume_list2=view.findViewById(R.id.volume_list2);

        String []area_units=new String[]{"cm^3","m^3","mm^3","ft^3","km^3"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
        volume_autoText.setAdapter(area_arrayAdapter);

        double area_list[] = new double[5];


        String area_tutorials[]
                = new String[]{"       cm^3:", "       m^3:",
                "       mm^3:", "       ft^3:",
                "       km^3:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        volume_list1.setAdapter(area_array);
        volume_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(volume_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(volume_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = volume_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = volume_autoText.getEditableText().toString();

                    switch (unit) {
                        case "cm^3":

                            area_list[0] = (double) finalValue; // cm
                            area_list[1] = (double) finalValue / 1e+6; //m
                            area_list[2] = (double) finalValue * 1000.0;  //mm
                            area_list[3] = (double) finalValue / 28317.0; //ft
                            area_list[4] = (double) finalValue / 1e+15; //km
                            break;
                        case "m^3":
                            area_list[0] = (double) finalValue * 1e+6;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) finalValue * 1e+9;
                            area_list[3] = (double) finalValue * 35.315;
                            area_list[4] = (double) finalValue / 1e+9;
                            break;
                        case "mm^3":
                            area_list[0] = (double) finalValue / 1000.0;
                            area_list[1] = (double) finalValue / 1e+9;
                            area_list[2] = (double) finalValue;
                            area_list[3] = (double) finalValue / 2.832e+7;
                            area_list[4] = (double) finalValue / 1e+18;
                            break;
                        case "ft^3":
                            area_list[0] = (double) finalValue * 28317.0;
                            area_list[1] = (double) finalValue / 35.315;
                            area_list[2] = (double) finalValue * 2.832e+7;
                            area_list[3] = (double) finalValue;
                            area_list[4] = (double) finalValue / 3.531e+10;
                            break;
                        case "km^3":
                            area_list[0] = (double) finalValue * 1e+15;
                            area_list[1] = (double) finalValue * 1e+9;
                            area_list[2] = (double) finalValue * 1e+9;
                            area_list[3] = (double) finalValue * 3.531e+10;
                            area_list[4] = (double) finalValue;
                            break;
                        default:
                            Toast.makeText(getActivity(), "Unit Missing", Toast.LENGTH_SHORT).show();
                            break;

                    }


                }


                ArrayList<String> area_arrayList = new ArrayList<String>();
                for (double s : area_list) {
                    area_arrayList.add(String.valueOf(s));
                }

                ArrayAdapter<String> area_arrayAdapter;
                area_arrayAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.support_simple_spinner_dropdown_item,
                        area_arrayList);
                volume_list2.setAdapter(area_arrayAdapter);
            }

        });



        view.setBackgroundColor(Color.WHITE);
        return view;
    }
}