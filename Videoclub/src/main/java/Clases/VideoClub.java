package Clases;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class VideoClub {
    private String nombreTienda;
    private String direccion;
    private ArrayList<Pelicula> listaPeliculas;
    private ArrayList<Cliente> listaClientes;
   // private hashMap películas; /*Mapa Hash que posee la base de datos de películas dentro*/
   // private hashMap clientes; /*Mapa Hash que posee la base de datos de clientes dentro*/
   /*  private int cantidadClientes;
    private int cantidadPeliculas;     Contadores de datos
    private int cantidadExistencias;*/

  
    public VideoClub(){//constructor
       /* listaPeliculas = new ArrayList();
        listaClientes = new ArrayList();*/
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
    2 = Tamaño lista de peliculas*/
    public int getSize(int modo){
        switch(modo){
            case 1: return listaClientes.size();
            case 2: return listaPeliculas.size();
        }
        return 0;
    }
    
   /* 
    public void ordenarPeliculasRank(){
        Función que despliega todas las películas ordenadas desde la mejor
        rankeada hasta la peor  
    }
    public void mostrarPelicula(){
        /*Función que arroja los datos de una película siempre y cuando esta 
        exista en la base de datos (Búsqueda con hashMap)
    }
    private void agregarPelicula(){
        /*Función para agregar películas individualmente a la base de datos
    }
    private void quitarPelicula(){
        /*Función para eliminar una película de la base de datos
    }
    private void editarPelicula(){
        /*Función para editar la información de una película (ideal para
        reducir/aumentar existencias)
    }     
    private void buscarCliente(){
        /*Función para buscar a un cliente en la base de datos(Búsquedas con 
        hashMap
    } */

}
