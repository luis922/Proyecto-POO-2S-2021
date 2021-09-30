package Clases;
import java.util.ArrayList;
import java.util.HashMap;

public class Cliente{
    private String nombre;
    private String rut;
    private ArrayList<Arriendo> historialArriendos; //Coleccion de objetos 1 anidación.
    private HashMap<String, Arriendo> historialXid;
    private ArrayList<Arriendo> arriendosActuales; //Contiene las peliculas arrendadas actuales
    private HashMap<String, Arriendo> arriendoXid;
    private int deuda;

    public Cliente() {
        this.historialArriendos = new ArrayList();//Agrege esto
        this.historialXid = new HashMap<>();
    }
    
    public Cliente(String nombre, String rut){ //Para el ingreso de un cliente nuevo, no existente en la base de datos.
        this.nombre = nombre;
        this.rut = rut;
        this.deuda = 0;
        this.historialArriendos = new ArrayList();
        arriendosActuales = new ArrayList();
        arriendoXid = new HashMap();
    }
    
    public int getSizeHistorial(){
        return historialArriendos.size();
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

    public Arriendo getArriendoXId(String id){
        return historialXid.get(id);
    }
//------------------AGREGA ELEMENTOS A HISTORIAL------------------
    public void addToHistorialXid(Arriendo arriendo) {
        this.historialXid.put(arriendo.getId(), arriendo);
    }
    
    public void addArriendoToHistorial(Arriendo arriendo) {
        historialArriendos.add(arriendo);
    }

    public void addToArriendosActuales(Arriendo arriendo){
        arriendosActuales.add(arriendo);
    }
//------------------MOSTRAR HISTORIAL------------------
    public void mostrarHistorial(){
        for (int i = 0; i < historialArriendos.size(); i++) {
            System.out.println("ID pelicula: "+historialArriendos.get(i).getId());
            System.out.print("Valoración : ");
            if(!historialArriendos.get(i).isEntregado())
                System.out.println("N0 REGISTRADA");
            else
                System.out.println(historialArriendos.get(i).getValoracion());
            System.out.println("Fecha de arriendo: "+historialArriendos.get(i).getFechaArriendo());
            System.out.println("Fecha de entrega: "+historialArriendos.get(i).getFechaEntrega());
            System.out.print("Estado de entrega: ");
            if(historialArriendos.get(i).isEntregado())
                System.out.println(" ENTREGADO");
            else
                System.out.println(" NO ENTREGADO");
            System.out.println();
        }
    }

    public void mostrarHistorial(String id){
        if(historialXid.containsKey(id)) {
            System.out.println("ID pelicula: "+historialXid.get(id).getId());
            System.out.print("Valoración : ");
            if(!historialXid.get(id).isEntregado())
                System.out.println("N0 REGISTRADA");
            else
                System.out.println(historialXid.get(id).getValoracion());
            System.out.println("Fecha de arriendo: "+historialXid.get(id).getFechaArriendo());
            System.out.println("Fecha de entrega: "+historialXid.get(id).getFechaEntrega());
            System.out.print("Estado de entrega: ");
            if(historialXid.get(id).isEntregado())
                System.out.println(" ENTREGADO");
            else
                System.out.println(" NO ENTREGADO");
        }
        else
            System.out.println("Ingrese una id valida");
    }
    
//------------------COMPRUEBA------------------
    public boolean existIDMap(String id){//Comprueba si la pelicula ya fue arrendada en base al ID otorgado
        return historialXid.containsKey(id);
    }

    public boolean existIDArriendo(String id){
        return arriendoXid.containsKey(id);
    }
}