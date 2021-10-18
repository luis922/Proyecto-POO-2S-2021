package Clases;
/*Instruccion del main:
Solo compilar y ejecutar el main para obtener los datos desde los archivos
y acceder a funcionalidades del menu
*/

import Menú.*;

public class Main {
    public static void main(String[] args) throws Exception{
	    VideoClub videoClub1 = new VideoClub();
//------------------Lectura de datos desde archivos--------------------------------
        Funciones.LeerArchivoPeliculas(videoClub1);
        Funciones.LeerArchivoClientes(videoClub1);
//-------------------Menu  por consola------------------------------
	    MenuTienda.inicioMenu(videoClub1);
    }
}