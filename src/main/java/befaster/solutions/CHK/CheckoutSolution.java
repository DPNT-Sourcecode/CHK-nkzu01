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

//        check the number of E's and remove the corresponding B's
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


//        +------+-------+------------------------+
//                | Item | Price | Special offers         |
//                +------+-------+------------------------+
//                | A    | 50    | 3A for 130, 5A for 200 |
//| B    | 30    | 2B for 45              |
//| C    | 20    |                        |
//| D    | 15    |                        |
//| E    | 40    | 2E get one B free      |
//| F    | 10    | 2F get one F free      |
//| G    | 20    |                        |
//| H    | 10    | 5H for 45, 10H for 80  |
//| I    | 35    |                        |
//| J    | 60    |                        |
//| K    | 80    | 2K for 150             |
//| L    | 90    |                        |
//| M    | 15    |                        |
//| N    | 40    | 3N get one M free      |
//| O    | 10    |                        |
//| P    | 50    | 5P for 200             |
//| Q    | 30    | 3Q for 80              |
//| R    | 50    | 3R get one Q free      |
//| S    | 30    |                        |
//| T    | 20    |                        |
//| U    | 40    | 3U get one U free      |
//| V    | 50    | 2V for 90, 3V for 130  |
//| W    | 20    |                        |
//| X    | 90    |                        |
//| Y    | 10    |                        |
//| Z    | 50    |                        |
//        +------+-------+------------------------+
        for (Map.Entry<Character, Product> entry : products.entrySet()) {
            Character key = entry.getKey();
            Product product = entry.getValue();
            totalValue += product.Offer();
        }
//
//        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
//            Character key = entry.getKey();
//            Integer val = entry.getValue();
//            if (key.equals('A')) {
////                first promotion
//                Integer nr_promotions1 = val / nr_A_prom_1;
//                totalValue += 200 * nr_promotions1;
//                val -= nr_promotions1 * nr_A_prom_1;
////                second promotion
//                Integer nr_promotions2 = val / nr_A_prom_2;
//                totalValue += 130 * nr_promotions2;
//                totalValue += (val % nr_A_prom_2) * 50;
//            } else if (key.equals('B')) {
//                Integer nr_promotions = val / nr_B_prom;
//                totalValue += 45 * nr_promotions;
//                totalValue += (val % nr_B_prom) * 30;
//            } else if (key.equals('C')) {
//                totalValue += 20 * val;
//            } else if (key.equals('D')) {
//                totalValue += 15 * val;
//            } else if (key.equals('E')) {
//                totalValue += 40 * val;
//            } else if (key.equals('F')) {
//                Integer nr_promotions = val / nr_F_prom;
//                val -= nr_promotions;
//                totalValue += 10 * val;
//            } else if (key.equals('G')) {
//                totalValue += 20 * val;
//            } else {
////                bad input
//                return -1;
//            }
//
//        }

        return totalValue;
    }

}


