package ICLCompiler;

public class ASTDiv implements ASTNode {

	private ASTNode lhs, rhs;
	private String mode;

	public ASTDiv(ASTNode l, ASTNode r, String mode) {
		lhs = l;
		rhs = r;
		this.mode = mode;
	}

	public IValue eval(Environment<IValue> env)
			throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		IValue v1 = lhs.eval(env);
		IValue v2 = rhs.eval(env);
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

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException {
		
		IType v1 = lhs.typecheck(env);
		if (v1 instanceof TInt) {
			IType v2 = rhs.typecheck(env);
			if (v2 instanceof TInt)
				return new TInt();
			else
				throw new TypeException("Expected TInt on right side of the expression");
		}
		throw new TypeException("Expected TInt on left side of the expression");
	}

}