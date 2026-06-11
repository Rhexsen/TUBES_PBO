package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Hewan;

public class TableHewan extends AbstractTableModel{

    private List<Hewan> list;

    public TableHewan(List<Hewan> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch(columnIndex){
            case 0:
                return "H" + list.get(rowIndex).getId_hewan();
            case 1:
                return list.get(rowIndex).getNama_hewan();
            case 2:
                return list.get(rowIndex).getJenis_hewan();
            case 3:
                return list.get(rowIndex).getWarna();
            case 4:
                return list.get(rowIndex).getUmur();
            case 5:
                return list.get(rowIndex).getGender();
            case 6:
                return list.get(rowIndex).getStatus_adopsi();
            case 7:
                return list.get(rowIndex).getSpecial();
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
                return "Jenis";
            case 3:
                return "Warna";
            case 4:
                return "Umur";
            case 5:
                return "Gender";
            case 6:
                return "Status";
            case 7:
                return "Atribut Khusus";
            default:
                return null;
        }
    }
}