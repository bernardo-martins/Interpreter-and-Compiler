package ICLInterpreter;


public class ASTBool implements ASTNode{

	private boolean v;
	
	public ASTBool(boolean val) {
		this.v = val;
	}
	
	@Override
	public IValue eval(Environment<IValue> environment) throws TypeException {
		return new VBool(v);
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		
	}

}
