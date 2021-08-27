package Clases;

import java.util.*; //Scanner, Arrays
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
	
	    VideoClub videoClub1 = new VideoClub();
        Pelicula pelicula ;
        Cliente cliente;
        ArrayList<Pelicula> listaPeliculas = new ArrayList();
        ArrayList<Cliente> listaClientes = new ArrayList();
//------------------------------Lectura de datos desde archivos------------------------------
        String linea;
        int qDatosPeliculas = 11;
        int qDatosClientes = 5;
        
//--------------Peliculas
        String[] arrayLineaPeliculas = new String[qDatosPeliculas];
        File flPeliculas = new File("./src/main/java/data/peliculas.tsv");
	Scanner scPel = new Scanner(flPeliculas);
	while(scPel.hasNextLine()){
	    linea = scPel.nextLine();
	    arrayLineaPeliculas = linea.split("\t");
	    //Guardar Datos en array de Peliculas
	    pelicula = new Pelicula();
	    pelicula.setNombre(arrayLineaPeliculas[0]);
	    pelicula.setExistencias(Short.parseShort(arrayLineaPeliculas[1]));
	    pelicula.setDisponibles(Short.parseShort(arrayLineaPeliculas[2]));
	    pelicula.setValuacion(Float.parseFloat(arrayLineaPeliculas[3]));
	    pelicula.setAñoEstreno(Short.parseShort(arrayLineaPeliculas[4]));
	    pelicula.setDuraciónMin(Short.parseShort(arrayLineaPeliculas[5]));
	    pelicula.setSinopsis(arrayLineaPeliculas[6]);
	    pelicula.setCalidad(arrayLineaPeliculas[7]);
	    pelicula.setDirector(arrayLineaPeliculas[8].split(" "));
	    pelicula.setActores(arrayLineaPeliculas[9].split(" "));
	    pelicula.setGeneros(arrayLineaPeliculas[10].split(" "));
	    listaPeliculas.add(pelicula);
	}
	videoClub1.setListaPeliculas(listaPeliculas);
//---------------Clientes
        String[] arrayLineaClientes = new String[qDatosClientes];
        File flClientes = new File("./src/main/java/data/clientes.tsv");
	Scanner scCli = new Scanner(flClientes);
	while(scCli.hasNextLine()){
	    linea = scCli.nextLine();
	    arrayLineaClientes = linea.split("\t");
	    //Guardar Datos en array de Clientes: [0]=noimbre, [1]=rut, [2]=historial, [3]=pelPosesion, [4]=Deuda
	    cliente = new Cliente();
	    cliente.setNombre(arrayLineaClientes[0]);
	    cliente.setRut(arrayLineaClientes[1]);
	   // cliente.setHistorial(arrayLineaClientes[2].split("_"));
	   // cliente.setPeliculasPosesion(arrayLineaClientes[3].split("_"));
	    cliente.setDeuda(Integer.parseInt(arrayLineaClientes[4]));
	}
	videoClub1.setListaClientes(listaClientes);       
//----------------------------------------------------------------------------------------------  
        Scanner entrada = new Scanner(System.in);
        int opción;
        do{
            Interfaz.Interface.login();
            opción = entrada.nextInt();
            switch(opción){
                 case 1:
                    Comprobadores.Comprobar.loginClientes(videoClub1);//Se llama a una función que verifique si el rut a ingresar está en la base de datos
                case 2:
                    ;
                default:
                    if(opción != 0) System.out.println("Ingrese una opción válida...");
            }
        
            
        }while(opción != 0);
     
    } 
}
