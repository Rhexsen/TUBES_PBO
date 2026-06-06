package model;

public class Adopsi {
    private int id_adopsi;
    private int id_customer;
    private int id_hewan;
    private String tanggal_adopsi;
    private double biaya_adopsi;

    public Adopsi(int id_customer, int id_hewan, String tanggal_adopsi, double biaya_adopsi) {
        this.id_customer = id_customer;
        this.id_hewan = id_hewan;
        this.tanggal_adopsi = tanggal_adopsi;
        this.biaya_adopsi = biaya_adopsi;
    }

    public Adopsi(int id_adopsi, int id_customer, int id_hewan, String tanggal_adopsi, double biaya_adopsi) {
        this.id_adopsi = id_adopsi;
        this.id_customer = id_customer;
        this.id_hewan = id_hewan;
        this.tanggal_adopsi = tanggal_adopsi;
        this.biaya_adopsi = biaya_adopsi;
    }

    public int getId_adopsi() {
        return id_adopsi;
    }

    public void setId_adopsi(int id_adopsi) {
        this.id_adopsi = id_adopsi;
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

    public String getTanggal_adopsi() {
        return tanggal_adopsi;
    }

    public void setTanggal_adopsi(String tanggal_adopsi) {
        this.tanggal_adopsi = tanggal_adopsi;
    }

    public double getBiaya_adopsi() {
        return biaya_adopsi;
    }

    public void setBiaya_adopsi(double biaya_adopsi) {
        this.biaya_adopsi = biaya_adopsi;
    }
}