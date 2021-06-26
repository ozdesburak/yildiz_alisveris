package com.app.yildizalisveris.models;

import java.util.Date;

public class AlisverisListe {

    String urunadi;
    Integer urunadedi;
    Double urunfiyati;
    String tarih;
    String alisverisyapilacakyer;
    Boolean tamamlandi;
    Double longitude;
    Double latitude;
    String not;

    public AlisverisListe(String urunadi, Integer urunadedi, Double urunfiyati, String tarih, String alisverisyapilacakyer, Boolean tamamlandi, Double longitude, Double latitude, String not) {
        this.urunadi = urunadi;
        this.urunadedi = urunadedi;
        this.urunfiyati = urunfiyati;
        this.tarih = tarih;
        this.alisverisyapilacakyer = alisverisyapilacakyer;
        this.tamamlandi = tamamlandi;
        this.longitude = longitude;
        this.latitude = latitude;
        this.not = not;
    }

    public String getUrunadi() {
        return urunadi;
    }

    public void setUrunadi(String urunadi) {
        this.urunadi = urunadi;
    }

    public Integer getUrunadedi() {
        return urunadedi;
    }

    public void setUrunadedi(Integer urunadedi) {
        this.urunadedi = urunadedi;
    }

    public Double getUrunfiyati() {
        return urunfiyati;
    }

    public void setUrunfiyati(Double urunfiyati) {
        this.urunfiyati = urunfiyati;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getAlisverisyapilacakyer() {
        return alisverisyapilacakyer;
    }

    public void setAlisverisyapilacakyer(String alisverisyapilacakyer) {
        this.alisverisyapilacakyer = alisverisyapilacakyer;
    }

    public Boolean getTamamlandi() {
        return tamamlandi;
    }

    public void setTamamlandi(Boolean tamamlandi) {
        this.tamamlandi = tamamlandi;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getNot() {
        return not;
    }

    public void setNot(String not) {
        this.not = not;
    }
}
