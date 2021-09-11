/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menú;
import Clases.VideoClub;
import java.util.Scanner;

/**
 *
 * @author sebas
 */


public class Interface {
    public static void login(){
            System.out.println("Porfavor, seleccione tipo de Usuario: ");
            System.out.println("1)Cliente");
            System.out.println("2)Trabajador");
            System.out.println("0)Finalizar programa");
    }
    
    //-------------------------MENU CLIENTE-----------------------------------------
    public static void menúCliente(String usuario,VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String opción;
        do{
            String nombre = x.getClientFromClientXRut(usuario).getNombre();
            System.out.println("Bienvenido Sr(a) " + nombre);
            System.out.println("1)Desplegar catálogo de películas");
            System.out.println("2)Revisar mi historial");
            System.out.println("3)Revisar historial de película");
            System.out.println("4)Desplegar mi ficha cliente");
            System.out.println("0)Menú anterior");
            opción = teclado.nextLine();
            
            switch(opción){
                case "1":
                    Funciones.listaPeliculas(x);
                    break;
                case "2":
                    Funciones.mostrarHistorialCliente(x,usuario);
                    break;
                case "3":
                    Funciones.mostrarHistorialPeli(x, usuario);
                    break;
                case "4":
                    Funciones.desplegarMiFicha(x,usuario);
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }
            
        }while(!opción.equals("0"));
        
    }
    
    //-------------------------MENU EMPLEADO-----------------------------------------
    public static void menúAdmin(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String opción;
        do{
            System.out.println("Menú Administrador");
            System.out.println("1)Desplegar lista de clientes");
            System.out.println("2)Desplegar lista de películas");
            System.out.println("3)Registrar Cliente");
            System.out.println("4)Registrar Película");
            System.out.println("5)Desplegar historial de cliente");
            System.out.println("6)Buscar Película");
            System.out.println("7)Buscar Cliente");
            System.out.println("8)Registrar Arriendo");
            System.out.println("0)Menú anterior");
            opción = teclado.nextLine();
            
            switch(opción){
                case "1":
                    Funciones.listaClientes(x);
                    break;
                case "2":
                    Funciones.listaPeliculas(x);
                    break;
                case "3":
                    Funciones.registrarCliente(x);
                    break;
                case "4":
                    Funciones.registrarPelicula(x);
                    break;
                case "5":
                    Funciones.historialCliente(x);
                    break;
                case "6":
                    Funciones.buscarPelicula(x);
                    break;
                case "7":
                    Funciones.buscarCliente(x);
                    break;
                case "8":
                    Funciones.registrarArriendo(x);
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
                    
            }
            
        }while(!opción.equals("0"));
                
    }
}
