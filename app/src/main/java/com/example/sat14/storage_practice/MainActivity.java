package com.example.sat14.storage_practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int count;
    private SharedPreferences file;
    private SharedPreferences.Editor edit;
    private TextView textBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        file = getPreferences(0);
        edit = file.edit();
        int savedCount = file.getInt("COUNT", 0);
        count = savedCount;
        textBox = (TextView)findViewById(R.id.textView);
        textBox.setText(String.valueOf(count));
    }

    public void increment(View v) {
        count++;
        textBox.setText(String.valueOf(count));
    }

    public void save(View v) {
        edit.putInt("COUNT", count);
        edit.commit();
    }

    public void reset(View v) {
        count = 0;
        textBox.setText(String.valueOf(count));
    }
}