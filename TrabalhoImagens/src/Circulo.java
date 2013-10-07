
public class Circulo extends Imagem{
	
	private static int largura;
	private static int altura;
	private Cor[][] imagem;
	
	public static void circulo(Coordenadas coord, int r, Cor cor){
		int x = coord.getX();
		int y = coord.getY();
		int x1, y1;

		for (int i = 0; i < 360; i++) {

			double d = Math.PI * i / 180;
			x1 = (int) Math.round(r * Math.cos(d) + x);
			y1 = (int) Math.round(r * Math.sin(d) + y);

			if ( (x > 0 && x < largura) && (y > 0 && y < altura))			
			PNMFile.setPixel(x1, y1, cor);
			
		}
	}
}