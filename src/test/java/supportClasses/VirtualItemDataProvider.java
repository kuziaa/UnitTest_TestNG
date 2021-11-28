package supportClasses;

import org.testng.annotations.DataProvider;


public class VirtualItemDataProvider {

    @DataProvider(name = "sizeOnDiskDataProvider")
    public static Object[][] getSizeOnDisk() {

        Object[][] data = {{0.01}, {10}, {Double.MAX_VALUE}};
        return data;
    }
}
