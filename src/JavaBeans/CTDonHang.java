package JavaBeans;

import java.io.Serializable;
import java.util.HashMap;

import BusinessLogics.Cart;

public class CTDonHang implements Serializable{
	private int IDDonHang;
	private int IDSach;
	private int SoLuong;
	public int getIDDonHang() {
		return IDDonHang;
	}
	public void setIDDonHang(int iDDonHang) {
		IDDonHang = iDDonHang;
	}
	public int getIDSach() {
		return IDSach;
	}
	public void setIDSach(int iDSach) {
		IDSach = iDSach;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public CTDonHang()
	{
		super();
	}
}
