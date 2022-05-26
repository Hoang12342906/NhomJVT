/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    

}
