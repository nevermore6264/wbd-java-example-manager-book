<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="BusinessLogics.*"%>
<%@page import="JavaBeans.*"%>
<jsp:include page="dau-trang.jsp"></jsp:include>
<jsp:include page="Menu-Member.jsp"></jsp:include>

<%
Account acc = AccountBL.LayAccountTheoUsername((String)session.getAttribute("username"));
KhachHang kh = KhachHangBL.LayKhachHangTheoAccount(acc.getIDAccount());
%>
<div class="container padding-width">
        <div class="row wrapper-register">
            <h2 class="align-center">Xin chào: <span><%=session.getAttribute("username")%></span>!</h2>
            <form action="UserInfoServlet" method="post">
                <label for="" >Họ và tên</label>
                <input required class="custom-input" type="text" name="fullname" value="<%=kh.getHoTen()%>">
                <label for="" >Tài khoản</label>
                <input required readonly="true" class="custom-input" type="text" name="username" value="<%=acc.getUsername()%>">
                <label for="">Mật khẩu</label>
                <input required class="custom-input" type="password" name="password" value="<%=acc.getPassword()%>">
                <label for="">Số điện thoại</label>
                <input required class="custom-input" type="text" name="phone" value="<%=kh.getSDT()%>">
                <label for="">Email</label>
                <input required class="custom-input" type="email" name="email" value="<%=kh.getEmail()%>">                
                <div class="row">
                    <div class="col-half">
                        <button type="submit" class="btn btn--orange"><span>Submit</span></button>
                    </div>
                    </form>
                    <div class="col-half"><a href="trang-chu.jsp"><img src="img/button-Cancel.png" alt="Cancel"/>
                  	</a>
                    </div>             
                </div>
                
            
					
        </div>

    </div>

<jsp:include page="cuoi-trang.jsp"></jsp:include>    