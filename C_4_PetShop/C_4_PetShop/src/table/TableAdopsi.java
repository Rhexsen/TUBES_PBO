package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Adopsi;

public class TableAdopsi extends AbstractTableModel{

    private List<Adopsi> list;

    public TableAdopsi(List<Adopsi> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch(columnIndex){
            case 0:
                return "A" + list.get(rowIndex).getId_adopsi();
            case 1:
                return list.get(rowIndex).getId_customer();
            case 2:
                return list.get(rowIndex).getId_hewan();
            case 3:
                return list.get(rowIndex).getTanggal_adopsi();
            case 4:
                return list.get(rowIndex).getBiaya_adopsi();
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
                return "Biaya";
            default:
                return null;
        }
    }
}