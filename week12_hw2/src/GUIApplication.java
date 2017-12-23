import java.util.ArrayList;

public class GUIApplication {
    private ArrayList<Window> windows = new ArrayList<>();
    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<ScrollBar> scrollBars = new ArrayList<>();
    private WidgetFactory widgetFactory = new MotifWidgetFactory();

    public void addWindow(String name) {
        windows.add(widgetFactory.createWindow(name));
    }
    public void addScrollBar(String name) {
        scrollBars.add(widgetFactory.createScrollBar(name));
    }
    public void addButton(String name) {
        buttons.add(widgetFactory.createButton(name));
    }
    public void present() {
        if (widgetFactory instanceof MotifWidgetFactory) {
            for (Window window : windows) {
                System.out.println("MotifWindow " + window.getName());
            }
            for (ScrollBar scrollBar : scrollBars) {
                System.out.println("MotifScrollBar " + scrollBar.getName());
            }
            for (Button button : buttons) {
                System.out.println("MotifButton " + button.getName());
            }
        }
        else {
            for (Window window : windows) {
                System.out.println("PMWindow " + window.getName());
            }
            for (ScrollBar scrollBar : scrollBars) {
                System.out.println("PMScrollBar " + scrollBar.getName());
            }
            for (Button button : buttons) {
                System.out.println("PMButton " + button.getName());
            }
        }
    }

    public void switchStyle(String style) {
        if (style.equals("Motif")) {
            widgetFactory = new MotifWidgetFactory();
        }
        else {
            widgetFactory = new PMWidgetFactory();
        }
    }
}
