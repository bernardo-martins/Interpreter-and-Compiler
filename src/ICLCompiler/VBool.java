package ICLCompiler;
public class VBool implements IValue {

	public boolean val;

	public VBool(boolean v) {
		this.val = v;
	}

	public String toString() {
		return String.valueOf(val);
	}

	public boolean getVal() {
		return val;
	}

}
