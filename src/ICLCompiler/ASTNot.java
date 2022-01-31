package ICLCompiler;

public class ASTNot implements ASTNode {

	private ASTNode node;

	public ASTNot(ASTNode node) {
		this.node = node;
	}

	@Override
	public IValue eval(Environment<IValue> env)
			throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {

		IValue lh = node.eval(env);
		if (lh instanceof VBool) {
			return new VBool(!((VBool) node).getVal());
		}
		throw new TypeException("Invalid type!");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {

	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException  {
		IType v = node.typecheck(env);
		if (v instanceof TBool)
			return v;
		throw new TypeException("Expected TBool");
	}
}
