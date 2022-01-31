package ICLInterpreter;

public class ASTWhile implements ASTNode {

	public ASTNode condition, exp;

	public ASTWhile(ASTNode condition, ASTNode exp) {
		this.condition = condition;
		this.exp = exp;
	}

	@Override
	public IValue eval(Environment<IValue> environment)
			throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {

		IValue cond = condition.eval(environment);
		boolean c;
		if (cond instanceof VBool) {
			c = ((VBool) cond).getVal();
			while (c) {
				exp.eval(environment);
				c = ((VBool) condition.eval(environment)).getVal();
			}
			return null;
		}

		throw new TypeException("Invalid type in while argument!");
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		// TODO Auto-generated method stub

	}

}
