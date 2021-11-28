package supportClasses;

import shop.RealItem;

public class RealItemCreator {

    public RealItem createRealItem(String ItemName, double price, double weight) {
        RealItem realItem = new RealItem();
        realItem.setName(ItemName);
        realItem.setPrice(price);
        realItem.setWeight(weight);

        return realItem;
    }
}
