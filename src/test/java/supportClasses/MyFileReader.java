package supportClasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {

    public String readFile(String path, String fileName) throws IOException {

        File file = new File(path + fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);

        String text = "";
        String st;
        while ((st = br.readLine()) != null) {
            text += st;
        }
        br.close();

        return text;
    }
}
