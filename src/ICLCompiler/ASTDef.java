package ICLCompiler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ASTDef implements ASTNode {

	List<Binding> decs;
	private ASTNode exp;
	private int evalResult;

	public ASTDef(List<Binding> declarations, ASTNode exp) {
		this.decs = declarations;
		this.exp = exp;
	}

	@Override
	public IValue eval(Environment<IValue> env) throws TypeException, UndeclaredIdentifierException, IDDeclaredTwiceException {

		env = env.beginScope();
		for (Binding b : decs) {
			env.assoc(b.getID(), ((VInt) b.getExp().eval(env)));
		}

		evalResult = ((VInt) exp.eval(env)).getVal();
		env.endScope();
		return new VInt(evalResult);
	}

	@Override
	public void compile(CodeBlock c, Environment<IValue> env) {
		try {
			
		    env = env.beginScope();
			createFrame(env.getDepth());
			c.emit("new frame_" + env.getDepth());
			c.emit("dup");
			c.emit(String.format("invokespecial frame_%d/<init>()V", env.getDepth()));
			c.emit("dup");

			if (env.getDepth() == 0) {
				c.emit("astore_3");

				for (Binding b : decs) {
					c.emit("dup");

					env.assoc(b.getID(), b.getExp().eval(env));
					b.getExp().compile(c, env);

					c.emit("putfield frame_0/" + b.getID() + " I");
				}
			} else {
				
				c.emit("aload_3");
				c.emit("putfield frame_" + env.getDepth() + "/sl Lframe_" + (env.getDepth() - 1) + ";");
				c.emit("dup");
				c.emit("astore_3");

				for (Binding b : decs) {
					
					c.emit("dup");
					b.getExp().compile(c, env);
					env.assoc(b.getID(), b.getExp().eval(env));
					c.emit("putfield frame_" + env.getDepth() + "/" + b.getID() + " I");
					
				}
			}
			c.emit("pop");
			exp.compile(c, env);
			if (env.getDepth() > 0) {
				
				c.emit("aload_3");
				c.emit("getfield frame_" + env.getDepth() + "/sl Lframe_" + (env.getDepth() - 1) + ";");
				c.emit("astore_3");
				
			}
			
			env = env.endScope();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createFrame(int depth) throws IOException {
		try {
			FileWriter frame = new FileWriter("frame_" + depth + ".j");

			frame.write(".class public frame_" + depth + "\n");
			frame.write(".super java/lang/Object\n");
			if (depth > 0)
				frame.write(".field public sl Lframe_" + (depth - 1) + ";\n");
			else
				frame.write(".field public sl Ljava/lang/Object;s\n");
			for (Binding b : decs)
				frame.write(".field public " + b.getID() + " I\n");
			frame.write(".method public <init>()V\n");
			frame.write("aload_" + depth + "\n");
			frame.write("invokenonvirtual java/lang/Object/<init>()V\n");
			frame.write("return\n");
			frame.write(".end method\n");
			frame.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	@Override
	public IType typecheck(Environment<IType> env) throws TypeException, IDDeclaredTwiceException {
		
		for(Binding b: decs) {
			b.getExp().typecheck(env);
		}
		
		return exp.typecheck(env);
	}

}
