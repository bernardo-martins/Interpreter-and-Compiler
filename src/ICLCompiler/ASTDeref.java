package ICLCompiler;

public class ASTDeref implements ASTNode {
	private ASTNode t;

	public ASTDeref(ASTNode t) {
		this.t = t;
	}

	@Override
	public IValue eval(Environment<IValue> env)
			throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		IValue val = t.eval(env);
		if (val instanceof VRef)
			return Memory.get((VRef)val);
		throw new TypeException("Dereference to an unexistent value!");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		
	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException {
		
		return t.typecheck(env);
	}

}
