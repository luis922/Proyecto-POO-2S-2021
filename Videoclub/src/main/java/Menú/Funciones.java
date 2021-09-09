/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menú;

import Clases.*;
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
    
    public static void mostrarHistorialCliente(VideoClub x, String rut){
        System.out.println("Información sobre las peliculas arrendadas");
        x.getClientFromClientXRut(rut).mostrarHistorial();
    }

    public static void mostrarHistorialPeli(VideoClub x, String rut){
        Scanner teclado = new Scanner(System.in);
        String id;
        System.out.println("Ingrese el id de la pelicula cuyo historial de arriendo quiere revisar: ");

        do{
            id = teclado.nextLine();
            if(x.getClientFromClientXRut(rut).existIDMap(id)){
                System.out.println("Información obtenida");
                x.getClientFromClientXRut(rut).mostrarHistorial(id);
            }
            else
                System.out.println("Ingrese una id valida");
        }while(!x.getClientFromClientXRut(rut).existIDMap(id));
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
        System.out.println("¡Cliente registrado exitosamente!");
    }
    
    public static void registrarPelicula(VideoClub x){//Incompleto aún, falta ranking e ingreso en la base
        Scanner teclado = new Scanner(System.in);
        Pelicula nueva = new Pelicula();
        System.out.println("Bienvenido al registro de peliculas, porfavor, introduzca el nombre de la película:");
        nueva.setNombre(teclado.nextLine());
        nueva.setDirector(ingresoDirectores(teclado));
        nueva.setGeneros(ingresoGeneros(teclado));
        System.out.println("Ingrese la Sinopsis:");
        nueva.setSinopsis(teclado.nextLine());
        System.out.println("Ingrese la duración en minutos:");
        nueva.setDuraciónMin(teclado.nextShort());
        System.out.println("Ingrese Año de estreno:");
        nueva.setAñoEstreno(teclado.nextShort());
        teclado.nextLine();
        nueva.setActores(ingresoActores(teclado));
        System.out.println("Ingrese la calidad de video del metraje:");
        nueva.setCalidad(teclado.nextLine());
        System.out.println("Ingrese cuantas unidades posee:");
        nueva.setExistencias(teclado.nextShort());
        teclado.nextLine();
        nueva.setDisponibles(nueva.getExistencias());
        System.out.println("Ingrese la Valuación *Entre 1.0 a 5.0*:");
        nueva.setValuacion(ingresoValuacion(teclado));
        nueva.setId(String.valueOf(x.getSize(2)));
        x.addPeliToListaPelis(nueva);
        x.addPeliToPelisXId(nueva.getId(), nueva);
        System.out.println("¡Pelicula Ingresada Exitosamente!");
        
        
    }
    
    public static String[] ingresoDirectores(Scanner teclado){//Podría presentar ingresos erroneos
        System.out.println("Ingrese la cantidad de directores");
        byte cantidad = teclado.nextByte();
        teclado.nextLine();
        String directores[] = new String[cantidad];
        int contador = 0;
        System.out.println("Ingrese el primer Director:");
        
        do{
            if(contador != 0) System.out.println("Ingrese el siguiente Director:");
            directores[contador] = teclado.nextLine();
            contador++;
        }while(contador < cantidad);
        return directores;
        
    }
    
    public static String[] ingresoGeneros(Scanner teclado){//Podría presentar ingresos erroneos
        System.out.println("Ingrese la cantidad de géneros:");
        byte cantidad = teclado.nextByte();
        teclado.nextLine();
        String generos[] = new String[cantidad];
        int contador = 0;
        System.out.println("Ingrese el primer Género:");
        
        do{
            if(contador != 0) System.out.println("Ingrese el siguiente Género:");
            generos[contador] = teclado.nextLine();
            contador++;
        }while(contador < cantidad);
        
        return generos;
        
    }
    
    public static String[] ingresoActores(Scanner teclado){
        System.out.println("Ingrese la cantidad de actores a ingresar:");
        byte cantidad = teclado.nextByte();
        teclado.nextLine();
        String actores[] = new String[cantidad];
        int contador = 0;
        System.out.println("Ingrese el primer Actor:");
        
        do{
            if(contador != 0) System.out.println("Ingrese el siguiente Actor");
            actores[contador] = teclado.nextLine();
            contador++;
        }while(contador < cantidad);
        return actores;
    }
    
    public static float ingresoValuacion(Scanner teclado){
        float valuacion;
        int contador = 0;
        do{
            if(contador != 0) System.out.println("Porfavor, ingrese la Valuacion en el formato solicitado");
            valuacion = teclado.nextFloat();
            teclado.nextLine();
            contador++;
        }while(Menú.Comprobar.formatoCorrectoValuacion(valuacion) != true);
        
        return valuacion;
        
    }
    
    public static void buscarPelicula(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String nombrePeli;
        System.out.println("Ingrese nombre de la pelicula a buscar: ");
        do{
            nombrePeli = teclado.nextLine();
            String id = x.obtenerIdXNombre(nombrePeli);
            if (id != null){
                x.mostrarDatosPeliculas(id);
                break;
            }
            else{
                System.out.println("Pelicula no registrada");
                System.out.println("Ingrese nombre nuevamente o '0' para terminar");
            }
        }while(!nombrePeli.equals("0"));
    }
    
    public static void desplegarMiFicha(VideoClub x, String usuario){
        x.mostrarDatosClientes(usuario);
    }
    
    public static void historialCliente(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el rut del cliente:");
        String rut;
        do{
            rut = teclado.nextLine();
            if(x.containsRUT(rut)){
                x.getClientFromClientXRut(rut).mostrarHistorial();
                break;
            }
            else if (!rut.equals("0")){
                System.out.println("Cliente no se encuentra registrado.");
                System.out.println("Ingrese rut nuevamente o '0' para terminar:");
            }
        }while(!rut.equals("0"));
    }
    
    public static void buscarCliente(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el rut del cliente:");
        String rut;
        do{
            rut = teclado.nextLine();
            if(x.containsRUT(rut)){
                x.mostrarDatosClientes(rut);
                break;
            }
            else if (!rut.equals("0")){
                System.out.println("Cliente no se encuentra registrado.");
                System.out.println("Ingrese rut nuevamente o '0' para terminar:");
            }
        }while(!rut.equals("0"));
    }
}    