package Clases;

import java.util.Arrays;

public class Pelicula {
     
    private String nombre;
    private String id;
    private short existencias; //Numero total de peliculas de la que es dueña la tienda
    private short disponibles; //Numero de peliculas disponibles para arrendar
    private float valuacion;   //Valoracion de la pelicula de 0 a 5 estrellas
    private short cantValuaciones; //Numero perosnas que han valorado la pelicula
    private short añoEstreno;
    private short duraciónMin;

    private String sinopsis;   //Breve sinopsis de la pelicula
    private String calidad;    //Almacena la calidad de la pelicula 
    private String director[]; //Arreglo que contiene los nombres de los directores(Compacto sin plibre)
    private String actores[];  //Arreglo que contiene los nombres de los actores(Compacto sin plibre)
    private String generos[];  //Arreglo que contiene los nombres de los generos(Compacto sin plibre)
    
    public Pelicula(){}       

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public short getExistencias() {
        return existencias;
    }

    public void setExistencias(short existencias) {
        this.existencias = existencias;
    }

    public short getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(short disponibles) {
        this.disponibles = disponibles;
    }

    public float getValuacion() {
        return valuacion;
    }

    public void setValuacion(float valuacion) {
        this.valuacion = valuacion;
    }

    public short getCantValuaciones() {
        return cantValuaciones;
    }

    public void setCantValuaciones(short cantValuaciones) {
        this.cantValuaciones = cantValuaciones;
    }

    public short getAñoEstreno() {
        return añoEstreno;
    }

    public void setAñoEstreno(short añoEstreno) {
        this.añoEstreno = añoEstreno;
    }

    public short getDuraciónMin() {
        return duraciónMin;
    }

    public void setDuraciónMin(short duraciónMin) {
        this.duraciónMin = duraciónMin;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String[] getDirector() {
        return Arrays.copyOf(director,director.length);
    }    

    public void setDirector(String[] directores) {
        director = Arrays.copyOf(directores,directores.length);
    }

    public String[] getActores() {
        return Arrays.copyOf(actores,actores.length);
    }

    public void setActores(String[] actor) {
        actores = Arrays.copyOf(actor,actor.length);
    }

    public String[] getGeneros() {
        return Arrays.copyOf(generos,generos.length);
    }

    public void setGeneros(String[] genero) {
        generos = Arrays.copyOf(genero,genero.length);
    }         
}
