public class XMLFormatOrder implements format {
    private String text;
    @Override
    public void createHeader() {
        this.text = "<XML header>";
    }

    @Override
    public void createFooter() {
        this.text += "<XML footer>";
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
