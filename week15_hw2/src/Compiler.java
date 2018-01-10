import java.util.ArrayList;

public class Compiler {
    private AST ast = new AST();
    private ASTVistor astVistor;

    public void addNode(Node node) {
        ArrayList<Node> nodes = ast.getNodes();
        nodes.add(node);
    }

    public void checkType(int index) {
        astVistor = new TypeChecker();
        ArrayList<Node> nodes = ast.getNodes();
        //DFS
        nodes.get(index - 1).accept(astVistor);
        if (index * 2 <= nodes.size()) {
            checkType(index * 2);
        }
        if (index * 2 + 1 <= nodes.size()) {
            checkType(index * 2 + 1);
        }
    }
    public void generateCode(int index) {
        astVistor = new CodeGenerater();
        ArrayList<Node> nodes = ast.getNodes();
        //DFS
        nodes.get(index - 1).accept(astVistor);
        if (index * 2 <= nodes.size()) {
            generateCode(index * 2);
        }
        if (index * 2 + 1 <= nodes.size()) {
            generateCode(index * 2 + 1);
        }
    }
    public void printCotent(int index) {
        astVistor = new ContentPrinter();
        ArrayList<Node> nodes = ast.getNodes();
        //DFS
        nodes.get(index - 1).accept(astVistor);
        if (index * 2 <= nodes.size()) {
            printCotent(index * 2);
        }
        if (index * 2 + 1 <= nodes.size()) {
            printCotent(index * 2 + 1);
        }
    }
}
