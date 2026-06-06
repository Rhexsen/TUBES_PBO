/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Penitipan {
    private int id_penitipan;
    private int id_customer;
    private int id_hewan;
    private String tanggal_masuk;   
    private String tanggal_keluar;  
    private double total_biaya;

    public Penitipan(int id_customer, int id_hewan, String tanggal_masuk, String tanggal_keluar, double total_biaya) {
        this.id_customer = id_customer;
        this.id_hewan = id_hewan;
        this.tanggal_masuk = tanggal_masuk;
        this.tanggal_keluar = tanggal_keluar;
        this.total_biaya = total_biaya;
    }

    public Penitipan(int id_penitipan, int id_customer, int id_hewan, String tanggal_masuk, String tanggal_keluar, double total_biaya) {
        this.id_penitipan = id_penitipan;
        this.id_customer = id_customer;
        this.id_hewan = id_hewan;
        this.tanggal_masuk = tanggal_masuk;
        this.tanggal_keluar = tanggal_keluar;
        this.total_biaya = total_biaya;
    }
    
    public int getId_penitipan() {
        return id_penitipan;
    }

    public void setId_penitipan(int id_penitipan) {
        this.id_penitipan = id_penitipan;
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

    public String getTanggal_masuk() {
        return tanggal_masuk;
    }

    public void setTanggal_masuk(String tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public String getTanggal_keluar() {
        return tanggal_keluar;
    }

    public void setTanggal_keluar(String tanggal_keluar) {
        this.tanggal_keluar = tanggal_keluar;
    }

    public double getTotal_biaya() {
        return total_biaya;
    }

    public void setTotal_biaya(double total_biaya) {
        this.total_biaya = total_biaya;
    }
    
    public String getString() {
        return id_penitipan + " | " + id_customer + " | " + id_hewan + " | " +
               tanggal_masuk + " → " + tanggal_keluar + " | Rp" + total_biaya;
    }
}
