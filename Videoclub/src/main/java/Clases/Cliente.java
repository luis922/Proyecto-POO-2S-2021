package Clases;

public class Cliente{
    private String nombre;
    private String rut;
    // Arreglar historail para funcionar con matriz
    private short historial[][] = new short [50][2]; // 50 x 2 fila: id col:la recomienda?rank?
    private short peliculasEnPosesion[] = new short[3];  // id     fecha //3 x 2
    int deuda;
    
    public Cliente(){ //constructor
        
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    public void setHistorial(short[][] listaPeliculas){       
        ArrayList<short[]> copia = new ArrayList(listaPeliculas);
        historial = copia;  
    }
    public void setPeliculasEnPosesion(short[] listaPeliculas){
        ArrayList<short> copia = new ArrayList(listaPeliculas);
        peliculasEnPosesion = copia;    
    }
    public void setDeuda(int deuda){
        this.deuda = deuda;
    }
    public String getNombre(){
        return nombre;
    }
    public String getRut(){
        return rut;
    }
    public short[][] getHistorial(){
        return historial;
    }
    public short[] getPeliculasEnPosesion(){
        return peliculasEnPosesion;
    }
    public int getDeuda(){
        return deuda;
    }
    public void sugerirPelicula(){ // Verificar que esté en stock.
    }
    public void rankPelicula(){ // valora pelicula de 1 al 5
    }
    public void arrendarPelicula(){ 
    }
    public void devolverPelicula(){
    }
}
