import java.awt.Color;
import java.awt.Graphics;


public class Imagem {
	
	protected int posicaoX, posicaoY;
	protected Color cor;
	public Imagem(){
		cor = Color.BLACK;
	}
	
	public void scan(){
		posicaoX = Shape.scanInt("Posicao X:");
		posicaoY = Shape.scanInt("Posicao Y:");
	}
	
	public void draw(Graphics g) {
		
	}
}

