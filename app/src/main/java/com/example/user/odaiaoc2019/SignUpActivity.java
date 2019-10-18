package com.example.user.odaiaoc2019;

import android.app.AlertDialog;
import android.app.LauncherActivity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    String[] ListItems= new String[8] ;

    Button confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        confirm = findViewById(R.id.buttonConfirm);
        ListItems = getResources().getStringArray(R.array.type_item);

        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View View) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignUpActivity.this);
                mBuilder.setTitle("Choose your BloodType");
                mBuilder.setSingleChoiceItems(ListItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                //intent here
                        Toast.makeText(SignUpActivity.this, ListItems[which], Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }

        });
    }
}