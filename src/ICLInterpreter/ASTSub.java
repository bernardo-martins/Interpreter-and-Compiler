package ICLInterpreter;

public class ASTSub implements ASTNode {

	ASTNode lhs, rhs;
	
	public ASTSub(ASTNode l, ASTNode r) {
		lhs = l;
		rhs = r;
	}

	public IValue eval(Environment<IValue> e)
			throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {
		IValue v1 = lhs.eval(e);
		IValue v2 = rhs.eval(e);

		if (v1 instanceof VInt) {
			v1 = (VInt) v1;
			if (v2 instanceof VInt) {
				v2 = (VInt) v2;
				return new VInt(((VInt) v1).getVal() - ((VInt) v2).getVal());
			}
		}

		throw new TypeException("Illegal types!");
	}

	public void compile(CodeBlock c, Environment<IValue> env) {
		lhs.compile(c, env);
		rhs.compile(c, env);
		c.emit("isub");
	}
}
