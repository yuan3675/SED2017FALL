import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Window window = new Window();

        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");

            if(info[0].equals("window")) {
                if (info[1].equals("IconWindow")) {
                    if (info[2].equals("XWindow")) {
                        window = new IconWindow(new XWindowImpl());
                    }
                    else {
                        window = new IconWindow(new PMWindowImpl());
                    }
                }
                else {
                    if (info[2].equals("XWindow")) {
                        window = new TransientWindow(new XWindowImpl());
                    }
                    else {
                        window = new TransientWindow(new PMWindowImpl());
                    }
                }
            }
            else if (info[0].equals("drawBorder")) {
                if (window instanceof IconWindow) {
                    ((IconWindow) window).drawBorder();
                }
            }
            else {
                if (window instanceof TransientWindow) {
                    ((TransientWindow) window).drawCloseBox();
                }
            }
        }
    }
}
