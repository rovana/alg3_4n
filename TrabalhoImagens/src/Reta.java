import java.awt.Graphics;

public class Reta extends Imagem {
	
	public static void reta(Coordenadas coord1, Coordenadas coord2, Cor cor)	{
		int x1 = coord1.getX();
		int y1 = coord1.getY();

		int x2 = coord2.getX();
		int y2 = coord2.getY();

		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);

		int sx = 0;
		int sy = 0;

		if (x1 > x2)
			sx = -1;
		else
			sx = 1;

		if (y1 > y2)
			sy = -1;
		else
			sy = 1;

		int err = dx - dy;

		while (true){
			PNMFile.setPixel(x1, y1, cor);

			if (x1 == x2 && y1 == y2)
				break;

			int e2 = 2 * err;
			
			if (e2 > -dy){
				err -= dy;
				x1 += sx;
			}

			if (x1 == x2 && y1 == y2){
				PNMFile.setPixel(x1, y1, cor);
				break;
			}

			if (e2 < dx){
				err += dx;
				y1 += sy;
			}
		}
	}
}
