public class Aluno {

	protected String nome;
	protected int idade;
	protected String semestre;
	protected double valorEstagio;

	public Aluno(String nome, int idade, String semestre, double valorEstagio) {
		this.setnome(nome);
		this.setidade(idade);
		this.setsemestre(semestre);
		this.setvalorEstagio(valorEstagio);
	}

	public String getnome() {
		return nome;
	}

	public int getidade() {
		return idade;
	}

	public String getsemestre() {
		return semestre;
	}

	public double getvalorEstagio() {
		return valorEstagio;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public void setidade(int idade) {
		if (idade < 16) {
			idade = 16;
		}
		this.idade = idade;
	}

	public void setsemestre(String semestre) {
		this.semestre = semestre;
	}

	public void setvalorEstagio(double valorEstagio) {
		if (valorEstagio < 600.00) {
			valorEstagio = 600.00;
		}
		this.valorEstagio = valorEstagio;
	}

	public double aumento(double percentual) {
		

		this.setvalorEstagio((this.getvalorEstagio() + this.getvalorEstagio()*0.2340));

		return this.getvalorEstagio();
	}
	
	 public static void main(String[] args) {
	        
	        Aluno aluno1 = new Aluno("Mateus", 25, "5", 950.00);
	        Aluno aluno2 = new Aluno("Lucas", 11, "3", 400.00);
	        Aluno aluno3 = new Aluno("Marina", 45, "6", 1300.00);
	    
	        aluno1.aumento(23.40);
	        aluno2.aumento(23.40);
	        aluno3.aumento(23.40);
	        
	        System.out.println( "Aluno: " + aluno1.getnome() + ", salário: " + aluno1.getvalorEstagio());
	        System.out.println( "Aluno: " + aluno2.getnome() + ", salário: " + aluno2.getvalorEstagio());
	        System.out.println( "Aluno: " + aluno3.getnome() + ", salário: " + aluno3.getvalorEstagio());

	        
	 }       
}
