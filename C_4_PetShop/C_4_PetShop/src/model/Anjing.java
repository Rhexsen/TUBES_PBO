package model;

public class Anjing extends Hewan{
    private String ras;

    public Anjing(String ras, Integer id_customer, String nama_hewan, String jenis_hewan, String warna, int umur, String gender, String status_adopsi) {
        super(id_customer, nama_hewan, "Anjing", warna, umur, gender, status_adopsi);
        this.ras = ras;
    }

    public Anjing(int id_hewan, String ras, Integer id_customer, String nama_hewan, String jenis_hewan, String warna, int umur, String gender, String status_adopsi) {
        super(id_hewan, id_customer, nama_hewan, "Anjing", warna, umur, gender, status_adopsi);
        this.ras = ras;
    }

    public String getRas() {
        return ras;
    }

    public void setRas(String ras) {
        this.ras = ras;
    }

    @Override
    public String getSpecial() {
        return ras;
    }
}