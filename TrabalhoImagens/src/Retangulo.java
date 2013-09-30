import java.awt.Graphics;

public class Retangulo extends Imagem {

	private int p1, p0;

	public void scan() {
		super.scan();
		p0 = Shape.scanInt("Largura: ");
		p1 = Shape.scanInt("Altura: ");
	}

	public void draw(Graphics g) {
		g.drawRect(posicaoX, posicaoY, p0, p1);
	}
}
