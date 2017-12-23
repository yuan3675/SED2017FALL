public class TextWidget implements TextFormat {
    private String content;

    public TextWidget(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
