package ICLCompiler;

public class ASTMinun implements ASTNode {

	ASTNode v;

	public ASTMinun(ASTNode value) {
		v = value;
	}
	
	public IValue eval(Environment<IValue> e)
			throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {
		IValue v1 = v.eval(e);
		if (v1 instanceof VInt) {
			return new VInt(-((VInt) v1).getVal());
		}
		throw new TypeException("Invalid type!");

	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		v.compile(c, env);
	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException {
		return v.typecheck(env);
	}
}
