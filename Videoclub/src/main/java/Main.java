/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*; //Scanner, Arrays
import java.io.*;
/**
 *
 * @author sebas
 */
public class Main {
    public static void main(String[] args) throws Exception{
	VideoClub videoClub1 = new VideoClub();
        Pelicula pelicula;
        Cliente cliente;
        private ArrayList<Pelicula> listaPeliculas;
        private ArrayList<Cliente> listaClientes;
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
	    pelicula.setExistencia(arrayLineaPeliculas[1]);
	    pelicula.setDisponilbes(arrayLineaPeliculas[2]);
	    pelicula.setValuacion(arrayLineaPeliculas[3]);
	    pelicula.setAñoEstreno(arrayLineaPeliculas[4]);
	    pelicula.setDuracionMin(arrayLineaPeliculas[5]);
	    pelicula.setSinopsis(arrayLineaPeliculas[6]);
	    pelicula.setCalidad(arrayLineaPeliculas[7]);
	    pelicula.setDirector(arrayLineaPeliculas[8].split('_'));
	    pelicula.setActores(arrayLineaPeliculas[9].split('_'));
	    pelicula.setGeneros(arrayLineaPeliculas[10].split('_'));
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
	    cliente.setrut(arrayLineaClientes[1]);
	    cliente.setHistorial(arrayLineaClientes[2].split("_"));
	    cliente.setPeliculasPosesion(arrayLineaClientes[3].split("_"));
	    cliente.setDeuda(arrayLineaClientes[4]);
	}
	videoClub1.setListaCliente(listaClientes);       
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
