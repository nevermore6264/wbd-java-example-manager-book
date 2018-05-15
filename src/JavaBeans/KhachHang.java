package JavaBeans;

import java.io.Serializable;

public class KhachHang implements Serializable {
	private int IDKH;
	private String HoTen;
	private String SDT;
	private String Email;
	private int GioiTinh;
	private int Account;
	public int getIDKH() {
		return IDKH;
	}
	public void setIDKH(int iDKH) {
		IDKH = iDKH;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public int getAccount() {
		return Account;
	}
	public void setAccount(int account) {
		Account = account;
	}
	public KhachHang()
	{
		super();
	}
}
