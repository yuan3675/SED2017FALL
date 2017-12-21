import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String command;
        Application application = new Application();

        while ((command = reader.readLine()) != null) {
            if (command.equals("Present")) {
                application.manageDocuments();
            }
            else {
                application.createDocument(command);
            }
        }
    }
}
