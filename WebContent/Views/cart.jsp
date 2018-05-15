<%@page import="BusinessLogics.*"%>
<%@page import="JavaBeans.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="dau-trang.jsp"></jsp:include>
<jsp:include page="Menu-Member.jsp"></jsp:include>
           <% 
           if (session.getAttribute("SHOP")==null)
           {
        	   %>
        	   <div class="row">
        	   <a href="trang-chu.jsp">
                <button type="submit" class="btn btn-buy btn--blue btn--large"><span>Go to Shop</span></button></a>
            </div>
        	    <%
           }
           else
           {
           %>
<div class="container padding-width">
            <h2 class="align-center">Shopping Cart</h2>
            <%--Copy từ đây --%>
            <div class="col-order-2">
                    <table class="cart-table">
                     
            <%
            Cart shop = (Cart)session.getAttribute("SHOP");
            if(request.getParameter("id")!=null)
            {
            	String id = request.getParameter("id");
            	for(String i: shop.keySet())
        		{
        			if(i.equals(id))
        			{
        				shop.remove(i);
        			}
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
                    <img src="img/specials-2.png" alt="book">
                </td>
                <td class="book-info">
                    <h4 class="book-name"><%=s.getTenSach()%></h4>
                    <span class="book-cost"><%=s.getDonGia()%></span><br>  
                    <span class="qty">Số lượng:</span>
                    <input type="number" class="custom-input required="true"" min="0" value="<%=shop.get(i)%>" name="qty<%=i%>">
                    <a href="Views/cart.jsp?id=<%=i%>">
                    <button class="fa fa-trash-o" aria-hidden="true" type="submit">
                    </button>
                    </a>         
                </td>
            </tr>
<%}%> 
</table>
<%
session.setAttribute("ThongTin",ThongTin);
%>
                </div>
    </div>
<%}%>  
                    

    
    <jsp:include page="cuoi-trang.jsp"></jsp:include>