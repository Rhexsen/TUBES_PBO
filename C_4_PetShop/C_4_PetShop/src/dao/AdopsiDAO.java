package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Adopsi;

public class AdopsiDAO implements IDAO<Adopsi, Integer>{

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    @Override
    public void insert(Adopsi data) {

        con = dbCon.makeConnection();

        String sql = "INSERT INTO adopsi "
                   + "(id_customer, id_hewan, tanggal_adopsi, biaya_adopsi) "
                   + "VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, data.getId_customer());
            statement.setInt(2, data.getId_hewan());
            statement.setString(3, data.getTanggal_adopsi());
            statement.setDouble(4, data.getBiaya_adopsi());

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Insert Adopsi...");

        } catch (Exception e) {
            System.out.println("Error Insert Adopsi...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public List<Adopsi> showData(String search) {

        con = dbCon.makeConnection();

        String sql = "SELECT * FROM adopsi a "
                   + "JOIN customer c ON a.id_customer = c.id_customer "
                   + "JOIN hewan h ON a.id_hewan = h.id_hewan "
                   + "WHERE c.nama_customer LIKE ? "
                   + "OR h.nama_hewan LIKE ?";

        List<Adopsi> list = new ArrayList<>();

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");
            statement.setString(2, "%" + search + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                Adopsi a = new Adopsi(
                        rs.getInt("id_adopsi"),
                        rs.getInt("id_customer"),
                        rs.getInt("id_hewan"),
                        rs.getString("tanggal_adopsi"),
                        rs.getDouble("biaya_adopsi")
                );

                list.add(a);
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Fetch Adopsi...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return list;
    }

    @Override
    public void update(Adopsi data, Integer id) {

        con = dbCon.makeConnection();

        String sql = "UPDATE adopsi SET "
                   + "id_customer = ?, "
                   + "id_hewan = ?, "
                   + "tanggal_adopsi = ?, "
                   + "biaya_adopsi = ? "
                   + "WHERE id_adopsi = ?";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, data.getId_customer());
            statement.setInt(2, data.getId_hewan());
            statement.setString(3, data.getTanggal_adopsi());
            statement.setDouble(4, data.getBiaya_adopsi());
            statement.setInt(5, id);

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Update Adopsi...");

        } catch (Exception e) {
            System.out.println("Error Update Adopsi...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public void delete(Integer id) {

        con = dbCon.makeConnection();

        String sql = "DELETE FROM adopsi "
                   + "WHERE id_adopsi = ?";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Delete Adopsi...");

        } catch (Exception e) {
            System.out.println("Error Delete Adopsi...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public Adopsi search(Integer id) {

        con = dbCon.makeConnection();

        String sql = "SELECT * FROM adopsi "
                   + "WHERE id_adopsi = ?";

        Adopsi a = null;

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){

                a = new Adopsi(
                        rs.getInt("id_adopsi"),
                        rs.getInt("id_customer"),
                        rs.getInt("id_hewan"),
                        rs.getString("tanggal_adopsi"),
                        rs.getDouble("biaya_adopsi")
                );
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Search Adopsi...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return a;
    }
}