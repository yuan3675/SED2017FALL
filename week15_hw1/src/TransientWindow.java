public class TransientWindow extends Window {
    public TransientWindow(WindowImpl impl) {
        this.impl = impl;
    }
    public void drawCloseBox() {
        drawRect();
    }
}
