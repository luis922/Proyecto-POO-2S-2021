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
        Pelicula pelicula;
        Cliente cliente;
        ArrayList<Pelicula> listaPeliculas = new ArrayList();
        ArrayList<Cliente> listaClientes = new ArrayList();
        HashMap<String,Pelicula> pelisXId = new HashMap<String,Pelicula>();
//------------------------------Lectura de datos desde archivos------------------------------
        String linea;
        //int qDatosPeliculas = 11;
        //int qDatosClientes = 5;
        
//--------------Peliculas
        String[] arrayLineaPeliculas;
        File flPeliculas = new File("./src/main/java/data/peliculas.tsv");
	Scanner scPel = new Scanner(flPeliculas);
        scPel.nextLine();
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
	    pelicula.setDirector(arrayLineaPeliculas[8].split("_"));
	    pelicula.setActores(arrayLineaPeliculas[9].split("_"));
	    pelicula.setGeneros(arrayLineaPeliculas[10].split("_"));
	    listaPeliculas.add(pelicula);
	    pelisXId.put(pelicula.getId(),pelicula);
	}
	videoClub1.setListaPeliculas(listaPeliculas);
	videoClub1.setPelisXId(pelisXId); //Se asigna el hashmao de peliculas por ide al video club

//---------------Clientes
        String[] arrayLineaClientes;
        File flClientes = new File("./src/main/java/data/clientes.tsv");
	Scanner scCli = new Scanner(flClientes);
        scCli.nextLine();
	while(scCli.hasNextLine()){
	    linea = scCli.nextLine();
	    arrayLineaClientes = linea.split("\t");
	    //Guardar Datos en array de Clientes: [0]=noimbre, [1]=rut, [2]=historial, [3]=pelPosesion, [4]=Deuda
	    cliente = new Cliente();
	    cliente.setNombre(arrayLineaClientes[0]);
	    cliente.setRut(arrayLineaClientes[1]);
	    cliente.setDeuda(Integer.parseInt(arrayLineaClientes[4]));
            listaClientes.add(cliente);
	}
	videoClub1.setListaClientes(listaClientes);

        //Imprime ciertos datos almacenados
        videoClub1.mostrarDatosClientes();
	videoClub1.mostrarDatosClientes("10693359-1");
	videoClub1.mostrarDatosPeliculas();
	videoClub1.mostrarDatosPeliculas(3);
//----------------------------------------------------------------------------------------------  
       	//Menu arcaico por consola
		/* Scanner entrada = new Scanner(System.in);
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
        
            
        }while(opción != 0); */
    } 
}
