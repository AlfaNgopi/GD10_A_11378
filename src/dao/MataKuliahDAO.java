/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import connection.DbConnection;
import java.util.ArrayList;
import java.util.List;
import model.Dosen;
import model.MataKuliah;

/**
 *
 * @author ASUS
 */
public class MataKuliahDAO {
    private DbConnection dbCON = new DbConnection();
    private Connection CON;
    
    
    
    public void insertMataKuliah(MataKuliah d){
        CON = dbCON.makeConnection();
        
        String sql = "INSERT INTO mata_kuliah(nomor_induk_dosen, nama, deskripsi, metode_pembelajaran, kelas"
                + "VALUES ('"+d.getDosen().getNomerIndukDosen()+"','"+d.getNama()+"','"+d.getDeskripsi()+"','"
                +d.getMetode_pembelajaran()+"','"+d.getKelas()+"')";
        
        System.out.println("Adding MataKuliah....");
        
        try{
            Statement statement = CON.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("added "+ result +" Mata Kuliah");
            statement.close();
            
        }catch(Exception e){
            System.out.println("Error Adding Mata Kuliah....");
            System.out.println(e);
        }
        
        dbCON.closeConnection();
        
    }
    
    public List<MataKuliah> showMataKuliah(String query){
        CON = dbCON.makeConnection();
        String sql = "SELECT mk.*, d.* FROM mata_kuliah as mk JOIN dosen as d d.nomor_induk_dosen = mk.nomor_induk_dosen WHERE (mk.nama LIKE "
        + "'%" + query + "%'"
        + "OR mk.deskripsi LIKE '$" + query + "%'"
        + "OR mk.metode_pembelajaran LIKE '$" + query + "%'"
        + "OR mk.kelas LIKE '%" + query + "%'"
        + "OR d.nama LIKE '%" + query + "&')";
        
        
        
        System.out.println("mengambil data dosen ....");
        
        List<MataKuliah> list = new ArrayList();
        
        try{
            Statement statement = CON.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while(rs.next()){
                    Dosen d = new Dosen(
                            rs.getString("d.nomor_induk_dosen"),
                            rs.getString("d.nama"),
                            rs.getString("d.email"),
                            rs.getString("d.no_handphone")
                    );
                    
                    MataKuliah mk = new MataKuliah(
                            Integer.parseInt(rs.getString("mk.id") ),
                            rs.getString("mk.nama"),
                            rs.getString("mk.deskripsi"),
                            rs.getString("mk.metode_pembelajaran"),
                            rs.getString("mk.kelas"),
                            d
                    );
                    
                    list.add(mk);
                }
            }
            
            rs.close();
            statement.close();
            
            
            
        }catch(Exception e){
            System.out.println("Error Reading Database ...");
        }
        dbCON.closeConnection();
        
        return list;
    }
    
   
    
    public void updateMataKuliah(MataKuliah mk){
        CON = dbCON.makeConnection();
        String sql = "UPDATE mata_kuliah SET nomor_induk_dosen = '" + mk.getDosen().getNomerIndukDosen() + "', "
                + "nama = '" + mk.getNama() + "' , "
                + "deskripsi = '" + mk.getDeskripsi()+ "',"
                + "metode_pembelajaran = '" + mk.getMetode_pembelajaran()+ "'"
                + "WHERE id = '" + mk.getId() + "'";
        
        System.out.println("updating mata kuliah ....");
        
        
        try{
            Statement statement = CON.createStatement();
            int rs = statement.executeUpdate(sql);
            
            System.out.println("Edited "+ rs +" Mata Kuliah  " + mk.getId());
            
            
            statement.close();
            
            
            
        }catch(Exception e){
            System.out.println("Error editing Database ...");
        }
        dbCON.closeConnection();
        
    }
    
    public void deleteMataKuliah(int id){
        CON = dbCON.makeConnection();
        String sql = "DELETE FROM mata_kuliah "
                + "WHERE id = '" + id + "'";
        
        System.out.println("deleting mata kuliah ....");
        
        
        try{
            Statement statement = CON.createStatement();
            int rs = statement.executeUpdate(sql);
            
            System.out.println("Deleted "+ rs +" mata kuliah " + id);
            
            
            statement.close();
            
            
            
        }catch(Exception e){
            System.out.println("Error deleting Database ...");
        }
        dbCON.closeConnection();
    }
    
}
