/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Admin
 */
public class connects {
    public static Connection openConnection() throws Exception{
       
        String connectionUrl = "jdbc:sqlserver://localhost\\DESKTOP-68R2QBK:1433;databaseName=Book;integratedSecurity=true;";
        String username = "sa";
        String password = "123456";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(connectionUrl,username,password);
            System.out.println(conn.getCatalog());
            System.out.println("Thanh Cong");
        
        } catch (Exception e) {
            System.out.println("that bai");
            e.printStackTrace();
            
        }
        return null;
        
       
    }
    public static void main(String[] args) throws Exception {
        openConnection();
    }
  
}