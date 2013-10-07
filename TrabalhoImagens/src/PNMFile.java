import java.io.PrintStream;

public class PNMFile {

	private final String FILE_HEADER = "%s\n%d %d\n";
	private final String ESPACO = " ";
	private static int largura;
	private static int altura;
	private static Cor[][] imagem;

	PNMFile(int largura, int altura) {

		this.largura = largura;
		this.altura = altura;

		imagem = new Cor[largura][altura];
	}

	public static void setPixel(int x, int y, Cor cor) {
		Coordenadas xy = new Coordenadas(x, y);
		setPixel(xy, cor);
	}

	public static void setPixel(Coordenadas coord, Cor cor) {
		int x = coord.getX();
		int y = coord.getY();

		validaCoordenadas(x, y);

		imagem[x][y] = cor;
	}

	private static void validaCoordenadas(int x, int y) {

		if (x < 0 || x >= largura)
			throw new IllegalArgumentException("Valor de x está fora dos limites");

		if (y < 0 || y >= altura)
			throw new IllegalArgumentException("Valor de y está fora do limites");
	}

	public void printImagem(PrintStream out, PNUMFileType pNMFileType) {
		
		String header = String.format(FILE_HEADER, pNMFileType.getValue(),
				largura, altura);

		if (pNMFileType != PNUMFileType.PORTABLE_BITMAP)
			header += "255\n";

		out.print(header);

		for (int x = 0; x < largura; x++) {
			for (int y = 0; y < altura; y++) {
				Cor pixel = getPixel(x, y);

				if (pixel == null)
					pixel = new Cor(255, 255, 255);

				String p;

				switch (pNMFileType) {
				case PORTABLE_BITMAP:
					p = pixel.GetBitmap().toString();
					break;

				case PORTABLE_GRAYMAP:
					p = pixel.getGraymap().toString();
					break;

				}

				out.print(ESPACO);
			}
			out.print("\n");
		}

	}

	private Cor getPixel(int x, int y) {
		validaCoordenadas(x, y);

		Cor pixel = imagem[x][y];

		return pixel;
	}

}
