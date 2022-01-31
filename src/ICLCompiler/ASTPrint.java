package ICLCompiler;

public class ASTPrint implements ASTNode {

	private ASTNode node;
	private boolean newLine;

	public ASTPrint(ASTNode n, boolean newLine) {
		this.node = n;
		this.newLine = newLine;
	}

	@Override
	public IValue eval(Environment<IValue> env)
			throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {

		IValue v = node.eval(env);
		if (!newLine)
			System.out.print(v.toString());
		else
			System.out.println(v.toString());
		return v;
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		node.compile(c, env);
		c.emit("invokestatic java/lang/String/valueOf(I)Ljava/lang/String;");
		if (newLine)
			c.emit("invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V");
		else
			c.emit("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
		
	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException {
		// TODO Auto-generated method stub
		return null;
	}

}
