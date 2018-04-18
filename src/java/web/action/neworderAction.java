/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author victoraubin
 */
public class neworderAction extends Action {
    
    CategoryModel categoryModel;
    ShoppingCart shoppingCart;
    ProductModel productModel;

    public neworderAction(ShoppingCart shoppingCart, ProductModel productModel, CategoryModel categoryModel) {
        this.shoppingCart = shoppingCart;
        this.productModel = productModel;
        this.categoryModel = categoryModel;
    }

    @Override
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int productid = (int) Integer.parseInt(req.getParameter("productid"));
        req.setAttribute("categories", categoryModel.retrieveAll());
        req.setAttribute("products", productModel.retrieveFromCategory(categoryModel.retrieve((int) Integer.parseInt(req.getParameter("categoryid")))));
        
        shoppingCart.addItem(productModel.retrieveFromId(productid));
        req.setAttribute("shoppingCart", shoppingCart);
        
        ViewManager.nextView(req, resp, "/view/category.jsp");
    }
    
}
