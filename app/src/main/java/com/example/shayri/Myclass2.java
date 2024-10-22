package com.example.shayri;

import static android.content.Context.CLIPBOARD_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.content.ClipData;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.ClipboardManager;
import android.widget.Toast;

public class Myclass2 extends BaseAdapter {

    String[] blank;
    MainActivity2 mainActivity2;
    int[] colr2;

    public Myclass2(String[] blank, MainActivity2 mainActivity2, int[] colr2) {
        this.blank = blank;
        this.mainActivity2 = mainActivity2;
        this.colr2 = colr2;
    }

    @Override
    public int getCount() {
        return blank.length;
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

        TextView txt;
        TextView wp;
        TextView shre;
        TextView cpy;

        convertView = LayoutInflater.from(mainActivity2).inflate(R.layout.myview2, parent, false);

        wp = convertView.findViewById(R.id.wp);
        shre = convertView.findViewById(R.id.shre);
        cpy = convertView.findViewById(R.id.cpy);

        txt = convertView.findViewById(R.id.txt2);
        txt.setBackgroundResource(colr2[position]);
        txt.setText(blank[position]);


        wp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, blank[position]);
                try {
                    mainActivity2.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {

                }

            }
        });

        shre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                String shareBody = "Here is the share content body";
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "blank[position]");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, blank[position]);
                mainActivity2.startActivity(Intent.createChooser(intent, ""));

            }
        });

        cpy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) mainActivity2.getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", blank[position]);
                clipboard.setPrimaryClip(clip);

            }
        });
        return convertView;
    }
}
