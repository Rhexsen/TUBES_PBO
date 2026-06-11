package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.DetailPenjualan;

public class TableDetailPenjualan extends AbstractTableModel{

    private List<DetailPenjualan> list;

    public TableDetailPenjualan(List<DetailPenjualan> list){
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
                return "DP" + list.get(rowIndex).getId_detail();
            case 1:
                return list.get(rowIndex).getId_penjualan();
            case 2:
                return list.get(rowIndex).getId_produk();
            case 3:
                return list.get(rowIndex).getJumlah();
            case 4:
                return list.get(rowIndex).getSubtotal();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column){

        switch(column){
            case 0:
                return "ID Detail";
            case 1:
                return "ID Penjualan";
            case 2:
                return "ID Produk";
            case 3:
                return "Jumlah";
            case 4:
                return "Subtotal";
            default:
                return null;
        }
    }
}