package BusinessLogics;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import JavaBeans.DonHang;

public class DonHangBL {
	public static void ThemDonHang(DonHang dh)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "insert into DONHANG values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, dh.getNguoiNhan());
			pst.setString(2, dh.getSDTNguoiNhan());
			pst.setString(3, dh.getDiaChiNguoiNhan());
			pst.setString(4, dh.getNgayDatHang());
			pst.setString(5, dh.getGhiChu());
			pst.setInt(6,dh.getTrangThai());
			pst.setDouble(7, dh.getTongTien());
			pst.setInt(8, dh.getKH());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static int LayIDDonHangLonNhat()
	{
		Connection ketNoi = CSDL.LayKetNoi();
		int kq = 0;
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select MAX(ID_DonHang) from DONHANG";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				kq = rs.getInt(1);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	public static List<DonHang> DocTatCa()
	{
		List<DonHang> lst = new ArrayList<DonHang>();
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from DONHANG";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				DonHang dh = new DonHang();
				dh.setID_DonHang(rs.getInt("ID_DonHang"));
				dh.setDiaChiNguoiNhan(rs.getString("DiaChiNhan"));
				dh.setGhiChu(rs.getString("GhiChu"));
				dh.setKH(rs.getInt("KH"));
				dh.setNgayDatHang(rs.getString("NgayDatHang"));
				dh.setNguoiNhan(rs.getString("NguoiNhan"));
				dh.setSDTNguoiNhan(rs.getString("SDTNguoiNhan"));
				dh.setTongTien(rs.getDouble("TongTien"));
				dh.setTrangThai(rs.getInt("TrangThai"));
				lst.add(dh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	public static List<DonHang> DocDonHangChuaXuLy()
	{
		List<DonHang> lst = new ArrayList<DonHang>();
		Connection ketNoi = CSDL.LayKetNoi();
		int tt = 0;
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from DONHANG where TrangThai="+tt;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				DonHang dh = new DonHang();
				dh.setID_DonHang(rs.getInt("ID_DonHang"));
				dh.setDiaChiNguoiNhan(rs.getString("DiaChiNhan"));
				dh.setGhiChu(rs.getString("GhiChu"));
				dh.setKH(rs.getInt("KH"));
				dh.setNgayDatHang(rs.getString("NgayDatHang"));
				dh.setNguoiNhan(rs.getString("NguoiNhan"));
				dh.setSDTNguoiNhan(rs.getString("SDTNguoiNhan"));
				dh.setTongTien(rs.getDouble("TongTien"));
				dh.setTrangThai(rs.getInt("TrangThai"));
				lst.add(dh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	public static List<DonHang> DocDonHangDaXuLy()
	{
		List<DonHang> lst = new ArrayList<DonHang>();
		Connection ketNoi = CSDL.LayKetNoi();
		int tt = 1;
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from DONHANG where TrangThai="+tt;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				DonHang dh = new DonHang();
				dh.setID_DonHang(rs.getInt("ID_DonHang"));
				dh.setDiaChiNguoiNhan(rs.getString("DiaChiNhan"));
				dh.setGhiChu(rs.getString("GhiChu"));
				dh.setKH(rs.getInt("KH"));
				dh.setNgayDatHang(rs.getString("NgayDatHang"));
				dh.setNguoiNhan(rs.getString("NguoiNhan"));
				dh.setSDTNguoiNhan(rs.getString("SDTNguoiNhan"));
				dh.setTongTien(rs.getDouble("TongTien"));
				dh.setTrangThai(rs.getInt("TrangThai"));
				lst.add(dh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	public static List<DonHang> LayDonHangTheoKH(int kh)
	{
		List<DonHang> lst = new ArrayList<DonHang>();
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from DONHANG where KH="+kh;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				DonHang dh = new DonHang();
				dh.setID_DonHang(rs.getInt("ID_DonHang"));
				dh.setDiaChiNguoiNhan(rs.getString("DiaChiNhan"));
				dh.setGhiChu(rs.getString("GhiChu"));
				dh.setKH(rs.getInt("KH"));
				dh.setNgayDatHang(rs.getString("NgayDatHang"));
				dh.setNguoiNhan(rs.getString("NguoiNhan"));
				dh.setSDTNguoiNhan(rs.getString("SDTNguoiNhan"));
				dh.setTongTien(rs.getDouble("TongTien"));
				dh.setTrangThai(rs.getInt("TrangThai"));
				lst.add(dh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	public static DonHang LayDonHangTheoID(int id)
	{
		DonHang dh = new DonHang();
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from DONHANG where ID_DonHang="+id;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){			
				dh.setID_DonHang(rs.getInt("ID_DonHang"));
				dh.setDiaChiNguoiNhan(rs.getString("DiaChiNhan"));
				dh.setGhiChu(rs.getString("GhiChu"));
				dh.setKH(rs.getInt("KH"));
				dh.setNgayDatHang(rs.getString("NgayDatHang"));
				dh.setNguoiNhan(rs.getString("NguoiNhan"));
				dh.setSDTNguoiNhan(rs.getString("SDTNguoiNhan"));
				dh.setTongTien(rs.getDouble("TongTien"));
				dh.setTrangThai(rs.getInt("TrangThai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dh;
	}
	public static void XacNhanDH(int id)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "update DONHANG set TrangThai=? where Id_DonHang=?";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setInt(2, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void XoaDonHang(int idDonHang)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "delete from DONHANG where ID_DonHang=?";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setInt(1, idDonHang);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
