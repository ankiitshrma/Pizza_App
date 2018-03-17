package com.example.ankiit.navigation;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MenuItems extends AppCompatActivity {
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_items);
        spinner=(Spinner) findViewById(R.id.Spinner);
        String [] pizzas ={"Pan Pizza", "Farm House", "Cheese Burst", "Crispy"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,pizzas);
        spinner.setAdapter(adapter);



    }

}
