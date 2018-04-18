<%@page import="cart.ShoppingCartItem"%>
<%@page import="cart.ShoppingCart"%>
<%@page import="entity.Product"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page import="entity.Category" %>
<%@ page import="java.util.List" %>

    <head>
        <meta http-equiv="Expires" CONTENT="0">
        <meta http-equiv="Cache-Control" CONTENT="no-cache">
        <meta http-equiv="Pragma" CONTENT="no-cache">
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>eCommerce Sample</title>
    </head>
    
    <body>
        
        <%
        ShoppingCart shoppingCart =  (ShoppingCart) request.getAttribute("shoppingCart");
        %>
        
        <img src="img/cart.gif"/>
        <%=shoppingCart.getNumberOfItems()%> items

        <h3>Your shopping cart contains <%=shoppingCart.getNumberOfItems()%> items.</h3>

        
        <a href="clearcart.do">Clear Cart</a>
        <br/>
        <a href="init.do">Continue shopping</a>
        
        <br/><br/>

        <table width="80%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
            <%
                for (ShoppingCartItem item : shoppingCart.getItems()) {
                    Product product = item.getProduct();
            %>
            <tr>
                <td width="25%" valign="center" align="middle">
                        <img src="img/products/<%=product.getName()%>.png"
                             alt="<%=product.getName()%>" />
                </td>
                <td width="25%" valign="center" align="middle">
                    <b> <%=product.getName()%> </b>
                    <br/><br/>
                    <%=product.getDescription()%>
                </td>

                <td width="25%" valign="center" align="middle">
                    <%=String.format("%.2f", product.getPrice())%> &#8364;
                </td>

                <td width="25%" valign="center" align="middle">
                    <form action="updatecart.do">
                        <input type="number" name="quantity" min="0" value="<%=item.getQuantity()%>">
                        <input type="number" hidden="true" name="productid" value="<%=item.getProduct().getId()%>">
                        <input type="submit" value="Update">
                    </form>
                </td>
            </tr>
            <% } %>
        </table>

    </body>