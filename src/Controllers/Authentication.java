package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessLogics.AccountBL;
import JavaBeans.Account;

/**
 * Servlet implementation class Authentication
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentication() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		if (username.equals("admin") && password.equals("123")) {
			session.setMaxInactiveInterval(100000);
			session.setAttribute("username", "admin");
			RequestDispatcher dispatcher = request.getRequestDispatcher("trang-chu-admin.jsp");
			dispatcher.forward(request, response);
		} else {
			Account acc = new Account(username, password);
			if (AccountBL.Check(acc)) {
				session.setMaxInactiveInterval(100000);
				session.setAttribute("username", username);
				RequestDispatcher dispatcher = request.getRequestDispatcher("trang-chu.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("login.jsp");
			}
		}
	}
}