<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="JavaBeans.*" %>
<%@page import="BusinessLogics.*" %>
<jsp:include page="Views/dau-trang.jsp"></jsp:include>
<%if(session.getAttribute("username")!=null)
{
if(((String)session.getAttribute("username")).equals("admin"))
{%>
<jsp:include page="Views/menu-admin.jsp"></jsp:include><%}
else{%>
<jsp:include page="Views/Menu-Member.jsp"></jsp:include><%}}
else{%><jsp:include page="Views/Menu-Member.jsp"></jsp:include><%}%>
    <div class="container padding-width">
        <div class="row">
            <div class="col-aside">
                <aside class="section-categories row">
                    <div class="container-categories">
                        <h2>Loại sách
                            <i id="btn-categories" class="fa fa-chevron-down right hide-on-desktop" aria-hidden="true"></i>
                        </h2>
                        <ul class="menu-categories">
                        <%
                        List<TheLoai> lstTheLoai = TheLoaiBL.DocTatCa();
                        if(lstTheLoai.size()>0)
                        {
                        	for(TheLoai sp : lstTheLoai)
                        	{
                        %> 
                            <li class="item-categories">
                            <a href="Sach-theo-loai.jsp?maTheLoai=<%=sp.getIDTheLoai()%>"><%=sp.getTenTL()%></a> </li> 
                          <%}}%>   
                        </ul>
                    </div>
                   
                </aside>
            </div>
            <div class="col-content">
                <section class="section-hero">
                                   
                </section>
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
                        <h2 class="title">Danh mục sản phẩm</h2>
                        <div class="row">
 
<%
	String maTheLoai = request.getParameter("maTheLoai");
	List <Sach> lstSach= SachBL.DocTheoTheLoai(maTheLoai);
%>                  

						<%--Bắt đầu --%>
                        <%
                        
                        if(lstSach.size()>0)
                        {
                        	for(Sach sp : lstSach)
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
                                        <h4 class="book-name"><%=sp.getTenSach() %></h4>
                                        <p class="cost-book"><%=sp.getDonGia() %></p>
                                        <a href="LoginAddtoCard?action=buy&id=<%=sp.getIDSach()%>"><button class="cart">
                                            <i class="fa fa-shopping-cart" aria-hidden="true"></i> ADD TO CART</button></a>
                                    </div>
                                </div>
                            </div>
                            <%}} %>
                           
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
    <jsp:include page="Views/cuoi-trang.jsp"></jsp:include>