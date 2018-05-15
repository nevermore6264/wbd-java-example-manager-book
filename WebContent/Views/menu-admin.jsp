<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<li class="customer-login hide-on-mobile">Xin chào : <span><%=session.getAttribute("username") %></span>
			<br /> <a href="LogoutServlet" class="logout">Logout</a>
		</li>
	</ul>
</nav>
</header>
