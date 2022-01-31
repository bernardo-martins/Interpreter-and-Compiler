package ICLInterpreter;

import java.util.HashMap;
import java.util.Map;

public class Memory {
	private static Map<VRef, IValue> map = new HashMap<VRef, IValue>();
	private static int counter = 0;

	public static IValue get(VRef ref) {
		return map.get(ref);
	}

	public static void set(VRef ref, IValue value) {
		map.put(ref, value);
	}

	public static VRef alloc(IValue value) {
		VRef ref = new VRef(String.valueOf(counter++));
		map.put(ref, value);
		return ref;
	}

	public static void free(VRef ref) {
		map.remove(ref);
	}
}
