<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="nav-bar row">
            <div class="btn-toggle-wrapper hide-on-desktop" id="btn-menu">
                <span class="btn-toggle"></span>
            </div>
            <ul class="menu">
                <li class="menu-item active">
                    <a href="trang-chu.jsp"><i class="fa fa-home" aria-hidden="true"></i> Trang chủ</a>
                </li>
                   <%if(session.getAttribute("username")!=null) 
                {%>
                <li class="customer-login hide-on-mobile">Xin chào : <span><%=session.getAttribute("username") %></span><br /> <a href="LogoutServlet" class="logout">Logout</a>
		</li>
			 <li class="menu-item">
                    <a href="UserInfoServlet" method="get"">
                        <i class="fa fa-user" aria-hidden="true"></i> Tài khoản của tôi</a>
                </li>
                <li class="menu-item">
                    <a href="OrderTrackServlet" method="get">
                        <i class="fa fa-cart-plus" aria-hidden="true"></i>Lịch sử mua hàng</a>
                </li>
		<%} else {%>
                <li class="menu-item">
                    <a href="login.jsp"><i class="fa fa-user" aria-hidden="true"></i> Đăng nhập</a>
                </li>
                <li class="menu-item">
                    <a href="register.jsp"><i class="fa fa-star" aria-hidden="true"></i> Đăng ký</a>
                </li>
                <%} %>
                <li class="menu-item">
                    <a href="ViewCartServlet"><i class="fa fa-shopping-cart" aria-hidden="true"></i> Giỏ hàng</a>
                </li>
             
            </ul>
            <span class="search">
            <form action="TimKiemSachServlet" method="get">
                <input id="search-bar" class="search-bar hide-on-mobile" placeholder="Tìm kiếm" type="text" name="txtTimKiem">
                <button class="btn-search">
                    <i class="fa fa-search fa-lg" aria-hidden="true"></i>
                </button>
    </form>             
            </span>
        </nav>
    </header>
