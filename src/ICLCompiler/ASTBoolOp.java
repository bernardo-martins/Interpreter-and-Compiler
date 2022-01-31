package ICLCompiler;

public class ASTBoolOp implements ASTNode {

	private ASTNode lhs, rhs;
	private String mode;

	public ASTBoolOp(ASTNode t1, ASTNode t2, String mode) {
		this.lhs = t1;
		this.rhs = t2;
		this.mode = mode;
	}

	@Override
	public IValue eval(Environment<IValue> env)
			throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {
		IValue lh = lhs.eval(env);
		IValue rh = null;
		if (lh instanceof VInt) {
			lh = (VInt) lh;
			rh = rhs.eval(env);
			if (rh instanceof VBool)
				rh = (VBool) rh;
			switch (mode) {
			case "TRUE":
				return new VBool(true);
			case "FALSE":
				return new VBool(false);
			case "EQUALS":
				return new VBool(((VInt) lh).getVal() == ((VInt) rh).getVal());
			case "HIGHEREQUALS":
				return new VBool(((VInt) lh).getVal() >= ((VInt) rh).getVal());
			case "HIGHER":
				return new VBool(((VInt) lh).getVal() > ((VInt) rh).getVal());
			case "SMALLER":
				return new VBool(((VInt) lh).getVal() < ((VInt) rh).getVal());
			case "SMALLEREQUALS":
				return new VBool(((VInt) lh).getVal() <= ((VInt) rh).getVal());
			}
		}
		throw new TypeException("Invalid type exception!");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		// TODO Auto-generated method stub

	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException {
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
