package Clases;
import java.util.*;

public class VideoClub {
    private String nombreTienda;
    private String direccion;
    private ArrayList<Pelicula> listaPeliculas;//Coleccion de objetos 1 anidación
    private ArrayList<Cliente> listaClientes;  //Coleccion de objetos 2 anidaciones

    private HashMap<String,Pelicula> pelisXId;       //Key es ID pelicula
    private HashMap<String, Cliente> clientesXRut; //Key es Rut cliente

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
            System.out.println("Nombre pelicula N°"+(i+1)+": "+listaPeliculas.get(i).getNombre());
            System.out.println("Año de estreno: "+listaPeliculas.get(i).getAñoEstreno());
            System.out.println("Duración: "+listaPeliculas.get(i).getDuraciónMin()+" minutos");
            System.out.println("Calidad: "+listaPeliculas.get(i).getCalidad());
            System.out.println("Puntuación: "+listaPeliculas.get(i).getValuacion()+ " de 5");
            System.out.println("Sinopsis: "+listaPeliculas.get(i).getSinopsis());
            System.out.print("Director(s): ");

            for(j=0; j<listaPeliculas.get(i).getDirector().length;j++ ) {
                if (j == (listaPeliculas.get(i).getDirector().length - 1))
                    System.out.println(listaPeliculas.get(i).getDirector()[j]);
                else
                    System.out.print(listaPeliculas.get(i).getDirector()[j] + ", ");
            }

            for(j=0; j<listaPeliculas.get(i).getGeneros().length;j++ ) {
                if (j == (listaPeliculas.get(i).getGeneros().length - 1))
                    System.out.println(listaPeliculas.get(i).getGeneros()[j]);
                else
                    System.out.print(listaPeliculas.get(i).getGeneros()[j] + ", ");
            }
            System.out.print("Actores: ");
            for (j = 0; j <listaPeliculas.get(i).getActores().length ; j++) {
                if(j==(listaPeliculas.get(i).getActores().length -1 ))
                    System.out.println(listaPeliculas.get(i).getActores()[j]);
                else
                    System.out.print(listaPeliculas.get(i).getActores()[j]+", ");
            }
            System.out.println();
        }
    }

    public void mostrarDatosPeliculas(int index){
        int j;
        System.out.println("Nombre: "+listaPeliculas.get(index).getNombre());
        System.out.println("Año de estreno: "+listaPeliculas.get(index).getAñoEstreno());
        System.out.println("Duración: "+listaPeliculas.get(index).getDuraciónMin()+" minutos");
        System.out.println("Calidad: "+listaPeliculas.get(index).getCalidad());
        System.out.println("Puntuación: "+listaPeliculas.get(index).getValuacion()+ " de 5");
        System.out.println("Sinopsis: "+listaPeliculas.get(index).getSinopsis());
        System.out.print("Director(s): ");

        for(j=0; j<listaPeliculas.get(index).getDirector().length;j++ ) {
            if (j == (listaPeliculas.get(index).getDirector().length - 1))
                System.out.println(listaPeliculas.get(index).getDirector()[j]);
            else
                System.out.print(listaPeliculas.get(index).getDirector()[j] + ", ");
        }

        for(j=0; j<listaPeliculas.get(index).getGeneros().length;j++ ) {
            if (j == (listaPeliculas.get(index).getGeneros().length - 1))
                System.out.println(listaPeliculas.get(index).getGeneros()[j]);
            else
                System.out.print(listaPeliculas.get(index).getGeneros()[j] + ", ");
        }
        System.out.print("Actores: ");
        for (j = 0; j <listaPeliculas.get(index).getActores().length ; j++) {
            if(j==(listaPeliculas.get(index).getActores().length -1 ))
                System.out.println(listaPeliculas.get(index).getActores()[j]);
            else
                System.out.print(listaPeliculas.get(index).getActores()[j]+", ");
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
        listaPeliculas.add(peli);
    }

    public void addClientToListaClients( Cliente cliente) {
        listaClientes.add(cliente);
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
