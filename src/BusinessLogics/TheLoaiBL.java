package BusinessLogics;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.TheLoai;

public class TheLoaiBL {
	public static List<TheLoai> DocTatCa()
	{
		List<TheLoai> lst = new ArrayList<TheLoai>();
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from TheLoai";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				TheLoai sp = new TheLoai();
				sp.setIDTheLoai(rs.getInt("ID_TheLoai"));
				sp.setDanhMuc(rs.getInt("DanhMuc"));
				sp.setMoTa(rs.getString("MoTa"));
				sp.setTenTL(rs.getString("TenTL"));
				lst.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
}
