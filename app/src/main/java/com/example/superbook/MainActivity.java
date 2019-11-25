package com.example.superbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText phoneText, passwordText;
    private Button logInButton, signUpButton;


    private String phone_string;

    private FirebaseAuth firebaseAuth;

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


        firebaseAuth = firebaseAuth.getInstance();



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
