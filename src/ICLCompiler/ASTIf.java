package ICLCompiler;

public class ASTIf implements ASTNode {

	private ASTNode condition, then, other = null;

	public ASTIf(ASTNode condition, ASTNode then, ASTNode other) {
		this.condition = condition;
		this.then = then;
		this.other = other;
	}

	@Override
	public IValue eval(Environment<IValue> environment)
			throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {
		if (condition instanceof ASTBool) {
			VBool val = (VBool) ((ASTBool) condition).eval(environment);
			if (val.getVal()) {
				return then.eval(environment);
			} else if (other != null)
				return other.eval(environment);
			return null;

		}
		throw new TypeException("Invalid type!");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException {
		return null;
	}

}
