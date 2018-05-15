<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="JavaBeans.*"%>
<%@page import="BusinessLogics.*"%>
<jsp:include page="dau-trang.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<nav class="nav-bar row">
	<div class="btn-toggle-wrapper hide-on-desktop" id="btn-menu">
		<span class="btn-toggle"></span>
	</div>
	<ul class="menu">
		<li class="menu-item active"><a href="trang-chu-admin.jsp"> <i
				class="fa fa-home" aria-hidden="true"></i> Trang chủ
		</a></li>
		<li class="menu-item"><a href="ManagerServlet"> <i
				class="fa fa-user" aria-hidden="true"></i> Quản lý
		</a></li>
		<li class="customer-login hide-on-mobile">Xin chào: <span><%=session.getAttribute("username")%></span>!
			<br /> <a href="LogoutServlet" class="logout">Logout</a>
		</li>
	</ul>
</nav>

<div class="container padding-width">
	<div class="manager-container">
		<ul class="manager row">
			<li class="manager-item"><a href="#content-customer-turnup"
				class=""> <i class="fa fa-user" aria-hidden="true"></i> Danh
					sách khách hàng
			</a></li>
			<li class="manager-item"><a href="#content-order-manager"
				class=""> <i class="fa fa-cart-plus" aria-hidden="true"></i>
					Quản lý đặt hàng
			</a></li>
			<li class="manager-item"><a href="#content-library-manager"
				class="active"> <i class="fa fa-book" aria-hidden="true"></i>
					Quản lý sách
			</a></li>
			<li class="manager-item"><a href="#content-statistic"> <i
					class="fa fa-user" aria-hidden="true"></i> Thống kê
			</a></li>
		</ul>
		<div class="manager-content">
			<div class="tab-content content-wrapper content-customer-turnup">
				<label for="">Mã khách hàng</label>
				<div class="customer-turnup-wrapper">
					<form action="ManagerServlet" method="get">
						<input type="text" class="custom-input customer-turnup"
							name="idturnup" required="true">
						<button class="btn-search">
							<i class="fa fa-search fa-lg" aria-hidden="true"></i>
						</button>
					</form>
				</div>
				<table class="table-manager">
					<tr>
						<th>STT</th>
						<th>Mã TK</th>
						<th>Họ và tên</th>
						<th>Tài khoản</th>
						<th>Giới tính</th>
						<th>Số điện thoại</th>
						<th>Email</th>
						<th>Loại TK</th>
					</tr>
					<%
						KhachHang kh = new KhachHang();
						Account acc = new Account();
						if (request.getAttribute("idturnup") != null) {
							String s = (String) request.getAttribute("idturnup");
							int id = Integer.parseInt(s);
							kh = KhachHangBL.LayKhachHangTheoID(id);
							if (kh != null) {
								acc = AccountBL.LayAccountTheoID(kh.getAccount());
					%>
					<tr>
						<td><%=kh.getIDKH()%></td>
						<td><%=acc.getIDAccount()%></td>

						<td><%=kh.getHoTen()%></td>

						<td><%=acc.getUsername()%></td>

						<%
							if (kh.getGioiTinh() == 0) {
						%>
						<td>Nữ</td>
						<%
							} else {
						%>
						<td>Nam</td>
						<%
							}
						%>
						<td><%=kh.getSDT()%></td>
						<td><%=kh.getEmail()%></td>
						<%
							if (acc.getLoai() == 0) {
						%>
						<td>Thành viên</td>
						<%
							} else {
						%>
						<td>Admin</td>
						<%
							}
						%>
					</tr>
					<%
						} else {
					%>
					<tr>Không tìm thấy khách hàng
					</tr>
					<%
						}
						} else {
							List<KhachHang> lstkh = KhachHangBL.DocTatCa();
							if (lstkh.size() > 0) {
								for (KhachHang khtemp : lstkh) {
									Account acctemp = AccountBL.LayAccountTheoID(khtemp.getAccount());
					%>
					<tr>
						<td><%=khtemp.getIDKH()%></td>
						<td><%=acctemp.getIDAccount()%></td>

						<td><%=khtemp.getHoTen()%></td>

						<td><%=acctemp.getUsername()%></td>

						<%
							if (khtemp.getGioiTinh() == 0) {
						%>
						<td>Nữ</td>
						<%
							} else {
						%>
						<td>Nam</td>
						<%
							}
						%>
						<td><%=khtemp.getSDT()%></td>
						<td><%=khtemp.getEmail()%></td>
						<%
							if (acctemp.getLoai() == 0) {
						%>
						<td>Thành viên</td>
						<%
							} else {
						%>
						<td>Admin</td>
						<%
							}
						%>
					</tr>

					<%
						}
							}
						}
					%>
				</table>
			</div>
			<div class="tab-content content-order-manager content-wrapper-wide">
				<table class="table-manager">
					<tr>
						<th>Order ID</th>
						<th>Họ và tên</th>
						<th>Mã TK</th>
						<th>SĐT</th>
						<th>Địa chỉ</th>
						<th>Ngày mua hàng</th>
						<th>Ghi chú</th>
						<th>SP Mua</th>
						<th>Tổng tiền</th>
						<th>Trạng thái</th>
					</tr>
					<form action="ConfirmDonHangServlet" method="get">
						<%
							List<DonHang> dhcxl = DonHangBL.DocDonHangChuaXuLy();
							List<CTDonHang> lstctdh = null;
							for (DonHang dh : dhcxl) {
								lstctdh = CTDonHangBL.DocTheoIDDonHang(dh.getID_DonHang());
						%>
						<tr>
							<td><%=dh.getID_DonHang()%></td>
							<td><%=dh.getNguoiNhan()%></td>
							<td><%=dh.getKH()%></td>
							<td><%=dh.getSDTNguoiNhan()%></td>
							<td><%=dh.getDiaChiNguoiNhan()%></td>
							<td><%=dh.getNgayDatHang()%></td>
							<%
								if (dh.getGhiChu() == null) {
							%><td></td>
							<%
								} else {
							%>
							<td><%=dh.getGhiChu()%></td>
							<%
								}
							%>
							<td>
								<%
									for (CTDonHang ctdh : lstctdh) {
								%>Mã SP: <%=ctdh.getIDSach()%> - Số lượng: <%=ctdh.getSoLuong()%> <br>
								<%
									}
								%>
							</td>
							<td><%=dh.getTongTien()%></td>
							<td><input class="gender-select" type="checkbox"
								name="Confirm<%=dh.getID_DonHang()%>"> <label
								class="gender-select">Thanh toán</label></td>
						</tr>
						<%
							}
							// session.setAttribute("lstIDDH", lstIDDH);
						%>
						<button type="submit" class="btn btn--orange">
							<span>Submit</span>
						</button>
						<br>
					</form>
				</table>
			</div>
			<div
				class="tab-content content-library-manager content-wrapper-wide active">
				<div class="content-wrapper">
					<table class="table-tool-library">
						<tr>
							<td>
								<div class="search-book-wrapper">
									<form action="ManagerServlet" method="get">
										<input type="text" class="custom-input"
											placeholder="Mời nhập tên sách" name="txtTimKiem">
										<button class="btn-search">
											<i class="fa fa-search fa-lg" aria-hidden="true"></i>
										</button>
									</form>
								</div>
							</td>
							<td>
								<button class="btn btn--small btn-add">
									<span><i class="fa fa-plus" aria-hidden="true"></i> Thêm</span>
								</button>
							</td>
						</tr>
					</table>
				</div>
				<table class="table-manager">
					<tr>
						<th>Mã sách</th>
						<th>Tên sách</th>
						<th>Giá</th>
						<th>Số lượng</th>
						<th>Tác giả</th>
						<th>NXB</th>
						<th>Thể loại</th>
						<th></th>
					</tr>
					<%
						if (request.getAttribute("txtTimKiem") != null) {
							String name = (String) request.getAttribute("txtTimKiem");
							// int id = Integer.parseInt(name);
							Sach lstID = SachBL.DocTheoID(0);
							List<Sach> lstName = SachBL.DocTheoTen(name);
							if (lstID != null) {
					%>

					<tr>
						<td><%=lstID.getIDSach()%></td>
						<td><%=lstID.getTenSach()%></td>
						<td><%=lstID.getDonGia()%></td>
						<td><%=lstID.getSoLuong()%></td>
						<td><%=lstID.getTacGia()%></td>
						<td><%=lstID.getNXB()%></td>
						<td><%=lstID.getTheLoai()%></td>
						<td>
							<button class="btn btn--small" data-type="close">
								<span><i class="fa fa-pencil" aria-hidden="true"></i>
									Edit</span>
							</button>
							<button class="btn btn--small btn--red" data-type="remove">
								<span><i class="fa fa-trash" aria-hidden="true"></i>
									Remove</span>
							</button>
						</td>
						<%
							}
						%>
						<%
							if (lstName != null) {
									for (Sach sp : lstName) {
						%>
					
					<tr>
						<td><%=sp.getIDSach()%></td>
						<td><%=sp.getTenSach()%></td>
						<td><%=sp.getDonGia()%></td>
						<td><%=sp.getSoLuong()%></td>
						<td><%=sp.getTacGia()%></td>
						<td><%=sp.getNXB()%></td>
						<td><%=sp.getTheLoai()%></td>
						<td>
							<button class="btn btn--small" data-type="edit">
								<span><i class="fa fa-pencil" aria-hidden="true"></i>
									Edit</span>
							</button> <a href="XoaSachServlet?id=<%=sp.getIDSach()%>"> <img
								src="img/remove.png" alt="Remove" align="center" />
						</a>
						</td>
						<%
							}
								}
							} else {
								List<Sach> lstSach = SachBL.DocTatCa();
								if (lstSach.size() > 0) {
									for (Sach sp : lstSach) {
						%>
					
					<tr>
						<td><%=sp.getIDSach()%></td>
						<td><%=sp.getTenSach()%></td>
						<td><%=sp.getDonGia()%></td>
						<td><%=sp.getSoLuong()%></td>
						<td><%=sp.getTacGia()%></td>
						<td><%=sp.getNXB()%></td>
						<td><%=sp.getTheLoai()%></td>
						<td>
							<button class="btn btn--small" data-type="edit">
								<span><i class="fa fa-pencil" aria-hidden="true"></i>
									Edit</span>
							</button> <a href="XoaSachServlet?id=<%=sp.getIDSach()%>"> <img
								src="img/remove.png" alt="Remove" align="center" />
						</a>
						</td>
						<%
							}
								}
							}
						%>

					</tr>



				</table>
				<div class="popup-book-add">
					<div class="popup-box">
						<i class="fa fa-close close-popup"></i>
						<div class="outer">
							<div class="container">
								<form action="ThemSachServlet" method="get">
									<label>Tên sách</label> <input type="text"
										class="custom-input" required="true" name="bookname">
									<label>Giá</label> <input type="text" class="custom-input"
										required="true" name="cost"> <label>Số lượng</label> <input
										type="number" class="custom-input" required="true" min="0"
										name="amount"> <label>Tác giả</label> <input
										type="text" class="custom-input" required="true" name="author">
									<label>NXB</label> <input type="text"
										class="custom-input" required="true" name="nxb"> <label>Thể loại</label>
									<input type="text" class="custom-input" required="true"
										name="loai"> <label>Địa chỉ lưu file</label> <input
										type="file" name="uploadFile" required="true">
									<button class="btn">
										<span>Add</span>
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="popup-book-edit">
					<div class="popup-box">
						<i class="fa fa-close close-popup"></i>
						<div class="outer">
							<div class="container">
								<form action="CapNhatSachServlet" method="post">
									<label>Book ID</label> <input type="text" class="custom-input"
										required="true" name="txtbookid" readonly> <label>Tên sách
										</label> <input type="text" class="custom-input" required="true"
										name="txtbookname"> <label>Giá</label> <input
										type="text" class="custom-input" required="true"
										name="txtcost"> <label>Số lượng</label> <input
										type="number" class="custom-input" required="true" min="0"
										name="txtamount"> <label>Tác giả</label> <input
										type="text" class="custom-input" required="true"
										name="txtauthor"> <label>NXB</label> <input
										type="text" class="custom-input" required="true" name="txtnxb">
									<label>Thể loại</label> <input type="text" class="custom-input"
										required="true" name="txtloai">
									<button class="btn">
										<span>Edit</span>
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-content content-statistic content-wrapper-wide">
				<table class="table-manager">
					<tr>
						<th>Mã mua hàng</th>
						<th>Mã TK</th>
						<th>Ngày mua</th>
						<th>SP Mua</th>
						<th>Tổng tiền</th>
						<th>Trạng thái</th>
					</tr>
					<%
						double TotalSales = 0;
						List<DonHang> dhdxl = DonHangBL.DocDonHangDaXuLy();
						List<CTDonHang> lstctdh2 = null;
						for (DonHang dh : dhdxl) {
							TotalSales = TotalSales + dh.getTongTien();
							lstctdh2 = CTDonHangBL.DocTheoIDDonHang(dh.getID_DonHang());
					%>

					<tr>
						<td><%=dh.getID_DonHang()%></td>
						<td><%=dh.getKH()%></td>
						<td><%=dh.getNgayDatHang()%></td>
						<td>
							<%
								for (CTDonHang ctdh : lstctdh2) {
							%> Mã sách: <%=ctdh.getIDSach()%> - Số lượng: <%=ctdh.getSoLuong()%> <br>
							<%
								}
							%>
						</td>
						<td><%=dh.getTongTien()%></td>
						<td>Finish</td>
					</tr>
					<%
						}
					%>
				</table>
				<div class="total-sale-wrapper">
					<span class="total-sale">Tổng tiền: </span> <span
						class="total-sale"><%=TotalSales%></span>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="cuoi-trang.jsp"></jsp:include>