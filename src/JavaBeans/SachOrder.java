package JavaBeans;

import java.io.Serializable;

public class SachOrder implements Serializable {
	private String ID;
	private int SoLuong;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public SachOrder()
	{
		super();
	}
	public SachOrder(String iD) {
		super();
		ID = iD;
		SoLuong = 1;
	}
	public SachOrder(String iD, int soLuong) {
		super();
		ID = iD;
		SoLuong = soLuong;
	}
	
}
