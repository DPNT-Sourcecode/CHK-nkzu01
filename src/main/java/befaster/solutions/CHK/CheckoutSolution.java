package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
//        throw new SolutionNotImplementedException();
        HashMap<Character, Integer> freq = new HashMap<>(4, 0);
        Integer totalValue = 0;

        for (int i = 0; i < skus.length(); i++) {
            Character ch = skus.charAt(i);
            Integer val = freq.get(ch);
            freq.put(ch, val + 1);
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            Character key = entry.getKey();
            if (key.equals('A')) {
                totalValue += 50;
            } else if (key.equals('B')) {
                totalValue += 30;
            } else if (key.equals('C')) {
                totalValue += 20;
            } else if (key.equals('D')) {
                totalValue += 15;
            }
        }

        return totalValue;
    }
}



