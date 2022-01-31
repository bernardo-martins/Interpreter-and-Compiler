package ICLInterpreter;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

class CodeBlock {
	List<String> code;
	int pc = 0;

	public CodeBlock() {
		code = new LinkedList<String>();
	}

	public void emit(String opcode) {
		code.add(opcode);
	}

	public void dump(PrintStream f, String filename) {

		f.println(".class public " + filename + "\n" + ".super java/lang/Object\n" + ";\n" + "; standard initializer\n"
				+ ".method public <init>()V\n" + "   aload_0\n" + "   invokenonvirtual java/lang/Object/<init>()V\n"
				+ "   return\n" + ".end method\n" + "\n" + ".method public static main([Ljava/lang/String;)V\n"
				+ "       ; set limits used by this method\n" + "       .limit locals 10\n"
				+ "       .limit stack 256\n" + "\n"
				+ "       ;    1 - the PrintStream object held in java.lang.System.out\n"
				+ "       getstatic java/lang/System/out Ljava/io/PrintStream;\n" + "\n"
				+ "       ; place your bytecodes here between START and END\n" + "       ; START\n" + "\n");

		for (String line : code)
			f.println("      " + line);

		f.println("\n" + "\n" + "\n" + "       ; END\n" + "\n" + "\n" + "\n" + "       ; convert to String;\n"
				+ "       invokestatic java/lang/String/valueOf(I)Ljava/lang/String;\n" + "       ; call println\n"
				+ "       invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n" + "       return\n"
				+ ".end method");

		f.flush();

	}

}