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
//        if (freq.containsKey('B') && freq.containsKey('E')) {
//            Integer nr_e = freq.get('E');
//            Integer nr_b = 0;
//            nr_b = freq.get('B');
//            if (nr_b >= nr_e / nr_E_prom) {
//                nr_b -= nr_e / nr_E_prom;
//            } else {
//                nr_b = 0;
//            }
//            freq.put('B', nr_b);
//        }
        if (product.getQuantity() >= (this.quantity / this.offerQuantity) * offerReduceQuantityAmount) {
            product.setQuantity(product.getQuantity() - (this.quantity / this.offerQuantity) * offerReduceQuantityAmount);
            return;
        }
        product.setQuantity(0);
    }
}


