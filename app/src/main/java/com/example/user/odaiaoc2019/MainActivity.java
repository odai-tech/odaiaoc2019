package com.example.user.odaiaoc2019;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //1, properties definition
    EditText editTextEmail , editTextPassword;
    Button buttonLogIn, buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2.initialize properties
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);

        buttonLogIn=findViewById(R.id.buttonLogIn);
        buttonSignUp=findViewById(R.id.buttonSignUp);
        buttonLogIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==buttonLogIn){
            if(editTextEmail.getText().toString().equals("")|| editTextPassword.getText().toString().equals("")){
                Toast.makeText(this,"Empty Password or Email",Toast.LENGTH_LONG).show();
            }
            else{
                Intent i=new Intent(this,HomePage.class);
                i.putExtra("email" , editTextEmail.getText().toString());
                i.putExtra("password" , editTextPassword.getText().toString());
                startActivity(i);}

        }
        else{
            Intent i=new Intent(this,SignUpActivity.class);
            startActivity(i);

        }
    }
}