import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CSVFile<T> {
	private Scanner arquivo;
	private Parser<T> parser; 
	
	public CSVFile(String filename, Parser<T> parser)
			throws FileNotFoundException
	{
		arquivo = new Scanner(
				new BufferedReader(
						new FileReader(filename)
				)
		  );
		this.parser = parser;
	}
	public boolean hasNext() {
		return arquivo.hasNext();
	}
	public T readObject() {
		return parser.parse(arquivo.nextLine());
	}
	public void close() {
		arquivo.close();
	}
	public void skipLine() {
		arquivo.nextLine();
	}
}
