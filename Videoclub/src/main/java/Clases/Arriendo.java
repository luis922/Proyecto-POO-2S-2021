package Clases;

public class Arriendo {
    private String id;
    private float valoracion; //Numero de estrellas con la que el cliente valoro el film de 0 a 5
    private String fechaArriendo;
    private String fechaEntrega;
    private boolean entregado; //TRUE si la pelicula fue devuelta, False en el caso contrario
    private int vecesArrendada;
    //Hacer una coleccion de un objeto que contenga fecha de arriendo, entrega y valoracion.

    public Arriendo(){
        id = null;
        valoracion = 0;
        fechaArriendo = null;
        fechaEntrega = null;
        entregado = true;
        vecesArrendada = 0;
    }
    
//------------------SETTER/GETTER------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public String getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(String fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public void setVecesArrendada(int vecesArrendada) {
        this.vecesArrendada = vecesArrendada;
    }

    public int getVecesArrendada() {
        return vecesArrendada;
    }
}
