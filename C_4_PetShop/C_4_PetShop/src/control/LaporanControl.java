package control;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.LaporanBulanan;

public class LaporanControl {

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    public List<LaporanBulanan> showLaporanBulanan(int tahun){

        con = dbCon.makeConnection();

        String sql =
                "SELECT MONTH(tanggal_penjualan) AS bulan, "
                + "COUNT(id_penjualan) AS jumlah_transaksi, "
                + "SUM(total_harga) AS total_pendapatan "
                + "FROM penjualan "
                + "WHERE YEAR(tanggal_penjualan) = ? "
                + "GROUP BY MONTH(tanggal_penjualan)";

        List<LaporanBulanan> list = new ArrayList<>();

        try{

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, tahun);

            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                LaporanBulanan l = new LaporanBulanan(
                        rs.getString("bulan"),
                        rs.getInt("jumlah_transaksi"),
                        rs.getDouble("total_pendapatan")
                );

                list.add(l);
            }

            rs.close();
            statement.close();

        }catch(Exception e){
            System.out.println("Error Report...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return list;
    }
}