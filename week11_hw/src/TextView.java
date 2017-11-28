import java.util.ArrayList;

public class TextView {
    private String text;
    private ArrayList<Element> elements = new ArrayList<>();

    public TextView(String text) {
        this.text = text;
    }

    public void display() {
        System.out.printf("%s", this.text);
        for (Element element : this.elements) {
            element.display();
        }
        System.out.printf("\n");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }
}
