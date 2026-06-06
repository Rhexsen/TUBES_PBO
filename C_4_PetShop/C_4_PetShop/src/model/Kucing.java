package model;

public class Kucing extends Hewan{
    private String jenis_bulu;

    public Kucing(String jenis_bulu, Integer id_customer, String nama_hewan, String jenis_hewan, String warna, int umur, String gender, String status_adopsi) {
        super(id_customer, nama_hewan, "Kucing", warna, umur, gender, status_adopsi);
        this.jenis_bulu = jenis_bulu;
    }

    public Kucing(int id_hewan, String jenis_bulu, Integer id_customer, String nama_hewan, String jenis_hewan, String warna, int umur, String gender, String status_adopsi) {
        super(id_hewan, id_customer, nama_hewan, "Kucing", warna, umur, gender, status_adopsi);
        this.jenis_bulu = jenis_bulu;
    }

    public String getJenis_bulu() {
        return jenis_bulu;
    }

    public void setJenis_bulu(String jenis_bulu) {
        this.jenis_bulu = jenis_bulu;
    }

    @Override
    public String getSpecial() {
        return jenis_bulu;
    }
}