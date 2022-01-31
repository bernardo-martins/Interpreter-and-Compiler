package ICLInterpreter;



public class ASTNot implements ASTNode {

	private ASTNode node;

	public ASTNot(ASTNode node) {
		this.node = node;
	}

	@Override
	public IValue eval(Environment<IValue> environment) throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {
		
		IValue lh = node.eval(environment);
		if (lh instanceof VBool) {
			return new VBool(!((VBool) node).getVal());
		}
		throw new TypeException("Illegal type!");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		// TODO Auto-generated method stub

	}
}
