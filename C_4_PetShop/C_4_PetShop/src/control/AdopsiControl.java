package control;

import dao.AdopsiDAO;
import java.util.List;
import model.Adopsi;

public class AdopsiControl {

    private AdopsiDAO aDao = new AdopsiDAO();
    private HewanControl hControl = new HewanControl();

    public void insertData(Adopsi a){

        aDao.insert(a);

        hControl.updateStatusAdopsi(
                a.getId_hewan(),
                "Dimiliki"
        );
    }

    public List<Adopsi> showData(String search){
        return aDao.showData(search);
    }

    public void updateData(Adopsi a, int id){
        aDao.update(a, id);
    }

    public void deleteData(int id){
        aDao.delete(id);
    }

    public Adopsi searchData(int id){
        return aDao.search(id);
    }
}