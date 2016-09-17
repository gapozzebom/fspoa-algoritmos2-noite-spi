import java.util.Scanner;

public class AlunoParser implements Parser<Aluno> {
	public Aluno parse(String dados) {
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		
		String nome = arquivo.next();
		String matricula = arquivo.next();
		int numeroAulas = arquivo.nextInt();
		Aluno aluno = new Aluno(nome, matricula, numeroAulas);
		for (int aula = 0; aula < numeroAulas; aula++) {
			int presenca = arquivo.nextInt();
			aluno.setPresenca(aula, presenca == 1);
		}		
		arquivo.close();

		return aluno;
	}
}
