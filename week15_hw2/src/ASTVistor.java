public interface ASTVistor {
    public void performOnVarRefNode(VariableRefNode variableRefNode);
    public void performOnAssignNode(AssignNode assignNode);
}
