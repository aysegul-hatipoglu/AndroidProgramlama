package com.aysegul.dondurmeislemleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b;
    TextView tv;
    int say;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.TextView);

        if(savedInstanceState!=null){
            say=savedInstanceState.getInt("sayac");
            tv.setText("Sayac: "+say);
        }else{
            say=0;
        }
        b= (Button) findViewById(R.id.button);

        say=0;

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                say++;
                tv.setText("Sayac: "+say);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sayac",say);
    }
}
