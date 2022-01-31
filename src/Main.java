import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import ICLCompiler.ICLCompiler;
import ICLInterpreter.ICLInterpreter;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = null;
		Scanner in = new Scanner(System.in);
		Runtime run = Runtime.getRuntime();
		String fileName = "";
		try {
			while (true) {
				System.out.print("> ");
				input = in.nextLine();
				fileName = input.split(" ")[1];
				if (input.contains("ICLCompiler")) {
					
					// run compiler
					run.exec("javac ICLCompiler.java");
					ICLCompiler.main(new String[] { fileName });
					Process p = run.exec("java -jar jasmin.jar " + fileName.split("\\.")[0] + ".j");
					
					BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
					String s = null;
					while ((s = stdInput.readLine()) != null) {
						System.out.println(s);
					}
					
				} else if (input.contentEquals("exit")) {
					// do exit
					System.out.println("exiting...");
					break;

				} else if (input.contains("ICLInterpreter")) {
					// run interpreter
					run.exec("javac ICLInterpreter.java");
					ICLInterpreter.main(new String[] { fileName });

				} else {
					Process p = run.exec(input);
					BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
					String s = null;
					while ((s = stdInput.readLine()) != null) {
						System.out.println(s);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		in.close();

	}
}
