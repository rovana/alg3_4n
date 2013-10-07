
public class Triangulo {

	public static void triangulo(Coordenadas coord1, Coordenadas coord2, Coordenadas coord3, Cor cor)
	{
		validaTriangulo(coord1, coord2, coord3);

		Reta.reta(coord1, coord2, cor);
		Reta.reta(coord1, coord3, cor);
		Reta.reta(coord2, coord3, cor);

	}

	private static void validaTriangulo(Coordenadas coord1, Coordenadas coord2, Coordenadas coord3) {
		boolean heTriangulo = !(coord1.equals(coord2) || coord2.equals(coord3) || coord3.equals(coord1));

		if (!heTriangulo)
			throw new IllegalArgumentException("Os valores informados não formam um triângulo válido.");
	}
}
