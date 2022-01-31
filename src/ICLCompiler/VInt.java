package ICLCompiler;
public class VInt implements IValue {

	int v;

	public VInt(int val) {
		this.v = val;
	}

	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(v);
	}

	public int getVal() {
		// TODO Auto-generated method stub
		return v;
	}

}
