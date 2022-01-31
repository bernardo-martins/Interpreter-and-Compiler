package ICLCompiler;

public class ASTAnd implements ASTNode {

	private ASTNode lhs, rhs;

	public ASTAnd(ASTNode lhs, ASTNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	@Override
	public IValue eval(Environment<IValue> env)
			throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {
		IValue lh = lhs.eval(env);
		if (lh instanceof VBool) {
			lh = (VBool) lh;
			IValue rh = rhs.eval(env);
			if (rh instanceof VBool) {
				rh = (VBool) rh;
				return new VBool(((VBool) lh).getVal() && ((VBool) rh).getVal());
			}
		}
		throw new TypeException("Invalid type!");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		

	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException {
		IType v1 = lhs.typecheck(env);
		if (v1 instanceof TBool) {
			IType v2 = rhs.typecheck(env);
			if (v2 instanceof TBool)
				return new TBool();
			else
				throw new TypeException("Expected TBool on the right side of the expression");
		}
		throw new TypeException("Expected TBool on right side of the expression");
	}

}
