import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int number = 1;
        Compiler compiler = new Compiler();

        while ((line = reader.readLine()) != null) {
            String[] info = line.split(" ");

            if (info[0].equals("node")) {
                Node node;
                if (info[1].equals("VariableRefNode")) {
                    node = new VariableRefNode(number, info[2], info[3], info[4]);
                }
                else {
                    node = new AssignNode(number, info[2], info[3], info[4]);
                }
                compiler.addNode(node);
                number ++;
            }
            else if (info[0].equals("checkType")) {
                compiler.checkType(Integer.parseInt(info[1]));
            }
            else if (info[0].equals("generateCode")) {
                compiler.generateCode(Integer.parseInt(info[1]));
            }
            else if (info[0].equals("printContent")) {
                compiler.printCotent(Integer.parseInt(info[1]));
            }
        }
    }
}
