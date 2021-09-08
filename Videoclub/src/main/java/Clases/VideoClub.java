package Clases;
import java.util.*;

public class VideoClub {
    private String nombreTienda;
    private String direccion;
    private ArrayList<Pelicula> listaPeliculas;//Coleccion de objetos 1 anidación
    private ArrayList<Cliente> listaClientes;  //Coleccion de objetos 2 anidaciones

    private HashMap<String,Pelicula> pelisXId;       //Key es ID pelicula
    private HashMap<String,Cliente> clientesXRut; //Key es Rut cliente

    public VideoClub(){ //constructor
        listaPeliculas = new ArrayList<>();
        listaClientes = new ArrayList<>();
        pelisXId = new HashMap<>();
        clientesXRut = new HashMap<>();
    }
    
    public void mostrarDatosClientes(){
        int i;
        String rut;
        for(i=0; i<listaClientes.size(); i++){
            rut = listaClientes.get(i).getRut();
            System.out.println("Cliente: " + (i+1));
            System.out.println("Nombre: " + clientesXRut.get(rut).getNombre());
            System.out.println("Rut: " + rut);
            System.out.println("Deuda: " + clientesXRut.get(rut).getDeuda());
            System.out.println();
        }
    }
    
    public void mostrarDatosClientes(String rut){
        System.out.println("Datos del cliente rut " + rut);
        System.out.println("Nombre: " + clientesXRut.get(rut).getNombre());
        System.out.println("Deuda: " + clientesXRut.get(rut).getDeuda());
        System.out.println();
    }
    
    public void mostrarDatosPeliculas(){
        int i,j;
        for (i=0; i<listaPeliculas.size(); i++){
            String id = listaPeliculas.get(i).getId();
            System.out.println("Nombre pelicula N°"+(i+1)+": "+pelisXId.get(id).getNombre());
            System.out.println("Id: " + id);
            System.out.println("Año de estreno: "+pelisXId.get(id).getAñoEstreno());
            System.out.println("Duración: "+pelisXId.get(id).getDuraciónMin()+" minutos");
            System.out.println("Calidad: "+pelisXId.get(id).getCalidad());
            System.out.println("Puntuación: "+pelisXId.get(id).getValuacion()+ " de 5");
            System.out.println("Sinopsis: "+pelisXId.get(id).getSinopsis());
            System.out.print("Director(s): ");

            for(j=0; j<pelisXId.get(id).getDirector().length;j++ ) {
                if (j == (pelisXId.get(id).getDirector().length - 1))
                    System.out.println(pelisXId.get(id).getDirector()[j]);
                else
                    System.out.print(pelisXId.get(id).getDirector()[j] + ", ");
            }

            for(j=0; j<pelisXId.get(id).getGeneros().length;j++ ) {
                if (j == (pelisXId.get(id).getGeneros().length - 1))
                    System.out.println(pelisXId.get(id).getGeneros()[j]);
                else
                    System.out.print(pelisXId.get(id).getGeneros()[j] + ", ");
            }
            System.out.print("Actores: ");
            for (j = 0; j <pelisXId.get(id).getActores().length ; j++) {
                if(j==(pelisXId.get(id).getActores().length -1 ))
                    System.out.println(pelisXId.get(id).getActores()[j]);
                else
                    System.out.print(pelisXId.get(id).getActores()[j]+", ");
            }
            System.out.println();
        }
    }

    public void mostrarDatosPeliculas(String id){
        int j;
        System.out.println("Nombre: "+pelisXId.get(id).getNombre());
        System.out.println("Id: " + id);
        System.out.println("Año de estreno: "+pelisXId.get(id).getAñoEstreno());
        System.out.println("Duración: "+pelisXId.get(id).getDuraciónMin()+" minutos");
        System.out.println("Calidad: "+pelisXId.get(id).getCalidad());
        System.out.println("Puntuación: "+pelisXId.get(id).getValuacion()+ " de 5");
        System.out.println("Sinopsis: "+pelisXId.get(id).getSinopsis());
        System.out.print("Director(s): ");

        for(j=0; j<pelisXId.get(id).getDirector().length;j++ ) {
            if (j == (pelisXId.get(id).getDirector().length - 1))
                System.out.println(pelisXId.get(id).getDirector()[j]);
            else
                System.out.print(pelisXId.get(id).getDirector()[j] + ", ");
        }

        for(j=0; j<pelisXId.get(id).getGeneros().length;j++ ) {
            if (j == (pelisXId.get(id).getGeneros().length - 1))
                System.out.println(pelisXId.get(id).getGeneros()[j]);
            else
                System.out.print(pelisXId.get(id).getGeneros()[j] + ", ");
        }
        System.out.print("Actores: ");
        for (j = 0; j <pelisXId.get(id).getActores().length ; j++) {
            if(j==(pelisXId.get(id).getActores().length -1 ))
                System.out.println(pelisXId.get(id).getActores()[j]);
            else
                System.out.print(pelisXId.get(id).getActores()[j]+", ");
        }
        System.out.println();
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

    public void addPeliToListaPelis(Pelicula peli) {
        if(!listaPeliculas.contains(peli))
            listaPeliculas.add(peli);
        else
            System.out.println("La pelicula \""+peli.getNombre()+ "\" ya esta almacenada");
    }

    public void addClientToListaClients( Cliente cliente) {
        if(!listaClientes.contains(cliente))
            listaClientes.add(cliente);
        else
            System.out.println("El cliente de rut "+cliente.getRut()+" ya esta almacenado");
    }
    
    public void addClientToClientXRut(String rut, Cliente cliente){
        clientesXRut.put(rut,cliente);
    }

    public void addPeliToPelisXId(String id, Pelicula peli) {
        pelisXId.put(id,peli);
    }

    public Cliente getClientFromClientXRut(String rut){
        return clientesXRut.get(rut);
    }

    public Pelicula getPeliFromPelisXId(String id) {
        return pelisXId.get(id);
    }

    public boolean containsID(String id){
        return pelisXId.containsKey(id);
    }

    public boolean containsRUT(String rut){
        return clientesXRut.containsKey(rut);
    }
    
    public String obtenerIdXNombre(String nombre){
        for (int j = 0; j < listaPeliculas.size() ; j++)
            if(listaPeliculas.get(j).getNombre().equals(nombre))
                return listaPeliculas.get(j).getId();
        return null;
    }

    public boolean existID(String id){//Comprueba si la pelicula esta ya guardada en base al ID otorgado
        return pelisXId.containsKey(id)
    }

    public boolean existRUT(String rut){//Comprueba si el cliente esta ya guardada en base al RUT otorgado
        return clientesXRut.containsKey(rut);
    }
    
    /*Función para obtener tamaños de los Arrays
    "listaClientes" y "listaPeliculas"
    
    Sus modos son:
    1 = Tamaño lista de clientes
    2 = Tamaño lista de pelicula*/
    public int getSize(int modo){
        switch(modo){
            case 1: return listaClientes.size();
            case 2: return listaPeliculas.size();
        }
        return 0;
    }
}
