import java.util.ArrayList;

public class GUIApplication {
    private ArrayList<Widget> widgets = new ArrayList<>();

    public void create(String type, String name) {
        if (widgets.size() == 0) {
            if (type.equals("Window")) {
                widgets.add(new Window(name, new Motif()));
            }
            else if (type.equals("ScrollBar")) {
                widgets.add(new ScrollBar(name, new Motif()));
            }
            else if (type.equals("Button")) {
                widgets.add(new Button(name, new Motif()));
            }
        }
        else {
            LAFStandard standard = widgets.get(0).getStandard();
            if (standard instanceof Motif) {
                if (type.equals("Window")) {
                    widgets.add(new Window(name, new Motif()));
                } else if (type.equals("ScrollBar")) {
                    widgets.add(new ScrollBar(name, new Motif()));
                } else if (type.equals("Button")) {
                    widgets.add(new Button(name, new Motif()));
                }
            }
            else if (standard instanceof PresentationManager) {
                if (type.equals("Window")) {
                    widgets.add(new Window(name, new PresentationManager()));
                } else if (type.equals("ScrollBar")) {
                    widgets.add(new ScrollBar(name, new PresentationManager()));
                } else if (type.equals("Button")) {
                    widgets.add(new Button(name, new PresentationManager()));
                }
            }
            else {
                System.out.println("instanceof not work");
            }
        }
    }
    public void switchStandard(String standard) {
        if (standard.equals("Motif")) {
            for (Widget widget : widgets) {
                widget.setStandard(new Motif());
            }
        }
        else if (standard.equals("PM")) {
            for (Widget widget : widgets) {
                widget.setStandard(new PresentationManager());
            }
        }
    }

    public void present() {
        for (Widget widget : widgets) {
            if (widget instanceof Window) {
                widget.implement();
            }
        }
        for (Widget widget : widgets) {
            if (widget instanceof ScrollBar) {
                widget.implement();
            }
        }
        for (Widget widget : widgets) {
            if (widget instanceof Button) {
                widget.implement();
            }
        }
    }
}
