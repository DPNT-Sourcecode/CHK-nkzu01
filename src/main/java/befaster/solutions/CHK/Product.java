package befaster.solutions.CHK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Product {
    int price;
    int offerPrice1;
    int offerPrice2;
    int offerQuantity1;
    int offerQuantity2;
    int quantity;

    public Integer calculateDoublePromotion() {
        Integer total = 0;
//                first promotion
        Integer nr_promotions1 = quantity / offerQuantity1;
        total += offerPrice1 * nr_promotions1;
        quantity -= nr_promotions1 * offerQuantity1;
        //                second promotion
        Integer nr_promotions2 = quantity / offerQuantity2;
        total += offerPrice2 * nr_promotions2;
        total += (quantity % offerQuantity2) * price;
        return total;
    }
}

