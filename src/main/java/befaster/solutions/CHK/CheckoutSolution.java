package befaster.solutions.CHK;

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


        for (int i = 0; i < skus.length(); i++) {
            Character ch = skus.charAt(i);
            if (!freq.containsKey(ch)) {
                freq.put(ch, 0);
            }
            Integer val = freq.get(ch);
            freq.put(ch, val + 1);
        }

//        check the number of E's and remove the corresponding B's
        if (freq.containsKey('B') && freq.containsKey('E')) {
            Integer nr_e = freq.get('E');
            Integer nr_b = 0;
            nr_b = freq.get('B');
            if (nr_b >= nr_e / nr_E_prom) {
                nr_b -= nr_e / nr_E_prom;
            } else {
                nr_b = 0;
            }
            freq.put('B', nr_b);
        }



        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (key.equals('A')) {
//                first promotion
                Integer nr_promotions1 = val / nr_A_prom_1;
                totalValue += 200 * nr_promotions1;
                val -= nr_promotions1 * nr_A_prom_1;
//                second promotion
                Integer nr_promotions2 = val / nr_A_prom_2;
                totalValue += 130 * nr_promotions2;
                totalValue += (val % nr_A_prom_2) * 50;
            } else if (key.equals('B')) {
                Integer nr_promotions = val / nr_B_prom;
                totalValue += 45 * nr_promotions;
                totalValue += (val % nr_B_prom) * 30;
            } else if (key.equals('C')) {
                totalValue += 20 * val;
            } else if (key.equals('D')) {
                totalValue += 15 * val;
            } else if (key.equals('E')) {
                totalValue += 40 * val;
            } else if (key.equals('F')) {
                Integer nr_promotions = val / nr_F_prom;
                val -= nr_promotions;
                totalValue += 10 * val;
            } else {
//                bad input
                return -1;
            }

        }

        return totalValue;
    }
}
