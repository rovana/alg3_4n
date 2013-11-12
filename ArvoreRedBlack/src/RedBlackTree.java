import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class RedBlackTree {

	// criar a árvore
	public RedBlackTree() {
		header = new NodoRedBlack(null);
		header.left = header.right = nodoNull;
	}

	private final int comparar(Comparable item, NodoRedBlack t) {
		if (t == header)
			return 1;
		else
			return item.compareTo(t.element);
	}
	
	public void abrirArquivo(){
		try {

			// Criação de um buffer para a ler de uma stream
			BufferedReader txt = new BufferedReader(new FileReader("F:\\dados.txt"));

			String Str;
			String[] line;

			// ler cada linha do arquivo
			while ((Str = txt.readLine()) != null) {
				// Aqui usamos o método split que divide a linha lida em um array de String
				// passando como parametro o divisor "=".
				line = Str.split("=");
			}
			
			txt.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public int altura(){
            int left = 0;
            int right = 0;

            if (getLeft() != null)
                    left = ((RedBlackTree) getLeft()).altura();

            if (getRight() != null)
                    right += ((RedBlackTree) getRight()).altura();

            if (left > right)
                    return left + 1;
            else
                    return right + 1;

    }

	private Object getRight() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object getLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	public void inserir(Comparable item) {
		
		current = pai = grand = header;
		nodoNull.element = item;

		while (comparar(item, current) != 0) {
			great = grand;
			grand = pai;
			pai = current;
			current = comparar(item, current) < 0 ? current.left : current.right;

			// verificar se dois filhos são red, se forem corrigir
			if (current.left.color == RED && current.right.color == RED)
				reordenar(item);
		}

		// verifica se pode ser inserido, se já tem elemento no nodo a ser inserido
		if (current != nodoNull)
			throw new DuplicateItemException(item.toString());
		current = new NodoRedBlack(item, nodoNull, nodoNull);

		// inserir o filho
		if (comparar(item, pai) < 0)
			pai.left = current;
		else
			pai.right = current;
		reordenar(item);
	}

	public void remover(Comparable x) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a chave do valor a ser excluído: ");
		String chave = sc.nextLine();
		
		
		//throw new UnsupportedOperationException();
	}

	// encontrar o menor item da árvore, retornar null caso seja vazio ou o valor inserido no nodo
	public Comparable encontrarMin() {
		if (isEmpty())
			return null;

		NodoRedBlack itr = header.right;

		while (itr.left != nodoNull)
			itr = itr.left;

		return itr.element;
	}

	// encontrar o maior item na árvore e retornar este valor ou nulo se for vazio
	public Comparable encontrarMax() {
		if (isEmpty())
			return null;

		NodoRedBlack itr = header.right;

		while (itr.right != nodoNull)
			itr = itr.right;

		return itr.element;
	}

	// localizar item na árvore
	public Comparable pesquisar(Comparable chave) {
		nodoNull.element = chave;
		current = header.right;

		for ( ; ; ) {
			if (chave.compareTo(current.element) < 0)
				current = current.left;
			else if (chave.compareTo(current.element) > 0)
				current = current.right;
			else if (current != nodoNull)
				return current.element;
			else
				return null;
		}
	}

	// montar árvore vazia
	public void makeEmpty() {
		header.right = nodoNull;
	}

	// imprimir todos os itens
	public void imprimirTree() {
		imprimirTree(header.right);
	}

	// método interno para imprimir uma sub-ordem de classificação
	private void imprimirTree(NodoRedBlack t) {
		if (t != nodoNull) {
			imprimirTree(t.left);
			System.out.println(t.element);
			imprimirTree(t.right);
		}
	}

	// testa se a árvore está vazia, retorna true se vazia
	public boolean isEmpty() {
		return header.right == nodoNull;
	}

	// método chamado durante uma inserção. Se um nodo tem dois filhos
	// vermelhos, altera a cor e faz as rotações
	private void reordenar(Comparable item) {
		// alterar as cores
		current.color = RED;
		current.left.color = BLACK;
		current.right.color = BLACK;

		if (pai.color == RED) // tem que girar
		{
			grand.color = RED;
			if ((comparar(item, grand) < 0) != (comparar(item, pai) < 0))
				pai = rotacionar(item, grand); // inicia a rotação
			current = rotacionar(item, great);
			current.color = BLACK;
		}
		header.right.color = BLACK; // torna a raiz black
	}

	// executar única ou dupla rotação
	private NodoRedBlack rotacionar(Comparable item, NodoRedBlack pai) {
		if (comparar(item, pai) < 0)
			return pai.left = comparar(item, pai.left) < 0 ? 
					rotacionarFilhoEsquerda(pai.left): // LL
					rotacionarFilhoDireita(pai.left); // LR
		else
			return pai.right = comparar(item, pai.right) < 0 ?
					rotacionarFilhoEsquerda(pai.right): // RL
					rotacionarFilhoDireita(pai.right); // RR
	}

	// girar a árvore com filho a esquerda
	private static NodoRedBlack rotacionarFilhoEsquerda(NodoRedBlack k2) {
		NodoRedBlack k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		return k1;
	}

	// rotacionar filho a direita
	private static NodoRedBlack rotacionarFilhoDireita(NodoRedBlack k1) {
		NodoRedBlack k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		return k2;
	}

	private static class NodoRedBlack {

		NodoRedBlack(Comparable elemento) {
			this(elemento, null, null);
		}

		NodoRedBlack(Comparable elemento, NodoRedBlack lt, NodoRedBlack rt) {
			element = elemento;
			left = lt;
			right = rt;
			color = RedBlackTree.BLACK;
		}

		Comparable element; // dados do nodo
		NodoRedBlack left; // filho da esquerda
		NodoRedBlack right; // filho da direita
		int color; // cor
	}

	private NodoRedBlack header;
	private static NodoRedBlack nodoNull;
	static // inicializar o nodo
	{
		nodoNull = new NodoRedBlack(null);
		nodoNull.left = nodoNull.right = nodoNull;
	}

	private static final int BLACK = 1; 
	private static final int RED = 0;

	private static NodoRedBlack current;
	private static NodoRedBlack pai;
	private static NodoRedBlack grand;
	private static NodoRedBlack great;

	//testes
	public static void main(String[] args) {
		RedBlackTree t = new RedBlackTree();
		final int NUMS = 400000;
		final int GAP = 35461;

		System.out.println("Verificando... (não há saídas a serem a serem apresentadas)");

		for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
			t.inserir(new Integer(i));

		if (((Integer) (t.encontrarMin())).intValue() != 1
				|| ((Integer) (t.encontrarMax())).intValue() != NUMS - 1)
			System.out.println("erro em encontrarMin ou encontrarMax!");

		for (int i = 1; i < NUMS; i++)
			if (((Integer) (t.pesquisar(new Integer(i)))).intValue() != i)
				System.out.println("Erro encontrado!");
	}
}
