import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Shape extends JPanel {

	public static Scanner scanner = new Scanner(System.in);

	public static String scanString(Object out) {
		System.out.print(out);
		return (scanner.nextLine());
	}

	public static int scanInt(Object out) {
		System.out.print(out);
		return (scanner.nextInt());
	}

	public static double scanDouble(Object out) {
		System.out.print(out);
		return (scanner.nextDouble());
	}

	public static boolean scanBoolean(Object out) {
		System.out.print(out);
		return (scanner.nextBoolean());
	}

	public static char scanChar(Object out) {
		System.out.print(out);
		return (scanner.next().charAt(0));
	}

	private List<Imagem> figuras;
	private int p0;
	private int p1;

	// private int[][]figuras;

	public Shape(int largura, int altura) {
		// this.figuras = new int[largura][altura];

		figuras = new ArrayList<Imagem>();
		this.p0 = largura;
		this.p1 = altura;
	}

	public void addFigura(Imagem f) {
		figuras.add(f);
		repaint();
	}

	public void removeFiguras() {
		figuras.clear();
		repaint();

	}

	public void paintComponent(Graphics g) {
		limparTela(g);
		g.setColor(Color.BLACK);
		for (Imagem f : figuras)
			f.draw(g);
	}

	public void limparTela(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, p0, p1);
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("Tela de desenho");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Shape tela = new Shape(400, 400);
		frame.add(tela);
		frame.setSize(400, 400);
		frame.setVisible(true);

		int opcao = 0;

		do {
			opcao = Shape.scanInt("Digite a opcao:\n" + "1- Criar Circulo\n"
					+ "2- Criar Retangulo\n" + "3- Criar Reta\n"
					+ "4- Ponto\n" +
					"5- Limpar Tela\n");

			if (opcao == 1) {
				Circulo c = new Circulo();
				c.scan();
				tela.addFigura(c);
			} else if (opcao == 2) {
				Retangulo r = new Retangulo();
				r.scan();
				tela.addFigura(r);
			} else if (opcao == 3) {
				Reta re = new Reta();
				re.scan();
				tela.addFigura(re);
			} else if (opcao == 4) {
				Ponto p = new Ponto();
				p.scan();
				tela.addFigura(p);
			} else if (opcao == 5) {
				tela.removeFiguras();
			}

		} while (opcao > 0 && opcao < 6);
		frame.dispose();
	}

}
