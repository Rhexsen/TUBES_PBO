package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DetailPenjualan;

public class DetailPenjualanDAO implements IDAO<DetailPenjualan, Integer>{

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    @Override
    public void insert(DetailPenjualan data) {

        con = dbCon.makeConnection();

        String sql = "INSERT INTO detail_penjualan "
                   + "(id_penjualan, id_produk, jumlah, subtotal) "
                   + "VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, data.getId_penjualan());
            statement.setInt(2, data.getId_produk());
            statement.setInt(3, data.getJumlah());
            statement.setDouble(4, data.getSubtotal());

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Insert Detail Penjualan...");

        } catch (Exception e) {
            System.out.println("Error Insert Detail Penjualan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public List<DetailPenjualan> showData(String search) {

        con = dbCon.makeConnection();

        String sql = "SELECT * FROM detail_penjualan dp "
                   + "JOIN penjualan p ON dp.id_penjualan = p.id_penjualan "
                   + "JOIN produk pr ON dp.id_produk = pr.id_produk "
                   + "WHERE pr.nama_produk LIKE ?";

        List<DetailPenjualan> list = new ArrayList<>();

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                DetailPenjualan dp = new DetailPenjualan(
                        rs.getInt("id_detail"),
                        rs.getInt("id_penjualan"),
                        rs.getInt("id_produk"),
                        rs.getInt("jumlah"),
                        rs.getDouble("subtotal")
                );

                list.add(dp);
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Fetch Detail Penjualan...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return list;
    }

    @Override
    public void update(DetailPenjualan data, Integer id) {

        con = dbCon.makeConnection();

        String sql = "UPDATE detail_penjualan SET "
                   + "id_penjualan = ?, "
                   + "id_produk = ?, "
                   + "jumlah = ?, "
                   + "subtotal = ? "
                   + "WHERE id_detail = ?";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, data.getId_penjualan());
            statement.setInt(2, data.getId_produk());
            statement.setInt(3, data.getJumlah());
            statement.setDouble(4, data.getSubtotal());
            statement.setInt(5, id);

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Update Detail Penjualan...");

        } catch (Exception e) {
            System.out.println("Error Update Detail Penjualan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public void delete(Integer id) {

        con = dbCon.makeConnection();

        String sql = "DELETE FROM detail_penjualan "
                   + "WHERE id_detail = ?";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Delete Detail Penjualan...");

        } catch (Exception e) {
            System.out.println("Error Delete Detail Penjualan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public DetailPenjualan search(Integer id) {

        con = dbCon.makeConnection();

        String sql = "SELECT * FROM detail_penjualan "
                   + "WHERE id_detail = ?";

        DetailPenjualan dp = null;

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){

                dp = new DetailPenjualan(
                        rs.getInt("id_detail"),
                        rs.getInt("id_penjualan"),
                        rs.getInt("id_produk"),
                        rs.getInt("jumlah"),
                        rs.getDouble("subtotal")
                );
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Search Detail Penjualan...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return dp;
    }
}