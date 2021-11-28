package parser;

import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import shop.Cart;
import supportClasses.CartCreator;
import supportClasses.FileCreator;
import supportClasses.MyFileReader;

import java.io.File;
import java.io.IOException;

import static supportClasses.PrefixPostfixPath.*;

public class JsonParserTest {

    private JsonParser jsonParser;

    @BeforeMethod(alwaysRun = true)
    void setUpJsonParser() {
        jsonParser = new JsonParser();
    }

    @Test(groups = {"sanity", "smoke"})
    void parserCreatesNewFileWhenWriteCartToFile() {
        System.out.println("parserCreatesNewFileWhenWriteCartToFile test");

        Cart cart = new CartCreator().plainCart(NAME_PREFIX + "plainCart" + NAME_POSTFIX);

        File file = new File(BASE_PATH + cart.getCartName() + ".json");
        Assert.assertFalse(file.isFile());
        jsonParser.writeToFile(cart);
        Assert.assertTrue(file.isFile());
    }

    @Test(groups = {"integration"})
    void parserRewritesFileDuringWritingCartToFileWhichAlreadyExists() throws IOException {

        Cart cart = new CartCreator().plainCart(NAME_PREFIX + "plainCart" + NAME_POSTFIX);

        File file = new File(BASE_PATH + cart.getCartName() + ".json");
        Assert.assertFalse(file.isFile());

        String textInFile = "message";
        new FileCreator().createFile(BASE_PATH, cart.getCartName() + ".json", textInFile);
        Assert.assertTrue(file.isFile());

        jsonParser.writeToFile(cart);
        Assert.assertTrue(file.isFile());
        String actualTextInFile = new MyFileReader().readFile(BASE_PATH, cart.getCartName() + ".json");

        Assert.assertNotEquals(actualTextInFile, textInFile);
    }

    @Test(groups = {"integration"})
    void writeNullCartToFile() {

        Cart cart = null;

        Assert.assertThrows(NullPointerException.class, () -> jsonParser.writeToFile(cart));
    }

    @Test(groups = {"integration"})
    void writeEmptyCartToFile() throws IOException {
        Cart cart = new CartCreator().emptyCart(NAME_PREFIX + "emptyCart" + NAME_POSTFIX);

        jsonParser.writeToFile(cart);
        String expectedText = new Gson().toJson(cart);

        String actualText = new MyFileReader().readFile(BASE_PATH, cart.getCartName() + ".json");

        Assert.assertEquals(expectedText, actualText);
    }

    @Test(groups = {"integration"})
    void writePlainCartToFile() throws IOException {

        Cart cart = new CartCreator().plainCart(NAME_PREFIX + "plainCart" + NAME_POSTFIX);

        jsonParser.writeToFile(cart);
        String expectedText = new Gson().toJson(cart);

        String actualText = new MyFileReader().readFile(BASE_PATH, cart.getCartName() + ".json");

        Assert.assertEquals(expectedText, actualText);
    }

    @Test(groups = {"integration"})
    void writeBigCartToFile() throws IOException {

        Cart cart = new CartCreator().bigCart(NAME_PREFIX + "bigCart" + NAME_POSTFIX);

        jsonParser.writeToFile(cart);
        String expectedText = new Gson().toJson(cart);

        String actualText = new MyFileReader().readFile(BASE_PATH, cart.getCartName() + ".json");

        Assert.assertEquals(expectedText, actualText);
    }

    @Test(groups = {"integration"})
    void readFromFileNoFile() {

        File file = new File("random_path");
        Assert.assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(file));
    }

    @Test(groups = {"integration"}, enabled = false)
    void readFromFileWithUnexpectedStructure() throws IOException {

        String fileName = NAME_PREFIX + "randomFileName" + NAME_POSTFIX + ".txt";
        String text = "random text";
        new FileCreator().createFile(BASE_PATH, fileName, text);

        File file = new File(BASE_PATH + fileName);

        Cart cart = jsonParser.readFromFile(file);

        //I expect that in this case cart should be null.
        //But maybe it should be one more Exception in try/catch block
        Assert.assertNull(cart);
    }

    @Test(groups = {"sanity"})
    void readEmptyCartFromFile() throws IOException {

        String emptyCartName = NAME_PREFIX + "emptyCart" + NAME_POSTFIX;
        File file = new FileCreator().createAndReturnFileWithEmptyCart(BASE_PATH, emptyCartName + ".json");

        Cart cart = jsonParser.readFromFile(file);

        SoftAssert asert = new SoftAssert();

        asert.assertEquals(cart.getCartName(), emptyCartName);
        asert.assertEquals(cart.getTotalPrice(), 0.0);

        asert.assertAll();
    }

    @Test(groups = {"integration"})
    void readPlainCartFromFile() throws IOException {

        String plainCartName = NAME_PREFIX + "plainCart" + NAME_POSTFIX;
        File file = new FileCreator().createAndReturnFileWithPlainCart(BASE_PATH, plainCartName + ".json");

        Cart cart = jsonParser.readFromFile(file);

        Assert.assertEquals(cart.getCartName(), plainCartName);
        Assert.assertEquals(cart.getTotalPrice(), 122.256);
    }

    @Test(groups = {"integration"})
    void readBigCartFromFile() throws IOException {

        String bigCartName = NAME_PREFIX + "bigCart" + NAME_POSTFIX;
        File file = new FileCreator().createAndReturnFileWithBigCart(BASE_PATH, bigCartName + ".json");

        Cart cart = jsonParser.readFromFile(file);

        Assert.assertEquals(cart.getCartName(), bigCartName);
        Assert.assertEquals(cart.getTotalPrice(), 1930.44);
    }

    @AfterMethod(alwaysRun = true)
    void afterEachTearDown() {

        new FileCreator().delAllTestFiles(BASE_PATH);
    }
}
