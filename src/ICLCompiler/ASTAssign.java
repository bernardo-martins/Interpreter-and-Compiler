package ICLCompiler;


public class ASTAssign implements ASTNode {

	public ASTNode lhs, rhs;

	public ASTAssign(ASTNode v1, ASTNode v2) {
		this.lhs = v1;
		this.rhs = v2;
	}

	@Override
	public IValue eval(Environment<IValue> env) throws TypeException,UndeclaredIdentifierException, IDDeclaredTwiceException {
		// TODO Auto-generated method stub
		IValue l = lhs.eval(env);
		if (l instanceof VCell) {
			IValue r = rhs.eval(env);

			((VCell) l).setValue(r);
			return r;
		}
		// throw error
		return null;
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		// TODO Auto-generated method stub

	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException {
		IType n = lhs.typecheck(env);
		if (n instanceof TRef) {
			return rhs.typecheck(env);
		}
		throw new TypeException("Element is not a reference");
	}

}
