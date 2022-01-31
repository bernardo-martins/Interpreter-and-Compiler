package ICLInterpreter;

public interface ASTNode {

	IValue eval(Environment<IValue> environment)
			throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException;
	
	void compile(CodeBlock c, Environment<IValue> env);
	

}
