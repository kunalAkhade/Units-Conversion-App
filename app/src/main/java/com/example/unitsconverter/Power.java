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


public class Power extends Fragment{

    private ListView power_list1;
    private AutoCompleteTextView power_autoText;
    private Button power_convert;
    private EditText power_editText;
    private ListView power_list2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_power, container, false);

        power_list1=view.findViewById(R.id.power_list1);
        power_autoText=view.findViewById(R.id.power_autoText);
        power_convert=view.findViewById(R.id.power_convert);
        power_editText=view.findViewById(R.id.power_editText);
        power_list2=view.findViewById(R.id.power_list2);
        String []area_units=new String[]{"W","kW","HP"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
        power_autoText.setAdapter(area_arrayAdapter);
        double area_list[] = new double[3];
        String area_tutorials[]
                = new String[]{"       W:", "       kW:",
                "       HP:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        power_list1.setAdapter(area_array);
        power_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(power_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(power_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = power_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = power_autoText.getEditableText().toString();

                    switch (unit) {
                        case "W":

                            area_list[0] = (double) finalValue; // C
                            area_list[1] = (double) finalValue / 1000.0 ; // F
                            area_list[2] = (double) finalValue / 746.0;  // K

                            // Re
                            break;
                        case "kW":
                            area_list[0] = (double) finalValue * 1000.0;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) finalValue * 1.341;


                            break;
                        case "HP":
                            area_list[0] = (double) finalValue * 746.0;
                            area_list[1] = (double) finalValue / 1.341;
                            area_list[2] = (double) finalValue;


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
                power_list2.setAdapter(area_arrayAdapter);
            }

        });



        view.setBackgroundColor(Color.WHITE);




        return  view;
    }
}