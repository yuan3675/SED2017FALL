import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader  = new BufferedReader(new FileReader(file));
        String line;
        PizzaStore pizzaStore = new PizzaStore();

        while((line = reader.readLine()) != null) {
            String[] info = line.split(" ");
            String flavor = info[0];
            String style = info[1];

            if (style.equals("NY")) {
                pizzaStore.offer(new NYFactory(), flavor);
            }
            else if (style.equals("Chicago")) {
                pizzaStore.offer(new CHFactory(), flavor);
            }
        }
    }
}
