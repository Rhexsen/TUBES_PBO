package control;

import dao.HewanDAO;
import java.util.List;
import model.Hewan;

public class HewanControl {

    private HewanDAO hDao = new HewanDAO();

    public void insertData(Hewan h){
        hDao.insert(h);
    }

    public List<Hewan> showData(String search){
        return hDao.showData(search);
    }

    public void updateData(Hewan h, int id){
        hDao.update(h, id);
    }

    public void deleteData(int id){
        hDao.delete(id);
    }

    public Hewan searchData(int id){
        return hDao.search(id);
    }

    public List<Hewan> showForDropdown(){
        return hDao.IShowForDropdown();
    }

    public void updateStatusAdopsi(int idHewan, String status){
        hDao.updateStatusAdopsi(idHewan, status);
    }
}