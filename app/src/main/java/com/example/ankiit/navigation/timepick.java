package com.example.ankiit.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by Ankiit on 15-Mar-18.
 */

public class timepick extends AppCompatActivity {
    TimePicker timePicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timepick);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Toast.makeText(getApplicationContext(),"Waise to aapka time kharab chal rha hai pr fir bhi time hai "+i+":"+i1,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
