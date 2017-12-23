import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        RTFReader rtfReader = new RTFReader();

        while((line = reader.readLine()) != null) {
            if (line.equals("TeX") || line.equals("TextWidget")) {
                rtfReader.setTextConverter(line);
            }
            else {
                rtfReader.convert(line);
            }
        }
    }
}
