package BusinessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class IDTang {
	public static int LayIdTang(){
		Connection ketNoi = CSDL.LayKetNoi();
		int i = 0;
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select MAX(ID_Account) from ACCOUNT";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				i = rs.getInt(1);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		}
}
