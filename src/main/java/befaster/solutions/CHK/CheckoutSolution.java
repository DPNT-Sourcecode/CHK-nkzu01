package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        HashMap<Character, Integer> freq = new HashMap<>(4);
        Integer totalValue = 0;
        Integer nr_A_prom_1 = 5;
        Integer nr_A_prom_2 = 3;
        Integer nr_B_prom = 2;
        Integer nr_E_prom = 2;
        Integer nr_F_prom = 3;

        HashMap<Character, Product> products = new HashMap<>(0);

        for (int i = 0; i < skus.length(); i++) {
            Character ch = skus.charAt(i);

            if (!products.containsKey(ch)) {
                Product product = null;
                if (ch.equals('A')) {
                    product = new ProductA(ch.toString(), 50, 0, 5, 200, 3,130);
                } else if (ch.equals('B')) {
                    product = new ProductB(ch.toString(), 30, 0, 2, 45);
                } else if (ch.equals('C')) {
                    product = new Product(ch.toString(), 20, 0);
                } else if (ch.equals('D')) {
                    product = new Product(ch.toString(), 15, 0);
                }  else if (ch.equals('E')) {
                    product = new ProductE(ch.toString(), 40, 0, 2, 1, 'B');
                } else {
                    return -1;
                }

                products.put(ch, product);
            }
            if (!freq.containsKey(ch)) {
                freq.put(ch, 0);
            }
            Integer val = freq.get(ch);
            Product product = products.get(ch);
            product.setQuantity(product.getQuantity() + 1);
            freq.put(ch, val + 1);
        }

        for (Map.Entry<Character, Product> entry : products.entrySet()) {
            Character key = entry.getKey();
            Product product = entry.getValue();
            product.reduceOffer(products);
        }


        for (Map.Entry<Character, Product> entry : products.entrySet()) {
            Character key = entry.getKey();
            Product product = entry.getValue();
            totalValue += product.calculateOffer();
        }

        return totalValue;
    }

}


