
package interfaceDAO;

public interface IProdukDAO {
    public void updateStok(int idProduk, int jumlah);
    public int cekStok(int idProduk);
}
