package ICLCompiler;

public class ASTSeq implements ASTNode {

	private ASTNode lhs, rhs;

	public ASTSeq(ASTNode lhs, ASTNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public IValue eval(Environment<IValue> env)
			throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		IValue l = lhs.eval(env);
		if (rhs == null)
			return l;

		IValue r = rhs.eval(env);
		return r;
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		lhs.compile(c, env);
		if (rhs != null)
			rhs.compile(c, env);
	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException  {
		return rhs.typecheck(env);
	}

}
