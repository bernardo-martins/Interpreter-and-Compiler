package ICLInterpreter;


public class ASTAssign implements ASTNode {

	public ASTNode lhs, rhs;

	public ASTAssign(ASTNode v1, ASTNode v2) {
		this.lhs = v1;
		this.rhs = v2;
	}

	@Override
	public IValue eval(Environment<IValue> environment) throws TypeException,IDDeclaredTwiceException, UndeclaredIdentifierException {
		IValue v1 = lhs.eval(environment);
		if (v1 instanceof VRef) {
			IValue v2 = rhs.eval(environment);
			Memory.set((VRef) v1, v2);
			return v2;
		}
		throw new TypeException("Illegal assignment to memory cell!");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {

	}

}
