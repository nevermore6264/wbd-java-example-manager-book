package BusinessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.Account;



public class AccountBL {
	public static boolean Check(Account acc)
	{
		String username = acc.getUsername();
		String password = acc.getPassword();
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select Pass from Account where UserName ='"+username+"'";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				if((rs.getString("Pass")).equals(password))
				{
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean CheckUsername(String username)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select UserName from Account";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				if(rs.getString(1).equals(username))
				{
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void ThemAccount(Account acc)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "insert into ACCOUNT values (?,?,?,?)";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			// pst.setInt(1, acc.getIDAccount());
			pst.setString(1, acc.getUsername());
			pst.setString(2, acc.getPassword());
			pst.setInt(3, acc.getTrangThai());
			pst.setInt(4, acc.getLoai());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Account LayAccountTheoUsername(String username)
	{
		Account acc=null;
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from ACCOUNT where Username='"+username+"'";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				acc = new Account();
				acc.setIDAccount(rs.getInt("ID_Account"));
				acc.setLoai(rs.getInt("Loai"));
				acc.setPassword(rs.getString("Pass"));
				acc.setTrangThai(rs.getInt("TrangThai"));
				acc.setUsername(rs.getString("UserName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}
	public static Account LayAccountTheoID(int id)
	{
		Account acc=null;
		Connection ketNoi = CSDL.LayKetNoi();
		try {
			Statement stm = ketNoi.createStatement();
			String sql = "select * from ACCOUNT where ID_Account="+id;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				acc = new Account();
				acc.setIDAccount(rs.getInt("ID_Account"));
				acc.setLoai(rs.getInt("Loai"));
				acc.setPassword(rs.getString("Pass"));
				acc.setTrangThai(rs.getInt("TrangThai"));
				acc.setUsername(rs.getString("UserName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acc;
	}
	public static void CapNhatAccount(Account acc)
	{
		Connection ketNoi = CSDL.LayKetNoi();
		String sql = "update ACCOUNT set Pass=? where ID_Account=?";
		try {
			PreparedStatement pst = ketNoi.prepareStatement(sql);
			pst.setString(1, acc.getPassword());
			pst.setInt(2, acc.getIDAccount());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
