package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produk;

public class TableProduk extends AbstractTableModel{

    private List<Produk> list;

    public TableProduk(List<Produk> list){
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
                return "PR" + list.get(rowIndex).getId_produk();
            case 1:
                return list.get(rowIndex).getNama_produk();
            case 2:
                return list.get(rowIndex).getKategori();
            case 3:
                return list.get(rowIndex).getHarga();
            case 4:
                return list.get(rowIndex).getStok();
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
                return "Nama Produk";
            case 2:
                return "Kategori";
            case 3:
                return "Harga";
            case 4:
                return "Stok";
            default:
                return null;
        }
    }
}