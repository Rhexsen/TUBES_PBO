package control;

import dao.DetailPenjualanDAO;
import java.util.List;
import model.DetailPenjualan;

public class DetailPenjualanControl {

    private DetailPenjualanDAO dpDao = new DetailPenjualanDAO();
    private ProdukControl pControl = new ProdukControl();

    public void insertData(DetailPenjualan dp){

        dpDao.insert(dp);

        pControl.updateStok(
                dp.getId_produk(),
                dp.getJumlah()
        );
    }

    public List<DetailPenjualan> showData(String search){
        return dpDao.showData(search);
    }

    public void updateData(DetailPenjualan dp, int id){
        dpDao.update(dp, id);
    }

    public void deleteData(int id){
        dpDao.delete(id);
    }

    public DetailPenjualan searchData(int id){
        return dpDao.search(id);
    }
}