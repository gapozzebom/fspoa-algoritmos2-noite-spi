import com.senac.SimpleJava.Console;

public class Menu {

	private Opcao opcoes [] = new Opcao [5]; 
	
	private int numOpcoes = 0;
	
	public void adicionaOpcao(Opcao opcao) {
		
		opcoes[numOpcoes] = opcao;
		numOpcoes++;
		
	}

	public void exibir() {
		for(int i = 0; i < numOpcoes; i++){
			Console.println("[",i+1,"] ",opcoes[i].getTexto());
		}		
	}

}
