package ICLInterpreter;

public class ASTBoolOp implements ASTNode {

	private ASTNode lhs, rhs;
	private String mode;

	public ASTBoolOp(ASTNode t1, ASTNode t2, String mode) {
		this.lhs = t1;
		this.rhs = t2;
		this.mode = mode;
	}

	@Override
	public IValue eval(Environment<IValue> environment) throws TypeException,IDDeclaredTwiceException, UndeclaredIdentifierException {
	
		IValue lh = lhs.eval(environment);
		IValue rh = null;
		if (lh instanceof VInt) {
			lh = (VInt) lh;
			rh = rhs.eval(environment);
			if (rh instanceof VInt)
				rh = (VInt) rh;
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
		throw new TypeException("Illegal type for boolean operation");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		// TODO Auto-generated method stub

	}

}
