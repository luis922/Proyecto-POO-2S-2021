/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menú;

import Clases.*;
import Comprobadores.Comprobar;
import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class Funciones {
    
    public static void listaPeliculas(VideoClub x){
        System.out.println("Listado de películas: ");
        x.mostrarDatosPeliculas();
        
    }
    
    public static void listaClientes(VideoClub x){
        System.out.println("Listado de Clientes: ");
        x.mostrarDatosClientes();
    }
    
    public static void mostarHistorialCliente(VideoClub x, String rut){
        System.out.println("Información sobre las peliculas arrendadas");
        x.getClientFromClientXRut(rut).mostrarHistorial();
    }

    public static void mostrarHistorialPeli(VideoClub x, String rut, String id){
        System.out.println("Información sobre el arriendo de esta pelicula");
        x.getClientFromClientXRut(rut).mostrarHistorial(id);

    }
    
    public static void registrarCliente(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        Cliente nuevo = new Cliente();
        int i = 0;
        System.out.println("Bienvenido al registro de clientes, porfavor introduzca el nombre del cliente:");
        nuevo.setNombre(teclado.nextLine()) ;
        System.out.println("Introduzca el rut del cliente(con guión antes del dígito verificador): ");
        
        do{
            if(i != 0) System.out.println("El rut ingresado no se encuentra en el formato solicitado, porfavor. ingreselo nuevamente.");
            nuevo.setRut(teclado.nextLine());
            i++;
        }while(Comprobar.formatoCorrectoRut(nuevo.getRut()) != true);
        
        x.addClientToListaClients(nuevo);
        x.addClientToClientXRut(nuevo.getRut(), nuevo);
        x.addClientToClientXRut(nuevo.getRut(),nuevo);
        System.out.println("¡Cliente registrado exitosamente!");
    }
    
    public static void registrarPelicula(VideoClub x){//Incompleto aún
        Scanner teclado = new Scanner(System.in);
        Pelicula nueva = new Pelicula();
        System.out.println("Bienvenido al registro de peliculas, porfavor, introduzca el nombre de la película:");
        nueva.setNombre(teclado.nextLine());
        nueva.setDirector(ingresoDirectores(teclado));
        
        
    }
    
    public static String[] ingresoDirectores(Scanner teclado){//Podría presentar ingresos erroneos
        String directores[] = new String[5];
        int contador = 0;
        boolean continuar = true;
        System.out.println("Ingrese el primer director");
        
        do{
            if(contador != 0) System.out.println("Ingrese el siguiente director:");
            directores[contador] = teclado.nextLine();
            contador++;
            System.out.println("¿Desea ingresar otro director? *Limite = 5*");
            System.out.println("0)No\n1)Si");
            if(teclado.nextByte()== 0) continuar = false;
            teclado.nextLine();
        }while(continuar && contador < 5);
        
        return directores;
    }
}
