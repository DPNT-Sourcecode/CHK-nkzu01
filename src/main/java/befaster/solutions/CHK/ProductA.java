package befaster.solutions.CHK;

public class ProductA extends Product{

    @Override
    public Integer BuyXForY(Integer offerQuantity, Integer offerPrice) {
        Integer nr_prom = this.quantity / offerQuantity;
        Integer price = nr_prom * offerPrice;
        return price;
    }
}

