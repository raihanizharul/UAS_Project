/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retail_minimarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
/**
 *
 * @author Raihan Izharul
 */
public class Delete_Barang extends Exception{
    static String jdbc = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/retail";
    static String username = "root";
    static String password = "";
    
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;
    
    public static void Hapus_Barang(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=============== DELETE BARANG ==================");
        System.out.print("Nama Barang : ");
        String Barang = sc.nextLine();
        
        try{
            Class.forName(jdbc);
            con = DriverManager.getConnection(url, username, password);
            
            String query = "delete FROM barang WHERE nama_barang=?";
            ps = con.prepareStatement(query);
            ps.setString(1, Barang);
            
            if(ps.executeUpdate() > 0){
                System.out.println("Proses Delete Berhasil");
            }
            else{
                System.out.println("Data Tidak Ditemukan");
                Menu.MenuBarang();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }  
    }
}
