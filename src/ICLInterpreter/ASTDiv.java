package ICLInterpreter;

public class ASTDiv implements ASTNode {

	private ASTNode lhs, rhs;
	private String mode;

	public ASTDiv(ASTNode l, ASTNode r, String mode) {
		lhs = l;
		rhs = r;
		this.mode = mode;
	}

	public IValue eval(Environment<IValue> e)
			throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		IValue v1 = lhs.eval(e);
		IValue v2 = rhs.eval(e);
		if (v1 instanceof VInt) {
			v1 = (VInt) v1;
			if (v2 instanceof VInt) {
				v2 = (VInt) v2;
				switch (mode) {
				case "MOD":
					return new VInt(((VInt) v1).getVal() % ((VInt) v2).getVal());
				case "DIV":
					return new VInt(((VInt) v1).getVal() / ((VInt) v2).getVal());
				}
			}
		}
		throw new TypeException("Illegal types divided!");
	}

	public void compile(CodeBlock c, Environment<IValue> env) {
		lhs.compile(c, env);
		rhs.compile(c, env);
		c.emit("idiv");
	}

}