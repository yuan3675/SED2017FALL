public class MenuItem implements MenuComponent{
    private String discription;

    public MenuItem(String discription) {
        this.discription = discription;
    }

    public String getDiscription() {
        return discription;
    }

    @Override
    public void print() {
        System.out.println("MenuItem:" + discription);
    }
}
