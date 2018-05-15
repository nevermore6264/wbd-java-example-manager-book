package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.AccountBL;
import BusinessLogics.IDTang;
import BusinessLogics.KhachHangBL;
import JavaBeans.Account;
import JavaBeans.KhachHang;

/**
 * Servlet implementation class DangKyServlet
 */
@WebServlet("/DangKyServlet")
public class DangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fullname, username, password, gender, phone, email;		
		fullname = request.getParameter("fullname");
		username = request.getParameter("username");
		password = request.getParameter("password");
		if(AccountBL.CheckUsername(username)==true)
		{
			request.setAttribute("CheckUserName", "True");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		else {
		KhachHang kh = new KhachHang();
		if(request.getParameter("gender").equals("nam"))
			kh.setGioiTinh(0);
		else kh.setGioiTinh(1);		
		phone = request.getParameter("phone");
		email = request.getParameter("email");		
		kh.setHoTen(fullname);
		kh.setSDT(phone);
		kh.setEmail(email);
		int id = IDTang.LayIdTang()+1;
		kh.setAccount(id);
		Account acc = new Account(username, password, id, 1, 0);
		AccountBL.ThemAccount(acc);
		KhachHangBL.ThemKhachHang(kh);
		response.sendRedirect("login.jsp");}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
	}

}
