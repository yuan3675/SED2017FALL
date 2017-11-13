import java.util.Map;

public class TextComposition implements LineBreakStrategy{
    @Override
    public void placeLineBreak(Map<Integer, Component> componentMap) {
        String output = "";
        for (Map.Entry<Integer, Component> entry: componentMap.entrySet()) {
            if (entry.getValue().getContent().equals("<ParagraphEnd>")) {
                output = output + "[" + entry.getValue().getNatureSize() + "]" + entry.getValue().getContent();
                System.out.println(output);
                output = "";
            }
            else {
                output = output + "[" + entry.getValue().getNatureSize() + "]" + entry.getValue().getContent() + " ";
            }
        }
        if (!output.equals("")) {
            System.out.println(output);
        }
    }
}
