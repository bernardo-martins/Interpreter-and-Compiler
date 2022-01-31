package ICLCompiler;
public class Binding {

	String id;
	ASTNode exp;

	public Binding(String id, ASTNode exp) {
		this.id = id;
		this.exp = exp;
	}

	public String getID() {
		return id;
	}

	public ASTNode getExp() {
		return exp;
	}

}
