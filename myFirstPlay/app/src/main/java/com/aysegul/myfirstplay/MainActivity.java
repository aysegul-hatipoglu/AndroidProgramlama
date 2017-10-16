package com.aysegul.myfirstplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,EditText.OnEditorActionListener {

    TextView tv;
    TextView tvKarakterOzellikleri;
    int sayac = 0;
    Button yemek;
    Button uyu;
    Button saldir;
    karakter k;
    EditText isim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isim= (EditText) findViewById(R.id.editText);

        isim.setVisibility(View.INVISIBLE);

        if(savedInstanceState!=null){
            k=savedInstanceState.getParcelable("karakter");
            isim.setVisibility(View.INVISIBLE);
            tvKarakterOzellikleri.setText(k.toString());
            tvKarakterOzellikleri.setVisibility(View.VISIBLE);

        }else{
            k = new karakter();
            k.hareketSayisi = 10;
            k.kilo = 10;
            k.saldiriGucu = 100;
        }

        tv = (TextView) findViewById(R.id.cevap);
        tvKarakterOzellikleri = (TextView) findViewById(R.id.bilmece);
        saldir= (Button) findViewById(R.id.saldir);
        yemek= (Button) findViewById(R.id.yemekye);
        uyu = (Button) findViewById(R.id.uyu);

        saldir.setOnClickListener(this);
        yemek.setOnClickListener(this);
        uyu.setOnClickListener(this);

        tvKarakterOzellikleri.setText(k.toString());
        tv.setText("Oyuna Hoş Geldiniz Lütfen bir eylem seçiniz");
        isim.setOnEditorActionListener(this);
    }

       @Override
       public void onClick(View v) {
           if(v.getId()==saldir.getId())
               tv.setText(k.savas());
           else if(v.getId()==uyu.getId())
               tv.setText(k.uyumak());
           else if(v.getId()==yemek.getId())
               tv.setText(k.yemek());
           tvKarakterOzellikleri.setText(k.toString());
       }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putString("anahtar","deger");
        outState.putParcelable("karakter",k);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        tv.setText("Karakterin İsmi "+isim.getText()+" olarak atandı");
        k.isim=(String)isim.getText().toString();
        isim.setVisibility(View.INVISIBLE);
        tvKarakterOzellikleri.setText(k.toString());
        tvKarakterOzellikleri.setVisibility(View.VISIBLE);

        return true;
    }
}

