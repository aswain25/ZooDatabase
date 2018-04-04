package com.example.admin.zoodatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void catagories_clicked(View view) {
        Intent intent = new Intent(getApplicationContext(), CatagoriesActivity.class);
        startActivity(intent);
    }
}
