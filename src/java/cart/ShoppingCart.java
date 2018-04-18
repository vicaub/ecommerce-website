package cart;

import entity.Product;
import java.text.NumberFormat;
import java.util.*;

/**
 *
 * @author juanluis
 */
public class ShoppingCart {

    public synchronized void addItem(Product product) {
    };
    
    public synchronized void update(Product product, String quantity) {
    };
    
    public synchronized List<ShoppingCartItem> getItems() {
        return null;
    };
    
    public synchronized int getNumberOfItems() {
        return 0;
    };
    
    public synchronized double getTotal() {
        return 0;
    };
    
    public synchronized void clear() {
    };
}