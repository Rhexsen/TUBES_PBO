package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Customer;

public class TableCustomer extends AbstractTableModel{

    private List<Customer> list;

    public TableCustomer(List<Customer> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch(columnIndex){
            case 0:
                return "C" + list.get(rowIndex).getId_customer();
            case 1:
                return list.get(rowIndex).getNama_customer();
            case 2:
                return list.get(rowIndex).getNo_telepon();
            case 3:
                return list.get(rowIndex).getAlamat();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "No Telepon";
            case 3:
                return "Alamat";
            default:
                return null;
        }
    }
}