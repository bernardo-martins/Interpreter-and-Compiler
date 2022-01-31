package ICLInterpreter;

public class ASTSeq implements ASTNode {

	private ASTNode lhs, rhs;

	public ASTSeq(ASTNode lhs, ASTNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public IValue eval(Environment<IValue> e) throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		IValue l = lhs.eval(e);
		if (rhs == null)
			return l;

		IValue r = rhs.eval(e);
		return r;
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> e) {
		lhs.compile(c, e);
		if (rhs != null)
			rhs.compile(c, e);
	}
	
}
