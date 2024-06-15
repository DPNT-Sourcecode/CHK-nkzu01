package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        HashMap<Character, Integer> freq = new HashMap<>(4);
        Integer totalValue = 0;
        Integer nr_A_prom = 3;
        Integer nr_B_prom = 2;

        for (int i = 0; i < skus.length(); i++) {
            Character ch = skus.charAt(i);
            if (!freq.containsKey(ch)) {
                freq.put(ch, 0);
            }
            Integer val = freq.get(ch);
            freq.put(ch, val + 1);
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (key.equals('A')) {
                Integer nr_promotions = val / nr_A_prom;
                totalValue += 130 * nr_promotions;
                totalValue += (val % nr_A_prom) * 50;
            } else if (key.equals('B')) {
                Integer nr_promotions = val / nr_B_prom;
                totalValue += 45 * nr_promotions;
                totalValue += (val % nr_B_prom) * 30;
            } else if (key.equals('C')) {
                totalValue += 20 * val;
            } else if (key.equals('D')) {
                totalValue += 15 * val;
            } else {
//                bad input
                return -1;
            }

        }

        return totalValue;
    }
}





