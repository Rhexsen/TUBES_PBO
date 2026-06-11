package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Penitipan;

public class TablePenitipan extends AbstractTableModel{

    private List<Penitipan> list;

    public TablePenitipan(List<Penitipan> list){
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
                return "PT" + list.get(rowIndex).getId_penitipan();
            case 1:
                return list.get(rowIndex).getId_customer();
            case 2:
                return list.get(rowIndex).getId_hewan();
            case 3:
                return list.get(rowIndex).getTanggal_masuk();
            case 4:
                return list.get(rowIndex).getTanggal_keluar();
            case 5:
                return list.get(rowIndex).getTotal_biaya();
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
                return "Tanggal Masuk";
            case 4:
                return "Tanggal Keluar";
            case 5:
                return "Total Biaya";
            default:
                return null;
        }
    }
}