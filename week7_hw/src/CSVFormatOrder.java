public class CSVFormatOrder implements format {
    private String text;

    @Override
    public void createHeader() {
        this.text = "<CSV header>";
    }

    @Override
    public void createFooter() {
        this.text += "<CSV footer>";
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
