package com.example.ankiit.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * Created by Ankiit on 15-Mar-18.
 */

public class rating extends AppCompatActivity {
    Button btn;
    RatingBar ratingBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate);
        btn =  findViewById(R.id.button);
        ratingBar= findViewById(R.id.ratingBar);

    }
    public void onBtnClick(View v){
        float ratingvalue=ratingBar.getRating();
        Toast.makeText(this,"Your Rating is: "+ratingvalue+". Thanks for rating us !",Toast.LENGTH_SHORT).show();

    }


}
