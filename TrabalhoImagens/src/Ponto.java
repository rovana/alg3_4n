import java.awt.Graphics;
import java.awt.Polygon;

public class Ponto extends Imagem {

	private int ponto;

	public void scan() {
		super.scan();
		ponto = 1;
	}

	public void draw(Graphics g) {
		g.drawOval(posicaoX, posicaoY, ponto, ponto);
		
	}

}
