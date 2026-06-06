package control;

import dao.CustomerDAO;
import java.util.List;
import model.Customer;

public class CustomerControl {

    private CustomerDAO cDao = new CustomerDAO();

    public void insertData(Customer c){
        cDao.insert(c);
    }

    public List<Customer> showData(String search){
        return cDao.showData(search);
    }

    public void updateData(Customer c, int id){
        cDao.update(c, id);
    }

    public void deleteData(int id){
        cDao.delete(id);
    }

    public Customer searchData(int id){
        return cDao.search(id);
    }

    public List<Customer> showForDropdown(){
        return cDao.IShowForDropdown();
    }
}