package Connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 
 */
public class Connect {
    
    public static Connection ConnectSQL (){
        String url = "net.sourceforge.jtds.jdbc.Driver";
        try {
            Class.forName(url);
            String dbUrl = "jdbc:jtds:sqlserver://LAPTOP-6IBE59SJ:1433/quanlydienthoai;instance=SQLEXPRESS;user=sa;password=123456789";
            return DriverManager.getConnection(dbUrl);
           
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void closeConnection(Connection con){
        if(con != null){
            try{
                con.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
}