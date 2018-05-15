package Controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import BusinessLogics.SachBL;
import JavaBeans.Sach;

/**
 * Servlet implementation class ThemSachServlet
 */
@WebServlet("/ThemSachServlet")
public class ThemSachServlet extends HttpServlet {
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
	public ThemSachServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Xử lý add book;
		String fileName = "product-1.png";
		if (request.getParameter("uploadFile") != null) {
			fileName = request.getParameter("uploadFile");
		}
		System.out.println(request.getParameter("amount"));
		System.out.println(request.getParameter("cost"));
		String tensach, dongia, soluong, tacgia, nxb, theloai;
		try {
			tensach = request.getParameter("bookname");
			tacgia = request.getParameter("author");
			nxb = request.getParameter("nxb");
			theloai = request.getParameter("loai");
			soluong = request.getParameter("amount");
			Sach sach = new Sach();
			int l = Integer.parseInt(soluong);
			double g = Double.parseDouble(request.getParameter("cost"));
			sach.setTenSach(tensach);
			sach.setDonGia(g);
			sach.setSoLuong(10);
			sach.setTacGia(tacgia);
			sach.setNXB(nxb);
			sach.setTheLoai(Integer.parseInt(theloai));
			sach.setHinhAnh(fileName);
			SachBL.ThemSach(sach);
		} catch (NumberFormatException ex) {
            System.out.println("Ban nhap chuoi khong hop le, xin vui long chi nhap so.");
        }
		response.sendRedirect("ManagerServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException 
	{
		// Xử lý up file ảnh
		if (!ServletFileUpload.isMultipartContent(request)) {
			// if not, we stop here
			PrintWriter writer = response.getWriter();
			writer.println("Error: Form must has enctype=multipart/form-data.");
			writer.flush();
			return;
		}
		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// sets memory threshold - beyond which files are stored in disk
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// sets temporary location to store files
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// sets maximum size of upload file
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// sets maximum size of request (include file + form data)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// constructs the directory path to store upload file
		// this path is relative to application's directory
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			// parses the request's content to extract file data
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {
				// iterates over form's fields
				for (FileItem item : formItems) {
					// processes only fields that are not form fields
					if (!item.isFormField()) {
						String fileName = new File(item.getName()).getName();
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);
						// saves the file on disk
						item.write(storeFile);
						// request.setAttribute("images", UPLOAD_DIRECTORY + "/" + fileName);
						// request.setAttribute("message",
						// "Upload has been done successfully >>" + UPLOAD_DIRECTORY + "/" + fileName);
					}
				}
			}
		} catch (Exception ex) {
			request.setAttribute("message", "There was an error: " + ex.getMessage());
		}
		doGet(request,response);
	}
}