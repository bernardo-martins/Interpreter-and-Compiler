package ICLInterpreter;

public class ASTNew implements ASTNode {

	public ASTNode t;

	public ASTNew(ASTNode t) {
		this.t = t;
	}

	@Override
	public IValue eval(Environment<IValue> environment)
			throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		return Memory.alloc(t.eval(environment));
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {

	}

}
