
public class Vw extends Fabricante {  
    public Vw() {  
        name = "Volkswagen";  
    }  
  
    public Carro getCarro( String marca ) {  
        if( marca == null ) {  
            return null;  
        }  
        else if( marca.equals("Golf") ) {  
            return new Golf();  
        }  
        else {  
            return null;  
        }  
    }  
}  