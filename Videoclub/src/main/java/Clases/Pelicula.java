package Clases;
package com.mycompany.videoclub;

/**
 *
 * @author HP
 */
public class Pelicula {
     
    private String nombre;
    public short id;
    public short existencias; //Numero total de peliculas de la que es dueña la tienda
    public short disponibles; //Numero de peliculas disponibles para arrendar
    public float valuacion;   //Valoracion de la pelicula de 1 a 5
    public short cantValuaciones; //Numero perosnas que han valorado la pelicula
    private short añoEstreno;
    private short duraciónMin;

    private String sinopsis;   //Breve sinopsis de la pelicula
    private String calidad;    //Almacena la calidad de la pelicula 
    private String director[]; //Arreglo que contiene los nombres de los directores(Compacto sin plibre)
    private String actores[];  //Arreglo que contiene los nombres de los actores(Compacto sin plibre)
    private String generos[];  //Arreglo que contiene los nombres de los generos(Compacto sin plibre)
    
    public Pelicula(){
        director = new String[5];
        actores = new String[5];
        generos = new String[5];
    }       

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
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

    public String getDirector(int index) {
        int i;
        for(i = 0; i< director.length ;i++){
            if(i == index){
                return director[i];
            }
        }        
        return "Indice fuera de rango";
    }    

    public void setDirector(String nombreDirector) {
        int i;
        for(i = 0; i< director.length ;i++){
            if(director[i] == null){
                director[i] = nombreDirector;
                return;
            }
        }
        if(i == director.length)
            System.out.println("No hay más espacio en arreglo \"director\"");
    }

    public String getActores(int index) {
        int i;
        for(i = 0; i< actores.length ;i++){
            if(i == index){
                return actores[i];
            }
        }        
        return "Indice fuera de rango";
    }

    public void setActores(String actor) {
        int i;
        for(i = 0; i< actores.length ;i++){
            if(actores[i] == null){
              actores[i] = actor;
              return;
            }                
        }
        if(i == actores.length)
            System.out.println("No hay más espacio en arreglo \"actores\"");
    }

    public String getGeneros(int index) {
        int i;
        for(i = 0; i< generos.length ;i++){
            if(i == index){
                return generos[i];
            }
        }        
        return "Indice fuera de rango";
    }

    public void setGeneros(String genero) {
        int i;
        for(i = 0; i< generos.length ;i++){
            if(generos[i] == null){
                generos[i] = genero;
              return;
            }                
        }
        if(i == generos.length)
            System.out.println("No hay más espacio en arreglo \"generos\"");
    }         
}
