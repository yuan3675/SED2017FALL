import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();

        while ((line = reader.readLine()) != null) {
            if (line.equals("Fill")) {
                chocolateBoiler.Fill();
            }
            else if (line.equals("Boil")) {
                chocolateBoiler.Boil();
            }
            else if (line.equals("Drain")) {
                chocolateBoiler.Drain();
            }
        }
    }
}
