import java.util.ArrayList;

public class TextWidgetConverter implements TextConverter {
    private ArrayList<TextWidget> textWidgets = new ArrayList<>();
    @Override
    public void convertF() {
        textWidgets.add(new TextWidget("<Font>"));
    }

    @Override
    public void convertP() {
        textWidgets.add(new TextWidget("<Paragraph>"));
    }

    @Override
    public void convertC() {
        textWidgets.add(new TextWidget("<Char>"));
    }

    @Override
    public void getConvertedTextFormat() {
        for (TextWidget textWidget : textWidgets) {
            System.out.printf("%s", textWidget.getContent());
        }
        System.out.printf("\n");
    }
}
