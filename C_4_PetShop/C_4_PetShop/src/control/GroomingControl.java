package control;

import dao.GroomingDAO;
import java.util.List;
import model.Grooming;

public class GroomingControl {

    private GroomingDAO gDao = new GroomingDAO();

    public void insertData(Grooming g){
        gDao.insert(g);
    }

    public List<Grooming> showData(String search){
        return gDao.showData(search);
    }

    public void updateData(Grooming g, int id){
        gDao.update(g, id);
    }

    public void deleteData(int id){
        gDao.delete(id);
    }

    public Grooming searchData(int id){
        return gDao.search(id);
    }
}