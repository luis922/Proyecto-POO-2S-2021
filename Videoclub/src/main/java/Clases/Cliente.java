package Clases;
import java.util.ArrayList;

public class Cliente{
    private String nombre;
    private String rut;
    private ArrayList<Historial> historial; //Coleccion de objetos 1 anidación.
    private int deuda;

    public Cliente() {
        deuda = 0;
    }
    
    public Cliente(String nombre, String rut){ //Para el ingreso de un cliente nuevo, no existente en la base de datos.
        this.nombre = nombre;
        this.rut = rut;
        this.deuda = 0;
        this.historial = new ArrayList();
    }

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

    public void setHistorial(ArrayList<Historial> historial) {
        this.historial = new ArrayList(historial);
    }

    public ArrayList<Historial> getHistorial() {
        return new ArrayList(historial);
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }
    
}
