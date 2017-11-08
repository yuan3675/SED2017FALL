import java.util.Map;

public class ArrayComposition implements LineBreakStrategy{
    @Override
    public void placeLineBreak(Map<Integer, Component> componentMap) {
        int counter = 0;
        String output = "";
        for (Map.Entry<Integer, Component> entry: componentMap.entrySet()) {
            counter ++;
            if (counter == 3) {
                output = output + "[" + entry.getValue().getNatureSize() + "]" + entry.getValue().getContent();
                System.out.println(output);
                output = "";
                counter = 0;
            }
            else {
                output = output + "[" + entry.getValue().getNatureSize() + "]" + entry.getValue().getContent() + " ";
            }
        }
        if (!output.equals("")) {
            System.out.println(output.substring(0, output.length()-1));
        }
    }
}
