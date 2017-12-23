public class TeXText implements TextFormat {
    private String content;

    public TeXText(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
