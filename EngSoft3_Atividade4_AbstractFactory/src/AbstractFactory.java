

public class AbstractFactory {  
    public static void main( String args[] ) {  
        //par�metro passado como argumento no console  
        //pega a inst�ncia do fabricante  
        Fabricante fab = Fabricante.getInstance( args[0] );  
        //pega a inst�ncia do carro, de acordo com o fabricante  
        Carro carro = fab.getCarro( args[1] );  
        //mostra o valor  
        if( carro != null ) {  
            System.out.println( "Pre�o: " + carro.getPreco() );  
        }  
    }  
}  