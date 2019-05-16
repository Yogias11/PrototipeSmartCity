package com.newbie.myapplication.model;

public class Content {
    private String user;
    private String times;
    private String lokasi;
    private String keterangan;



    public Content(String user, String times, String lokasi,String keterangan) {
        this.user = user;
        this.times = times;
        this.lokasi = lokasi;
        this.keterangan = keterangan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getTimes() {
        return times;
    }

    public String getUser() {
        return user;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
