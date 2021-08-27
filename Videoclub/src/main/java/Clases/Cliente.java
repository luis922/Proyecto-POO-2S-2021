package Clases;

public class Cliente{
    private String nombre;
    private String rut;

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
    public void setHistorial(short id, short ranking){       
        short i; 
        for(i=0; i<50; i++){
            if(historial[i][0] == 0){
                historial[i][0] = id;
                historial[i][1] = ranking;
                return;
            }
        }
    }
    public void setPeliculasEnPosesion(short id){
        short i;
        for(i=0; i<3; i++){
            if(peliculasEnPosesion[i] == 0){
                peliculasEnPosesion[i] = id;
                return;
            }
        }
            
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
