/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak20;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class isi_tabel {
    
    public static void main(String[] args){
        String user = "root";
        String pass ="";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/prak20";
            
            Connection conn = DriverManager.getConnection(url ,user,pass );
            
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery("Select * from tbl_test");
            
            while (rs.next()){
                System.out.println("Nama    : " + rs.getString("Indri"));
                System.out.println("Jurusan : " +rs.getString("SI"));
                System.out.println("Alamat  : " +rs.getString("STMIK DIPANEGARA"));
            }
            st.close();
            conn.close();
        }
        catch(SQLException e){
            System.out.println("Koneksi Gagal" + e.toString());
        }
        catch (ClassNotFoundException e){
            System.out.println("jdbc.Driver tidak ditemukan");
        }
    }
}
