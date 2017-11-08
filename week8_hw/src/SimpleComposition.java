import java.util.Map;

public class SimpleComposition implements LineBreakStrategy{
    @Override
    public void placeLineBreak(Map<Integer, Component> componentMap) {
        for (Map.Entry<Integer, Component> entry: componentMap.entrySet()) {
            System.out.println("[" + entry.getValue().getNatureSize() + "]" + entry.getValue().getContent());
        }
    }
}
