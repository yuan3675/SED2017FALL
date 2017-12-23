public class PMWidgetFactory implements WidgetFactory {
    @Override
    public Button createButton(String name) {
        return new PMButton(name);
    }

    @Override
    public ScrollBar createScrollBar(String name) {
        return new PMScrollBar(name);
    }

    @Override
    public Window createWindow(String name) {
        return new PMWindow(name);
    }
}
