package ICLCompiler;

public class TRef implements IType {
	private IType t;

	public TRef(IType t) {
		this.t = t;
	}

	IType getrefttype() {
		return t;
	}

	@Override
	public String toString() {
		return "TRef -> " + t;
	}
}
