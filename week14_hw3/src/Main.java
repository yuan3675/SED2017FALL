import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;

        PancakeHouseMenu pancakeHouseMenu = null;
        DinerMenu dinerMenu = null;
        DinerMenu subMenu = null;
        int mode = 0;
        while ((line = reader.readLine()) != null) {
            if (line.equals("PancakeHouse")) {
                pancakeHouseMenu = new PancakeHouseMenu();
                mode = 0;
            }
            else if (line.equals("Diner")) {
                dinerMenu = new DinerMenu(false);
                mode = 1;
            }
            else if (line.equals("SubMenu")) {
                if (dinerMenu != null) {
                    if (subMenu != null) {
                        dinerMenu.add(subMenu);
                    }
                    subMenu = new DinerMenu(true);
                    mode = 2;
                }
            }
            else {
                if (mode == 0) {
                    MenuItem menuItem = new MenuItem(line);
                    pancakeHouseMenu.add(menuItem);
                }
                else if (mode == 1) {
                    MenuItem menuItem = new MenuItem(line);
                    dinerMenu.add(menuItem);
                }
                else {
                    MenuItem menuItem = new MenuItem(line);
                    subMenu.add(menuItem);
                }
            }
        }
        if (subMenu != null) {
            dinerMenu.add(subMenu);
        }
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}
