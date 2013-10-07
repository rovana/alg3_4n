import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Shape {

	public static void main(String[] args) {

		lerTeclado();

	}

	private static void lerTeclado() {
		PNMFile pnmFile = new PNMFile(0, 0);
		Cor cor = new Cor(0, 0, 0);
		char cores = '\0';

		Scanner sc = new Scanner(System.in);
		sc.reset();

		System.out.print("->");

		while (sc.hasNext()) {

			Comandos comando;
			try {
				comando = Comandos.valueOf(sc.next());

				switch (comando) {
				
				case sair: {
					System.out.println("Fim do programa");
					return;
				}
				case cor: {
					int r = 0;
					int b = 0;
					int g = sc.nextInt();
					if (sc.hasNext()) {
						r = g;
						g = sc.nextInt();
						b = sc.nextInt();
					}
					cor = new Cor(r, g, b);
					System.out.println("Cor Configurada");
					break;
				}
				case circulo: {
					int x = sc.nextInt();
					int y = sc.nextInt();
					int r = sc.nextInt();
					Coordenadas coord = new Coordenadas(x, y);
					Circulo.circulo(coord, r, cor);
					System.out.println("Circulo Desenhado");
					break;
				}
				case reta: {
					int x0 = sc.nextInt();
					int y0 = sc.nextInt();
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					Coordenadas coord1 = new Coordenadas(x0, y0);
					Coordenadas coord2 = new Coordenadas(x1, y1);
					Reta.reta(coord1, coord2, cor);
					System.out.println("Reta desenhada");
					break;
				}
				case retangulo: {
					int x0 = sc.nextInt();
					int y0 = sc.nextInt();
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					Coordenadas coord1 = new Coordenadas(x0, y0);
					Coordenadas coord2 = new Coordenadas(x1, y1);
					Retangulo.retangulo(coord1, coord2, cor);
					System.out.println("Retângulo desenhado");
					break;
				}
				case triangulo: {
					int x0 = sc.nextInt();
					int y0 = sc.nextInt();
					int x1 = sc.nextInt();
					int y1 = sc.nextInt();
					int x2 = sc.nextInt();
					int y2 = sc.nextInt();

					Coordenadas coord1 = new Coordenadas(x0, y0);
					Coordenadas coord2 = new Coordenadas(x1, y1);
					Coordenadas coord3 = new Coordenadas(x2, y2);
					Triangulo.triangulo(coord1, coord2, coord3, cor);
					System.out.println("Triangulo Desenhado");
					break;
				}
				case imagem: {
					int l = sc.nextInt();
					int h = sc.nextInt();
					cores = sc.next().charAt(0);
					pnmFile = new PNMFile(l, h);
					System.out.println("-Imagem Criada");
					break;
				}
				case salvar: {
					String fileName = sc.next();

					File file = new File(fileName);

					try {
						PrintStream ps = new PrintStream(file);

						try {
							if (cores == 'C')
								pnmFile.printImagem(ps,PNUMFileType.PORTABLE_BITMAP);
							else
								pnmFile.printImagem(ps,PNUMFileType.PORTABLE_GRAYMAP);
						} finally {
							ps.flush();
							ps.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					System.out.println("Imagem Salva");
					break;
				}
				case ponto:{
					System.out.println("Ainda não implementado");
				}
				
				}
			} catch (Exception ex) {
				System.out.println("ERRO. Comando inválido");
				sc.nextLine();
				sc.reset();
			}

			System.out.println();
			System.out.print("->");
		}

		sc.close();

	}
}
