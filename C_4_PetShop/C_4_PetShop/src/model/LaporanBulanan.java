package model;

public class LaporanBulanan {

    private String bulan;
    private int jumlah_transaksi;
    private double total_pendapatan;

    public LaporanBulanan(String bulan, int jumlah_transaksi, double total_pendapatan) {
        this.bulan = bulan;
        this.jumlah_transaksi = jumlah_transaksi;
        this.total_pendapatan = total_pendapatan;
    }

    public String getBulan() {
        return bulan;
    }

    public int getJumlah_transaksi() {
        return jumlah_transaksi;
    }

    public double getTotal_pendapatan() {
        return total_pendapatan;
    }
}