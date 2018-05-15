package JavaBeans;

import java.io.Serializable;

public class Sach implements Serializable{
	private int IDSach;
	private String TenSach;
	private double DonGia;
	private int SoLuong;
	private String TacGia;
	private String NXB;
	private int TheLoai;
	private String HinhAnh;
	public int getIDSach() {
		return IDSach;
	}
	public void setIDSach(int iDSach) {
		IDSach = iDSach;
	}
	public String getTenSach() {
		return TenSach;
	}
	public void setTenSach(String tenSach) {
		TenSach = tenSach;
	}
	public double getDonGia() {
		return DonGia;
	}
	public void setDonGia(double donGia) {
		DonGia = donGia;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public String getTacGia() {
		return TacGia;
	}
	public void setTacGia(String tacGia) {
		TacGia = tacGia;
	}
	public String getNXB() {
		return NXB;
	}
	public void setNXB(String nXB) {
		NXB = nXB;
	}
	public int getTheLoai() {
		return TheLoai;
	}
	public void setTheLoai(int theLoai) {
		TheLoai = theLoai;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public Sach() {
		super();
	}
}
