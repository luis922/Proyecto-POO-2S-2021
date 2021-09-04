package Clases;
/*Instruccion del main:
Solo compilar y ejecutar el main para obtener los datos desde los archivos
y mostrar algunos de estos por pantalla
*/
import java.util.*; //Scanner, Arrays
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception{
		VideoClub videoClub1 = new VideoClub();
        Pelicula pelicula = new Pelicula();
        Cliente cliente = new Cliente();

//------------------------------Lectura de datos desde archivos--------------------------------
        LeerArchivoPeliculas(videoClub1,pelicula);
        LeerArchivoClientes(videoClub1, cliente);
//---------------Imprime ciertos datos almacenados----------------------------------------------
        videoClub1.mostrarDatosClientes();
		videoClub1.mostrarDatosClientes("10693359-1");
		videoClub1.mostrarDatosPeliculas();
		videoClub1.mostrarDatosPeliculas("3");
//----------------------------------------------------------------------------------------------  
       	//Menu arcaico por consola
/*		 Scanner entrada = new Scanner(System.in);
        byte opción;
        do{
            Interfaz.Interface.login();
            opción = entrada.nextByte();
            switch(opción){
                 case 1:
                     String rut = Comprobadores.Comprobar.loginClientes(videoClub1);
                    if (videoClub1.containsRUT(rut)) Interfaz.Interface.menúCliente(rut,videoClub1);
                    break;//Se llama a una función que verifique si el rut a ingresar está en la base de datos
                case 2:
                    Interfaz.Interface.menúAdmin(videoClub1);
                    break;
                default:
                    if(opción != 0) System.out.println("Ingrese una opción válida...");
                    break;
            }
        }while(opción != 0);*/ 
    }
    
    public static void LeerArchivoPeliculas(VideoClub videoClub, Pelicula pelicula) throws FileNotFoundException{
        File flPeliculas = new File("./src/main/java/data/peliculas.tsv");
		Scanner scPel = new Scanner(flPeliculas);
        String linea;
        String[] arrayLineaPeliculas;
        scPel.nextLine();
		while(scPel.hasNextLine()){
			linea = scPel.nextLine();
			arrayLineaPeliculas = linea.split("\t");
			//Guardar Datos en array de Peliculas
			pelicula = new Pelicula();
                        pelicula.setId(arrayLineaPeliculas[0]);
			pelicula.setNombre(arrayLineaPeliculas[1]);
			pelicula.setExistencias(Short.parseShort(arrayLineaPeliculas[2]));
			pelicula.setDisponibles(Short.parseShort(arrayLineaPeliculas[3]));
			pelicula.setValuacion(Float.parseFloat(arrayLineaPeliculas[4]));
			pelicula.setAñoEstreno(Short.parseShort(arrayLineaPeliculas[5]));
			pelicula.setDuraciónMin(Short.parseShort(arrayLineaPeliculas[6]));
			pelicula.setSinopsis(arrayLineaPeliculas[7]);
			pelicula.setCalidad(arrayLineaPeliculas[8]);
			pelicula.setDirector(arrayLineaPeliculas[9].split("_"));
			pelicula.setActores(arrayLineaPeliculas[10].split("_"));
			pelicula.setGeneros(arrayLineaPeliculas[11].split("_"));
			videoClub.addPeliToListaPelis(pelicula);
			videoClub.addPeliToPelisXId(pelicula.getId(),pelicula);
		}
    }
    public static void LeerArchivoClientes(VideoClub videoClub, Cliente cliente)throws FileNotFoundException{
        File flClientes = new File("./src/main/java/data/clientes.tsv");
        Scanner scCli = new Scanner(flClientes);
        String linea;
        String[] arrayLineaClientes;
        scCli.nextLine();
	while(scCli.hasNextLine()){
		linea = scCli.nextLine();
		arrayLineaClientes = linea.split("\t");
		//Guardar Datos en array de Clientes: [0]=noimbre, [1]=rut, [2]=historial, [3]=pelPosesion, [4]=Deuda
		cliente = new Cliente();
		cliente.setNombre(arrayLineaClientes[0]);
		cliente.setRut(arrayLineaClientes[1]);
		/*
		arrayIdHistorial = arrayLineaClientes[2].split("_");
		for(i=0; i<arrayIdHistorial.length; i++){
		    film = videoClub.getPeliFromPelisXId(arrayIdHistorial[i]);
		    historial.setFilm(film.getId());
		    cliente.setHistorial(historial);
		}
		for(i=0; i<arrayIdHistorial.length; i++){
		    System.out.print(arrayIdHistorial[i]+ " ");
		    System.out.println(cliente.getHistorial().get(i).getId());
		}
		System.out.println("");
		*/
		cliente.setDeuda(Integer.parseInt(arrayLineaClientes[4]));
		videoClub.addClientToListaClients(cliente);
		videoClub.addClientToClientXRut(arrayLineaClientes[1], cliente);
		}
    }
}
