package control;

import dao.PenjualanDAO;
import java.util.List;
import model.Penjualan;

public class PenjualanControl {

    private PenjualanDAO pDao = new PenjualanDAO();

    public void insertData(Penjualan p){
        pDao.insert(p);
    }

    public List<Penjualan> showData(String search){
        return pDao.showData(search);
    }

    public void updateData(Penjualan p, int id){
        pDao.update(p, id);
    }

    public void deleteData(int id){
        pDao.delete(id);
    }

    public Penjualan searchData(int id){
        return pDao.search(id);
    }
}