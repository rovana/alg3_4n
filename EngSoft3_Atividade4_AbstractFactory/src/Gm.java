
public class Gm extends Fabricante {  
    public Gm() {  
        name = "Chevrolet";  
    }  
  
    public Carro getCarro( String marca ) {  
        if( marca == null ) {  
            return null;  
        }  
        else if( marca.equals("Vectra") ) {  
            return new Vectra();  
        }   
        else {  
            return null;  
        }  
    }  
}  