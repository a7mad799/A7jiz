package com.example.superbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class SignUpActivity extends AppCompatActivity  {
    private EditText phoneText, year,edit_code,Full_name,password,repassword;
    private Button  send_code,sign_up;
    private String verificationid;
    private FirebaseAuth mauth;
    private int y2;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        phoneText = (EditText) findViewById(R.id.phoneID4);
        Full_name=(EditText)findViewById(R.id.Full_name);
        password=(EditText)findViewById(R.id.passwordID3);
        repassword=(EditText)findViewById(R.id.passwordID4);
        year = (EditText) findViewById(R.id.year);
        send_code = (Button) findViewById(R.id.button);
        sign_up=(Button)findViewById(R.id.Sign_up);
        edit_code=(EditText)findViewById(R.id.edittext_code);
        mauth=FirebaseAuth.getInstance();

       ref= FirebaseDatabase.getInstance().getReference().child("User");

        send_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendVerification(phoneText.getText().toString().trim());
                String code=edit_code.getText().toString().trim();
                    if(code.isEmpty() || code.length()<6){
                        edit_code.setError("Enter code ...");
                        edit_code.requestFocus();
                        return;
                    }
                    verifyCode(code);
                    Sign_up(v);


            }
        });




    }

    public void Sign_up(View view){

        user user1=new user(Full_name.getText().toString(),phoneText.getText().toString(),Integer.parseInt(year.getText().toString()),password.getText().toString());
       ref.push().setValue(user1);
        Intent intent=new Intent(this,ChoosingActivity.class);
        startActivity(intent);
    }

    private void verifyCode(String code){
        PhoneAuthCredential credintial=PhoneAuthProvider.getCredential(verificationid,code);
        SignwithCredential(credintial);
    }

    private void SignwithCredential(PhoneAuthCredential credintial) {
        mauth.signInWithCredential(credintial)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent=new Intent(SignUpActivity.this,listviewActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SignUpActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }

                    });
                }



    private void sendVerification(String phone){

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks

        );

    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationid=s;

        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
        String code=phoneAuthCredential.getSmsCode();
        if(code!=null){
            verifyCode(code);
        }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(SignUpActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    };

}
