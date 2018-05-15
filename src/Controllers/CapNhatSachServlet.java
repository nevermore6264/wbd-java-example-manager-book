package Controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.util.*;

import BusinessLogics.SachBL;
import JavaBeans.Sach;

/**
 * Servlet implementation class CapNhatSachServlet
 */
@WebServlet("/CapNhatSachServlet")
public class CapNhatSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// location to store file uploaded
	private static final String UPLOAD_DIRECTORY = "img";

	// upload settings
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapNhatSachServlet() {
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
		String id, tensach, dongia, soluong, tacgia, nxb, theloai;
		try {
			tensach = request.getParameter("txtbookname");
			tacgia = request.getParameter("txtauthor");
			nxb = request.getParameter("txtnxb");
			theloai = request.getParameter("txtloai");
			Sach sach = new Sach();
			int k = Integer.parseInt(request.getParameter("txtbookid"));
			Sach sachCu = SachBL.DocTheoID(k);
			int l = Integer.parseInt(request.getParameter("txtamount"));
			double g = Double.parseDouble(request.getParameter("txtcost"));
			sach.setIDSach(k);
			sach.setTenSach(tensach);
			sach.setDonGia(g);
			sach.setSoLuong(l);
			sach.setTacGia(tacgia);
			sach.setNXB(nxb);
			sach.setTheLoai(Integer.parseInt(theloai));				
			sach.setHinhAnh(sachCu.getHinhAnh());				
			SachBL.CapNhatSach(sach);
		} catch (NumberFormatException ex) {
			System.err.println("Ilegal input");
		}
	response.sendRedirect("ManagerServlet");
}
}