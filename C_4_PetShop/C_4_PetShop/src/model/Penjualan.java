/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class Penjualan {
    private int id_penjualan;
    private int id_customer;
    private String tanggal_penjualan; 
    private double total_harga;

    public Penjualan(int id_customer, String tanggal_penjualan, double total_harga) {
        this.id_customer = id_customer;
        this.tanggal_penjualan = tanggal_penjualan;
        this.total_harga = total_harga;
    }

    public Penjualan(int id_penjualan, int id_customer, String tanggal_penjualan, double total_harga) {
        this.id_penjualan = id_penjualan;
        this.id_customer = id_customer;
        this.tanggal_penjualan = tanggal_penjualan;
        this.total_harga = total_harga;
    }
    
    public int getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(int id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getTanggal_penjualan() {
        return tanggal_penjualan;
    }

    public void setTanggal_penjualan(String tanggal_penjualan) {
        this.tanggal_penjualan = tanggal_penjualan;
    }

    public double getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(double total_harga) {
        this.total_harga = total_harga;
    }
    
    public String getString() {
        return id_penjualan + " | " + id_customer + " | " + tanggal_penjualan + " | Rp" + total_harga;
    }
}
