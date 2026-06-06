package control;

import dao.ProdukDAO;
import java.util.List;
import model.Produk;

public class ProdukControl {

    private ProdukDAO pDao = new ProdukDAO();

    public void insertData(Produk p){
        pDao.insert(p);
    }

    public List<Produk> showData(String search){
        return pDao.showData(search);
    }

    public void updateData(Produk p, int id){
        pDao.update(p, id);
    }

    public void deleteData(int id){
        pDao.delete(id);
    }

    public Produk searchData(int id){
        return pDao.search(id);
    }

    public List<Produk> showForDropdown(){
        return pDao.IShowForDropdown();
    }

    public void updateStok(int idProduk, int jumlah){
        pDao.updateStok(idProduk, jumlah);
    }

    public int cekStok(int idProduk){
        return pDao.cekStok(idProduk);
    }
}