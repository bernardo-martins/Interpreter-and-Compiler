package ICLCompiler;

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
		throw new TypeException("Invalid type!");
	}

	public void compile(CodeBlock c, Environment<IValue> env) {

		lhs.compile(c, env);
		rhs.compile(c, env);
		c.emit("isub");
	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException  {
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
