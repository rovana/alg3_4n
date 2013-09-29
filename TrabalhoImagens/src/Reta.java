import java.awt.Graphics;


public class Reta extends Imagem{

	//setVertices(p0: Ponto, p1:Ponto):void
	
	private int altura, largura;

	public void scan() {
		super.scan();
		largura = Shape.scanInt("Largura: ");
		altura = Shape.scanInt("Altura: ");
	}

	
	public void draw(Graphics g) {
	//	g.drawRect(posicaoX, posicaoY, largura, altura);
		g.drawLine(posicaoX, posicaoY, largura, altura);
	}
}
