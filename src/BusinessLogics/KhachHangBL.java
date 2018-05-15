package BusinessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.Account;
import JavaBeans.KhachHang;

public class KhachHangBL {
	public static List<KhachHang> DocTatCa()
	{
		List<KhachHang> lst = new ArrayList<KhachHang>();
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from KHACHHANG";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				KhachHang sp = new KhachHang();
				sp.setIDKH(rs.getInt("ID_KhachHang"));
				sp.setAccount(rs.getInt("Account"));
				sp.setEmail(rs.getString("Email"));
				sp.setGioiTinh(rs.getInt("GioiTinh"));
				sp.setHoTen(rs.getString("TenKH"));
				sp.setSDT(rs.getString("SDT"));
				lst.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	public static void ThemKhachHang(KhachHang kh)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "insert into KHACHHANG values (?,?,?,?,?)";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			//pst.setInt(1, kh.getIDKH());
			pst.setString(1, kh.getHoTen());
			pst.setString(2, kh.getSDT());
			pst.setString(3, kh.getEmail());
			pst.setInt(4, kh.getGioiTinh());
			pst.setInt(5, kh.getAccount());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static KhachHang LayKhachHangTheoAccount(int id_account)
	{
		KhachHang kh = null;
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from KHACHHANG where Account="+id_account;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				kh = new KhachHang();
				kh.setAccount(rs.getInt("Account"));
				kh.setEmail(rs.getString("Email"));
				kh.setGioiTinh(rs.getInt("GioiTinh"));
				kh.setHoTen(rs.getString("TenKH"));
				kh.setIDKH(rs.getInt("ID_KhachHang"));
				kh.setSDT(rs.getString("SDT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}
	public static KhachHang LayKhachHangTheoID(int id_account)
	{
		KhachHang kh = null;
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from KHACHHANG where ID_KhachHang="+id_account;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				kh = new KhachHang();
				kh.setAccount(rs.getInt("Account"));
				kh.setEmail(rs.getString("Email"));
				kh.setGioiTinh(rs.getInt("GioiTinh"));
				kh.setHoTen(rs.getString("TenKH"));
				kh.setIDKH(rs.getInt("ID_KhachHang"));
				kh.setSDT(rs.getString("SDT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}
	public static void CapNhatKH(KhachHang kh)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "update KHACHHANG set TenKH=?, SDT=?, Email=? where Account=?";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, kh.getHoTen());
			pst.setString(2, kh.getSDT());
			pst.setString(3, kh.getEmail());
			pst.setInt(4, kh.getAccount());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
