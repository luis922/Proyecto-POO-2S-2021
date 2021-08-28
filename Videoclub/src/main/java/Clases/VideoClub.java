package Clases;
import java.util.ArrayList;

public class VideoClub {
    private String nombreTienda;
    private String direccion;
    private ArrayList<Pelicula> listaPeliculas;//Coleccion de objetos 1 anidación
    private ArrayList<Cliente> listaClientes;  //Coleccion de objetos 2 anidaciones

    public VideoClub(){ //constructor

    }
    
    public void mostrarClientes(){
        int i;
        for(i=0; i<listaClientes.size(); i++){
            System.out.println("Cliente: " + (i+1));
            System.out.println("Nombre: " + listaClientes.get(i).getNombre());
            System.out.println("Rut: " + listaClientes.get(i).getRut());
            System.out.println("Deuda: " + listaClientes.get(i).getDeuda());
            System.out.println();
        }
    }
    
    public void mostrarClientes(String rut){
        int i;
        for(i=0; i<listaClientes.size(); i++){
            System.out.println("Test");
            if(listaClientes.get(i).getRut().equals(rut)){
                System.out.println("Datos cliente de rut " + rut);
                System.out.println("Nombre: " + listaClientes.get(i).getNombre());
                System.out.println("Deuda: " + listaClientes.get(i).getDeuda());
                return;
            }
        }
    }
    
    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return new ArrayList(listaPeliculas);
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPelis) {
        listaPeliculas = new ArrayList(listaPelis);
    }

    public ArrayList<Cliente> getListaClientes() {
        return new ArrayList(listaClientes);
    }

    public void setListaClientes( ArrayList<Cliente> listaClientes) {
        this.listaClientes = new ArrayList(listaClientes);
    }
    
    /*Función para obtener tamaños de los Arrays
    "listaClientes" y "listaPeliculas"
    
    Sus modos son:
    1 = Tamaño lista de clientes
    2 = Tamaño lista de pelicula
    public int getSize(int modo){
        switch(modo){
            case 1: return listaClientes.size();
            case 2: return listaPeliculas.size();
        }
        return 0;
    }*/
}
