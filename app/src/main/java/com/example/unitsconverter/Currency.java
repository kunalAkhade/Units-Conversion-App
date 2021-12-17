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


public class Currency extends Fragment{

    private ListView currency_list1;
    private AutoCompleteTextView currency_autoText;
    private Button currency_convert;
    private EditText currency_editText;
    private ListView currency_list2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_currency, container, false);
        currency_list1=view.findViewById(R.id.currency_list1);
        currency_autoText=view.findViewById(R.id.currency_autoText);
        currency_convert=view.findViewById(R.id.currency_convert);
        currency_editText=view.findViewById(R.id.currency_editText);
        currency_list2=view.findViewById(R.id.currency_list2);

        view.setBackgroundColor(Color.WHITE);

        String []area_units=new String[]{"INR","USD","EURO","YEN","CAD"};
        ArrayAdapter<String> area_arrayAdapter=new ArrayAdapter<String>(
                getContext(),
                R.layout.dropdown_area,
                area_units
        );
        currency_autoText.setAdapter(area_arrayAdapter);
        double area_list[] = new double[5];
        String area_tutorials[]
                = new String[]{"       INR:", "       USD:",
                "       EURO:", "       YEN:",
                "       CAD:",
        };

        ArrayAdapter<String> area_array;
        area_array = new ArrayAdapter<String>(
                getActivity(),
                R.layout.support_simple_spinner_dropdown_item,
                area_tutorials);
        currency_list1.setAdapter(area_array);
        currency_convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(currency_editText.getText().toString())) {
                    Toast.makeText(getActivity(), "Enter The Value First", Toast.LENGTH_SHORT).show();


                }
                else if(!TextUtils.isDigitsOnly(currency_editText.getText())){
                    Toast.makeText(getActivity(), "Enter Numbers only as Input", Toast.LENGTH_SHORT).show();

                }
                else {

                    String value = currency_editText.getText().toString();
                    int finalValue = Integer.parseInt(value);
                    String unit = currency_autoText.getEditableText().toString();

                    switch (unit) {
                        case "INR":

                            area_list[0] = (double) finalValue; // INR
                            area_list[1] = (double) finalValue * 0.013; //USD
                            area_list[2] = (double) finalValue * 0.01177;  //EURO
                            area_list[3] = (double) finalValue * 1.51; // YEN
                            area_list[4] = (double) finalValue * 0.01708; // CAD
                            break;
                        case "USD":
                            area_list[0] = (double) finalValue * 75.0;
                            area_list[1] = (double) finalValue;
                            area_list[2] = (double) finalValue * 0.88;
                            area_list[3] = (double) finalValue * 113.07;
                            area_list[4] = (double) finalValue * 1.28;
                            break;
                        case "EURO":
                            area_list[0] = (double) finalValue * 84.95;
                            area_list[1] = (double) finalValue * 1.13;
                            area_list[2] = (double) finalValue;
                            area_list[3] = (double) finalValue * 128.02;
                            area_list[4] = (double) finalValue * 1.45;
                            break;
                        case "YEN":
                            area_list[0] = (double) finalValue * 0.66;
                            area_list[1] = (double) finalValue * 0.0088;
                            area_list[2] = (double) finalValue * 0.0078;
                            area_list[3] = (double) finalValue;
                            area_list[4] = (double) finalValue * 0.011;
                            break;
                        case "CAD":
                            area_list[0] = (double) finalValue * 58.55;
                            area_list[1] = (double) finalValue * 0.78;
                            area_list[2] = (double) finalValue * 0.69;
                            area_list[3] = (double) finalValue * 88.24;
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
                currency_list2.setAdapter(area_arrayAdapter);
            }

        });






        return view;
    }
}