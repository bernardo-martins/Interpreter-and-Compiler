package ICLInterpreter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import ICLInterpreter.Parser0;

public class ICLInterpreter {

	public static void main(String args[]) throws FileNotFoundException {
		//Parser0 parser = new Parser0(System.in);

		Parser0 parser = new Parser0(new FileInputStream(args[0]));
		Environment<IValue> env = new Environment<IValue>();
			try {
				System.out.print(">");
				ASTNode ast = (ASTNode) parser.Start();
				ast.eval(env);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Syntax Error!");
				parser.ReInit(System.in);
			}
	}

}
