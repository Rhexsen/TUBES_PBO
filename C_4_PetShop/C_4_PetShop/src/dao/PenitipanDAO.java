package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Penitipan;

public class PenitipanDAO implements IDAO<Penitipan, Integer>{

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    @Override
    public void insert(Penitipan data) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO penitipan "
                   + "(id_customer, id_hewan, tanggal_masuk, tanggal_keluar, total_biaya) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, data.getId_customer());
            statement.setInt(2, data.getId_hewan());
            statement.setString(3, data.getTanggal_masuk());
            statement.setString(4, data.getTanggal_keluar());
            statement.setDouble(5, data.getTotal_biaya());

            statement.executeUpdate();

            System.out.println("Berhasil Insert Penitipan...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Insert Penitipan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public List<Penitipan> showData(String search) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM penitipan p "
                   + "JOIN customer c ON p.id_customer = c.id_customer "
                   + "JOIN hewan h ON p.id_hewan = h.id_hewan "
                   + "WHERE c.nama_customer LIKE ? "
                   + "OR h.nama_hewan LIKE ?";

        List<Penitipan> list = new ArrayList<>();

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");
            statement.setString(2, "%" + search + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                Penitipan p = new Penitipan(
                        rs.getInt("id_penitipan"),
                        rs.getInt("id_customer"),
                        rs.getInt("id_hewan"),
                        rs.getString("tanggal_masuk"),
                        rs.getString("tanggal_keluar"),
                        rs.getDouble("total_biaya")
                );

                list.add(p);
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Fetch Penitipan...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return list;
    }

    @Override
    public void update(Penitipan data, Integer id) {
        con = dbCon.makeConnection();

        String sql = "UPDATE penitipan SET "
                   + "id_customer = ?, "
                   + "id_hewan = ?, "
                   + "tanggal_masuk = ?, "
                   + "tanggal_keluar = ?, "
                   + "total_biaya = ? "
                   + "WHERE id_penitipan = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, data.getId_customer());
            statement.setInt(2, data.getId_hewan());
            statement.setString(3, data.getTanggal_masuk());
            statement.setString(4, data.getTanggal_keluar());
            statement.setDouble(5, data.getTotal_biaya());
            statement.setInt(6, id);

            statement.executeUpdate();

            System.out.println("Berhasil Update Penitipan...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Update Penitipan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public void delete(Integer id) {
        con = dbCon.makeConnection();

        String sql = "DELETE FROM penitipan "
                   + "WHERE id_penitipan = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Berhasil Delete Penitipan...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Delete Penitipan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public Penitipan search(Integer id) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM penitipan "
                   + "WHERE id_penitipan = ?";

        Penitipan p = null;

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                p = new Penitipan(
                        rs.getInt("id_penitipan"),
                        rs.getInt("id_customer"),
                        rs.getInt("id_hewan"),
                        rs.getString("tanggal_masuk"),
                        rs.getString("tanggal_keluar"),
                        rs.getDouble("total_biaya")
                );
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Search Penitipan...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return p;
    }
}