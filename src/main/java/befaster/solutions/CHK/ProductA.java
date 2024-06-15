package befaster.solutions.CHK;

public class ProductA extends Product{

    Integer offerQuantity1;
    Integer offerPrice1;
    Integer offerQuantity2;
    Integer offerPrice2;

    public ProductA(Integer offerQuantity1, Integer offerPrice1, Integer offerQuantity2, Integer offerPrice2) {
        this.offerQuantity1 = offerQuantity1;
        this.offerPrice1 = offerPrice1;
        this.offerQuantity2 = offerQuantity2;
        this.offerPrice2 = offerPrice2;
    }

    public ProductA(String name, Integer price, Integer quantity, Integer offerQuantity1, Integer offerPrice1, Integer offerQuantity2, Integer offerPrice2) {
        super(name, price, quantity);
        this.offerQuantity1 = offerQuantity1;
        this.offerPrice1 = offerPrice1;
        this.offerQuantity2 = offerQuantity2;
        this.offerPrice2 = offerPrice2;
    }

    @Override
    public Integer calculateOffer() {
        Integer nr_prom1 = this.quantity / offerQuantity1;
        Integer totalPrice = nr_prom1 * offerPrice1;
        Integer quantity = this.getQuantity();
        quantity -= nr_prom1 * offerQuantity1;

        Integer nr_prom2 = quantity / offerQuantity2;
        totalPrice += offerPrice2 * nr_prom2;
        totalPrice += (quantity % offerQuantity2) * this.price;
        return totalPrice;
    }
}
