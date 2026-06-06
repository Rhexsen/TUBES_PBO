package model;

public class Produk {
    private int id_produk;
    private String nama_produk;
    private String kategori;
    private double harga;
    private int stok;

    public Produk(String nama_produk, String kategori, double harga, int stok) {
        this.nama_produk = nama_produk;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public Produk(int id_produk, String nama_produk, String kategori, double harga, int stok) {
        this.id_produk = id_produk;
        this.nama_produk = nama_produk;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}