package JavaBeans;

import java.io.Serializable;

public class DonHang implements Serializable{
	private int ID_DonHang;
	private String NguoiNhan;
	private String SDTNguoiNhan;
	private String DiaChiNguoiNhan;
	private String NgayDatHang;
	private String GhiChu;
	private int TrangThai;
	private double TongTien;
	private int KH;
	public int getID_DonHang() {
		return ID_DonHang;
	}
	public void setID_DonHang(int iD_DonHang) {
		ID_DonHang = iD_DonHang;
	}
	public String getNguoiNhan() {
		return NguoiNhan;
	}
	public void setNguoiNhan(String nguoiNhan) {
		NguoiNhan = nguoiNhan;
	}
	public String getSDTNguoiNhan() {
		return SDTNguoiNhan;
	}
	public void setSDTNguoiNhan(String sDTNguoiNhan) {
		SDTNguoiNhan = sDTNguoiNhan;
	}
	public String getDiaChiNguoiNhan() {
		return DiaChiNguoiNhan;
	}
	public void setDiaChiNguoiNhan(String diaChiNguoiNhan) {
		DiaChiNguoiNhan = diaChiNguoiNhan;
	}
	public String getNgayDatHang() {
		return NgayDatHang;
	}
	public void setNgayDatHang(String ngayDatHang) {
		NgayDatHang = ngayDatHang;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public int getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}
	public double getTongTien() {
		return TongTien;
	}
	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}
	public int getKH() {
		return KH;
	}
	public void setKH(int kH) {
		KH = kH;
	}
	public DonHang()
	{
		super();
	}
}
