package befaster.solutions.CHK;

public class BuyXForY {
    Integer offerQuantity;
    Integer offerPrice;

    public BuyXForY(Integer offerQuantity, Integer offerPrice) {
        this.offerQuantity = offerQuantity;
        this.offerPrice = offerPrice;
    }

    public Integer getOfferQuantity() {
        return offerQuantity;
    }

    public void setOfferQuantity(Integer offerQuantity) {
        this.offerQuantity = offerQuantity;
    }

    public Integer getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Integer offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Integer calculateOffer(Product product) {
        Integer nr_promotions = product.getQuantity() / offerQuantity;
        return nr_promotions * offerPrice;
    }
}

