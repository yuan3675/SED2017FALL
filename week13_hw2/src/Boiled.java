public class Boiled implements BoilerState {
    @Override
    public void execute(Boiler boiler, String command) {
        if (command.equals("Drain")) {
            boiler.setState(new Empty());
            System.out.println("Drain the boiled chocolate");
        }
    }
}
