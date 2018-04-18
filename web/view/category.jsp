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
        List<Category> categories = (List<Category>) request.getAttribute("categories");
        int selectedCategoryId = Integer.parseInt(request.getParameter("categoryid"));
        Category selectedCategory = new Category();
        search:
        for (Category category : categories) {
            if (category.getId() == selectedCategoryId) {
                selectedCategory = category;
                break search;
            }
        }
        List<Product> products = (List<Product>) request.getAttribute("products");
        %>

        <h3> Products of <%=selectedCategory.getName()%> </h3>
        
        <img src="img/cart.gif"/>
        0 items
        
        <br/><br/>

        <table width="80%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
        
            <tr>
                <td>
                    <table width="100%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
                        <%
                        for(Category category : categories){
                        %>

                        <tr>
                            <td valign="center" align="middle">
                            <a href="category.do?categoryid=<%=category.getId()%>">
                                <%=category.getName()%>
                            </a>
                            </td>
                        </tr>

                       <% } %>
                    </table>
                </td>
                <td>
                    <table width="100%" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
                        <%
                            int index = 0;
                            for(Product product : products) {
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
                                <button type="button" onclick="window.location.href=''"> Add to cart </button>
                            </td>
                        </tr>
                        <% } %>
                    </table>
                </td>
            </tr>

          
        </table>

    </body>