/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retail_minimarket;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static retail_minimarket.Kasir.con;

/**
 *
 * @author Raihan Izharul
 */
public class Transaksi {
    static String jdbc = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost/retail";
    static String username = "root";
    static String password = "";
    
    static Connection conn;
    static ResultSet rs;
    static PreparedStatement ps;
    
    public static void Transaksi()throws Exception {
        Scanner sc = new Scanner(System.in);
        
        
        try{
            System.out.println("=============== Transaksi ==================");
        System.out.print("Id Transaksi : ");
        int id_transaksi=sc.nextInt();
        System.out.print("Nama Pembeli : ");
        String nama_pembeli = sc.next();
        System.out.print("Barang yang ingin dibeli : ");
        String nama_barang= sc.next();
        System.out.print("Jumlah : ");
        int jumlah= sc.nextInt();
        int harga=Integer.parseInt(Transaksi.getHarga(nama_barang))*jumlah;
        System.out.println("\nNama Barang yang dibeli : "+nama_barang);
        System.out.println("Jumlah : "+jumlah);
        System.out.println("total harga : "+harga);
        
          Class.forName(jdbc);
          conn= DriverManager.getConnection(url,username,password);
          String query= "insert into transaksi values (?,?,?,?,?)";
          ps= conn.prepareStatement(query);
          ps.setInt(1, id_transaksi);
          ps.setString(2, nama_pembeli);
          ps.setString(3, nama_barang);
          ps.setInt(4, jumlah);
          ps.setInt(5, harga);
          
          if(ps.executeUpdate()>0){
              System.out.println("Proses Transaksi berhasil");   
          
          }
        else{
              System.out.println("Proses transaksi gagal");
          }
        }
        catch(Exception ex){
            System.out.println("INPUT TIDAK VALID");
            Transaksi.MenuTransaksi();
        }
        Transaksi.MenuTransaksi();
        
    }
    public static void MenuTransaksi() throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("\nLakukan transaksi kembali?(Y/N): ");
        String ulangTransaksi=sc.next();
        if(ulangTransaksi.equalsIgnoreCase("y")){
            Transaksi.Transaksi();
        }
        else if(ulangTransaksi.equalsIgnoreCase("n")){
            Menu.MenuUtama();
        }
        else{
            Transaksi.MenuTransaksi();
        }
    }
    public static String getHarga(String nama_barang) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "SELECT harga FROM barang WHERE nama_barang= (?)";
        ps = con.prepareStatement(query);
        ps.setString(1, nama_barang);
        rs = ps.executeQuery();
        
        if(!rs.next()){
            return "INPUT TIDAK VALID";
        }
        else{
            return rs.getString(1).toString();
        }
    }
}
