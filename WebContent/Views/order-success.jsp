<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="JavaBeans.*"%>
<%@page import="BusinessLogics.*"%>
<jsp:include page="dau-trang.jsp"></jsp:include>
<jsp:include page="Menu-Member.jsp"></jsp:include>
<%
	DonHang dh = (DonHang)session.getAttribute("DonHang");
%>
<div class="container padding-width">
        <div class="row">
            <h2 class="align-center">Đặt hàng thành công!</h2>
            <table class="order-info">
               
                <tr>
                    <td class="order-info--key">Họ và tên:</td>
                    <td class="order-info--value"><%=dh.getNguoiNhan()%></td>
                </tr>
                <tr>
                    <td class="order-info--key">Số điện thoại:</td>
                    <td class="order-info--value"><%=dh.getSDTNguoiNhan()%></td>
                </tr>
                <tr>
                    <td class="order-info--key">Địa chỉ:</td>
                    <td class="order-info--value"><%=dh.getDiaChiNguoiNhan()%></td>
                </tr>
                 <tr>
                    <td class="order-info--key">Ngày mua hàng:</td>
                    <td class="order-info--value"><%=dh.getNgayDatHang()%></td>
                </tr>
                <tr class="total-cost">
                    <td class="order-info--key">Tổng tiền:</td>
                    <td class="order-info--value"><%=dh.getTongTien()%> VND</td>
                </tr>
		 <%session.setAttribute("SHOP", null);%>	
            </table>
            <div class="btn-wrapper">
                <a href="trang-chu.jsp" class="btn">Tiếp tục mua sắm</a>
            </div>
        </div>
    </div>
<jsp:include page="cuoi-trang.jsp"></jsp:include>