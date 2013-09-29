import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

public class Circulo extends Imagem{

		
	private int diametro;

	
	public void scan() {
		super.scan();
		diametro = Shape.scanInt("Diametro: ");
	}

	
	public void draw(Graphics g) {
		g.drawOval(posicaoX, posicaoY,diametro, diametro);
	}
}
