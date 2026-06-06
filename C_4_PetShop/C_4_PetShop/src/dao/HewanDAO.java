package dao;

import connection.DbConnection;
import interfaceDAO.IDAO;
import interfaceDAO.IHewanDAO;
import interfaceDAO.IShowForDropdown;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Anjing;
import model.Hewan;
import model.Kucing;

public class HewanDAO implements 
        IDAO<Hewan, Integer>,
        IShowForDropdown<Hewan>,
        IHewanDAO{

    private DbConnection dbCon = new DbConnection();
    private Connection con;

    @Override
    public void insert(Hewan data) {

        con = dbCon.makeConnection();

        String sql = "INSERT INTO hewan "
                   + "(id_customer, nama_hewan, jenis_hewan, warna, umur, gender, status_adopsi) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement statement = con.prepareStatement(
                    sql,
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            if(data.getId_customer() == null){
                statement.setNull(1, java.sql.Types.INTEGER);
            }else{
                statement.setInt(1, data.getId_customer());
            }

            statement.setString(2, data.getNama_hewan());
            statement.setString(3, data.getJenis_hewan());
            statement.setString(4, data.getWarna());
            statement.setInt(5, data.getUmur());
            statement.setString(6, data.getGender());
            statement.setString(7, data.getStatus_adopsi());

            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            int generatedId = 0;

            if(rs.next()){
                generatedId = rs.getInt(1);
            }

            if(data instanceof Kucing){

                String sqlKucing = "INSERT INTO kucing(id_hewan, jenis_bulu) "
                                 + "VALUES (?, ?)";

                PreparedStatement psKucing = con.prepareStatement(sqlKucing);

                psKucing.setInt(1, generatedId);
                psKucing.setString(2, ((Kucing)data).getJenis_bulu());

                psKucing.executeUpdate();

                psKucing.close();

            }else if(data instanceof Anjing){

                String sqlAnjing = "INSERT INTO anjing(id_hewan, ras) "
                                 + "VALUES (?, ?)";

                PreparedStatement psAnjing = con.prepareStatement(sqlAnjing);

                psAnjing.setInt(1, generatedId);
                psAnjing.setString(2, ((Anjing)data).getRas());

                psAnjing.executeUpdate();

                psAnjing.close();
            }

            rs.close();
            statement.close();

            System.out.println("Berhasil Insert Hewan...");

        } catch (Exception e) {
            System.out.println("Error Insert Hewan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public List<Hewan> showData(String search) {

        con = dbCon.makeConnection();

        String sql = "SELECT * FROM hewan h "
                   + "LEFT JOIN kucing k ON h.id_hewan = k.id_hewan "
                   + "LEFT JOIN anjing a ON h.id_hewan = a.id_hewan "
                   + "WHERE h.nama_hewan LIKE ?";

        List<Hewan> list = new ArrayList<>();

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, "%" + search + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){

                Hewan h;

                String jenis = rs.getString("jenis_hewan");

                if(jenis.equalsIgnoreCase("Kucing")){

                    h = new Kucing(
                            rs.getInt("id_hewan"),
                            rs.getString("jenis_bulu"),
                            (Integer)rs.getObject("id_customer"),
                            rs.getString("nama_hewan"),
                            jenis,
                            rs.getString("warna"),
                            rs.getInt("umur"),
                            rs.getString("gender"),
                            rs.getString("status_adopsi")
                    );

                }else{

                    h = new Anjing(
                            rs.getInt("id_hewan"),
                            rs.getString("ras"),
                            (Integer)rs.getObject("id_customer"),
                            rs.getString("nama_hewan"),
                            jenis,
                            rs.getString("warna"),
                            rs.getInt("umur"),
                            rs.getString("gender"),
                            rs.getString("status_adopsi")
                    );
                }

                list.add(h);
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Fetch Hewan...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return list;
    }

    @Override
    public void update(Hewan data, Integer id) {

        con = dbCon.makeConnection();

        String sql = "UPDATE hewan SET "
                   + "id_customer = ?, "
                   + "nama_hewan = ?, "
                   + "jenis_hewan = ?, "
                   + "warna = ?, "
                   + "umur = ?, "
                   + "gender = ?, "
                   + "status_adopsi = ? "
                   + "WHERE id_hewan = ?";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            if(data.getId_customer() == null){
                statement.setNull(1, java.sql.Types.INTEGER);
            }else{
                statement.setInt(1, data.getId_customer());
            }

            statement.setString(2, data.getNama_hewan());
            statement.setString(3, data.getJenis_hewan());
            statement.setString(4, data.getWarna());
            statement.setInt(5, data.getUmur());
            statement.setString(6, data.getGender());
            statement.setString(7, data.getStatus_adopsi());
            statement.setInt(8, id);

            statement.executeUpdate();

            if(data instanceof Kucing){

                String sqlKucing = "UPDATE kucing SET jenis_bulu = ? "
                                 + "WHERE id_hewan = ?";

                PreparedStatement psKucing = con.prepareStatement(sqlKucing);

                psKucing.setString(1, ((Kucing)data).getJenis_bulu());
                psKucing.setInt(2, id);

                psKucing.executeUpdate();

                psKucing.close();

            }else if(data instanceof Anjing){

                String sqlAnjing = "UPDATE anjing SET ras = ? "
                                 + "WHERE id_hewan = ?";

                PreparedStatement psAnjing = con.prepareStatement(sqlAnjing);

                psAnjing.setString(1, ((Anjing)data).getRas());
                psAnjing.setInt(2, id);

                psAnjing.executeUpdate();

                psAnjing.close();
            }

            statement.close();

            System.out.println("Berhasil Update Hewan...");

        } catch (Exception e) {
            System.out.println("Error Update Hewan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public void delete(Integer id) {

        con = dbCon.makeConnection();

        String sql = "DELETE FROM hewan WHERE id_hewan = ?";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Delete Hewan...");

        } catch (Exception e) {
            System.out.println("Error Delete Hewan...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }

    @Override
    public Hewan search(Integer id) {

        con = dbCon.makeConnection();

        String sql = "SELECT * FROM hewan h "
                   + "LEFT JOIN kucing k ON h.id_hewan = k.id_hewan "
                   + "LEFT JOIN anjing a ON h.id_hewan = a.id_hewan "
                   + "WHERE h.id_hewan = ?";

        Hewan h = null;

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){

                String jenis = rs.getString("jenis_hewan");

                if(jenis.equalsIgnoreCase("Kucing")){

                    h = new Kucing(
                            rs.getInt("id_hewan"),
                            rs.getString("jenis_bulu"),
                            (Integer)rs.getObject("id_customer"),
                            rs.getString("nama_hewan"),
                            jenis,
                            rs.getString("warna"),
                            rs.getInt("umur"),
                            rs.getString("gender"),
                            rs.getString("status_adopsi")
                    );

                }else{

                    h = new Anjing(
                            rs.getInt("id_hewan"),
                            rs.getString("ras"),
                            (Integer)rs.getObject("id_customer"),
                            rs.getString("nama_hewan"),
                            jenis,
                            rs.getString("warna"),
                            rs.getInt("umur"),
                            rs.getString("gender"),
                            rs.getString("status_adopsi")
                    );
                }
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Error Search Hewan...");
            System.out.println(e);
        }

        dbCon.closeConnection();

        return h;
    }

    @Override
    public List<Hewan> IShowForDropdown() {
        return showData("");
    }

    @Override
    public void updateStatusAdopsi(int idHewan, String status) {

        con = dbCon.makeConnection();

        String sql = "UPDATE hewan SET status_adopsi = ? "
                   + "WHERE id_hewan = ?";

        try {

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, status);
            statement.setInt(2, idHewan);

            statement.executeUpdate();

            statement.close();

            System.out.println("Berhasil Update Status Adopsi...");

        } catch (Exception e) {
            System.out.println("Error Update Status...");
            System.out.println(e);
        }

        dbCon.closeConnection();
    }
}