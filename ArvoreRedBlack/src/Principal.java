import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		lerTeclado();

	}

	private static void lerTeclado() {
		String item;
		RedBlackTree tree = new RedBlackTree();
		
		Scanner sc = new Scanner(System.in);
		sc.reset();

		System.out.print("->");

		while (sc.hasNext()) {

			Comandos comando;
			comando = Comandos.valueOf(sc.next());

			switch (comando) {
			
			case sair: {
				System.out.println("Fim do programa");
				return;
			}
			case inserir: {
				
				item = sc.next();
				
				break;
			}
			case consultar: {
				
				break;
			}
			case imprimir: {
				
				break;
			}
			case remover: {
				break;
			}				
}
//sc.close();
		}
	}
}
