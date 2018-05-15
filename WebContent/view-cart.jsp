<%@page import="BusinessLogics.*"%>
<%@page import="JavaBeans.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="Views/dau-trang.jsp"></jsp:include>
<jsp:include page="Views/Menu-Member.jsp"></jsp:include>
                 <% 
           if (session.getAttribute("SHOP")==null)
           {
        	   %>
        	   <div class="row">
        	   <a href="trang-chu.jsp">
                <button type="submit" class="btn btn-buy btn--blue btn--large"><span>Xem cửa hàng</span></button></a>
            </div>
        	    <%
           }
           else
           {
           %>
<div class="container padding-width">
            <h2 class="align-center">Bạn chưa mua sản phẩm nào tại shop !!!</h2>
            <%--Copy từ đây --%>
            <form action="DatHangServlet" method ="get">  
            <div class="col-order-2">
                    <table class="cart-table">
                     
            <%
            Cart shop = (Cart)session.getAttribute("SHOP");
            if(request.getParameter("id")!=null)
            {
            	try {
            	String id = request.getParameter("id");
            	if(shop.keySet()!=null)
            	{
            	for(Object i: shop.keySet())
        		{
        			if(i.equals(id))
        			{
        				shop.remove(i);
        			}
        		}
            	}
            	} catch(ConcurrentModificationException e) {
        			e.printStackTrace();
        		}
            }
           HashMap<Integer,Integer> ThongTin = new HashMap(); //Hashmap chứa id sách và số lượng.
           double TotalCost = 0;
           for (Object i : shop.keySet())
           { 
        	   String temp = (String)i;
        	   int id = Integer.parseInt(temp);
        	   Sach s = SachBL.DocTheoID(id);    	  
        	   TotalCost = TotalCost + s.getDonGia()*shop.get(i);
        	   ThongTin.put(id, shop.get(i));
           %>
        	   
           
          
            <tr class="container-cart">
                <td class="book-img">
                    <%if(s.getHinhAnh().equals("CapNhat")){%>
									<img src="img/product-1.png" alt="book"> <%}else{
									String hinhAnh = "img/" + s.getHinhAnh();%>
								<img src="<%=hinhAnh%>" alt="book" width="355" height="208"> <%} %>
                </td>
                <td class="book-info">
                    <h4 class="book-name"><%=s.getTenSach()%></h4>
                    <span class="book-cost"><%=s.getDonGia()%></span><br>  
                    <span class="qty">Số lượng:</span>
                    <input type="number" class="custom-input required="true"" min="0" value="<%=shop.get(i)%>" name="qty<%=i%>">
                    <a href="view-cart.jsp?id=<%=i%>">
                    <img src="img/button-Delete.png" alt="Delete" width="30px" height="30px"/>
                    </a> 
                </td>
            </tr>
<%}%>
</table>
<%
session.setAttribute("ThongTin",ThongTin); //ThongTin chứa id sách và số lượng đã update
%>
                </div>
            <%--Đến đây --%>
       
            <div class="row wrapper-order">
                <div class="col-order-1">
                        <label for="" >Họ và tên <span class="required-symbol">(*)</span></label>
                        <input required class="custom-input" type="text" name="fullname">
                        <label for="">Số điện thoại <span class="required-symbol">(*)</span></label>
                        <input required class="custom-input" type="text" name="phone">
                        <label for="">Địa chỉ <span class="required-symbol">(*)</span></label>
                        <input required class="custom-input" type="text" name="address">
                        <label for="">Ghi chú</label>
                        <textarea rows="4" cols="50" class="custom-input" type="text" name="note"></textarea>
                </div>
                <p><b>Tổng tiền: <%=TotalCost%></b></p>
            </div>
            
            <div class="row">          
                <button type="submit" class="btn btn-buy btn--blue btn--large"><span>Thanh toán</span></button>
            </div>
        </form>
    </div>
<%}%>  
                    

    
    <jsp:include page="Views/cuoi-trang.jsp"></jsp:include>