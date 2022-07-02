package com.istidataproject.entity;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_informations")
public class Information {
   
    @Id
    private Long nik;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String alamat;
    
    @Column(length = 25, nullable = false)
    private String jk;

    @Column(length = 50, nullable = false)
    private String negara;

    @Column(length = 30, nullable = false)
    private String tgl_lahir;

    private int umur;


    public Information() {
        
    }

    public Long getNik() {
        return this.nik;
    }

    public void setNik(Long nik) {
        this.nik = nik;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJk() {
        return this.jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public int getUmur() {
        return this.umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getNegara() {
        return this.negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getTgl_lahir() {
        return this.tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }
    
    
    
}
