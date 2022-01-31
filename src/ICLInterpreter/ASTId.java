package ICLInterpreter;

public class ASTId implements ASTNode {

	String id;

	public ASTId(String id) {
		this.id = id;
	}

	@Override
	public IValue eval(Environment<IValue> e) throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {
		return e.find(id);
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> e) {

	}

}
