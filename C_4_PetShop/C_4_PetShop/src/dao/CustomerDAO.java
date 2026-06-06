package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import interfaceDAO.IShowForDropdown;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerDAO implements IDAO<Customer, Integer>, IShowForDropdown<Customer>{

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    @Override
    public void insert(Customer data) {
        con = dbCon.makeConnection();

        String sql = "INSERT INTO customer(nama_customer, no_telepon, alamat) "
                   + "VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, data.getNama_customer());
            statement.setString(2, data.getNo_telepon());
            statement.setString(3, data.getAlamat());

            statement.executeUpdate();

            System.out.println("Berhasil Insert Data Customer...");

            statement.close();
        } catch (Exception e) {
            System.out.println("Error Insert Data Customer...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public List<Customer> showData(String search) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM customer "
                   + "WHERE nama_customer LIKE ?";

        List<Customer> list = new ArrayList<>();

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                Customer c = new Customer(
                        rs.getInt("id_customer"),
                        rs.getString("nama_customer"),
                        rs.getString("no_telepon"),
                        rs.getString("alamat")
                );

                list.add(c);
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Fetch Data...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return list;
    }

    @Override
    public void update(Customer data, Integer id) {
        con = dbCon.makeConnection();

        String sql = "UPDATE customer SET "
                   + "nama_customer = ?, "
                   + "no_telepon = ?, "
                   + "alamat = ? "
                   + "WHERE id_customer = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, data.getNama_customer());
            statement.setString(2, data.getNo_telepon());
            statement.setString(3, data.getAlamat());
            statement.setInt(4, id);

            statement.executeUpdate();

            System.out.println("Berhasil Update Customer...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Update Customer...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public void delete(Integer id) {
        con = dbCon.makeConnection();

        String sql = "DELETE FROM customer WHERE id_customer = ?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            System.out.println("Berhasil Delete Customer...");

            statement.close();

        } catch (Exception e) {
            System.out.println("Error Delete Customer...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public Customer search(Integer id) {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM customer WHERE id_customer = ?";

        Customer c = null;

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                c = new Customer(
                        rs.getInt("id_customer"),
                        rs.getString("nama_customer"),
                        rs.getString("no_telepon"),
                        rs.getString("alamat")
                );
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Search Customer...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return c;
    }

    @Override
    public List<Customer> IShowForDropdown() {
        return showData("");
    }
}