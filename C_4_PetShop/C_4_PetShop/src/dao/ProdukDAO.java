package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import interfaceDAO.IProdukDAO;
import interfaceDAO.IShowForDropdown;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Produk;

public class ProdukDAO implements 
        IDAO<Produk, Integer>,
        IShowForDropdown<Produk>,
        IProdukDAO {

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    @Override
    public void insert(Produk data) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO produk(nama_produk, kategori, harga, stok) "
                   + "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, data.getNama_produk());
            statement.setString(2, data.getKategori());
            statement.setDouble(3, data.getHarga());
            statement.setInt(4, data.getStok());

            statement.executeUpdate();

            System.out.println("Berhasil Insert Produk...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Insert Produk...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public List<Produk> showData(String search) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM produk "
                   + "WHERE nama_produk LIKE ?";

        List<Produk> list = new ArrayList<>();

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                Produk p = new Produk(
                        rs.getInt("id_produk"),
                        rs.getString("nama_produk"),
                        rs.getString("kategori"),
                        rs.getDouble("harga"),
                        rs.getInt("stok")
                );

                list.add(p);
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Fetch Produk...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return list;
    }

    @Override
    public void update(Produk data, Integer id) {
        con = dbCon.makeConnection();

        String sql = "UPDATE produk SET "
                   + "nama_produk = ?, "
                   + "kategori = ?, "
                   + "harga = ?, "
                   + "stok = ? "
                   + "WHERE id_produk = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, data.getNama_produk());
            statement.setString(2, data.getKategori());
            statement.setDouble(3, data.getHarga());
            statement.setInt(4, data.getStok());
            statement.setInt(5, id);

            statement.executeUpdate();

            System.out.println("Berhasil Update Produk...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Update Produk...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public void delete(Integer id) {
        con = dbCon.makeConnection();

        String sql = "DELETE FROM produk WHERE id_produk = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Berhasil Delete Produk...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Delete Produk...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public Produk search(Integer id) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM produk WHERE id_produk = ?";

        Produk p = null;

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                p = new Produk(
                        rs.getInt("id_produk"),
                        rs.getString("nama_produk"),
                        rs.getString("kategori"),
                        rs.getDouble("harga"),
                        rs.getInt("stok")
                );
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Search Produk...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return p;
    }

    @Override
    public List<Produk> IShowForDropdown() {
        return showData("");
    }

    @Override
    public void updateStok(int idProduk, int jumlah) {
        con = dbCon.makeConnection();

        String sql = "UPDATE produk SET stok = stok - ? "
                   + "WHERE id_produk = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, jumlah);
            statement.setInt(2, idProduk);

            statement.executeUpdate();

            System.out.println("Berhasil Update Stok...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Update Stok...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public int cekStok(int idProduk) {
        con = dbCon.makeConnection();

        String sql = "SELECT stok FROM produk "
                   + "WHERE id_produk = ?";

        int stok = 0;

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, idProduk);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                stok = rs.getInt("stok");
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Cek Stok...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return stok;
    }
}