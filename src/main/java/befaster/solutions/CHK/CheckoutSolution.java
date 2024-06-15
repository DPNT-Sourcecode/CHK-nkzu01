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
                } else if (ch.equals('F')) {
                    product = new ProductB(ch.toString(), 10, 0, 3, 20);
                } else if (ch.equals('G')) {
                    product = new Product(ch.toString(), 20, 0);
                } else if (ch.equals('H')) {
                    product = new ProductA(ch.toString(), 10, 0, 10, 80, 5,45);
                }else if (ch.equals('I')) {
                    product = new Product(ch.toString(), 35, 0);
                } else if (ch.equals('J')) {
                    product = new Product(ch.toString(), 60, 0);
                } else if (ch.equals('K')) {
                    product = new ProductB(ch.toString(), 80, 0, 2, 150);
                } else if (ch.equals('L')) {
                    product = new Product(ch.toString(), 90, 0);
                } else if (ch.equals('M')) {
                    product = new Product(ch.toString(), 15, 0);
                } else if (ch.equals('N')) {
                    product = new ProductE(ch.toString(), 40, 0, 3, 1, 'M');
                } else if (ch.equals('O')) {
                    product = new Product(ch.toString(), 10, 0);
                } else if (ch.equals('P')) {
                    product = new ProductB(ch.toString(), 50, 0, 5, 200);
                } else if (ch.equals('Q')) {
                    product = new ProductB(ch.toString(), 30, 0, 3, 80);
                } else if (ch.equals('R')) {
                    product = new ProductE(ch.toString(), 50, 0, 3, 1, 'Q');
                } else if (ch.equals('S')) {
                    product = new Product(ch.toString(), 30, 0);
                } else if (ch.equals('T')) {
                    product = new Product(ch.toString(), 20, 0);
                } else if (ch.equals('U')) {
                    product = new ProductB(ch.toString(), 40, 0, 4, 120);
                } else if (ch.equals('V')) {
                    product = new ProductA(ch.toString(), 50, 0, 3, 130, 2,90);
                } else if (ch.equals('W')) {
                    product = new Product(ch.toString(), 20, 0);
                }  else if (ch.equals('X')) {
                    product = new Product(ch.toString(), 90, 0);
                }  else if (ch.equals('Y')) {
                    product = new Product(ch.toString(), 10, 0);
                } else if (ch.equals('Z')) {
                    product = new Product(ch.toString(), 50, 0);
                }   else {
                    return -1;
                }
//| W    | 20    |                        |
//| X    | 90    |                        |
//| Y    | 10    |                        |
//| Z    | 50    |                        |
//        +------+-------+------------------------+
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
