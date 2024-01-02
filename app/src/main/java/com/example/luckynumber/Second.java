package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Second extends AppCompatActivity {
    TextView t2,t3;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        t3=findViewById(R.id.t3);
        b2=findViewById(R.id.b2);

        Intent i=getIntent();
        String x=i.getStringExtra("name");
        int r=num();
        t3.setText(""+r);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(x,r);
            }
        });
    }
    public int num(){
        Random r=new Random();
        int u=100;
        int rn=r.nextInt(u);
        return rn;
    }
    public void share(String s,int r)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,s+" got lucky today ");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is : "+r);
        startActivity(Intent.createChooser(i,"Choose a platform"));
    }
}