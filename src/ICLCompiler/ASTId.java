package ICLCompiler;


public class ASTId implements ASTNode {

	String id;

	public ASTId(String id) {
		this.id = id;
	}

	@Override
	public IValue eval(Environment<IValue> e) throws UndeclaredIdentifierException, IDDeclaredTwiceException {
		// TODO Auto-generated method stub
		return e.find(id);
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> e) {
		// TODO Auto-generated method stub
		// compilation will be done differently
		int depth = -1;
		c.emit("aload_3");
		if (e.assocs.containsKey(id))
			c.emit(String.format("getfield frame_%d/%s I", e.getDepth(), id));
		else {
			Environment<IValue> current = e.getFather();
			depth = current.getDepth();
			while (current != null) {
				if (current.assocs.containsKey(id)) {
					depth = current.getDepth();
					break;
				}
				current = current.getFather();
			}
			for (int i = e.getDepth(); i > depth; i--)
				c.emit(String.format("getfield frame_%d/sl Lframe_%d;", i, i - 1));
			c.emit(String.format("getfield frame_%d/%s I", depth, id));

		}

	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException {
		
		try {
			return env.find(id);
		} catch (UndeclaredIdentifierException e) {
			e.printStackTrace();
		}
		throw new TypeException("Not found!");
		
	}

}
