package com.example.ankiit.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Ankiit on 15-Mar-18.
 */

public class splash extends AppCompatActivity {





        private ImageView iv1;
        private ImageView iv2;
        Button btnBounce;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.splash);

            iv1 =findViewById(R.id.iv1);
            Animation myanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);


            iv1.startAnimation(myanim);
            final Intent i = new Intent(this,MainActivity.class);
            Thread timer=new Thread(){
                public void run(){
                    try{
                        sleep(4000);




                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        startActivity(i);
                        finish();


                    }
                }
            };
            timer.start();


            }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.splash);



       /* btnBounce.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                iv2=findViewById(R.id.iv2);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
                iv2.startAnimation(animation);

            }
        });
    }
}  */

        iv2 = findViewById(R.id.iv2);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        iv2.startAnimation(animation);
    }}