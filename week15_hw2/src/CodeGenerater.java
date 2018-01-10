public class CodeGenerater implements ASTVistor {
    @Override
    public void performOnVarRefNode(VariableRefNode variableRefNode) {
        System.out.println("Node " + variableRefNode.getNumber() + ": VariableRefNode " + variableRefNode.getCode() );
    }

    @Override
    public void performOnAssignNode(AssignNode assignNode) {
        System.out.println("Node " + assignNode.getNumber() + ": AssignNode " + assignNode.getCode() );
    }
}
