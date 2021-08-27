package Clases;
import java.util.ArrayList;

public class Cliente{
    private String nombre;
    private String rut;
    private ArrayList<Historial> historial;
    int deuda;

    public Cliente() {
        deuda = 0;
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
        this.historial = historial;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }
    
}
