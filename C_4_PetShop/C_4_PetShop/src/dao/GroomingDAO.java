package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Grooming;

public class GroomingDAO implements IDAO<Grooming, Integer>{

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    @Override
    public void insert(Grooming data) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO grooming "
                   + "(id_customer, id_hewan, tanggal_grooming, jenis_layanan, harga) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, data.getId_customer());
            statement.setInt(2, data.getId_hewan());
            statement.setString(3, data.getTanggal_grooming());
            statement.setString(4, data.getJenis_layanan());
            statement.setDouble(5, data.getHarga());

            statement.executeUpdate();

            System.out.println("Berhasil Insert Grooming...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Insert Grooming...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public List<Grooming> showData(String search) {
        con = dbCon.makeConnection();
        //show pake join karena lebih enak nyari nama customer sama nama hewan
        String sql = "SELECT * FROM grooming g "
                   + "JOIN customer c ON g.id_customer = c.id_customer "
                   + "JOIN hewan h ON g.id_hewan = h.id_hewan "
                   + "WHERE c.nama_customer LIKE ? "
                   + "OR h.nama_hewan LIKE ?";

        List<Grooming> list = new ArrayList<>();

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");
            statement.setString(2, "%" + search + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                Grooming g = new Grooming(
                        rs.getInt("id_grooming"),
                        rs.getInt("id_customer"),
                        rs.getInt("id_hewan"),
                        rs.getString("tanggal_grooming"),
                        rs.getString("jenis_layanan"),
                        rs.getDouble("harga")
                );

                list.add(g);
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Fetch Grooming...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return list;
    }

    @Override
    public void update(Grooming data, Integer id) {
        con = dbCon.makeConnection();

        String sql = "UPDATE grooming SET "
                   + "id_customer = ?, "
                   + "id_hewan = ?, "
                   + "tanggal_grooming = ?, "
                   + "jenis_layanan = ?, "
                   + "harga = ? "
                   + "WHERE id_grooming = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, data.getId_customer());
            statement.setInt(2, data.getId_hewan());
            statement.setString(3, data.getTanggal_grooming());
            statement.setString(4, data.getJenis_layanan());
            statement.setDouble(5, data.getHarga());
            statement.setInt(6, id);

            statement.executeUpdate();

            System.out.println("Berhasil Update Grooming...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Update Grooming...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public void delete(Integer id) {
        con = dbCon.makeConnection();

        String sql = "DELETE FROM grooming "
                   + "WHERE id_grooming = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Berhasil Delete Grooming...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Delete Grooming...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public Grooming search(Integer id) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM grooming "
                   + "WHERE id_grooming = ?";

        Grooming g = null;

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                g = new Grooming(
                        rs.getInt("id_grooming"),
                        rs.getInt("id_customer"),
                        rs.getInt("id_hewan"),
                        rs.getString("tanggal_grooming"),
                        rs.getString("jenis_layanan"),
                        rs.getDouble("harga")
                );
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Search Grooming...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return g;
    }
}