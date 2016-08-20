import com.senac.SimpleJava.Console;

public class SistemaDeMenus {
	public void run() {
		Console.println("Sistema de Menus");
		
		Menu menu = new Menu();
		
		Opcao cut = new Opcao("cut");
		Opcao copy = new Opcao("copy");
		Opcao paste = new Opcao("paste");
		
		menu.adicionaOpcao(cut);
		menu.adicionaOpcao(copy);
		menu.adicionaOpcao(paste);
		
		menu.exibir();
		
		menu = new Menu();
		String[] opcoes = {"New", "Open", "Close", "Save"};
		for (String op : opcoes)
			menu.adicionaOpcao(new Opcao(op));
		menu.exibir();
	}
}
