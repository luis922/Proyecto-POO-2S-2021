package Clases;
import java.util.*;
import java.io.*;

public class VideoClub {
    private String nombreTienda;
    private String direccion;
    private ArrayList<Pelicula> listaPeliculas;//Coleccion de objetos 1 anidación
    private ArrayList<Cliente> listaClientes;  //Coleccion de objetos 2 anidaciones

    private HashMap<String,Pelicula> pelisXId;   //Key es ID pelicula
    private HashMap<String,Cliente> clientesXRut;//Key es Rut cliente
    private HashMap<String, Trabajador> trabajadoresXRut;

    public VideoClub(){ //constructor
        listaPeliculas = new ArrayList<>();
        listaClientes = new ArrayList<>();
        pelisXId = new HashMap<>();
        clientesXRut = new HashMap<>();
        trabajadoresXRut = new HashMap<>();
    }
//------------------SETTER/GETTER------------------
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
    
//------------------MOSTRAR DATOS POR PANTALLA------------------
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
    //ASDADFASDFGASDGFASFASDFASDFSADFASDFA SDFAS DFSAD FASDF ASDF ASDF ASDF ASDF ASDFASDF ASDF ASDF ASDFSAD F
    public void mostrarDatosTrabajadores(String rut){
        System.out.println("Datos del trabajador rut " + rut);
        System.out.println("Nombre: " + trabajadoresXRut.get(rut).getNombre());
        System.out.println("Deuda: " + trabajadoresXRut.get(rut).getDeuda());
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
            System.out.print("Generos: ");
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
            System.out.println("Copias disponibles: "+listaPeliculas.get(i).getDisponibles());
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
        System.out.print("Generos: ");
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
        System.out.println("Copias disponibles: "+pelisXId.get(id).getDisponibles());
        System.out.println();
    }
    
//------------------AGREGAR ELEMENTOS A ARRAYLIST/HASHMAP------------------
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
    public void addTrabajadorToTrabajadoresXRut(String id, Trabajador trabajador){
        trabajadoresXRut.put(id, trabajador);
    }
    
//------------------OBTENER ELEMENTOS DE ARRAYLIST/HASHMAP------------------
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
    public boolean containsRutTrabajadores(String rut){
        return trabajadoresXRut.containsKey(rut);
    }
    public Trabajador getTrabajadorFromTrabajadoresXRut(String id){
        return trabajadoresXRut.get(id);
    }
    
//------------------COMPROBADORES DE REGISTRO------------------
    public boolean existID(String id){//Comprueba si la pelicula esta ya guardada en base al ID otorgado
        return pelisXId.containsKey(id);
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
//------------------Eliminadores------------------
    public void delPelicula(String id){
        pelisXId.remove(id) ;
        for(int i = 0;i < listaPeliculas.size();i++){
            if (listaPeliculas.get(i).getId().equals(id)) {
                listaPeliculas.remove(i);
                return;
            }
        }
    }
    
    public void delCliente (String rut){
        clientesXRut.remove(rut);
        for(int i = 0;i < listaClientes.size();i++){
            if(listaClientes.get(i).getRut().equals(rut)){
                listaClientes.remove(i);
                return;
            }
        }
    }
//---------------------------CLASIFICACION DE OBJETOS--------------------------------
    public String peliMejorEvaluada(){
        //retorna el nombre de la pelicula mejor evaluada, si todas tienen la misma valoracion se retorna la que primero se encuentra
        String idPeli = null;
        float valoracion = 0;
        for(int i =0;i<listaPeliculas.size();i++){
            if(idPeli == null || listaPeliculas.get(i).getValuacion() > valoracion){
                idPeli = listaPeliculas.get(i).getId();
                valoracion = listaPeliculas.get(i).getValuacion();
            }
        }
        return idPeli;
    }
    public String peliMejorEvaluada(String genero){
        //retorna el nombre de la pelicula mejor evaluada POR GENERO, si todas tienen la misma valoracion se retorna la que primero se encuentra
        String idPeli = null;
        float valoracion = 0;
        for(int i =0;i<listaPeliculas.size();i++){
            if( (idPeli == null || listaPeliculas.get(i).getValuacion() > valoracion) && containsGenero(listaPeliculas.get(i).getId(),genero)){
                idPeli = listaPeliculas.get(i).getId();
                valoracion = listaPeliculas.get(i).getValuacion();
            }
        }
        return idPeli;
    }

   /* public String peliMejorEvaluada(String genero,ArrayList<String> ids, float valoracion){
        //retorna el nombre de la pelicula mejor evaluada, si todas tienen la misma valoracion se retorna la que primero se encuentra
        String peli = null;
        for(int i =0;i<listaPeliculas.size();i++){
            if( (peli == null || listaPeliculas.get(i).getValuacion() > valoracion) && containsGenero(listaPeliculas.get(i).getId(),genero)){
                if(!ids.contains(listaPeliculas.get(i).getId())){//Si no se ha arrendado
                    peli = listaPeliculas.get(i).getNombre();
                    valoracion = listaPeliculas.get(i).getValuacion();
                }
            }
        }
        return peli;
    }*/

//---------------OTROS----------------------------------------------
    public boolean containsGenero (String id, String genero){
        for (int i = 0; i < pelisXId.get(id).getGeneros().length; i++) {            
            if(pelisXId.get(id).getGeneros()[i].equals(genero))
                return true;
        }
        return false;
    }
 //----------------------ESCRITURA DE ARCHIVOS-----------------------
    public void escribirArchivoDeudores(){
        int cantDeudores = 0;
        long deudaTotal = 0;
        try{
            FileWriter file = new FileWriter("./Reportes/deudores.csv"); //Agregar direccion
            for(Cliente c: listaClientes){
                if(c.getDeuda()>0){
                    cantDeudores++;
                    deudaTotal += c.getDeuda();
                }
            }
            if(cantDeudores > 0){
                file.write("Cantidad de deudores: " + cantDeudores + "   Monto total de la deuda: " + deudaTotal + "\n\n");
                file.write("Detalle de los deudores: \n");
                for(Cliente c: listaClientes){
                    if(c.getDeuda() > 0){ //Verifica que contenga deuda para agregarlo al archivo
                        file.write("Nombre: " + c.getNombre() + "   rut: " + c.getRut() + "   Deuda: " + c.getDeuda() + "\n"); //Formato de escritura
                    }
                }
            }
            else{
                System.out.println("No existen deudores.");
                file.write("No existen deudores");
            }
            file.close();
            System.out.println("Archivo escrito correctamente");
        }
        catch(IOException e){
            System.out.println("Error al escribir");
            e.printStackTrace();
        }
    }
    public void escribirArchivoArriendosActuales(){
        try{
            FileWriter file = new FileWriter("./Reportes/peliculasEnArriendo.csv");//Agregar direccion
            String peliculas;
            int i;
            for(Cliente c: listaClientes){
                if(!c.isEmptyArriendos()){
                    peliculas = "";
                    for(i=0; i<c.getSize(2); i++){
                        if (i==0)
                            peliculas += pelisXId.get(c.getArriendo(i).getId()).getNombre();
                        else
                            peliculas += ", " + pelisXId.get(c.getArriendo(i).getId()).getNombre();//Formato de escritura de peliculas
                    }
                    file.write("Cliente: " +  c.getNombre() + "   rut: " + c.getRut() + "   lista de peliculas arrendadas: " + peliculas + "\n");//Formato de escritura
                }
            }
            file.close();
            System.out.println("Archivo escrito correctamente");
        }
        catch(IOException e){
            System.out.println("Error al escribir");
            e.printStackTrace();
        }
    }
}