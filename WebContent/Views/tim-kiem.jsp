<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="JavaBeans.*"%>
<%@page import="BusinessLogics.*"%>
<jsp:include page="dau-trang.jsp"></jsp:include>
<jsp:include page="Menu-Member.jsp"></jsp:include>
    <div class="container padding-width">
        <div class="row">
            <div class="col-aside">
                <aside class="section-categories row">
                    <div class="container-categories">

					<h2>
						Loại sách <i id="btn-categories"
							class="fa fa-chevron-down right hide-on-desktop"
							aria-hidden="true"></i>
					</h2>
					<ul class="menu-categories">
						<%
							List<TheLoai> lstTheLoai = TheLoaiBL.DocTatCa();
							if (lstTheLoai.size() > 0) {
								for (TheLoai sp : lstTheLoai) {
						%>
						<li class="item-categories"><a
							href="Sach-theo-loai.jsp?maTheLoai=<%=sp.getIDTheLoai()%>"><%=sp.getTenTL()%></a>
						</li>
						<%
							}
							}
						%>
					</ul>
				</div>
				
			</aside>
		</div>
		<div class="col-content">
			<section class="section-hero"></section>
			<section class="section-display-book">
				<div class="container-suggest">
					<div class="row">
						<div class="item-suggest col-half-desktop">
							<img src="img/display-1.jpg" alt="book"> 
						</div>
						<div class="item-suggest col-half left">
							<img src="img/display-2.jpg" alt="book">
						</div>
						<div class="item-suggest col-half left">
							<img src="img/display-3.jpg" alt="book">
						</div>
					</div>
				</div>
				<div class="container-lastest">
					<h2 class="title"></h2>

					<div class="row">

						<%--Bắt đầu --%>


						<%
						if(request.getAttribute("lstSach")!=null)
						{
							List<Sach> lstSachTim = (List<Sach>)request.getAttribute("lstSach");
							if (lstSachTim.size()>0) 
							{
								for (Sach sp : lstSachTim) 
								{
						%>

						<div class="container col-desktop">
							<div class="container-product row">
								<div class="img-product col-1">
										<%if(sp.getHinhAnh().equals("CapNhat")){%>
									<img src="img/product-1.png" alt="book"> <%}else{
									String hinhAnh = "img/" + sp.getHinhAnh();%>
								<img src="<%=hinhAnh%>" alt="book" width="355" height="208"> <%} %>
								</div>
								<div class="info-product col-2">
									<h4 class="book-name"><%=sp.getTenSach()%></h4>
									<p class="cost-book"><%=sp.getDonGia()%></p>
									<button class="cart">
										<i class="fa fa-shopping-cart" aria-hidden="true"></i> ADD TO
										CART
									</button>
								</div>
							</div>
						</div>


						<%
							}
							}}
						%>
						<%--Kết thúc --%>





					</div>
				</div>
		</div>
	</div>
</div>
</section>
</div>
</div>
</div>
<jsp:include page="cuoi-trang.jsp"></jsp:include>