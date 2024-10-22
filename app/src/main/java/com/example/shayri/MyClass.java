package com.example.shayri;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyClass extends BaseAdapter {
    String[] array;
    MainActivity mainActivity;
    int[] imagearray;
    int[] colr;

    public MyClass(String[] array, MainActivity mainActivity, int[] imagearray, int[] colr) {
        this.array = array;
        this.mainActivity = mainActivity;
        this.imagearray = imagearray;
        this.colr = colr;
    }

    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {

        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView img;
        convertView = LayoutInflater.from(mainActivity).inflate(R.layout.myview, parent, false);

        img = convertView.findViewById(R.id.img);
        img.setBackgroundResource(imagearray[position]);

        TextView txt ;
        txt = convertView.findViewById(R.id.txt);
        txt.setBackgroundResource(colr[position]);
        txt.setText(array[position]);

        return convertView;
    }
}
