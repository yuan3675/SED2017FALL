import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Map<String, TextView> textViewMap = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");
            String textViewName = info[0];

            if (textViewMap.get(textViewName) != null) {
                TextView textView = textViewMap.get(textViewName);
                if (info[1].equals("display")) {
                    textView.display();
                }
                else {
                    for (int i = 2; i < info.length; i++) {
                        if (info[i].equals("scrollBar")) {
                            textView.getElements().add(new ScrollBar());
                        }
                        else {
                            textView.getElements().add(new ThickBlackBorder());
                        }
                    }
                }
            }
            else {
                textViewMap.put(textViewName, new TextView(info[1]));
            }
        }
    }
}
