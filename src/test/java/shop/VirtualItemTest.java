package shop;

import org.testng.Assert;
import org.testng.annotations.Test;
import supportClasses.VirtualItemDataProvider;

public class VirtualItemTest {

    @Test(groups = {"smoke"}, dataProvider = "sizeOnDiskDataProvider", dataProviderClass = VirtualItemDataProvider.class)
    void setSizeOnDiskTest(double size) {

        VirtualItem virtualItem = new VirtualItem();

        Assert.assertEquals(virtualItem.getSizeOnDisk(), 0);

        virtualItem.setSizeOnDisk(size);

        Assert.assertEquals(virtualItem.getSizeOnDisk(), size);
    }
}
