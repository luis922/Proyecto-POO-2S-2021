/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menú;
import Clases.Pelicula;
import Clases.VideoClub;
import java.util.Scanner;

public class MenuTienda {

    public static void inicioMenu(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        String opción;
        Funciones.llenarPresentes(tienda,"1-1");
        do{
            System.out.println();
            System.out.println("Por favor, seleccione su rol: ");
            System.out.println("1)Cliente");
            System.out.println("2)Trabajador");
            System.out.println("0)Finalizar programa");
            opción = teclado.nextLine();

            switch(opción){
                case "1":
                    String rut = Funciones.loginClientes(tienda);
                    if(rut != null) {
                        menúCliente(rut, tienda);
                        Funciones.llenarPresentes(tienda,rut);
                    }
                    break;
                case "2":
                    String rutTra = Funciones.loginTrabajadores(tienda);
                    if(rutTra != null) {
                        menúAdmin(rutTra, tienda);
                        Funciones.llenarPresentes(tienda,rutTra);
                    }
                    break;
                default:
                    if(!opción.equals("0"))
                        System.out.println("Ingrese una opción válida...");
                    break;
            }
        }while(!opción.equals("0"));
        tienda.mostrarPresentes();
    }
    
//-------------------------MENU CLIENTE-----------------------------------------
    public static void menúCliente(String rut,VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        String opción;
        do{
            String nombre = tienda.getClientFromClientXRut(rut).getNombre();
            System.out.println();
            System.out.println("Bienvenido Sr(a) " + nombre +"\n");
            System.out.println("1)Películas");
            System.out.println("2)Servicios para cliente");
            System.out.println("3)Información usuario");
            System.out.println("0)Menú anterior");
            opción = teclado.nextLine();
            
            switch(opción){
                case "1":
                    do{
                        System.out.println();
                        System.out.println("1)Desplegar catálogo de películas");
                        System.out.println("2)Buscar Película");
                        System.out.println("3)Recomendar película");
                        System.out.println("4)Recomendar película por genero");
                        System.out.println("5)Desplegar catálogo por Filtros");
                        System.out.println("0)Menú anterior");
                        switch (opción = teclado.nextLine()){
                            case "1":
                                Funciones.listaPeliculas(tienda);
                                break;
                            case "2":
                                Funciones.buscarPelicula(tienda);
                                break;
                            case "3":
                                tienda.mostrarDatosPeliculas(tienda.peliMejorEvaluada());
                                break;
                            case "4":
                                System.out.println("Ingrese genero a buscar: (Animacion, Accion, Ciencia Ficcion, Comedia, Aventura, Drama, Romance, Crimen)");    
                                opción = teclado.nextLine();
                                tienda.mostrarDatosPeliculas(tienda.peliMejorEvaluada(opción));
                                break;
                            case "5":
                                menúFiltros(tienda);
                                break;
                            default:
                                if(!opción.equals("0"))
                                    System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }while(!opción.equals("0"));
                    opción =" ";//Evita que se vuelva al menu de inicio
                    break;
                case "2":
                    do{
                        System.out.println();
                        System.out.println("1)Arrendar películas");
                        System.out.println("2)Devolver películas");
                        System.out.println("3)Pagar deuda");
                      //  System.out.println("4)Recibir una recomendación");
                        System.out.println("0)Menú anterior");
                        switch (opción = teclado.nextLine()){
                            case "1":
                                tienda.getClientFromClientXRut(rut).arrendar(tienda);
                                break;
                            case "2":
                                tienda.getClientFromClientXRut(rut).devolverArriendo(tienda);
                                break;
                            case "3":
                                tienda.getClientFromClientXRut(rut).pagarDeuda(tienda);
                                break;
                            default:
                                if(!opción.equals("0"))
                                    System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }while(!opción.equals("0"));
                    opción =" ";//Evita que se vuelva al menu de inicio
                    break;
                case "3":
                    do{
                        System.out.println();
                        System.out.println("1)Desplegar mi ficha cliente");
                        System.out.println("2)Revisar mi historial");
                        System.out.println("3)Revisar historial de película");
                        System.out.println("0)Menú anterior");
                        switch (opción = teclado.nextLine()){
                            case "1":
                                Funciones.desplegarMiFicha(tienda,rut);
                                break;
                            case "2":
                                Funciones.mostrarHistorialCliente(tienda,rut);
                                break;
                            case "3":
                                Funciones.mostrarHistorialPeli(tienda, rut);
                                break;
                            default:
                                if(!opción.equals("0"))
                                    System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }while(!opción.equals("0"));
                    opción =" ";//Evita que se vuelva al menu de inicio
                    break;
                default:
                    if(!opción.equals("0"))
                        System.out.println("Ingrese una opción valida");
                    break;
            }
        }while(!opción.equals("0"));
    }
    
//-------------------------MENU EMPLEADO-----------------------------------------
    public static void menúAdmin(String rutTra, VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        String opción;
        do{
            System.out.println();
            System.out.println("Menú Administrador");
            System.out.println("1)Ingresar datos");
            System.out.println("2)Mostrar datos");
            System.out.println("3)Buscar datos");
            System.out.println("4)Editar datos");
            System.out.println("5)Servicios para cliente");
            System.out.println("6)Generar reportes");
            System.out.println("0)Menú anterior");
            
            switch(opción = teclado.nextLine()){
                case "1":
                    do{
                        System.out.println();
                        System.out.println("1)Registrar Cliente");
                        System.out.println("2)Registrar Película");
                        System.out.println("3)Registrar Historial");
                        System.out.println("0)Menú anterior");
                        switch (opción = teclado.nextLine()){
                            case "1":
                                Funciones.registrarCliente(tienda);
                                break;
                            case "2":
                                Funciones.registrarPelicula(tienda);
                                break;
                            case "3":
                                Funciones.registrarHistorial(tienda);
                                break;
                            default:
                                if(!opción.equals("0"))
                                    System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }while(!opción.equals("0"));
                    opción =" ";//Para que vuelva al menu anterior
                    break;
                case "2":
                    do{
                        System.out.println();
                        System.out.println("1)Desplegar lista de clientes");
                        System.out.println("2)Desplegar lista de películas");
                        System.out.println("3)Desplegar historial de cliente");
                        System.out.println("4)Desplegar datos trabajador");
                        System.out.println("0)Menú anterior");
                        switch (opción = teclado.nextLine()){
                            case "1":
                                Funciones.listaClientes(tienda);
                                break;
                            case "2":
                                Funciones.listaPeliculas(tienda);
                                break;
                            case "3":
                                Funciones.mostrarHistorialCliente(tienda);
                                break;
                            case "4":
                                tienda.mostrarDatosTrabajadores();
                                break;
                            default:
                                if(!opción.equals("0"))
                                    System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }while(!opción.equals("0"));
                    opción =" ";//Para que vuelva al menu anterior
                    break;
                case "3":
                    do{
                        System.out.println();
                        System.out.println("1)Buscar Película");
                        System.out.println("2)Buscar Cliente");
                        System.out.println("0)Menú anterior");
                        switch (opción = teclado.nextLine()){
                            case "1":
                                Funciones.buscarPelicula(tienda);
                                break;
                            case "2":
                                Funciones.buscarCliente(tienda);
                                break;
                            default:
                                if(!opción.equals("0"))
                                    System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }while(!opción.equals("0"));
                    opción =" ";//Para que vuelva al menu anterior
                    break;
                case "4":
                    do{
                        System.out.println();
                        System.out.println("1)Editar Película");
                        System.out.println("2)Editar Cliente");
                        System.out.println("3)Eliminar Película");
                        System.out.println("4)Eliminar Cliente");
                        System.out.println("0)Menú anterior");
                        switch (opción = teclado.nextLine()){
                            case "1":
                                menúEdiciónPelícula(tienda);
                                break;
                            case "2":
                                menúEdiciónCliente(tienda);
                                break;
                            case "3":
                                Funciones.eliminarPelicula(tienda);
                                break;
                            case "4":
                                Funciones.eliminarCliente(tienda);
                                break;
                            default:
                                if(!opción.equals("0"))
                                    System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }while(!opción.equals("0"));
                    opción =" ";//Para que vuelva al menu anterior
                    break;
                case "5":
                    do{
                        System.out.println();
                        System.out.println("1)Arrendar Película");
                        System.out.println("2)Devolver Película");
                        System.out.println("3)Pagar deuda");
                        System.out.println("0)Menú anterior");
                        switch (opción = teclado.nextLine()){
                            case "1":
                                tienda.getTrabajadorFromTrabajadoresXRut(rutTra).arrendar(tienda);
                                break;
                            case "2":
                                tienda.getTrabajadorFromTrabajadoresXRut(rutTra).devolverArriendo(tienda);
                                break;
                            case "3":
                                tienda.getTrabajadorFromTrabajadoresXRut(rutTra).pagarDeuda(tienda);
                                break;
                            default:
                                if(!opción.equals("0"))
                                    System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }while(!opción.equals("0"));
                    opción =" ";//Para que vuelva al menu anterior
                    break;
                case "6":
                    do{
                        System.out.println("1)Deudores");
                        System.out.println("2)Peliculas en arriendo");
                        System.out.println("0)Menú anterior");
                        switch (opción = teclado.nextLine()){
                            case "1":
                                tienda.escribirArchivoDeudores();
                                break;
                            case "2":
                                tienda.escribirArchivoArriendosActuales();
                                break;
                            default:
                                if(!opción.equals("0"))
                                    System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }while(!opción.equals("0"));
                    opción =" ";//Para que vuelva al menu anterior
                    break;
                default:
                    if(!opción.equals("0"))
                        System.out.println("Ingrese una opción valida");
                    break;
            }
        }while(!opción.equals("0"));
                
    }
//-------------------------EdiciónPelícula-----------------------------------------
    public static void menúEdiciónPelícula(VideoClub tienda){
        String nombre = Funciones.loginPelicula(tienda);
        Scanner teclado = new Scanner(System.in);
        if(!nombre.equals("0")){
            String opcion;
            Pelicula peli = tienda.getPeliFromPelisXId(nombre);
            do{
               tienda.mostrarDatosPeliculas(nombre);
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
                        if(!opcion.equals("0"))
                            System.out.println("Ingrese una opción valida");
                        break;
               }
              
            }while(!opcion.equals("0"));
        }
    }
//-------------------------EdiciónCliente-----------------------------------------
    public static void menúEdiciónCliente(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        String cliente = Funciones.loginClientes(tienda);
        String opcion;
        String rut;
        if(!cliente.equals("0")){
            do{

                tienda.mostrarDatosClientes(cliente);
                System.out.println("Seleccione el atributo que desea modifcar:");
                System.out.println("1)Nombre del Cliente.\n2)Rut del cliente.");
                System.out.println("3)Deuda del cliente.\n0)Terminar Edición.");
                switch(opcion = teclado.nextLine()){
                    case "1":
                        System.out.println("Ingrese el Nuevo nombre del Cliente:");
                        tienda.getClientFromClientXRut(cliente).setNombre(teclado.nextLine());
                        break;
                    case "2":
                        System.out.println("Ingrese el nuevo rut del cliente:");
                        rut = tienda.getClientFromClientXRut(cliente).getRut();
                        cliente = teclado.nextLine();
                        tienda.getClientFromClientXRut(rut).setRut(cliente);
                        tienda.addClientToClientXRut(cliente, tienda.getClientFromClientXRut(rut));
                        tienda.delCliente(rut);
                        System.out.println("Exitoso");
                        break;
                    case "3":
                        System.out.println("Ingrese el nuevo monto de deuda del cliente:");
                        tienda.getClientFromClientXRut(cliente).setDeuda(teclado.nextInt());
                        teclado.nextLine();
                        break;
                    default:
                        if(!opcion.equals("0"))
                            System.out.println("Ingrese una opción valida");
                        break;
                }
            }while(!opcion.equals("0"));
        }
    }
 //-------------------------Filtrado-----------------------------------------
    public static void menúFiltros(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        String opción;
        
        do{
            System.out.println("Seleccione el filtro que desea implementar:");
            System.out.println("1)Rango de años");
            System.out.println("2)Rango de Valuación");
            System.out.println("3)Género");
            System.out.println("4)Disponibilidad");
            System.out.println("5)Director");
            System.out.println("6)Calidad de imagen");
            System.out.println("7)Rango de duración");
            System.out.println("0)Volver al menú anterior");
            
            switch(opción = teclado.nextLine()){
                case "1":
                    Funciones.filtradoPorAño(tienda);
                    break;
                case "2":
                    Funciones.filtradoPorValuación(tienda);
                    break;
                case "3":
                    Funciones.filtradoPorGénero(tienda);
                    break;
                case "4":
                    Funciones.filtradoDisponibles(tienda);
                    break;
                case "5":
                    Funciones.filtradoDirector(tienda);
                    break;
                case "6":
                    Funciones.filtradoCalidad(tienda);
                    break;
                case "7":
                    Funciones.filtradoDuración(tienda);
                    break;
                default:
                    if(!opción.equals("0"))
                        System.out.println("Porfavor, ingrese una opción Válida");
                    break;
            
            }
            
        }while(opción.equals("0"));
    }
}
