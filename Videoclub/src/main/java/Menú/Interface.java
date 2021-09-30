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
            System.out.println("Por favor, seleccione tipo de Usuario: ");
            System.out.println("1)Cliente");
            System.out.println("2)Trabajador");
            System.out.println("0)Finalizar programa");
    }
    
    //-------------------------MENU CLIENTE-----------------------------------------
    public static void menúCliente(String usuario,VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        String opción;
        do{
            String nombre = tienda.getClientFromClientXRut(usuario).getNombre();
            System.out.println("Bienvenido Sr(a) " + nombre);
            System.out.println("1)Desplegar catálogo de películas");
            System.out.println("2)Revisar mi historial");
            System.out.println("3)Revisar historial de película");
            System.out.println("4)Desplegar mi ficha cliente");
            System.out.println("0)Menú anterior");
            opción = teclado.nextLine();
            
            switch(opción){
                case "1":
                    Funciones.listaPeliculas(tienda);
                    break;
                case "2":
                    Funciones.mostrarHistorialCliente(tienda,usuario);
                    break;
                case "3":
                    Funciones.mostrarHistorialPeli(tienda, usuario);
                    break;
                case "4":
                    Funciones.desplegarMiFicha(tienda,usuario);
                    break;
                default:
                    System.out.println("Ingrese una opción valida");
                    break;
            }
            
        }while(!opción.equals("0"));
        
    }
    
    //-------------------------MENU EMPLEADO-----------------------------------------
    public static void menúAdmin(VideoClub tienda){
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
            System.out.println("9)Eliminar Película");
            System.out.println("10)Editar Película");
            System.out.println("11)Eliminar cliente");
            System.out.println("12)Editar cliente");
            System.out.println("0)Menú anterior");
            opción = teclado.nextLine();
            
            switch(opción){
                case "1":
                    Funciones.listaClientes(tienda);
                    break;
                case "2":
                    Funciones.listaPeliculas(tienda);
                    break;
                case "3":
                    Funciones.registrarCliente(tienda);
                    break;
                case "4":
                    Funciones.registrarPelicula(tienda);
                    break;
                case "5":
                    Funciones.mostrarHistorialCliente(tienda);
                    break;
                case "6":
                    Funciones.buscarPelicula(tienda);
                    break;
                case "7":
                    Funciones.buscarCliente(tienda);
                    break;
                case "8":
                    Funciones.registrarArriendo(tienda);
                    break;
                case "9":
                    Funciones.eliminarPelicula(tienda);
                    break;
                case "10":
                  //  Funciones.editarPelicula(tienda);
                    break;
                case "11":
                    Funciones.eliminarCliente(tienda);
                    break;
                case "12":
                  //  Funciones.editarCliente(tienda);
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
                    
            }
            
        }while(!opción.equals("0"));
                
    }
}
