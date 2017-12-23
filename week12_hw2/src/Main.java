import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        GUIApplication guiApplication = new GUIApplication();

        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");

            if (info[0].equals("Present")) {
                guiApplication.present();
            }
            else if (info[0].equals("PM") || info[0].equals("Motif")) {
                guiApplication.switchStyle(info[0]);
            }
            else if (info[0].equals("Window")) {
                guiApplication.addWindow(info[1]);
            }
            else if (info[0].equals("ScrollBar")) {
                guiApplication.addScrollBar(info[1]);
            }
            else if (info[0].equals("Button")) {
                guiApplication.addButton(info[1]);
            }
        }
    }
}
