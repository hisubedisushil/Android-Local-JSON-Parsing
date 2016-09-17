package com.example.sushil.jsonparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sushil on 6/11/2016.
 */
public class BrandAdapter extends ArrayAdapter<Brands> {

    TextView mPosition,mBrand,mName;
    Brands brand;
    Context context;

    public BrandAdapter(Context context, ArrayList<Brands> brandses) {
        super(context, 0, brandses);
        this.brand = brand;
        this.context = context;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public Brands getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getPosition(Brands item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Brands brands = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_each_brand, parent, false);
        }
        // Lookup view for data population
        mPosition = (TextView) convertView.findViewById(R.id.adapter_each_brand_tv_position);
        mBrand = (TextView) convertView.findViewById(R.id.adapter_each_brand_tv_brand);
        mName = (TextView) convertView.findViewById(R.id.adapter_each_brand_tv_name);

        mPosition.setText(brands.getPosition());
        mBrand.setText(brands.getBrand());
        mName.setText(brands.getName());

        return convertView;
    }
}