package ICLCompiler;

public class ASTBool implements ASTNode {

	private boolean v;

	public ASTBool(boolean val) {
		this.v = val;
	}

	@Override
	public IValue eval(Environment<IValue> environment) throws UndeclaredIdentifierException, IDDeclaredTwiceException {
		// TODO Auto-generated method stub
		return new VBool(v);
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		// TODO Auto-generated method stub

	}

	@Override
	public IType typecheck(Environment<IType> e) throws TypeException {
		// TODO Auto-generated method stub
		return null;
	}

}
