package ICLCompiler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ICLCompiler {

	public static void main(String args[]) throws FileNotFoundException {

		String fileName = args[0].split("\\.")[0];
		FileInputStream file = new FileInputStream(args[0]);
		Parser0 parser = new Parser0(file);
		Environment<IValue> env = new Environment<IValue>();
		ASTNode exp = null;
		PrintStream ps = new PrintStream(fileName + ".j");
		CodeBlock code = new CodeBlock();
		try {
			code.init(ps, fileName);
			code = new CodeBlock();
			exp = parser.Start();
			exp.eval(env);
			exp.compile(code, env);
			code.dump(ps);
			code.close(ps);
		} catch (Exception e) {
			System.out.println("Syntax Error!");
			Parser0.ReInit(new FileInputStream(args[0]));
		}

	}

}
