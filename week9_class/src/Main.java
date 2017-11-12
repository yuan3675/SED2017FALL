import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Map<String, Duck> duckMap = new HashMap<>();

        while ((line = reader.readLine()) != null ) {
            String[] info = line.split(" ");

            if (info[0].equals("duck")) {
                Duck duck;
                if(info[1].equals("MallardDuck")) {
                    duck = new MallardDuck();
                    duck.setFlyMode(info[2]);
                    duck.setQuackMode(info[3]);
                }
                else if (info[1].equals("RubberDuck")) {
                    duck = new RubberDuck();
                    duck.setFlyMode(info[2]);
                    duck.setQuackMode(info[3]);
                }
                else if (info[1].equals("RedheadDuck")) {
                    duck = new RedheadDuck();
                    duck.setFlyMode(info[2]);
                    duck.setQuackMode(info[3]);
                }
                else {
                    duck = new DecoyDuck();
                    duck.setFlyMode(info[2]);
                    duck.setQuackMode(info[3]);
                }
                duckMap.put(info[1], duck);
            }
            else if (info[0].equals("changeFly")) {
                Duck duck = duckMap.get(info[1]);
                duck.setFlyMode(info[2]);
            }
            else if (info[0].equals("changeQuack")) {
                Duck duck = duckMap.get(info[1]);
                duck.setQuackMode(info[2]);
            }
            else if (info[0].equals("swim")) {
                Duck duck = duckMap.get(info[1]);
                duck.swim();
            }
            else if (info[0].equals("fly")) {
                Duck duck = duckMap.get(info[1]);
                FlyMode fly = duck.getFlyMode();
                fly.fly();
            }
            else if (info[0].equals("quack")) {
                Duck duck = duckMap.get(info[1]);
                QuackMode quack = duck.getQuackMode();
                quack.quack();
            }
            else {
                System.out.println("No such command!");
            }
        }
    }
}
