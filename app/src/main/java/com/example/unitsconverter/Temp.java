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


public class Temp extends Fragment{

    private ListView temp_list1;
    private AutoCompleteTextView temp_autoText;
    private Button temp_convert;
    private EditText temp_editText;
    private ListView temp_list2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_temp, container, false);

        temp_list1=view.findViewById(R.id.temp_list1);
        temp_autoText=view.findViewById(R.id.temp_autoText);
        temp_convert=view.findViewById(R.id.temp_convert);
        temp_editText=view.findViewById(R.id.temp_editText);
        temp_list2=view.findViewById(R.id.temp_list2);
        String []area_units=new String[]{"C","F","K","R"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
        temp_autoText.setAdapter(area_arrayAdapter);
        double area_list[] = new double[4];
        String area_tutorials[]
                = new String[]{"       C:", "       F:",
                "       K:", "       R:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        temp_list1.setAdapter(area_array);
        temp_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(temp_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(temp_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = temp_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = temp_autoText.getEditableText().toString();

                    switch (unit) {
                        case "C":

                            area_list[0] = (double) finalValue; // C
                            area_list[1] = (double) (finalValue * 9/5)+32; // F
                            area_list[2] = (double) finalValue + 273.15;  // K
                            area_list[3] = (double) (finalValue * 9/5) + 491.67; // R
                            // Re
                            break;
                        case "F":
                            area_list[0] = (double) (finalValue - 32) * 5/9;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) (finalValue - 32) * 5/9 + 273.15;
                            area_list[3] = (double) (finalValue + 459.67);

                            break;
                        case "K":
                            area_list[0] = (double) (finalValue - 273.15);
                            area_list[1] = (double) (finalValue - 273.15)*9/5 + 32;
                            area_list[2] = (double) finalValue;
                            area_list[3] = (double) finalValue * 1.8;

                            break;
                        case "R":
                            area_list[0] = (double) (finalValue - 491.67)*5/9;
                            area_list[1] = (double) (finalValue - 459.67);
                            area_list[2] = (double) finalValue * 5/9;
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
                temp_list2.setAdapter(area_arrayAdapter);
            }

        });



        view.setBackgroundColor(Color.WHITE);



        return view;
    }
}