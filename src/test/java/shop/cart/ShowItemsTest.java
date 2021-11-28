package shop.cart;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import shop.Cart;
import supportClasses.CartCreator;

public class ShowItemsTest {

    private ByteArrayOutputStream outContent;
    private final PrintStream defaultPrintStream = System.out;

    @BeforeMethod(alwaysRun = true)
    void setUpSystemOut() {

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }


    @Test(groups = {"smoke"})
    void ShowEmptyCartTest() {

        String showItemsExpected = "";

        Cart cart = new CartCreator().emptyCart("TestCart");
        cart.showItems();

        Assert.assertEquals(outContent.toString().strip(), showItemsExpected);
    }

    @Test(groups = {"smoke", "regression"})
    void showPlainCartTest() {

        String showItemsExpected = "Class: class shop.RealItem; Name: RealItem1; Price: 1.55; Weight: 1.11\r\n" +
                "Class: class shop.VirtualItem; Name: virtualItem1; Price: 100.33; Size on disk: 100.33";

        Cart cart = new CartCreator().plainCart("TestCart");
        cart.showItems();

        Assert.assertEquals(outContent.toString().strip(), showItemsExpected);
    }

    @Test(groups = {"regression"})
    void showBigCartTest() {

        String showItemsExpected = "Class: class shop.RealItem; Name: realItem1; Price: 1.11; Weight: 2.22\r\n" +
                "Class: class shop.RealItem; Name: realItem2; Price: 3.33; Weight: 4.44\r\n" +
                "Class: class shop.RealItem; Name: realItem3; Price: 5.55; Weight: 6.66\r\n" +
                "Class: class shop.RealItem; Name: realItem4; Price: 7.77; Weight: 8.88\r\n" +
                "Class: class shop.RealItem; Name: realItem5; Price: 9.99; Weight: 10.11\r\n" +
                "Class: class shop.RealItem; Name: realItem6; Price: 11.22; Weight: 12.33\r\n" +
                "Class: class shop.RealItem; Name: realItem7; Price: 13.44; Weight: 14.55\r\n" +
                "Class: class shop.VirtualItem; Name: virtualItem1; Price: 15.66; Size on disk: 16.77\r\n" +
                "Class: class shop.VirtualItem; Name: virtualItem2; Price: 17.88; Size on disk: 18.99\r\n" +
                "Class: class shop.VirtualItem; Name: virtualItem3; Price: 100.11; Size on disk: 110.22\r\n" +
                "Class: class shop.VirtualItem; Name: virtualItem4; Price: 120.33; Size on disk: 130.44\r\n" +
                "Class: class shop.VirtualItem; Name: virtualItem5; Price: 140.55; Size on disk: 150.66\r\n" +
                "Class: class shop.VirtualItem; Name: virtualItem6; Price: 160.77; Size on disk: 170.88\r\n" +
                "Class: class shop.VirtualItem; Name: virtualItem7; Price: 1000.99; Size on disk: 1100.11";

        Cart cart = new CartCreator().bigCart("TestCart");
        cart.showItems();

        Assert.assertEquals(showItemsExpected, outContent.toString().strip());
    }

    @AfterClass(alwaysRun = true)
    void tearDownSystemOut() {

        System.setOut(defaultPrintStream);
    }
}
