public class IconWindow extends Window {
    public IconWindow(WindowImpl impl) {
        this.impl = impl;
    }
    public void drawBorder() {
        drawText();
        drawRect();
    }
}
