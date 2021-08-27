/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author sebas
 */
public class Main {
    public static void main(String[] args) throws Exception{
	VideoClub videoClub1 = new VideoClub();
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
		//Guardar Datos en array de Peliculas [0]=nombre, [1]=Existencias, [2]=Disponibles, [3]Rank... 
	}
//---------------Clientes
        String[] arrayLineaClientes = new String[qDatosClientes];
        File flClientes = new File("./src/main/java/data/clientes.tsv");
	Scanner scCli = new Scanner(flClientes);
	while(scCli.hasNextLine()){
		linea = scCli.nextLine();
		arrayLineaClientes = linea.split("\t");
		//Guardar Datos en array de Clientes: [0]=noimbre, [1]=rut, [2]=historial, [3]=pelPosesion, [4]=Deuda
	}
        
//----------------------------------------------------------------------------------------------  
        Scanner entrada = new Scanner(System.in);
        int opción;
        
        do{
            Interfaz.Interface.login();
            opción = entrada.nextInt();
            switch(opción){
                 case 1:
                    ;//Se llama a una función que verifique si el rut a ingresar está en la base de datos
                case 2:
                    ;
                default:
                    if(opción != 0) System.out.println("Ingrese una opción válida...");
            }
        
            
        }while(opción != 0);
        
        
    } 
}
