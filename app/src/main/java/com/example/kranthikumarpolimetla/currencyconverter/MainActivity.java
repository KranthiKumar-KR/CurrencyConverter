package com.example.kranthikumarpolimetla.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner1;
    Spinner spinner2;
    EditText et1;
    Button convert;
    ImageButton reverse;
    TextView result;
    private String currency1;
    private String currency2;
     int input1 = 1;
     int input2 = 1;

    private List<String> currencyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = (Spinner) findViewById(R.id.currency1);
        spinner2 = (Spinner) findViewById(R.id.currency2);
        et1 = (EditText) findViewById(R.id.input1);
        et1.setText("1");
        convert = (Button) findViewById(R.id.convert);
        result = (TextView) findViewById(R.id.result);
        reverse = (ImageButton) findViewById(R.id.reverse);
        reverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reverseCurrency();
            }
        });


        currencyList.add("usd");
        currencyList.add("inr");
        currencyList.add("aud");
        currencyList.add("eur");
        currencyList.add("bnm");
        currencyList.add("dud");
        currencyList.add("ryd");
        currencyList.add("chi");
        currencyList.add("kin");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, currencyList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);
        input1 = Integer.parseInt(et1.getText().toString());

//        Toast.makeText(this, input1, Toast.LENGTH_SHORT).show();
        input2 = Integer.parseInt(et1.getText().toString());

        //Toast.makeText(this, input2, Toast.LENGTH_SHORT).show();
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), ""+input1 +input2, Toast.LENGTH_SHORT).show();
                result.setText("Value is: " +convertit(Integer.parseInt(et1.getText().toString())));
            }
        });


    }

    private String convertit(int i1) {
        if(currency1.equals("usd") && currency2.equals("inr")) {
            return String.format("%.2f", i1*64.26);
        }
        return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.currency1:
                currency1 = parent.getItemAtPosition(position).toString();
                Toast.makeText(this, currency1, Toast.LENGTH_SHORT).show();
            case R.id.currency2:
                currency2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(this, currency2, Toast.LENGTH_SHORT).show();
        }

    }

    public void reverseCurrency() {
        Toast.makeText(this, "Reverse button clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
currency1 = "usd";
        currency2 = "inr";
    }
}
