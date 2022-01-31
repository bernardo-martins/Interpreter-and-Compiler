package ICLCompiler;

public interface ASTNode {

	IValue eval(Environment<IValue> env)
			throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException;

	void compile(CodeBlock c, Environment<IValue> env);
	
	IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException;

}
