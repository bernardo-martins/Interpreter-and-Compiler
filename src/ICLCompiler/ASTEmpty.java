package ICLCompiler;

public class ASTEmpty implements ASTNode {

	public ASTEmpty() {
	}

	@Override
	public IValue eval(Environment<IValue> environment)
			throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		return null;
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException {
		// TODO Auto-generated method stub
		return null;
	}

}
