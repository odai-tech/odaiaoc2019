package com.example.user.odaiaoc2019;

import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.DialogInterface;
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{


    private static final String TAG = "Firebase";
    private FirebaseAuth mAuth;

    EditText editTextEmail, editTextPassword;

    String[] ListItems= new String[8] ;


    Button buttonConfirm;
    Button buttonConfirm2;

    String bloodType = "undefined";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        ListItems = getResources().getStringArray(R.array.type_item);

        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);

        buttonConfirm2 = findViewById(R.id.buttonConfirm2);
        buttonConfirm2.setOnClickListener(this);

        buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonConfirm.setOnClickListener(this);



    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
    public void signUp(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            //    updateUI(user);
                            Intent i=new Intent(SignUpActivity.this , HomePage.class);
                            i.putExtra("bloodType", bloodType);
                            startActivity(i);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //    updateUI(null);
                        }

                        // ...
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if(v==buttonConfirm2) {
            if (!bloodType.equals("undefined"))
                signUp(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            else
                Toast.makeText(SignUpActivity.this, "Please Choose Blood Type", Toast.LENGTH_LONG).show();

        }
        else{
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpActivity.this);
                    mBuilder.setTitle("Choose your BloodType");
                    mBuilder.setSingleChoiceItems(ListItems, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(SignUpActivity.this, ListItems[which], Toast.LENGTH_LONG).show();
                            bloodType = ListItems[which];
                            dialog.dismiss();
                        }
                    }) ;

                    AlertDialog mDialog = mBuilder.create();
                    mDialog.show();
                }
            }
        }

