package ICLCompiler;

public class ASTNum implements ASTNode {

	int val;

	public ASTNum(int n) {
		val = n;
	}
	
	public IValue eval(Environment<IValue> e) {
		return new VInt(val);
	}
	
	public void compile(CodeBlock c, Environment<IValue> env) {
		c.emit("sipush " + val);
	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException {
		return new TInt();
	}

}
