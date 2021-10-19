package Clases;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Persona {
    protected String nombre;
    protected String rut;
    protected int deuda;
    protected ArrayList<Arriendo> arriendosActuales; //Contiene las películas arrendadas actuales
    protected HashMap<String, Arriendo> arriendoXid;

    public Persona(){
        arriendosActuales = new ArrayList<>();
        arriendoXid = new HashMap<>();
    }
    public Persona(String nombre, String rut){
        this.nombre = nombre;
        this.rut = rut;
        deuda = 0;
        arriendosActuales = new ArrayList<>();
        arriendoXid = new HashMap<>();
    }
//------------------SETTER/GETTER------------------

    public String getNombre() {
    return nombre;
}

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    //Objeto arriendo dado un id
    public Arriendo getArriendoXId(String id){
        return arriendoXid.get(id);
    }

    //Objeto arriendo dado un indice
    public Arriendo getArriendo(int i){
        return arriendosActuales.get(i);
    }

//------------------AGREGA ELEMENTOS --------------------------

    public void addToArriendosActuales(Arriendo arriendo){
        arriendosActuales.add(arriendo);
    }

    public void addToArriendosXid(Arriendo arriendo){
        arriendoXid.put(arriendo.getId(),arriendo);
    }

//------------------COMPRUEBA----------------------------------

    public boolean isEmptyArriendos(){
        return arriendosActuales.isEmpty();
    }

    public boolean existIDArriendo(String id){
        return arriendoXid.containsKey(id);
    }

//-----------------ABSTRACTO------------------------------------

    public abstract void identificacion();

}
