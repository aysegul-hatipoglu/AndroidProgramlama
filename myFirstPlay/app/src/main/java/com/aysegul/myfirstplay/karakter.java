package com.aysegul.myfirstplay;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by MUTLU on 7.10.2017.
 */

public class karakter implements Parcelable {
    int kilo;
    int hareketSayisi;
    int saldiriGucu;
    String isim="Karaktere isim verin";

    public String yemek(){

        if(hareketSayisi>0){
            kilo++;
            hareketSayisi--;
            return "Yemek yedi ve Kilosu arttı";
        }
        else
            return "Yeterli Hareket Yok";
    }
    public String uyumak(){
        if(hareketSayisi>0){
            hareketSayisi--;
            return "Karakterimiz Uyudu";
        }
        else
            return "Yeterli Hareket Yok";
    }
    public String savas(){
        if(hareketSayisi>0){
            hareketSayisi--;
            saldiriGucu++;
            return "Karakterimiz Savaştı";
        }
        else
            return "Yeterli Hareket Yok";
    }

    @Override
    public String toString(){
        return " Karakterin ismi: "+ isim
                +"\n Kilo:"+kilo
                +"\n Hareket Sayisi: "+hareketSayisi
                +"\n Saldiri Gücü: "+saldiriGucu;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.kilo);
        dest.writeInt(this.hareketSayisi);
        dest.writeInt(this.saldiriGucu);
        dest.writeString(this.isim);
    }

    public karakter() {
    }

    protected karakter(Parcel in) {
        this.kilo = in.readInt();
        this.hareketSayisi = in.readInt();
        this.saldiriGucu = in.readInt();
        this.isim = in.readString();
    }

    public static final Parcelable.Creator<karakter> CREATOR = new Parcelable.Creator<karakter>() {
        @Override
        public karakter createFromParcel(Parcel source) {
            return new karakter(source);
        }

        @Override
        public karakter[] newArray(int size) {
            return new karakter[size];
        }
    };
}


