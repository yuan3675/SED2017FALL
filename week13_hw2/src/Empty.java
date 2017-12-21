public class Empty implements BoilerState {
    @Override
    public void execute(Boiler boiler, String command) {
        if (command.equals("Fill")) {
            boiler.setState(new Filled());
            System.out.println("Fill chocolate");
        }
    }
}
