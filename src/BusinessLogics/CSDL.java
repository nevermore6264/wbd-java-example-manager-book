package BusinessLogics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.sql.*;  

public class CSDL {  
	public static Connection LayKetNoi(){
        Connection con = null;
        try {
            String url = "jdbc:sqlserver://localhost:1433;" +  
                    "databaseName=QL_BanSach;user=sa;password=123456"; 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}  
