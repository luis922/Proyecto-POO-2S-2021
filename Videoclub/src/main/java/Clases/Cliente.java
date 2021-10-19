package Clases;
import java.util.ArrayList;
import java.util.HashMap;

public class Cliente extends Persona{
    private ArrayList<Arriendo> historialArriendos; //Coleccion de objetos 1 anidación.
    private HashMap<String, Arriendo> historialXid;
    //Podria aplicarse un descuento al primer arriendo

    public Cliente() {
        super();
        historialArriendos = new ArrayList<>();
        historialXid = new HashMap<>();
    }
    
    public Cliente(String nombre, String rut){ //Para el ingreso de un cliente nuevo, no existente en la base de datos.
        super(nombre, rut);
        historialArriendos = new ArrayList<>();
        historialXid = new HashMap<>();
    }
    
//------------------SETTER/GETTER---------------------------------

    public Arriendo getHistorialXId(String id){
        return historialXid.get(id);
    }

//------------------AGREGA ELEMENTOS A HISTORIAL------------------
    public void addToHistorialXid(Arriendo arriendo) {
        this.historialXid.put(arriendo.getId(), arriendo);
    }
    
    public void addToHistorial(Arriendo arriendo) {
        historialArriendos.add(arriendo);
    }

//------------------MOSTRAR HISTORIAL------------------

    //Muestra todas las películas arrendadas y sus datos
    public void mostrarHistorial(VideoClub tienda){
        for (int i = 0; i < historialArriendos.size(); i++) {
            System.out.println("Nombre película: "+ tienda.getPeliFromPelisXId(historialArriendos.get(i).getId()).getNombre());
            System.out.println("ID película: "+historialArriendos.get(i).getId());
            System.out.print("Valoración : ");
            if(!historialArriendos.get(i).isEntregado())
                System.out.println("N0 REGISTRADA");
            else
                System.out.println(historialArriendos.get(i).getValoracion());
            System.out.println("Fecha de arriendo: "+historialArriendos.get(i).getFechaArriendo());
            System.out.println("Fecha de entrega: "+historialArriendos.get(i).getFechaEntrega());
            System.out.println("Veces arrendada: "+historialArriendos.get(i).getVecesArrendada());
            System.out.print("Estado de entrega: ");
            if(historialArriendos.get(i).isEntregado())
                System.out.println(" ENTREGADO");
            else
                System.out.println(" NO ENTREGADO");
            System.out.println();
        }
    }

    //Muestra el historial de arriendo de una película
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

    public boolean existIDHistorial(String id){//Comprueba si la pelicula ya fue arrendada en base al ID otorgado
        return historialXid.containsKey(id);
    }

//--------------Eliminar----------------------
    public void delArriendo(String id){
        arriendoXid.remove(id);
        for(int i = 0; i< arriendosActuales.size(); i++){
            if(arriendosActuales.get(i).getId().equals(id)) {
                arriendosActuales.remove(i);
                return;
            }
        }
    }

    public Arriendo delArriendo2(String id){
        Arriendo eliminado;
        arriendoXid.remove(id);
        for(int i = 0; i< arriendosActuales.size(); i++){
            if(arriendosActuales.get(i).getId().equals(id)) {
                eliminado = arriendosActuales.get(i);
                arriendosActuales.remove(i);
                return eliminado;
            }
        }
        return null;
    }

//-------------------IMPLEMENTACION METODO ABSTRACTO---------------------------
    @Override
    public void identificacion() {
        System.out.print("Nombre: "+nombre+" Rut: "+rut+" Tipo Cliente: ");
        if (arriendosActuales.isEmpty() && historialArriendos.isEmpty())
            System.out.println("NUEVO");
        else
            System.out.println("ANTIGUO");
    }

//-----------------Otros-----------------------
    public int getSize(int modo){
        switch(modo){
            case 1: return historialArriendos.size();
            case 2: return arriendosActuales.size();
        }
        return 0;
    }

    public int contarGeneroEnHistorial(VideoClub tienda,String genero){
        //cuenta cuantas veces se ha visto una pelicula que contenga la categoria ingresada, esta puede ser la categoría principal o no
        int contador = 0;
        for (int i = 0; i <historialArriendos.size() ; i++) {
           if(tienda.containsGenero(historialArriendos.get(i).getId(),genero))
               contador += historialArriendos.get(i).getVecesArrendada();
        }
        return contador;
    }

    public String generoMasVisto(VideoClub tienda){
        String genero = null, generoPrincipal;
        int vecesVista = 0;
        for (int i = 0; i <historialArriendos.size() ; i++) {
            generoPrincipal = tienda.getPeliFromPelisXId(historialArriendos.get(i).getId()).getGeneros()[0];
            if (genero == null || contarGeneroEnHistorial(tienda,generoPrincipal) > vecesVista){
                genero = generoPrincipal;
                vecesVista = contarGeneroEnHistorial(tienda,generoPrincipal);
            }
        }
        return genero;
    }

}