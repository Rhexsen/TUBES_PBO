package model;

public class DetailPenjualan {
    private int id_detail;
    private int id_penjualan;
    private int id_produk;
    private int jumlah;
    private double subtotal;

    public DetailPenjualan(int id_penjualan, int id_produk, int jumlah, double subtotal) {
        this.id_penjualan = id_penjualan;
        this.id_produk = id_produk;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
    }

    public DetailPenjualan(int id_detail, int id_penjualan, int id_produk, int jumlah, double subtotal) {
        this.id_detail = id_detail;
        this.id_penjualan = id_penjualan;
        this.id_produk = id_produk;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
    }

    public int getId_detail() {
        return id_detail;
    }

    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    public int getId_penjualan() {
        return id_penjualan;
    }

    public void setId_penjualan(int id_penjualan) {
        this.id_penjualan = id_penjualan;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}