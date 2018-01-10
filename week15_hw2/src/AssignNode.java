public class AssignNode implements Node {
    private String type;
    private String code;
    private String content;
    private int number;

    public AssignNode(int number, String type, String code, String content) {
        this.number = number;
        this.type = type;
        this.code = code;
        this.content = content;
    }

    @Override
    public void accept(ASTVistor vistor) {
        vistor.performOnAssignNode(this);
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }

    public int getNumber() {
        return number;
    }
}
