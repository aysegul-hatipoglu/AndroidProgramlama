package com.aysegul.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int x=1002;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("mesaj","start");
        x=1002;
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("mesaj","stop");
        Log.e("hata","stop");
        x++;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("mesaj","destroy");
        x++;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("mesaj","pause");
        x++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mesaj","resume");
        x++;
    }

}
