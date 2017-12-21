public class Filled implements BoilerState {
    @Override
    public void execute(Boiler boiler, String command) {
        if (command.equals("Boil")) {
            boiler.setState(new Boiled());
            System.out.println("Boil chocolate");
        }
    }
}
