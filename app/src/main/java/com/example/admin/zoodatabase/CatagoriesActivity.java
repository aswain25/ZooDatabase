package com.example.admin.zoodatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CatagoriesActivity extends AppCompatActivity {

    public enum Catagory
    {
        Mammals,
        Birds,
        Fish,
        Amphibians,
        Reptiles,
    }

    ListView catagoriesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagories);

        catagoriesView = findViewById(R.id.catagories_view);
        final Catagory[] catagories = Catagory.values();
        String[] asStringArray = new String[catagories.length];
        for (int i = 0 ; i < asStringArray.length; i++)
            asStringArray[i] = catagories[i].toString();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, asStringArray);
        catagoriesView.setAdapter(arrayAdapter);
        catagoriesView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView asTV = (TextView)view;
                Catagory catagory = Catagory.valueOf(asTV.getText().toString());
                Intent intent = new Intent(getApplicationContext(), AnimalsActivity.class);
                intent.putExtra("catagory", catagory);
                startActivity(intent);
            };
        });
    }
}
