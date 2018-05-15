<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="Views/dau-trang.jsp"></jsp:include>

<nav class="nav-bar row">
            <div class="btn-toggle-wrapper hide-on-desktop" id="btn-menu">
                <span class="btn-toggle"></span>
            </div>
            <ul class="menu">
                <li class="menu-item">
                    <a href="trang-chu.jsp"><i class="fa fa-home" aria-hidden="true"></i> Trang chủ</a>
                </li>
                <li class="menu-item">
                    <a href="login.jsp"><i class="fa fa-star" aria-hidden="true"></i> Đăng nhập</a>
                </li>
            </ul>
           
        </nav>
    </header>
    <%if(request.getAttribute("CheckUserName")!=null){%>
     <h2 class="align-center">Tên tài khoản đã tồn tại</h2>
    <%}%>
    <div class="container padding-width">
        <div class="row wrapper-register">
            <h2 class="align-center">Đăng ký tài khoản mới</h2>
            <form action="DangKyServlet" method = "get">
                <label for="" >Họ và tên</label>
                <input required class="custom-input" type="text" name="fullname">
                <label for="" >Tài khoản</label>
                <input required class="custom-input" type="text" name="username">
                <label for="">Mật khẩu</label>
                <input required class="custom-input" type="password" name="password">
                <label class="gender">Giới tính</label><br />
                <input checked id="male" type="radio" name="gender" value="nam">
                <label for="male">Nam</label>
                <input id="female" type="radio" name="gender" value="nu">
                <label for="female">Nữ</label><br /><br />
                <label for="">Số điện thoại</label>
                <input required class="custom-input" type="text" name="phone">
                <label for="">Email</label>
                <input required class="custom-input" type="email" name="email">
                <button type="submit" class="btn"><span>Register</span></button>
            </form>

        </div>
    </div>
<jsp:include page="Views/cuoi-trang.jsp"></jsp:include>