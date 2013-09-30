import java.awt.Graphics;

public class Reta extends Imagem {
	// largura p0 altura p1
	
	private int p1, p0;

	public void scan() {
		super.scan();
		p0 = Shape.scanInt("Largura: ");
		p1 = Shape.scanInt("Altura: ");
	}

	public void draw(Graphics g) {
		g.drawLine(posicaoX, posicaoY, p0, p1);
	}
}
