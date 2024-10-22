package com.example.shayri;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyPagerAdapter extends PagerAdapter {

    MainActivity3 mainActivity3;
    String[] array;

    public MyPagerAdapter(MainActivity3 mainActivity3, String[] array) {
        this.mainActivity3 = mainActivity3;
        this.array = array;
    }

    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        TextView vtext;
        View vv = LayoutInflater.from(mainActivity3).inflate(R.layout.qwe,container,false);

        vtext = vv.findViewById(R.id.vtext);
        vtext.setText(array[position]);

        container.addView(vv);

        return vv;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
