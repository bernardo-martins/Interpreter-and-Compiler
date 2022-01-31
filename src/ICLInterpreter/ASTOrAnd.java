package ICLInterpreter;

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
		throw new TypeException("Illegal types to &&/|| operation");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
	}

}
