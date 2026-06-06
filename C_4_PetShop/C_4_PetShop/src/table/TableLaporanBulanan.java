package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.LaporanBulanan;

public class TableLaporanBulanan extends AbstractTableModel{

    private List<LaporanBulanan> list;

    public TableLaporanBulanan(List<LaporanBulanan> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch(columnIndex){

            case 0:
                return list.get(rowIndex).getBulan();

            case 1:
                return list.get(rowIndex).getJumlah_transaksi();

            case 2:
                return list.get(rowIndex).getTotal_pendapatan();

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column){

        switch(column){

            case 0:
                return "Bulan";

            case 1:
                return "Jumlah Transaksi";

            case 2:
                return "Total Pendapatan";

            default:
                return null;
        }
    }
}