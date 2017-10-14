package com.fracktory.abhi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent intent=getIntent();
        String name=intent.getStringExtra("NAME");
        TextView textView= (TextView) findViewById(R.id.text_welcome);
        textView.setText(name);
    }
}
