/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook.application;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

/**
 *
 * @author bangadam
 */
public class DokterServices {
   private Connection connection;
   private PreparedStatement preparedStatement;
   private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
   
    public List<Dokter> getAll(int halaman, int banyakBaris) {
        List<Dokter> listDokter = new ArrayList<Dokter>();
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("SELECT * FROM dokter limit ?,?");
            preparedStatement.setInt(1, banyakBaris*(halaman-1));
            preparedStatement.setInt(2, banyakBaris);
            ResultSet res = preparedStatement.executeQuery();
            
            while (res.next()) {                
                Dokter dk = new Dokter();
                dk.setId(res.getLong("id"));
                dk.setNama(res.getString("nama"));
                dk.setAlamat(res.getString("alamat"));
                dk.setNo_hp_1(res.getString("no_hp_1"));
                dk.setNo_hp_2(res.getString("no_hp_2"));
                listDokter.add(dk);
            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException eRollBack) {
                eRollBack.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException close) {
                close.printStackTrace();
            }
            return listDokter;
        }
    }
    
    public int count() {
        int jumlahBaris=0;
        
        try{
            connection=dataSource.getConnection();
            connection.setAutoCommit(false);
            preparedStatement=connection.prepareStatement("SELECT count(id) from dokter");
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                jumlahBaris=rs.getInt("count(id)");
            }
            
            connection.commit();
            connection.setAutoCommit(true);
            
        }catch(SQLException ex){
            ex.printStackTrace();
            try{
                connection.rollback();
            }catch(SQLException exRollBack){
                exRollBack.printStackTrace();
            }
        }finally{
            try{
                connection.close();
            }catch(SQLException exClose){
                exClose.printStackTrace();
            }
            return jumlahBaris;
        }
    }
        
}
