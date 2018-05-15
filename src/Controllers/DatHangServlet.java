package Controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import BusinessLogics.AccountBL;
import BusinessLogics.CTDonHangBL;
import BusinessLogics.Cart;
import BusinessLogics.DonHangBL;
import BusinessLogics.KhachHangBL;
import BusinessLogics.SachBL;
import JavaBeans.Account;
import JavaBeans.CTDonHang;
import JavaBeans.DonHang;
import JavaBeans.KhachHang;
import JavaBeans.Sach;

/**
 * Servlet implementation class DatHangServlet
 */
@WebServlet("/DatHangServlet")
public class DatHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DatHangServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("SHOP") != null) // SHOP chứa id sách và số lượng
		{
			try {
				DonHang dh = new DonHang();
				dh.setNguoiNhan(request.getParameter("fullname"));
				dh.setSDTNguoiNhan(request.getParameter("phone"));
				dh.setDiaChiNguoiNhan(request.getParameter("address"));
				dh.setGhiChu(request.getParameter("note"));
				dh.setTrangThai(0);
				// Lấy tổng số tiền
				double tongTien = 0;
				Cart c = (Cart) session.getAttribute("SHOP");
				Sach s = null;
				for (String i : c.keySet()) {
					String temp = "qty" + i;
					if (request.getParameter(temp) != null) {
						String soluong = request.getParameter(temp);
						int id = Integer.parseInt(i);
						int sl = Integer.parseInt(soluong);
						s = SachBL.DocTheoID(id);
						tongTien = tongTien + (sl * s.getDonGia());
					}
				}
				session.setAttribute("TotalCost", tongTien);
				dh.setTongTien(tongTien);
				// Lấy ngày giờ hệ thống.
				Date today = new Date(System.currentTimeMillis());
				SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = timeFormat.format(today.getTime());
				dh.setNgayDatHang(time);
				// Lấy thông tin khách hàng;
				if (session.getAttribute("username") != null) {
					Account acc = AccountBL.LayAccountTheoUsername((String) session.getAttribute("username"));
					KhachHang kh = KhachHangBL.LayKhachHangTheoAccount(acc.getIDAccount());
					dh.setKH(kh.getIDKH());
				}
				DonHangBL.ThemDonHang(dh);
				int iddh = DonHangBL.LayIDDonHangLonNhat();
				// Lấy chi tiết đơn hàng;
				if (session.getAttribute("ThongTin") != null) {
					HashMap<Integer, Integer> ThongTin = (HashMap<Integer, Integer>) session.getAttribute("ThongTin");
					CTDonHang ctdonhang = new CTDonHang();
					for (int i : ThongTin.keySet()) {
						String SLSach = "qty" + i;
						String temp = request.getParameter(SLSach);
						int sl = Integer.parseInt(temp);
						ctdonhang.setIDDonHang(iddh);
						ctdonhang.setIDSach(i);
						ctdonhang.setSoLuong(sl);
						CTDonHangBL.ThemCTDonHang(ctdonhang);
					}
				}
				session.setAttribute("DonHang", dh);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Views/order-success.jsp");
				dispatcher.forward(request, response);
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
