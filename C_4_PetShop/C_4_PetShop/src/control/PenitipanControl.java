package control;

import dao.PenitipanDAO;
import java.util.List;
import model.Penitipan;

public class PenitipanControl {

    private PenitipanDAO pDao = new PenitipanDAO();

    public void insertData(Penitipan p){
        pDao.insert(p);
    }

    public List<Penitipan> showData(String search){
        return pDao.showData(search);
    }

    public void updateData(Penitipan p, int id){
        pDao.update(p, id);
    }

    public void deleteData(int id){
        pDao.delete(id);
    }

    public Penitipan searchData(int id){
        return pDao.search(id);
    }
}