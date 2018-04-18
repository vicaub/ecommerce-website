/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import entity.Product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author victoraubin
 */
public class updatecartAction extends Action {
    
    private ShoppingCart shoppingCart;
    private ProductModel productModel;

    public updatecartAction(ShoppingCart shoppingCart, ProductModel productModel) {
        this.shoppingCart = shoppingCart;
        this.productModel = productModel;
    }
    
    @Override
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int quantity = (int) Integer.parseInt(req.getParameter("quantity"));
        int productid =  (int) Integer.parseInt(req.getParameter("productid"));
        Product product = productModel.retrieveFromId(productid);
        
        shoppingCart.update(product, quantity);
        req.setAttribute("shoppingCart", shoppingCart);
        ViewManager.nextView(req, resp, "/view/cart.jsp");
    }
    
}
