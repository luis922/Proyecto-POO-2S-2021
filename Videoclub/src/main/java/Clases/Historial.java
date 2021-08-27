package Clases;

public class Historial {
    private Pelicula film;
    private float valoracion; //Numero de estrellas con la que el cliente valoro el film de 1 a 5
    private String fechaArriendo;
    private String fechaEntrega;
    private boolean entregado; //TRUE si la pelicula fue devuelta, False en el caso contrario
    
    public Historial(){
        entregado = true;
    }

    public Pelicula getFilm() {
        return film;
    }

    public void setFilm(Pelicula film) {
        this.film = film;
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
    
}
