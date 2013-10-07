import java.awt.Graphics;

public class Retangulo extends Imagem {

	public static void retangulo(Coordenadas coordSuperior, Coordenadas coordInferior, Cor cor){
		Coordenadas xy1 = coordSuperior;
		Coordenadas xy2 = new Coordenadas(coordSuperior.getX(), coordInferior.getY());
		Coordenadas xy3 = coordInferior;
		Coordenadas xy4 = new Coordenadas(coordInferior.getX(), coordSuperior.getY());

		Reta.reta(xy1, xy2, cor);
		Reta.reta(xy2, xy3, cor);
		Reta.reta(xy4, xy3, cor);
		Reta.reta(xy1, xy4, cor);
	}
}
