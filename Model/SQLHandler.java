/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xtir0
 */
public class SQLHandler {

    public ConnectSQL conn = new ConnectSQL();

    public SQLHandler() {
        conn.connect();
    }

    public ResultSet getDataDT() {
        String query = "select * from dienthoai";
        return conn.getData(query);
    }

    public ResultSet getDataIdProductId(int id) {
        String query = "select * from dienthoai where id = '" + id + "'";
        return conn.getData(query);
    }

    public void insertProduct(String tendt, String hangdt, double gia) {
        String query = "insert into dienthoai(tendt, hangdt, gia) values(N'" + tendt + "', N'" + hangdt + "', " + gia + ")";
        conn.excute(query);
    }

    public void deleteProduct(int id) {
        String query = "delete from dienthoai where id = '" + id + "'";
        conn.excute(query);
    }
    
    
    public void updateProduct(int id, String tendt, String hangdt, double gia ) {
        String query = "update dienthoai\n" +
            "set tendt= '"+tendt+"', hangdt= '"+hangdt+"', gia= "+gia+"\n" +
            "where id= " + id;
        conn.excute(query);
    }
    
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> listBH = new ArrayList<>();
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Nhanvien");
            ResultSet result = ps.executeQuery();
            
            while (result.next()) {
                NhanVien bh = new NhanVien();
                bh.setMaNV(result.getString("maNV"));
                bh.setHoTen(result.getString("hoTen"));
                bh.setSDT(result.getString("SDT"));  
                bh.setGioiTinh(result.getString("gioiTinh"));
                bh.setPassword(result.getString("Pass"));
                listBH.add(bh);
            }
            System.out.println("sucessss");
        } catch (SQLException ex) {
            Logger.getLogger(SQLHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listBH;
    }
    
    public void AddNhanVien(NhanVien bh) {
        
        Connection conn = Connect.ConnectSQL();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Nhanvien values (?,?,?,?,?)");
            ps.setString(1, bh.getMaNV());
            ps.setString(2, bh.getHoTen());
            ps.setString(3, bh.getGioiTinh());
            ps.setString(4,  bh.getSDT());
            ps.setString(5, bh.getPassword());
            
            int result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SQLHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
