package ICLInterpreter;

public class VBool implements IValue {

	public boolean val;

	public VBool(boolean v) {
		this.val = v;
	}

	public boolean getVal() {
		return val;
	}
	
	public String toString() {
		return String.valueOf(val);
	}

}
