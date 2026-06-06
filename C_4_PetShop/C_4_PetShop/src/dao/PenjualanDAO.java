package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Penjualan;

public class PenjualanDAO implements IDAO<Penjualan, Integer>{

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    @Override
    public void insert(Penjualan data) {

        con = dbCon.makeConnection();

        String sql = "INSERT INTO penjualan "
                   + "(id_customer, tanggal_penjualan, total_harga) "
                   + "VALUES (?, ?, ?)";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, data.getId_customer());
            statement.setString(2, data.getTanggal_penjualan());
            statement.setDouble(3, data.getTotal_harga());

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Insert Penjualan...");

        } catch (Exception e) {
            System.out.println("Error Insert Penjualan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public List<Penjualan> showData(String search) {

        con = dbCon.makeConnection();

        String sql = "SELECT * FROM penjualan p "
                   + "JOIN customer c ON p.id_customer = c.id_customer "
                   + "WHERE c.nama_customer LIKE ?";

        List<Penjualan> list = new ArrayList<>();

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                Penjualan p = new Penjualan(
                        rs.getInt("id_penjualan"),
                        rs.getInt("id_customer"),
                        rs.getString("tanggal_penjualan"),
                        rs.getDouble("total_harga")
                );

                list.add(p);
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Fetch Penjualan...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return list;
    }

    @Override
    public void update(Penjualan data, Integer id) {

        con = dbCon.makeConnection();

        String sql = "UPDATE penjualan SET "
                   + "id_customer = ?, "
                   + "tanggal_penjualan = ?, "
                   + "total_harga = ? "
                   + "WHERE id_penjualan = ?";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, data.getId_customer());
            statement.setString(2, data.getTanggal_penjualan());
            statement.setDouble(3, data.getTotal_harga());
            statement.setInt(4, id);

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Update Penjualan...");

        } catch (Exception e) {
            System.out.println("Error Update Penjualan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public void delete(Integer id) {

        con = dbCon.makeConnection();

        String sql = "DELETE FROM penjualan "
                   + "WHERE id_penjualan = ?";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Delete Penjualan...");

        } catch (Exception e) {
            System.out.println("Error Delete Penjualan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public Penjualan search(Integer id) {

        con = dbCon.makeConnection();

        String sql = "SELECT * FROM penjualan "
                   + "WHERE id_penjualan = ?";

        Penjualan p = null;

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){

                p = new Penjualan(
                        rs.getInt("id_penjualan"),
                        rs.getInt("id_customer"),
                        rs.getString("tanggal_penjualan"),
                        rs.getDouble("total_harga")
                );
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Search Penjualan...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return p;
    }
}