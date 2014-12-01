
public class CarroFactory { 
	
    public static Carro getCarro( String tipoCarro ) { 
    	
        if( tipoCarro == null ) return null;  
        else if( tipoCarro.equals("Vectra") ) return new Vectra();    
        else if( tipoCarro.equals("Golf") ) return new Golf();    
        else return null;  
    }  
}  