package befaster.solutions.CHK;

public class ProductB extends Product{
    Integer offerQuantity;
    Integer offerPrice;

    public ProductB(Integer offerQuantity, Integer offerPrice) {
        this.offerQuantity = offerQuantity;
        this.offerPrice = offerPrice;
    }

    public ProductB(String name, Integer price, Integer quantity, Integer offerQuantity, Integer offerPrice) {
        super(name, price, quantity);
        this.offerQuantity = offerQuantity;
        this.offerPrice = offerPrice;
    }

    @Override
    public Integer calculateOffer() {
        Integer total = 0;
        Integer nr_prom = this.quantity / offerQuantity;
        total += nr_prom * offerPrice;
        total += (quantity % offerQuantity) * this.price;
        return total;
    }
}

