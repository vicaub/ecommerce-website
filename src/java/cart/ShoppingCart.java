package cart;

import entity.Product;
import java.util.*;

/**
 *
 * @author juanluis
 */
public class ShoppingCart {
    
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        items = new ArrayList<ShoppingCartItem>();
    }

    public synchronized void addItem(Product product) {
        ShoppingCartItem rightItem = null;
        for (ShoppingCartItem item : items) {
            if (item.getProduct().equals(product)) {
                rightItem = item;
            }
        }
        if (rightItem != null) {
            rightItem.setQuantity(rightItem.getQuantity() + 1);
        } else {
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product);
            items.add(shoppingCartItem);
        }
    };
    
    public synchronized void update(Product product, int quantity) {
        ShoppingCartItem rightItem = null;
        for (ShoppingCartItem item : items) {
            if (item.getProduct().equals(product)) {
                rightItem = item;
            }
        }
        if (quantity > 0) {
            rightItem.setQuantity(quantity);
        } else {
            items.remove(rightItem);
        }
    };
    
    public synchronized List<ShoppingCartItem> getItems() {
        return items;
    };
    
    public synchronized int getNumberOfItems() {
        int number = 0;
        for (ShoppingCartItem item : items) {
            number += item.getQuantity();
        }
        return number;
    };
    
    public synchronized double getTotal() {
        double total = 0;
        for (ShoppingCartItem item : items) {
            total += item.getTotal();
        }
        return total;
    };
    
    public synchronized void clear() {
        items = new ArrayList<ShoppingCartItem>();
    };
}