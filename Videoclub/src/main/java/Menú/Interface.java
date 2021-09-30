/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menú;
import Clases.Pelicula;
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
    public static void menúAdmin(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String opción;
        do{
            System.out.println("Menú Administrador");
            System.out.println("1)Desplegar lista de clientes\n2)Desplegar lista de películas");
            System.out.println("3)Registrar Cliente\n4)Registrar Película");
            System.out.println("5)Desplegar historial de cliente\n6)Buscar Película");
            System.out.println("7)Buscar Cliente\n8)Registrar Arriendo");
            System.out.println("9)Eliminar Película\n10)Editar Película");
            System.out.println("11)Eliminar cliente\n12)Editar cliente");
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
                    Funciones.mostrarHistorialCliente(x);
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
                case "9":
                    Funciones.eliminarPelicula(x);
                    break;
                case "10":
                    menúEdiciónPelícula(x);
                    break;
                case "11":
                    Funciones.eliminarCliente(x);
                    break;
                case "12":
                    menúEdiciónCliente(x);
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
                    
            }
            
        }while(!opción.equals("0"));
                
    }
//-------------------------EdiciónPelícula-----------------------------------------
    public static void menúEdiciónPelícula(VideoClub x){
        String nombre = Comprobar.loginPelicula(x);
        Scanner teclado = new Scanner(System.in);
        if(!nombre.equals("0")){
            String opcion;
            Pelicula peli = x.getPeliFromPelisXId(nombre);
            do{
               x.mostrarDatosPeliculas(nombre);
               System.out.println("Seleccione que atributo desea modificar:");
               System.out.println("1)Nombre\n2)Año de Estreno");
               System.out.println("3)Duración\n4)Sinopsis");
               System.out.println("5)Existencias\n6)Valuación");
               System.out.println("7)Calidad\n8)Directores");
               System.out.println("9)Actores\n10)Géneros");
               System.out.println("0)Terminar edición");
               switch(opcion = teclado.nextLine()){
                    case "1":
                        System.out.println("Ingrese el nuevo nombre:");
                        peli.setNombre(teclado.nextLine());
                        break;
                    case "2":
                        System.out.println("Ingrese el nuevo Año de Estreno:");
                        peli.setAñoEstreno(teclado.nextShort());
                        teclado.nextLine();
                        break;
                    case "3":
                        System.out.println("Ingrese la nueva duración:");
                        peli.setDuraciónMin(teclado.nextShort());
                        teclado.nextLine();
                        break;
                    case "4":
                        System.out.println("Ingrese la nueva Sinopsis:");
                        peli.setSinopsis(teclado.nextLine());
                        break;
                    case "5":
                        System.out.println("Ingrese la nueva cantidad:");
                        peli.setExistencias(teclado.nextShort());
                        peli.setDisponibles((short)(peli.getDisponibles() - peli.getExistencias()));
                        break;
                    case "6":
                        System.out.println("Ingrese la nueva Valuación:");
                        peli.setValuacion(Funciones.ingresoValuacion(teclado));
                        break;
                    case "7":
                        System.out.println("Ingrese la nueva Calidad:");
                        peli.setCalidad(teclado.nextLine());
                        break;
                    case "8":
                        System.out.println("Ingrese el/los nuevos directores:");
                        peli.setDirector(Funciones.ingresoDirectores(teclado));
                        break;
                    case "9":
                        System.out.println("Ingrese el/los nuevos actores:");
                        peli.setActores(Funciones.ingresoActores(teclado));
                        break;
                    case "10":
                        System.out.println("Ingrese el/los nuevos géneros:");
                        peli.setGeneros(Funciones.ingresoGeneros(teclado));
                        break;
                    default:
                        System.out.println("Ingrese una opción valida");
                        break;
               }
              
            }while(!opcion.equals("0"));
        }
    }
    //-------------------------EdiciónCliente-----------------------------------------
    public static void menúEdiciónCliente(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String cliente = Comprobar.loginClientes(x);
        String opcion;
        String rut,rutN;
        if(!cliente.equals("0")){
        do{
            
            x.mostrarDatosClientes(cliente);
            System.out.println("Seleccione el atributo que desea modifcar:");
            System.out.println("1)Nombre del Cliente.\n2)Rut del cliente.");
            System.out.println("3)Deuda del cliente.\n0)Terminar Edición.");
            switch(opcion = teclado.nextLine()){
                case "1":
                    System.out.println("Ingrese el Nuevo nombre del Cliente:");
                    x.getClientFromClientXRut(cliente).setNombre(teclado.nextLine());
                    break;
                case "2":
                    System.out.println("Ingrese el nuevo rut del cliente:");
                    rut = x.getClientFromClientXRut(cliente).getRut();
                    cliente = teclado.nextLine();
                    x.getClientFromClientXRut(rut).setRut(cliente);
                    x.addClientToClientXRut(cliente, x.getClientFromClientXRut(rut));
                    x.delCliente(rut);
                    System.out.println("sucxcesfull");
                    break;
                case "3":
                    System.out.println("Ingrese el nuevo monto de deuda del cliente:");
                    x.getClientFromClientXRut(cliente).setDeuda(teclado.nextInt());
                    teclado.nextLine();
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        }while(!opcion.equals("0"));
        }
    }
}
