package com.example.superbook;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText phoneText, passwordText;
    private Button logInButton, signUpButton;


    private String phone_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneText = (EditText) findViewById(R.id.phoneID);
        passwordText = (EditText) findViewById(R.id.passwordID);
        logInButton = (Button) findViewById(R.id.logButton);
        signUpButton = (Button) findViewById(R.id.signupButton);
        logInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);


        phoneText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                phone_string = editable.toString();
            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent signUpIntent = new Intent(this, SignUpActivity.class);
        Intent logInIntent = new Intent(this, ChoosingActivity.class);
        if(view == signUpButton)
            startActivity(signUpIntent);
        if(view == logInButton)
            startActivity(logInIntent);



    }
}
