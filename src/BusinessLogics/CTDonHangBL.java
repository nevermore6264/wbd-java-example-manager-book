package BusinessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.CTDonHang;


public class CTDonHangBL {
	public static void ThemCTDonHang(CTDonHang ctdh)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "insert into CT_DONHANG values (?,?,?)";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setInt(1, ctdh.getIDDonHang());
			pst.setInt(2, ctdh.getIDSach());
			pst.setInt(3, ctdh.getSoLuong());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static List<CTDonHang> DocTheoIDDonHang(int iddh)
	{
		List<CTDonHang> lst = new ArrayList<CTDonHang>();
		
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from CT_DONHANG where ID_DonHang="+iddh;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				CTDonHang ctdh = new CTDonHang();
				ctdh.setIDDonHang(rs.getInt("ID_DonHang"));
				ctdh.setIDSach(rs.getInt("ID_Sach"));
				ctdh.setSoLuong(rs.getInt("SoLuong"));
				lst.add(ctdh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	public static void XoaCTDonHang(int idDonHang)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "delete from CT_DONHANG where ID_DonHang=?";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setInt(1, idDonHang);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
