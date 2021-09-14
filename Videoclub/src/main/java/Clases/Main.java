package Clases;
/*Instruccion del main:
Solo compilar y ejecutar el main para obtener los datos desde los archivos
y mostrar algunos de estos por pantalla
*/

import java.util.*; //Scanner, Arrays
import Menú.*;

public class Main {
    public static void main(String[] args) throws Exception{
	VideoClub videoClub1 = new VideoClub();
        Pelicula pelicula = new Pelicula();
        Cliente cliente = new Cliente();

//------------------------------Lectura de datos desde archivos--------------------------------
        Funciones.LeerArchivoPeliculas(videoClub1, pelicula);
        Funciones.LeerArchivoClientes(videoClub1, cliente);
//-------------------Menu  por consola------------------------------
	Scanner entrada = new Scanner(System.in);
        byte opción;
        do{
            Interface.login();
            opción = entrada.nextByte();
            switch(opción){
                 case 1:
                    String rut = Comprobar.loginClientes(videoClub1);
                    if(rut != null)
                        Interface.menúCliente(rut,videoClub1);
                    break;
                case 2:
                    Interface.menúAdmin(videoClub1);
                    break;
                default:
                    if(opción != 0) System.out.println("Ingrese una opción válida...");
                    break;
            }
        }while(opción != 0);
    }
}