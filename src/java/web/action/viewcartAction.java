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
public class viewcartAction extends Action {
    
    private ShoppingCart shoppingCart;

    public viewcartAction(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void perform(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("shoppingCart", shoppingCart);
        ViewManager.nextView(req, resp, "/view/cart.jsp");
    }
    
}
