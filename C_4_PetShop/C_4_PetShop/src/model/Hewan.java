package model;

public abstract class Hewan {
    protected int id_hewan;
    protected Integer id_customer;
    protected String nama_hewan;
    protected String jenis_hewan;
    protected String warna;
    protected int umur;
    protected String gender;
    protected String status_adopsi;

    public Hewan(Integer id_customer, String nama_hewan, String jenis_hewan, String warna, int umur, String gender, String status_adopsi) {
        this.id_customer = id_customer;
        this.nama_hewan = nama_hewan;
        this.jenis_hewan = jenis_hewan;
        this.warna = warna;
        this.umur = umur;
        this.gender = gender;
        this.status_adopsi = status_adopsi;
    }

    public Hewan(int id_hewan, Integer id_customer, String nama_hewan, String jenis_hewan, String warna, int umur, String gender, String status_adopsi) {
        this.id_hewan = id_hewan;
        this.id_customer = id_customer;
        this.nama_hewan = nama_hewan;
        this.jenis_hewan = jenis_hewan;
        this.warna = warna;
        this.umur = umur;
        this.gender = gender;
        this.status_adopsi = status_adopsi;
    }

    public int getId_hewan() {
        return id_hewan;
    }

    public void setId_hewan(int id_hewan) {
        this.id_hewan = id_hewan;
    }

    public Integer getId_customer() {
        return id_customer;
    }

    public void setId_customer(Integer id_customer) {
        this.id_customer = id_customer;
    }

    public String getNama_hewan() {
        return nama_hewan;
    }

    public void setNama_hewan(String nama_hewan) {
        this.nama_hewan = nama_hewan;
    }

    public String getJenis_hewan() {
        return jenis_hewan;
    }

    public void setJenis_hewan(String jenis_hewan) {
        this.jenis_hewan = jenis_hewan;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus_adopsi() {
        return status_adopsi;
    }

    public void setStatus_adopsi(String status_adopsi) {
        this.status_adopsi = status_adopsi;
    }

    public String getString() {
        return id_hewan + " | " + nama_hewan + " | " + jenis_hewan + " | " + warna +
               " | " + umur + " tahun | " + gender + " | " + status_adopsi;
    }

    public abstract String getSpecial();
}