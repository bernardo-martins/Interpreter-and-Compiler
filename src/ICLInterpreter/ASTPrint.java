package ICLInterpreter;

public class ASTPrint implements ASTNode {

	private ASTNode node;
	private boolean newLine;

	public ASTPrint(ASTNode n, boolean newLine) {
		this.node = n;
		this.newLine = newLine;
	}

	@Override
	public IValue eval(Environment<IValue> environment)
			throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {

		IValue v = node.eval(environment);
		if (!newLine)
			System.out.print(v.toString());
		else
			System.out.println(v.toString());
		return v;
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
	}

}
