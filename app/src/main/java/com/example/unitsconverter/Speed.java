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


public class Speed extends Fragment{

    private ListView speed_list1;
    private AutoCompleteTextView speed_autoText;
    private Button speed_convert;
    private EditText speed_editText;
    private ListView speed_list2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_speed, container, false);

        speed_list1=view.findViewById(R.id.speed_list1);
        speed_autoText=view.findViewById(R.id.speed_autoText);
        speed_convert=view.findViewById(R.id.speed_convert);
        speed_editText=view.findViewById(R.id.speed_editText);
        speed_list2=view.findViewById(R.id.speed_list2);
        String []area_units=new String[]{"cm/s","m/s","km/hr","ft/s"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
        speed_autoText.setAdapter(area_arrayAdapter);
        double area_list[] = new double[4];
        String area_tutorials[]
                = new String[]{"       cm/s:", "       m/s:",
                "       km/hr:", "       ft/s:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        speed_list1.setAdapter(area_array);
        speed_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(speed_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(speed_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = speed_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = speed_autoText.getEditableText().toString();

                    switch (unit) {
                        case "cm/s":

                            area_list[0] = (double) finalValue; // C
                            area_list[1] = (double) finalValue / 100.0 ; // F
                            area_list[2] = (double) finalValue / 27.778;  // K
                            area_list[3] = (double) finalValue / 30.48; // R
                            // Re
                            break;
                        case "m/s":
                            area_list[0] = (double) finalValue * 100.0;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) finalValue * 3.6;
                            area_list[3] = (double) finalValue * 3.281;

                            break;
                        case "km/hr":
                            area_list[0] = (double) finalValue * 27.778;
                            area_list[1] = (double) finalValue / 3.6;
                            area_list[2] = (double) finalValue;
                            area_list[3] = (double) finalValue / 1.097;

                            break;
                        case "ft/s":
                            area_list[0] = (double) finalValue * 30.48;
                            area_list[1] = (double) finalValue / 3.281;
                            area_list[2] = (double) finalValue * 1.097;
                            area_list[3] = (double) finalValue;

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
                speed_list2.setAdapter(area_arrayAdapter);
            }

        });



        view.setBackgroundColor(Color.WHITE);
        return view;
    }
}