package BusinessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.Sach;

public class SachBL {
	public static List<Sach> DocTatCa()
	{
		List<Sach> lst = new ArrayList<Sach>();
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from sach";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Sach sp = new Sach();
				sp.setIDSach(rs.getInt("Id_Sach"));
				sp.setDonGia(rs.getDouble("DonGia"));
				sp.setHinhAnh(rs.getString("HinhAnh"));
				sp.setNXB(rs.getString("NXB"));
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setTacGia(rs.getString("TacGia"));
				sp.setTenSach(rs.getString("TenSach"));
				sp.setTheLoai(rs.getInt("TheLoai"));
				lst.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	public static List<Sach> DocTheoTheLoai(String matheloai)
	{
		List<Sach> lst = new ArrayList<Sach>();
		
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from sach where TheLoai='"+matheloai+"'";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Sach sp = new Sach();
				sp.setIDSach(rs.getInt("Id_Sach"));
				sp.setDonGia(rs.getDouble("DonGia"));
				sp.setHinhAnh(rs.getString("HinhAnh"));
				sp.setNXB(rs.getString("NXB"));
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setTacGia(rs.getString("TacGia"));
				sp.setTenSach(rs.getString("TenSach"));
				sp.setTheLoai(rs.getInt("TheLoai"));
				lst.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	public static List<Sach> DocTheoTen(String ten)
	{
		List<Sach> lst = new ArrayList<Sach>();
		
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from sach where TenSach like N'%"+ten+"%'";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				Sach sp = new Sach();
				sp.setIDSach(rs.getInt("Id_Sach"));
				sp.setDonGia(rs.getDouble("DonGia"));
				sp.setHinhAnh(rs.getString("HinhAnh"));
				sp.setNXB(rs.getString("NXB"));
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setTacGia(rs.getString("TacGia"));
				sp.setTenSach(rs.getString("TenSach"));
				sp.setTheLoai(rs.getInt("TheLoai"));
				lst.add(sp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	public static void CapNhatSach(Sach sp)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "update SACH set TenSach=?, DonGia=?, SoLuong=?,TacGia=?, NXB=?, TheLoai=?, HinhAnh=? where Id_Sach=?";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, sp.getTenSach());
			pst.setDouble(2, sp.getDonGia());
			pst.setInt(3, sp.getSoLuong());
			pst.setString(4, sp.getTacGia());
			pst.setString(5, sp.getNXB());
			pst.setInt(6, sp.getTheLoai());
			pst.setString(7, sp.getHinhAnh());
			pst.setInt(8, sp.getIDSach());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Sach DocTheoID(int id)
	{
		Sach sp=null;
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from SACH where ID_Sach="+id;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				sp = new Sach();
				sp.setIDSach(rs.getInt("Id_Sach"));
				sp.setDonGia(rs.getDouble("DonGia"));
				sp.setHinhAnh(rs.getString("HinhAnh"));
				sp.setNXB(rs.getString("NXB"));
				sp.setSoLuong(rs.getInt("SoLuong"));
				sp.setTacGia(rs.getString("TacGia"));
				sp.setTenSach(rs.getString("TenSach"));
				sp.setTheLoai(rs.getInt("TheLoai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sp;
	}
	public static void ThemSach(Sach sach)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "insert into SACH values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			// pst.setInt(1, acc.getIDAccount());
			pst.setString(1, sach.getTenSach());
			pst.setDouble(2, sach.getDonGia());
			pst.setInt(3, sach.getSoLuong());
			pst.setString(4, sach.getTacGia());
			pst.setString(5, sach.getNXB());
			pst.setInt(6, sach.getTheLoai());
			pst.setString(7, sach.getHinhAnh());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void XoaSach(int idSach)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "delete from SACH where ID_Sach=?";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setInt(1, idSach);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
