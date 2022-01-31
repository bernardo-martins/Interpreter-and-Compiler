package ICLCompiler;
import java.util.HashMap;
import java.util.Map;


public class Environment<V> {

	Map<String, V> assocs;
	Environment<V> father;
	int depth;

	public Environment(Environment<V> e) {
		assocs = new HashMap<String, V>();
		father = e;
		depth = e.depth + 1;
	}

	public Environment<V> beginScope() {

		return new Environment<V>(this);

	}

	public Environment() {
		assocs = new HashMap<String, V>();
		father = null;
		depth = -1;
	}

	public Environment<V> endScope() {
		father = father.getFather();
		return this;
	}

	public void assoc(String id, V val) throws IDDeclaredTwiceException {

		if (assocs.containsKey(id)) {
			throw new IDDeclaredTwiceException("Variable " + id + " already declared");
		}
		assocs.put(id, val);
	}

	public int getDepth() {
		return depth;
	}

	public Environment<V> getFather() {
		return father;
	}

	public V find(String id) throws UndeclaredIdentifierException, IDDeclaredTwiceException {

		V node = assocs.get(id);
		if (node != null)
			return node;
		if (father != null)
			return father.find(id);

		throw new UndeclaredIdentifierException("Undeclared identifier!");
	}

}
