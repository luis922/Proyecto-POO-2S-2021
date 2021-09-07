package Clases;
import java.util.ArrayList;

public class Cliente{
    private String nombre;
    private String rut;
    private ArrayList<Historial> listaArriendo; //Coleccion de objetos 1 anidación.
    private int deuda;

    public Cliente() {
    }
    
    public Cliente(String nombre, String rut){ //Para el ingreso de un cliente nuevo, no existente en la base de datos.
        this.nombre = nombre;
        this.rut = rut;
        this.deuda = 0;
        this.listaArriendo = new ArrayList();
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

    public void addArriendoToHistorial(Historial arriendo) {
        listaArriendo.add(arriendo);
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }

    public void mostrarHistorial(){
        for (int i = 0; i < listaArriendo.size(); i++) {
            System.out.println("ID pelicula: "+listaArriendo.get(i).getId());
            System.out.print("Valoración : ");
            if(!listaArriendo.get(i).isEntregado())
                System.out.println("N0 REGISTRADA");
            else
                System.out.println(listaArriendo.get(i).getValoracion());
            System.out.println("Fecha de arriendo: "+listaArriendo.get(i).getFechaArriendo());
            System.out.println("Fecha de entrega: "+listaArriendo.get(i).getFechaEntrega());
            System.out.print("Estado de entrega: ");
            if(listaArriendo.get(i).isEntregado())
                System.out.println(" ENTREGADO");
            else
                System.out.println(" NO ENTREGADO");
        }
    }
    
}
