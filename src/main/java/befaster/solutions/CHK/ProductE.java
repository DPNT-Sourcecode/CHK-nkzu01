package befaster.solutions.CHK;

import java.util.HashMap;

public class ProductE extends Product{
    Integer offerQuantity;
    Integer offerReduceQuantityAmount;
    Character productReduceName;

    public ProductE(Integer offerQuantity, Integer offerReduceQuantityAmount, Character productReduceName) {
        this.offerQuantity = offerQuantity;
        this.offerReduceQuantityAmount = offerReduceQuantityAmount;
        this.productReduceName = productReduceName;
    }

    public ProductE(String name, Integer price, Integer quantity, Integer offerQuantity, Integer offerReduceQuantityAmount, Character productReduceName) {
        super(name, price, quantity);
        this.offerQuantity = offerQuantity;
        this.offerReduceQuantityAmount = offerReduceQuantityAmount;
        this.productReduceName = productReduceName;
    }

    @Override
    public void reduceOffer(HashMap<Character, Product> products) {
        if (!products.containsKey(productReduceName))
            return;
        Product product = products.get(productReduceName);
        if (product.getQuantity() >= (this.quantity / this.offerQuantity) * offerReduceQuantityAmount) {
            product.setQuantity(product.getQuantity() - (this.quantity / this.offerQuantity) * offerReduceQuantityAmount);
            return;
        }
        product.setQuantity(0);
    }
}



