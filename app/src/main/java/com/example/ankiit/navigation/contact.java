package com.example.ankiit.navigation;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ankiit on 15-Mar-18.
 */

public class contact extends AppCompatActivity {
    Button btn;
    EditText numTxt;
    String sNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        btn =(Button)findViewById(R.id.btnCall);
        numTxt=(EditText)findViewById(R.id.numTxt);
    }
    public void btnClick(View v){
        Intent i = new Intent(Intent.ACTION_CALL);
        sNum= numTxt.getText().toString();
        if (sNum.trim().isEmpty()){
            i.setData(Uri.parse("tel:9891293951"));
        }
        else{
            i.setData(Uri.parse("tel: "+sNum));
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"Please grant the permission", Toast.LENGTH_SHORT).show();
            requestPermissions();
        }
        else{
            startActivity(i);

        }
    }
    private void requestPermissions(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
