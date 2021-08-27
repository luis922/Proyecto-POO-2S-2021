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
        listaPeliculas = new ArrayList();
        listaClientes = new ArrayList();
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

    public Pelicula getListaPeliculas(short index) {//Retorna objeto pelicula
        return listaPeliculas.get(index);
    }

    public void setListaPeliculas(Pelicula peli) {
        listaPeliculas.add(peli);
    }

    public Cliente getListaClientes(int index) {
        return listaClientes.get(index);
    }

    public void setListaClientes( Cliente persona) {
        listaClientes.add(persona);
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