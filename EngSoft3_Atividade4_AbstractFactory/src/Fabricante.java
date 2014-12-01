public abstract class Fabricante {  
    protected String name;  
  
    public abstract Carro getCarro( String marca );  
  
    public static Fabricante getInstance( String fabricante ) {  
        if( fabricante == null ) {  
            return null;  
        }  
        else if(fabricante.equals("Chevrolet")) {  
            return new Gm();  
        }  
        else if(fabricante.equals("Volkswagen")) {  
            return new Vw();  
        }  
        else {  
            return null;  
        }  
    }  
}  