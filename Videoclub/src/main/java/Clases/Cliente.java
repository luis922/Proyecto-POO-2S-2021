package Clases;

public class Cliente {
    private String nombre;
    private String rut;

    private short historial[][]; // 50 x 2 fila: id col:la recomienda?rank?
    private String peliculasEnPosesion[];  // id     fecha //3 x 2
    int deuda;
    
    public Cliente(){ //constructor
        
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setRut(String rut){
        this.rut = rut;
    }
    public void setHistorial(short id, short ranking, short i){       
        historial[i][0] = id;
        historial[i][1] = ranking;
    }
    public void setPeliculasEnPosecion(String film, short i){
        peliculasEnPosesion[i] = film;       
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
    public void getHistorial(){ // terminar
        short i;
        
        for(i=0 ; i <50; i++){
            System.out.println("");
        }
    }
    public void getPeliculasEnPosecion(){//terminar
        
    }
    public int getDeuda(){
        return deuda;
    }
    /*
    public void sugerirPelicula(){ // Verificar que esté en stock.
    }
    public void rankPelicula(){ // valora pelicula de 1 al 5
    }
    public void arrendarPelicula(){ 
    }
    public void devolverPelicula(){
    }*/

}
