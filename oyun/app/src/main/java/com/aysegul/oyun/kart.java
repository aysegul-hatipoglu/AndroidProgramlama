package com.aysegul.oyun;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;


/**
 * Created by MUTLU on 14.10.2017.
 */

public class kart extends Button {

    boolean acikMi=false;
    boolean cevrilebilir=true;
    int arkaplanID;
    int onPlanID;
    Drawable on;
    Drawable arka;

    @SuppressLint("NewApi")
    public kart(Context context, int id) {
        super(context);
        setId(id);
        arkaplanID=R.drawable.arka;
        onPlanID=R.drawable.c1;
        if(id%8==0)
            onPlanID=R.drawable.c0;
        if(id%8==1)
            onPlanID=R.drawable.c1;
        if(id%8==2)
            onPlanID=R.drawable.c2;
        if(id%8==3)
            onPlanID=R.drawable.c3;
        if(id%8==4)
            onPlanID=R.drawable.c4;
        if(id%8==5)
            onPlanID=R.drawable.c5;
        if(id%8==6)
            onPlanID=R.drawable.c6;
        if(id%8==7)
            onPlanID=R.drawable.c7;


        arka= AppCompatDrawableManager.get().getDrawable(context,arkaplanID);
        on= AppCompatDrawableManager.get().getDrawable(context,onPlanID);
        setBackground(arka);

    }



    public void cevir(){
        if(cevrilebilir){
            if(!acikMi){//arkasi çevrili ise
                setBackground(on);
                acikMi=true;
            }else{
                setBackground(arka);
                acikMi=false;
            }
        }
    }
}
