import java.util.Scanner;

public class Recursao {

	 protected static int a;
	 protected static int x;
	 protected static int n;
	 protected static int resultado;

	public static Scanner str = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Informe um valor para A: ");
		a = str.nextInt();
		System.out.println("Informe um valor para X: ");
		x = str.nextInt();
		System.out.println("Informe um valor para N: ");
		n = str.nextInt();

		while (n != 0) {

			resultado = resultado + potencia((a * x), (a * x), n) * potencia(x, x, n);
			n = n - 1;
		}

		System.out.println("O resultado é: " + resultado);

	}

	public static int potencia(int valor, int base, int expoente) {
		if (expoente - 1 != 0) {

			valor = potencia(valor * base, base, expoente - 1);
		}
		return valor;
	}
}
