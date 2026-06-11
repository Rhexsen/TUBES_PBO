package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Grooming;

public class TableGrooming extends AbstractTableModel{

    private List<Grooming> list;

    public TableGrooming(List<Grooming> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch(columnIndex){
            case 0:
                return "G" + list.get(rowIndex).getId_grooming();
            case 1:
                return list.get(rowIndex).getId_customer();
            case 2:
                return list.get(rowIndex).getId_hewan();
            case 3:
                return list.get(rowIndex).getTanggal_grooming();
            case 4:
                return list.get(rowIndex).getJenis_layanan();
            case 5:
                return list.get(rowIndex).getHarga();
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
                return "Customer";
            case 2:
                return "Hewan";
            case 3:
                return "Tanggal";
            case 4:
                return "Layanan";
            case 5:
                return "Harga";
            default:
                return null;
        }
    }
}