package ICLCompiler;

public class ASTOrAnd implements ASTNode {

	private ASTNode lhs, rhs = null;
	private String mode;

	public ASTOrAnd(ASTNode lhs, ASTNode rhs, String mode) {
		this.mode = mode;
		this.lhs = lhs;
		this.rhs = rhs;

	}

	@Override
	public IValue eval(Environment<IValue> environment)
			throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		IValue lh = lhs.eval(environment);
		if (lh instanceof VBool) {
			lh = (VBool) lh;
			IValue rh = rhs.eval(environment);
			if (rh instanceof VBool) {
				rh = (VBool) rh;
				switch (mode) {
				case "AND":
					return new VBool(((VBool) lh).getVal() && ((VBool) rh).getVal());
				case "OR":
					return new VBool(((VBool) lh).getVal() || ((VBool) rh).getVal());
				}
			}
		}
		throw new TypeException("Illegal types to && operator");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException  {
		
		IType v1 = lhs.typecheck(env);
		if (v1 instanceof TBool) {
			IType v2 = rhs.typecheck(env);
			if (v2 instanceof TBool)
				return new TBool();
			else
				throw new TypeException("Expected TBool on right side of the expression");
		}
		throw new TypeException("Expected TBool on left side of the expression");
	}

}
