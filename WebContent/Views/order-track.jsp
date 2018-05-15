<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="BusinessLogics.*"%>
<%@page import="JavaBeans.*"%>
<%@page import="java.util.List"%>
<jsp:include page="dau-trang.jsp"></jsp:include>
<jsp:include page="Menu-Member.jsp"></jsp:include>

<div class="container padding-width">
        <div class="order-track-container">
            <table class="table-manager">
                <tr>
                    <th>Mã mua hàng</th>
                    <th>Họ và tên</th>
                    <th>Số điện thoại</th>
                    <th>Địa chỉ</th>
                    <th>Ghi chú</th>
                    <th>SP Mua</th>
                    <th>Tổng tiền</th>
                    <th>Trạng thái</th>
                </tr>
<%
if(session.getAttribute("username")!=null)
{
	Account acc = AccountBL.LayAccountTheoUsername((String)session.getAttribute("username"));
	KhachHang kh = KhachHangBL.LayKhachHangTheoAccount(acc.getIDAccount());
	List<DonHang> lst = DonHangBL.LayDonHangTheoKH(kh.getIDKH());
	List<CTDonHang> lstctdh2 = null;
	for(DonHang dh : lst)
	{
		lstctdh2 = CTDonHangBL.DocTheoIDDonHang(dh.getID_DonHang());
%>
                <tr>
                    <td><%=dh.getID_DonHang() %></td>
                    <td><%=dh.getNguoiNhan() %></td>
                    <td><%=dh.getSDTNguoiNhan() %></td>
                    <td><%=dh.getDiaChiNguoiNhan() %></td>
                    <%if(dh.getGhiChu()==null)
                    {%><td></td><%}else{ %>
                    <td><%=dh.getGhiChu() %></td> 
                    <%}%>
                    <td>
                        <% for(CTDonHang ctdh : lstctdh2)
						{
						%>
						Mã sách: <%=ctdh.getIDSach()%> - Số lượng: <%=ctdh.getSoLuong()%>
						<br>
						<%} %>
                    </td>
                    <td><%=dh.getTongTien()%></td>
                    <%if(dh.getTrangThai()==1){%>                  
                    <td><img src="img/Finish.png" witdh="35" height="35"></td> 
                    <%}else
                    {
                    
                    %>
                                  
                    <td>
                    <a href="XoaDonHangServlet?id=<%=dh.getID_DonHang()%>"> <img src="img/Cancel-Order.png" witdh="35" height="35"></a>
                    </td>
                </tr>
<%}}} %>
            </table>
        </div>

    </div>

<jsp:include page="cuoi-trang.jsp"></jsp:include>    