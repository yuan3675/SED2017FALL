import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");

            Coffee coffee = null;
            if (info[0].equals("HouseBlend")) {
                coffee = new HouseBlend();
            }
            else if (info[0].equals("DarkRoast")) {
                coffee = new DarkRoast();
            }
            else if (info[0].equals("Decaf")){
                coffee = new Decaf();
            }
            else {
                coffee = new Espresso();
            }
            for (int i = 1; i < info.length; i++) {
                if (info[i].equals("Mocha")) {
                    coffee = new Mocha(coffee);
                }
                else if (info[i].equals("Milk")) {
                    coffee = new Milk(coffee);
                }
                else if (info[i].equals("Soy")) {
                    coffee = new Soy(coffee);
                }
            }
            double price = coffee.getPrice();
            System.out.println("price: " + price);
        }
    }
}
