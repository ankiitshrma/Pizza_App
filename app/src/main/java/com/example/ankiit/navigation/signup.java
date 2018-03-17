package com.example.ankiit.navigation;

/**
 * Created by Ankiit on 17-Mar-18.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;


public class signup extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

 /*   @BindView(R.id.input_name)
    EditText _nameText;
    @BindView(R.id.input_address)
    EditText _addressText;
    @BindView(R.id.input_email)
    EditText _emailText;
    @BindView(R.id.input_mobile)
    EditText _mobileText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.input_reEnterPassword)
    EditText _reEnterPasswordText;
    @BindView(R.id.btn_signup)
    Button _signupButton;
    @BindView(R.id.link_login)
    TextView _loginLink;*/

    EditText in;
    EditText ia;
    EditText ie;
    EditText im;
    EditText ip;
    EditText ipp;
    TextView ll;
    Button su;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        in =(EditText)findViewById(R.id.input_name);
        ia =(EditText)findViewById(R.id.input_address);
        ie =(EditText)findViewById(R.id.input_email);
        im =(EditText)findViewById(R.id.input_mobile);
        ip =(EditText)findViewById(R.id.input_password);
        ipp =(EditText)findViewById(R.id.input_reEnterPassword);
        su=(Button)findViewById(R.id.btn_signup);
        ll=(TextView)findViewById(R.id.link_login);


        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), login.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.pushi, R.anim.pusho);
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        su.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(signup.this,
                R.style.Theme_Design_Light);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = in.getText().toString();
        String address = ia.getText().toString();
        String email = ie.getText().toString();
        String mobile = im.getText().toString();
        String password = ip.getText().toString();
        String reEnterPassword = ipp.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        onSignupSuccess();

                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        su.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        su.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = in.getText().toString();
        String address = ia.getText().toString();
        String email = ie.getText().toString();
        String mobile = im.getText().toString();
        String password = ip.getText().toString();
        String reEnterPassword = ipp.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            in.setError("at least 3 characters");
            valid = false;
        } else {
            in.setError(null);
        }

        if (address.isEmpty()) {
            ia.setError("Enter Valid Address");
            valid = false;
        } else {
            ia.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ie.setError("enter a valid email address");
            valid = false;
        } else {
            ie.setError(null);
        }

        if (mobile.isEmpty() || mobile.length() != 10) {
            im.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            im.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            ip.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            ip.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            ipp.setError("Password Do not match");
            valid = false;
        } else {
            ipp.setError(null);
        }

        return valid;
    }
}
