package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Penjualan;

public class TablePenjualan extends AbstractTableModel{

    private List<Penjualan> list;

    public TablePenjualan(List<Penjualan> list){
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
                return "PJ" + list.get(rowIndex).getId_penjualan();
            case 1:
                return list.get(rowIndex).getId_customer();
            case 2:
                return list.get(rowIndex).getTanggal_penjualan();
            case 3:
                return list.get(rowIndex).getTotal_harga();
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
                return "Tanggal";
            case 3:
                return "Total Harga";
            default:
                return null;
        }
    }
}