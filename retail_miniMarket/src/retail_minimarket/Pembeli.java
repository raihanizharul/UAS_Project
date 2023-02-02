/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package retail_minimarket;

/**
 *
 * @author Raihan Izharul
 */
public class Pembeli {
    Pembeli(){
        
    }
    
    public static void insertPembeli() throws Exception{
        Insert_Pelanggan.Masukan_Pelanggan();
    }
    
    public static void deletePembeli(){
        Delete_Pelanggan.Hapus_Pelanggan();
    }
    
    public static void updatePembeli() throws Exception{
        Update_Pelanggan.Pelanggan_Baru();
    }
}


