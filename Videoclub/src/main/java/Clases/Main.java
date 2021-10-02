package Clases;
/*Instruccion del main:
Solo compilar y ejecutar el main para obtener los datos desde los archivos
y acceder a funcionalidades del menu
*/

import Menú.*;

public class Main {
    public static void main(String[] args) throws Exception{
	    VideoClub videoClub1 = new VideoClub();
        Pelicula pelicula = new Pelicula();
        Cliente cliente = new Cliente();

//------------------Lectura de datos desde archivos--------------------------------
        Funciones.LeerArchivoPeliculas(videoClub1, pelicula);
        Funciones.LeerArchivoClientes(videoClub1, cliente);
//-------------------Menu  por consola------------------------------
	    Interface.inicioMenu(videoClub1);
    }
}