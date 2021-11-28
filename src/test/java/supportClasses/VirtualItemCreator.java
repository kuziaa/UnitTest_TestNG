package supportClasses;

import shop.VirtualItem;

public class VirtualItemCreator {

    public VirtualItem createVirtualItem(String ItemName, double price, double sizeOnDisk) {
        VirtualItem virtualItem = new VirtualItem();
        virtualItem.setName(ItemName);
        virtualItem.setPrice(price);
        virtualItem.setSizeOnDisk(sizeOnDisk);

        return virtualItem;
    }
}
