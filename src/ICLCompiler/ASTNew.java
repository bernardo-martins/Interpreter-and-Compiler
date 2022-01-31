package ICLCompiler;

public class ASTNew implements ASTNode {

	public ASTNode t;

	public ASTNew(ASTNode t) {
		this.t = t;
	}

	@Override
	public IValue eval(Environment<IValue> env)
			throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		return Memory.alloc(t.eval(env));
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {

	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException  {
		
		return new TRef(t.typecheck(env));
	}

}
