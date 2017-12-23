import java.util.ArrayList;

public class TeXConverter implements TextConverter {
    private ArrayList<TeXText> teXTexts = new ArrayList<>();
    @Override
    public void getConvertedTextFormat() {
        for (TeXText teXText : teXTexts) {
            System.out.printf("%s", teXText.getContent());
        }
        System.out.printf("\n");
    }

    @Override
    public void convertC() {
        teXTexts.add(new TeXText("c"));
    }

    @Override
    public void convertF() {
        teXTexts.add(new TeXText("_"));
    }

    @Override
    public void convertP() {
        teXTexts.add(new TeXText("|"));
    }
}
