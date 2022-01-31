package ICLInterpreter;

public class VRef implements IValue {
	private String ref;

	public VRef(String ref) {
		this.ref = ref;
	}

	public String getVal() {
		return ref;
	}

	public String toString() {
		return ref;
	}
}
