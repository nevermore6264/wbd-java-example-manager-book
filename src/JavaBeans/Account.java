package JavaBeans;

import java.io.Serializable;

public class Account implements Serializable {
	private String username;
	private String password;
	private int IDAccount;
	private int TrangThai;
	private int Loai;

	public int getIDAccount() {
		return IDAccount;
	}

	public void setIDAccount(int iDAccount) {
		IDAccount = iDAccount;
	}

	public int getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}

	public int getLoai() {
		return Loai;
	}

	public void setLoai(int loai) {
		Loai = loai;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account() {
		super();
	}
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Account(String username, String password, int iDAccount, int trangThai, int loai) {
		super();
		this.username = username;
		this.password = password;
		IDAccount = iDAccount;
		TrangThai = trangThai;
		Loai = loai;
	}
	
}
