import java.util.LinkedHashMap;
import java.util.Map;

public class Composition {
    private Map<Integer, Component> componentMap = new LinkedHashMap<>();

    public void createText (int ID, int size, int shrink, int stretch, String content) {
        Text t = new Text();
        t.setID(ID);
        t.setNatureSize(size);
        t.setShrinkability(shrink);
        t.setStretchability(stretch);
        t.setContent(content);
        t.setType("Text");

        componentMap.put(ID, t);
    }

    public  void createGE(int ID, int size, int shrink, int stretch, String content) {
        GraphElement ge = new GraphElement();
        ge.setID(ID);
        ge.setNatureSize(size);
        ge.setShrinkability(shrink);
        ge.setStretchability(stretch);
        ge.setContent(content);
        ge.setType("Text");

        componentMap.put(ID, ge);
    }

    public void changeSize (int ID, int changedSize) {
        Component c = componentMap.get(ID);
        if (changedSize < c.getShrinkability() || changedSize > c.getStretchability()) {
            System.out.println("component " + ID + " failed to change size");
        }
        else {
            c.setNatureSize(changedSize);
            System.out.println("component " + ID + " size changed to " + changedSize);
        }
    }

    public void require (String strategy) {
        if (strategy.equals("SimpleComposition")) {
            SimpleComposition s = new SimpleComposition();
            s.placeLineBreak(componentMap);
        }
        else if (strategy.equals("TexComposition")) {
            TextComposition t = new TextComposition();
            t.placeLineBreak(componentMap);
        }
        else {
            ArrayComposition a = new ArrayComposition();
            a.placeLineBreak(componentMap);
        }
    }
}
