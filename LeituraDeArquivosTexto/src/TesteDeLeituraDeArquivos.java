import java.io.FileNotFoundException;

public class TesteDeLeituraDeArquivos {

	public static void main(String[] args) {
		try {
			(new TesteDeLeituraDeArquivos()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrei o arquivo.");
			System.err.println(e.getMessage());
		}
	}

	private void run() throws FileNotFoundException {
		testaLeituraDeAluno();
		testaLeituraDeRoute();
	}

	private void testaLeituraDeRoute() throws FileNotFoundException {
		CSVFile<Route> arquivo = new CSVFile<>("routes.txt", new RouteParser());
		arquivo.skipLine(); // pula header do arquivo
		while (arquivo.hasNext()) {
			Route route = arquivo.readObject();			
			System.out.println(route);
		}
		arquivo.close();
	}

	private void testaLeituraDeAluno() throws FileNotFoundException {
		CSVFile<Aluno> arquivo = new CSVFile<>("alunos.csv", new AlunoParser());
		while (arquivo.hasNext()) {
			Aluno aluno = arquivo.readObject();			
			System.out.println(aluno);
		}
		arquivo.close();
	}

}
