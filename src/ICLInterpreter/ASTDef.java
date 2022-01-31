package ICLInterpreter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ASTDef implements ASTNode {

	private List<Pair<String, ASTNode>> init;
	private List<Binding> decs;
	private ASTNode exp;
	private IValue value;
	private int evalResult;
	private ASTNode body;

	public ASTDef(List<Binding> declarations, ASTNode exp) {
		this.decs = declarations;
		this.init = new LinkedList<Pair<String, ASTNode>>();
		this.exp = exp;
		this.value=null;
	}

	@Override
	public IValue eval(Environment<IValue> e)
			throws TypeException, IDDeclaredTwiceException, UndeclaredIdentifierException {

		e = e.beginScope();
		for (Binding b : decs) {
			e.assoc(b.getID(), b.getExp().eval(e));
		}
		value = exp.eval(e);
		e.endScope();
		
		return value;
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {

	}

}