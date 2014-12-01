

public class AbstractFactory {  
    public static void main( String args[] ) {  
        //parâmetro passado como argumento no console  
        //pega a instância do fabricante  
        Fabricante fab = Fabricante.getInstance( args[0] );  
        //pega a instância do carro, de acordo com o fabricante  
        Carro carro = fab.getCarro( args[1] );  
        //mostra o valor  
        if( carro != null ) {  
            System.out.println( "Preço: " + carro.getPreco() );  
        }  
    }  
}  