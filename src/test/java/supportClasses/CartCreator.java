package supportClasses;

import shop.Cart;
import shop.RealItem;
import shop.VirtualItem;

public class CartCreator {

    public Cart emptyCart(String cartName) {
        return new Cart(cartName);
    }

    public Cart plainCart(String cartName) {
        RealItem realItem1 = new RealItem();
        realItem1.setName("RealItem1");
        realItem1.setPrice(1.55);
        realItem1.setWeight(1.11);

        VirtualItem virtualItem1 = new VirtualItem();
        virtualItem1.setName("virtualItem1");
        virtualItem1.setPrice(100.33);
        virtualItem1.setSizeOnDisk(100.33);

        Cart cart = new Cart(cartName);
        cart.addRealItem(realItem1);
        cart.addVirtualItem(virtualItem1);

        return cart;
    }

    public Cart bigCart(String cartName) {
        RealItem realItem1 = new RealItemCreator().createRealItem("realItem1", 1.11, 2.22);
        RealItem realItem2 = new RealItemCreator().createRealItem("realItem2", 3.33, 4.44);
        RealItem realItem3 = new RealItemCreator().createRealItem("realItem3", 5.55, 6.66);
        RealItem realItem4 = new RealItemCreator().createRealItem("realItem4", 7.77, 8.88);
        RealItem realItem5 = new RealItemCreator().createRealItem("realItem5", 9.99, 10.11);
        RealItem realItem6 = new RealItemCreator().createRealItem("realItem6", 11.22, 12.33);
        RealItem realItem7 = new RealItemCreator().createRealItem("realItem7", 13.44, 14.55);

        VirtualItem virtualItem1 = new VirtualItemCreator().createVirtualItem("virtualItem1", 15.66, 16.77);
        VirtualItem virtualItem2 = new VirtualItemCreator().createVirtualItem("virtualItem2", 17.88, 18.99);
        VirtualItem virtualItem3 = new VirtualItemCreator().createVirtualItem("virtualItem3", 100.11, 110.22);
        VirtualItem virtualItem4 = new VirtualItemCreator().createVirtualItem("virtualItem4", 120.33, 130.44);
        VirtualItem virtualItem5 = new VirtualItemCreator().createVirtualItem("virtualItem5", 140.55, 150.66);
        VirtualItem virtualItem6 = new VirtualItemCreator().createVirtualItem("virtualItem6", 160.77, 170.88);
        VirtualItem virtualItem7 = new VirtualItemCreator().createVirtualItem("virtualItem7", 1000.99, 1100.11);

        Cart cart = new Cart(cartName);
        cart.addRealItem(realItem1);
        cart.addRealItem(realItem2);
        cart.addRealItem(realItem3);
        cart.addRealItem(realItem4);
        cart.addRealItem(realItem5);
        cart.addRealItem(realItem6);
        cart.addRealItem(realItem7);

        cart.addVirtualItem(virtualItem1);
        cart.addVirtualItem(virtualItem2);
        cart.addVirtualItem(virtualItem3);
        cart.addVirtualItem(virtualItem4);
        cart.addVirtualItem(virtualItem5);
        cart.addVirtualItem(virtualItem6);
        cart.addVirtualItem(virtualItem7);

        return cart;
    }
}
