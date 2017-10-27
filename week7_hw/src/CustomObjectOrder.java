public class CustomObjectOrder implements format {
    private String text;
    @Override
    public void createHeader() {
        this.text = "<Object header>";
    }

    @Override
    public void createFooter() {
        this.text += "<Object footer>";
    }

    @Override
    public void addData(String data) {
        this.text += data;
    }

    @Override
    public void display() {
        System.out.println(this.text);
    }
}
