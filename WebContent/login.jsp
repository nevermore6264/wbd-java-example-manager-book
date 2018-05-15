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
                    <a href="register.jsp"><i class="fa fa-star" aria-hidden="true"></i> Đăng ký</a>
                </li>
            </ul>           
        </nav>
    </header>  
    <div class="container padding-width">
        <div class="row wrapper-login">
            <h2 class="align-center">Đăng nhập hệ thống</h2>
            <span class="wrong-password align-center">Mật không không chính xác</span>
            <form action="Authentication" method="post">
                <label for="" >Tài khoản</label>
                <input id="login-username" class="custom-input" type="text" name="username">
                <label for="">Mật khẩu</label>
                <input id="login-password" class="custom-input" type="password" name="password">
                <input type="checkbox" id="remember">
                <label for="remember">Nhớ mật khẩu?</label>
                <button id="btn-login" type="submit" class="btn"><span>Login</span></button>
            </form>
            <div class="register-link">
                <a href="register.jsp">Bạn chưa có tài khoản?</a>
            </div>

        </div>
    </div>

<jsp:include page="Views/cuoi-trang.jsp"></jsp:include>