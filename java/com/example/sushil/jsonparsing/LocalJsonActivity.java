package com.example.sushil.jsonparsing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Sushil on 9/16/2016.
 */
public class LocalJsonActivity extends AppCompatActivity {

    int ctr;
    ArrayList<Brands> data = new ArrayList<Brands>();
    ListView listView;
    Brands brands;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_json);

        listView = (ListView) findViewById(R.id.local_json_list_view);

        InputStream inputStream = getResources().openRawResource(R.raw.json);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Parse the data into jsonobject to get original data in form of json.
            JSONObject jObject = new JSONObject(
                    byteArrayOutputStream.toString());
            JSONObject jObjectResult = jObject.getJSONObject("Brands");
            JSONArray jArray = jObjectResult.getJSONArray("Brand");
            for (int i = 0; i < jArray.length(); i++) {

                JSONObject prodObj = jArray.getJSONObject(i);
                String position = prodObj.getString("position");
                String brand = prodObj.getString("brand");
                String name = prodObj.getString("name");
                String description = prodObj.getString("description");

                brands = new Brands(position,brand,name,description);
                data.add(brands);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BrandAdapter brandAdapter = new BrandAdapter(LocalJsonActivity.this,data);
        listView.setAdapter(brandAdapter);


    }
}

