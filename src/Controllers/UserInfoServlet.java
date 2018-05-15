package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.AccountBL;
import BusinessLogics.KhachHangBL;
import JavaBeans.Account;
import JavaBeans.KhachHang;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		KhachHang kh = new KhachHang();
		if(request.getParameter("username")!=null)
		{
		Account acc = AccountBL.LayAccountTheoUsername(request.getParameter("username"));
		kh.setHoTen(request.getParameter("fullname"));
		kh.setSDT(request.getParameter("phone"));
		kh.setEmail(request.getParameter("email"));
		kh.setAccount(acc.getIDAccount());
		
		acc.setUsername(request.getParameter("username"));
		acc.setPassword(request.getParameter("password"));
		
		KhachHangBL.CapNhatKH(kh);
		AccountBL.CapNhatAccount(acc);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Views/user-info.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
