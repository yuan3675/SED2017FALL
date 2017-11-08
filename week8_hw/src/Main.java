import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        Composition composition = new Composition();

        while (line != null) {
            String[] info = line.split(" ");

            if (info[0].equals("Text")) {
                composition.createText(Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]), info[5]);
            }
            else if (info[0].equals("GraphicalElement")) {
                composition.createGE(Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]), Integer.parseInt(info[4]), info[5]);
            }
            else if (info[0].equals("ChangeSize")) {
                composition.changeSize(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
            }
            else if (info[0].equals("Require")) {
                composition.require(info[1]);
            }
            else {
                System.out.println("Wrong Command!");
            }

            line = reader.readLine();
        }
    }
}
