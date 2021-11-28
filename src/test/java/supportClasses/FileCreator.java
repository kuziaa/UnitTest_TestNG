package supportClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {



    public void createFile(String path, String fileName, String msg) throws IOException {

        File file = new File(path + fileName);
        FileWriter writer = new FileWriter(file);
        writer.write(msg);
        writer.close();
    }

    public File createAndReturnFileWithEmptyCart(String path, String fileName) throws IOException {

        String emptyCart = "" +
                "{\"cartName\":\"test_emptyCart_test\"," +
                "\"realItems\":[]," +
                "\"virtualItems\":[]," +
                "\"total\":0.0}";

        File file = new File(path + fileName);
        FileWriter writer = new FileWriter(file);
        writer.write(emptyCart);
        writer.close();

        return file;
    }

    public File createAndReturnFileWithPlainCart(String path, String fileName) throws IOException {

        String plainCart = "" +
                "{\"cartName\":\"test_plainCart_test\"" +
                ",\"realItems\":[{\"weight\":1.11,\"name\":\"RealItem1\",\"price\":1.55}]," +
                "\"virtualItems\":[{\"sizeOnDisk\":100.33,\"name\":\"virtualItem1\"," +
                "\"price\":100.33}],\"total\":122.256}";

        File file = new File(path + fileName);
        FileWriter writer = new FileWriter(file);
        writer.write(plainCart);
        writer.close();

        return file;
    }

    public File createAndReturnFileWithBigCart(String path, String fileName) throws IOException {

        String bigCart = "{" +
                "\"cartName\":\"test_bigCart_test\"," +
                "\"realItems\":[{\"weight\":2.22,\"name\":\"realItem1\",\"price\":1.11}," +
                               "{\"weight\":4.44,\"name\":\"realItem2\",\"price\":3.33}," +
                               "{\"weight\":6.66,\"name\":\"realItem3\",\"price\":5.55}," +
                               "{\"weight\":8.88,\"name\":\"realItem4\",\"price\":7.77}," +
                               "{\"weight\":10.11,\"name\":\"realItem5\",\"price\":9.99}," +
                               "{\"weight\":12.33,\"name\":\"realItem6\",\"price\":11.22}," +
                               "{\"weight\":14.55,\"name\":\"realItem7\",\"price\":13.44}]," +
                "\"virtualItems\":[{\"sizeOnDisk\":16.77,\"name\":\"virtualItem1\",\"price\":15.66}," +
                                  "{\"sizeOnDisk\":18.99,\"name\":\"virtualItem2\",\"price\":17.88}," +
                                  "{\"sizeOnDisk\":110.22,\"name\":\"virtualItem3\",\"price\":100.11}," +
                                  "{\"sizeOnDisk\":130.44,\"name\":\"virtualItem4\",\"price\":120.33}," +
                                  "{\"sizeOnDisk\":150.66,\"name\":\"virtualItem5\",\"price\":140.55}," +
                                  "{\"sizeOnDisk\":170.88,\"name\":\"virtualItem6\",\"price\":160.77}," +
                                  "{\"sizeOnDisk\":1100.11,\"name\":\"virtualItem7\",\"price\":1000.99}]," +
                "\"total\":1930.44}";

        File file = new File(path + fileName);
        FileWriter writer = new FileWriter(file);
        writer.write(bigCart);
        writer.close();

        return file;
    }

    public void delAllTestFiles(String path) {

        File folder = new File(path);
        File[] listOfFile = folder.listFiles();

        if (listOfFile == null) {
            return;
        }

        for (File file: listOfFile) {
            String fileName = file.getName();
            if (fileName.contains("test_") & fileName.contains("_test")) {
                file.delete();
            }
        }
    }
}
