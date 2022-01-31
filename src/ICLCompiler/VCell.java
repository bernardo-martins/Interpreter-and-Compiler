package ICLCompiler;
public class VCell implements IValue {

	public IValue val;

	public VCell(IValue v) {
		this.val = v;
	}

	public void setValue(IValue v) {
		this.val = v;
	}

	public IValue get() {
		return val;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}

}
