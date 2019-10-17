package com.example.user.odaiaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<BloodDonation> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        listView=findViewById(R.id.myList);
        arrayList=new ArrayList<BloodDonation>();
        arrayList.add(new BloodDonation(33, "OO", true, R.drawable.ic_launcher_background,"first", "123", "123"));

        //      adapter =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);

        ///  public BloodDonation(int age , String BloodType , boolean isHealthy , int imageId , String FullName, int PhoneNumner , int ID  ){


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
        }


    public boolean onOptionsItemSelected(MenuItem item) {
        Intent goToNextActivity;

        switch (item.getItemId()) {

            case R.id.profile:
                goToNextActivity = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(goToNextActivity);
                break;

            case R.id.logout:
                goToNextActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToNextActivity);
                break;


        }
        return true;
    }
}
