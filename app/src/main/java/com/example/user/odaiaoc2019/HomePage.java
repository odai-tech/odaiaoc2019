package com.example.user.odaiaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
        public boolean onCreateOptionsMenu( Menu;menu);
        {
            getMenuInflater().inflate(R.menu.my_menu, menu);
            return true;
        }

        public boolean onOptionsItemSelected(MenuItem item) {
            Intent goToNextActivity = new Intent(getApplicationContext(), .class);

            switch (item.getItemId()) {

                case R.id.SignUp:
                    goToNextActivity = new Intent(getApplicationContext(),SignUpActivity .class);
                    startActivity(goToNextActivity);
                    break;


            }
            return true;
        }

    } }
