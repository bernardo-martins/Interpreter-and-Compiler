package ICLInterpreter;


public class ASTAdd implements ASTNode {

	ASTNode lhs, rhs;

	public ASTAdd(ASTNode l, ASTNode r) {
		lhs = l;
		rhs = r;
	}

	public VInt eval(Environment<IValue> e) throws TypeException,IDDeclaredTwiceException, UndeclaredIdentifierException {
		IValue v1 = lhs.eval(e);
		IValue v2 = rhs.eval(e);
		if (v1 instanceof VInt) {
			v1 = (VInt) v1;
			if (v2 instanceof VInt) {
				v2 = (VInt) v2;
				return new VInt(((VInt) v1).getVal() + ((VInt) v2).getVal());
			}
		}
		throw new TypeException("llegal types to + operator");
	}
	
	public IValue evalx(Environment<IValue> e) throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		IValue v2 = rhs.eval(e);
		VInt v = null;
		if (v2 instanceof VInt) {
				
		}
		return null;
	}

	public void compile(CodeBlock c, Environment<IValue> env) {

		lhs.compile(c, env);
		rhs.compile(c, env);
		c.emit("iadd");
	}

}
