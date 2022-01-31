package ICLCompiler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {

		String str = "Hello";
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("Main.j"));
			String s;
			File f1 = new File("Main.j"); // Creation of File Descriptor for input file
			String[] words = null; // Intialize the word Array
			FileReader fr = new FileReader(f1); // Creation of File Reader object
			BufferedReader br = new BufferedReader(fr); // Creation of BufferedReader object
			int c = 0;
			String input = "START"; // Input word to be searched
			int count = 0; // Intialize the word to zero	
			while ((s = br.readLine()) != null) // Reading Content from the file
			{
				words = s.split(" "); // Split the word using space
				c += words.length * (' ');
				for (String word : words) {
					c += word.length();
					System.out.println(word);
					if (word.equals(input)) // Search for the given word
					{
						writer.newLine();

					}
				}
			}
			
			writer.write(str);
			br.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
