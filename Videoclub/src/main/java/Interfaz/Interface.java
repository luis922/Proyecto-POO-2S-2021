/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
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
    public static void menúCliente(String usuario,VideoClub x){
        Scanner input = new Scanner(System.in);
        
        byte opción;
        String nombre = x.getClientFromClientXRut(usuario).getNombre();
        System.out.println("Bienvenido Sr(a) " + nombre);
        System.out.println("1)Desplegar lista de peliculas");
        System.out.println("2)Revisar mi historial");
        System.out.println("0)Menú anterior");
        do{
            opción = input.nextByte();
            switch(opción){
                case 1:
                    listaPeliculas(x);
                    break;
                case 2:
                    historialCliente(x,usuario);
                default:
                    System.out.println("Ingrese una opción valida");
            }
            
        }while(opción != 0);
        
    }
    public static void menúAdmin(VideoClub x){
        Scanner input = new Scanner(System.in);
        
        byte opción;
        System.out.println("Menú Administrador");
        System.out.println("1)Desplegar lista de clientes");
        System.out.println("2)Desplegar lista de peliculas");
        System.out.println("3)Registrar Cliente");
        System.out.println("4)Registrar Pelicula");
        System.out.println("5)Desplegar historial de cliente");
        System.out.println("0)Menú anterior");
        do{
            opción = input.nextByte();
            switch(opción){
                case 1:
                    listaClientes(x);
                    break;
                case 2:
                    listaPeliculas(x);
                    break;
                case 3:
                    registroClientes(x);
                    break;
                case 4:
                    registroPeliculas(x);
                    break;
                case 5:
                    historialCliente(x,null);
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    
            }
            
        }while(opción != 0);
                
    }
}
