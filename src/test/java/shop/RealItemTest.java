package shop;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RealItemTest {

    @Test(groups = {"smoke"})
    @Parameters({"weight"})
    void setWeightTest(double weight) {

        RealItem realItem = new RealItem();
        double defaultWeight = realItem.getWeight();

        Assert.assertEquals(realItem.getWeight(), 0);

        realItem.setWeight(weight);

        Assert.assertEquals(realItem.getWeight(), weight);
    }
}
