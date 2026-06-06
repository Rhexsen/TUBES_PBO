/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Grooming {
    private int id_grooming;
    private int id_customer;
    private int id_hewan;
    private String tanggal_grooming;
    private String jenis_layanan;
    private double harga;

    public Grooming(int id_customer, int id_hewan, String tanggal_grooming, String jenis_layanan, double harga) {
        this.id_customer = id_customer;
        this.id_hewan = id_hewan;
        this.tanggal_grooming = tanggal_grooming;
        this.jenis_layanan = jenis_layanan;
        this.harga = harga;
    }

    public Grooming(int id_grooming, int id_customer, int id_hewan, String tanggal_grooming, String jenis_layanan, double harga) {
        this.id_grooming = id_grooming;
        this.id_customer = id_customer;
        this.id_hewan = id_hewan;
        this.tanggal_grooming = tanggal_grooming;
        this.jenis_layanan = jenis_layanan;
        this.harga = harga;
    }
    
    public int getId_grooming() {
        return id_grooming;
    }

    public void setId_grooming(int id_grooming) {
        this.id_grooming = id_grooming;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_hewan() {
        return id_hewan;
    }

    public void setId_hewan(int id_hewan) {
        this.id_hewan = id_hewan;
    }

    public String getTanggal_grooming() {
        return tanggal_grooming;
    }

    public void setTanggal_grooming(String tanggal_grooming) {
        this.tanggal_grooming = tanggal_grooming;
    }

    public String getJenis_layanan() {
        return jenis_layanan;
    }

    public void setJenis_layanan(String jenis_layanan) {
        this.jenis_layanan = jenis_layanan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public String getString() {
        return id_grooming + " | " + id_customer + " | " + id_hewan + " | " +
               tanggal_grooming + " | " + jenis_layanan + " | Rp" + harga;
    }
}
