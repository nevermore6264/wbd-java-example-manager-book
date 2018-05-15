package JavaBeans;

import java.io.Serializable;

public class TheLoai implements Serializable {
	private int IDTheLoai;
	private String TenTL;
	private String MoTa;
	private int DanhMuc;
	public int getIDTheLoai() {
		return IDTheLoai;
	}
	public void setIDTheLoai(int iDTheLoai) {
		IDTheLoai = iDTheLoai;
	}
	public String getTenTL() {
		return TenTL;
	}
	public void setTenTL(String tenTL) {
		TenTL = tenTL;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public int getDanhMuc() {
		return DanhMuc;
	}
	public void setDanhMuc(int danhMuc) {
		DanhMuc = danhMuc;
	}
	public TheLoai() {
		super();
	}
}
