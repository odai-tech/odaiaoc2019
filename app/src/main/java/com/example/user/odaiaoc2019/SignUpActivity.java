package com.example.user.odaiaoc2019;

import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {
    String[] listItems;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        confirm = findViewById(R.id.buttonConfirm);
        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View View) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpActivity.this);
                mBuilder.setTitle("Choose your BloodType");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

            }
        });
    }
}