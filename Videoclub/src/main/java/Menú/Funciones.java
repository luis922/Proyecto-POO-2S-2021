/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menú;

import Clases.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Funciones {
    
    public static void listaPeliculas(VideoClub x){
        System.out.println("Listado de películas: ");
        x.mostrarDatosPeliculas();
        
    }
    
    public static void listaClientes(VideoClub x){
        System.out.println("Listado de Clientes: ");
        x.mostrarDatosClientes();
    }
    
//------------------MOSTRAR HISTORIAL CLIENTE------------------ 
    public static void mostrarHistorialCliente(VideoClub x, String rut){
        System.out.println("Información sobre las peliculas arrendadas");
        if (x.getClientFromClientXRut(rut).getSize(1) == 0)
                System.out.println("Cliente no posee historial.");
        else
            x.getClientFromClientXRut(rut).mostrarHistorial(x);
    }
    
    public static void mostrarHistorialCliente(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el rut del cliente:(20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
        String rut;
        do{
            rut = teclado.nextLine();
            if(x.containsRUT(rut)){
                if (x.getClientFromClientXRut(rut).getSize(1) == 0)
                    System.out.println("Cliente no posee historial.");
                else
                    x.getClientFromClientXRut(rut).mostrarHistorial(x);
                break;
            }
            else if (!rut.equals("0")){
                System.out.println("Cliente no se encuentra registrado.");
                System.out.println("Ingrese rut nuevamente o '0' para terminar: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            }
        }while(!rut.equals("0"));
    }
    
//------------------ MOSTRAR HISTORIAL PELICULA------------------ 
    public static void mostrarHistorialPeli(VideoClub x, String rut){
        Scanner teclado = new Scanner(System.in);
        String nombre, id;
        System.out.println("Ingrese el nombre de la pelicula cuyo historial de arriendo quiere revisar: (Killer Bean Forever, Bob Esponja: La Pelicula, Shrek, Shrek 2, ¿Quien mató al Capitan Alex?)");
        do{
            nombre = teclado.nextLine();
            id = x.obtenerIdXNombre(nombre);
            if(id != null){
                System.out.println("Información obtenida");
                x.getClientFromClientXRut(rut).mostrarHistorial(id);
                System.out.println();
                break;
            }
            else{
                System.out.println("No se encuentra la pelicula en el historial.");
                System.out.println("Ingrese nombre nuevamente o '0' para terminar.");
            }
        }while(!nombre.equals("0"));
    }
    
//------------------REGISTRO NUEVO CLIENTE------------------    
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
        }while(!Comprobar.formatoCorrectoRut(nuevo.getRut()));
        
        x.addClientToListaClients(nuevo);
        x.addClientToClientXRut(nuevo.getRut(), nuevo);
        System.out.println("¡Cliente registrado exitosamente!");
    }
    
//------------------REGISTRO NUEVA PELICULA------------------    
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
    
//------------------REGISTRO NUEVO HISTORIAL------------------
    public static void registrarHistorial(VideoClub x){
        String rut, nombrePeli, id;
        Arriendo arriendo;
        Scanner teclado = new Scanner(System.in);
        LocalDate fechaEntrega, fechaArriendo;
        do{
            System.out.println("Ingrese rut cliente que va a registrar['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            rut = teclado.nextLine();
            if (!x.existRUT(rut)){
                System.out.println("rut no registrado.");
            }
            else{
                do{
                    System.out.println("Ingrese nombre pelicula a arrendar['0' para terminar]: (Killer Bean Forever, Bob Esponja: La Pelicula, Shrek, Shrek 2, ¿Quien mató al Capitan Alex?)");
                    nombrePeli = teclado.nextLine();
                    id = x.obtenerIdXNombre(nombrePeli);
                    if (!nombrePeli.equals("0")){
                        if (id == null){
                            System.out.println("No se encuentra la pelicula.");
                            continue;
                        }
                        System.out.println("Ingrese fecha arriendo: yyyy-mm-dd Ej: 2021-09-06");
                        fechaArriendo = LocalDate.parse(teclado.nextLine());
                        System.out.println("Ingrese fecha entrega: yyyy-mm-dd Ej: 2021-09-06");
                        fechaEntrega = LocalDate.parse(teclado.nextLine());
                        if(!x.getClientFromClientXRut(rut).existIDHistorial(id)){//Primera vez q arrienda la pelicula.
                            arriendo = new Arriendo();
                            arriendo.setId(id);
                            arriendo.setFechaArriendo(fechaArriendo);
                            arriendo.setFechaEntrega(fechaEntrega);
                            arriendo.setVecesArrendada(arriendo.getVecesArrendada()+1);
                            arriendo.setEntregado(false);
                            x.getClientFromClientXRut(rut).addToHistorialXid(arriendo);
                            x.getClientFromClientXRut(rut).addToHistorial(arriendo);
                        }
                        else{//Ha arrendadoo antes la pelicula
                            System.out.println("Cliente ha arrendado la pelicula antes, se actualizan los datos...");
                            arriendo = x.getClientFromClientXRut(rut).getHistorialXId(id);
                            arriendo.setFechaArriendo(fechaArriendo);
                            arriendo.setFechaEntrega(fechaEntrega);
                            arriendo.setVecesArrendada(arriendo.getVecesArrendada()+1);
                            arriendo.setEntregado(false);
                        }
                    }
                }while (!nombrePeli.equals("0"));
                rut = "0";
            }
        }while(!rut.equals("0"));
    }
    
///---------Ingresos---------     
    public static String[] ingresoDirectores(Scanner teclado){
        System.out.println("Ingrese la cantidad de directores");
        byte cantidad = teclado.nextByte();
        teclado.nextLine();
        String []directores = new String[cantidad];
        int contador = 0;
        System.out.println("Ingrese el primer Director:");
        
        do{
            if(contador != 0) System.out.println("Ingrese el siguiente Director:");
            directores[contador] = teclado.nextLine();
            contador++;
        }while(contador < cantidad);
        return directores;  
    }
    
    public static String[] ingresoGeneros(Scanner teclado){
        System.out.println("Ingrese la cantidad de géneros:");
        byte cantidad = teclado.nextByte();
        teclado.nextLine();
        String []generos = new String[cantidad];
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
        String []actores = new String[cantidad];
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
        }while(!Menú.Comprobar.formatoCorrectoValuacion(valuacion));
        
        return valuacion;
        
    }
    
//------------------BUSQUEDA------------------ 
    public static void buscarPelicula(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String nombrePeli;
        System.out.println("Ingrese nombre de la pelicula a buscar: (Killer Bean Forever, Bob Esponja: La Pelicula, Shrek, Shrek 2, ¿Quien mató al Capitan Alex?)");
        do{
            nombrePeli = teclado.nextLine();
            String id = x.obtenerIdXNombre(nombrePeli);
            if (id != null){
                x.mostrarDatosPeliculas(id);
                break;
            }
            else{
                System.out.println("Pelicula no registrada");
                System.out.println("Ingrese nombre nuevamente o '0' para terminar: (Killer Bean Forever, Bob Esponja: La Pelicula, Shrek, Shrek 2, ¿Quien mató al Capitan Alex?)");
            }
        }while(!nombrePeli.equals("0"));
    }
    
    public static void desplegarMiFicha(VideoClub x, String usuario){
        x.mostrarDatosClientes(usuario);
    }
    
    public static void buscarCliente(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el rut del cliente: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
        String rut;
        do{
            rut = teclado.nextLine();
            if(x.containsRUT(rut)){
                x.mostrarDatosClientes(rut);
                break;
            }
            else if (!rut.equals("0")){
                System.out.println("Cliente no se encuentra registrado.");
                System.out.println("Ingrese rut nuevamente o '0' para terminar: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            }
        }while(!rut.equals("0"));
    }
    
//------------------LECTURA DE DATOS DESDE ARCHIVO------------------ 
    public static void LeerArchivoClientes(VideoClub videoClub, Cliente cliente)throws FileNotFoundException{
        File flClientes = new File("./src/main/java/data/clientes.tsv");
        Scanner scCli = new Scanner(flClientes);
        String linea;
        String[] arrayLineaClientes;
        scCli.nextLine();
        Arriendo arriendo;
        int i;
	while(scCli.hasNextLine()){
		linea = scCli.nextLine();
		arrayLineaClientes = linea.split("\t");
		//Guardar Datos en array de Clientes: [0]=nombre, [1]=rut, [2]=historial arriendos , [3]=pelPosesion, [4]=Deuda
		cliente = new Cliente();
		cliente.setNombre(arrayLineaClientes[0]);
		cliente.setRut(arrayLineaClientes[1]);
                for(i=0; i<arrayLineaClientes[2].split("_").length; i++){
                    arriendo = new Arriendo();
                    arriendo.setId(arrayLineaClientes[2].split("_")[i]);
                    cliente.addToHistorial(arriendo);
                    cliente.addToHistorialXid(arriendo);
                }
		cliente.setDeuda(Integer.parseInt(arrayLineaClientes[4]));
		videoClub.addClientToListaClients(cliente);
		videoClub.addClientToClientXRut(arrayLineaClientes[1], cliente);
		}
    }
    
    public static void LeerArchivoPeliculas(VideoClub videoClub, Pelicula pelicula) throws FileNotFoundException{
        File flPeliculas = new File("./src/main/java/data/peliculas.tsv");
		Scanner scPel = new Scanner(flPeliculas);
        String linea;
        String[] arrayLineaPeliculas;
        scPel.nextLine();
		while(scPel.hasNextLine()){
			linea = scPel.nextLine();
			arrayLineaPeliculas = linea.split("\t");
			//Guardar Datos en array de Peliculas
			pelicula = new Pelicula();
                        pelicula.setId(arrayLineaPeliculas[0]);
			pelicula.setNombre(arrayLineaPeliculas[1]);
			pelicula.setExistencias(Short.parseShort(arrayLineaPeliculas[2]));
			pelicula.setDisponibles(Short.parseShort(arrayLineaPeliculas[3]));
			pelicula.setValuacion(Float.parseFloat(arrayLineaPeliculas[4]));
			pelicula.setAñoEstreno(Short.parseShort(arrayLineaPeliculas[5]));
			pelicula.setDuraciónMin(Short.parseShort(arrayLineaPeliculas[6]));
			pelicula.setSinopsis(arrayLineaPeliculas[7]);
			pelicula.setCalidad(arrayLineaPeliculas[8]);
			pelicula.setDirector(arrayLineaPeliculas[9].split("_"));
			pelicula.setActores(arrayLineaPeliculas[10].split("_"));
			pelicula.setGeneros(arrayLineaPeliculas[11].split("_"));
			videoClub.addPeliToListaPelis(pelicula);
			videoClub.addPeliToPelisXId(pelicula.getId(),pelicula);
		}
    }
//------------------Eliminación------------------ 
    public static void eliminarPelicula (VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String nombre;
        int contador = 0;
        System.out.println("Ingrese el nombre de la pelicula que desea eliminar:");
        do{
            if(contador != 0) System.out.println("La pelicula ingresada no se encuentra en nuestro registro, intentelo nuevamente\n(ingrese \"0\" para cancelar)");
            nombre = teclado.nextLine();
            contador++;
        }while(!x.containsID(x.obtenerIdXNombre(nombre)) && !nombre.equals("0"));
        if(!nombre.equals("0")){
            Pelicula ay = x.getPeliFromPelisXId(x.obtenerIdXNombre(nombre));
            System.out.println("¿Está seguro de eliminar la película \"" + ay.getNombre() + "\" de la base de datos?\n1)Sí\n2)No");
            
            switch(teclado.nextLine()){
                case "1":
                    x.delPelicula(ay.getId());
                    if(x.containsID(x.obtenerIdXNombre(nombre))) System.out.println("Operación Falló");//Dudo que se use pero podría ahorrarnos un dolor de cabeza
                    else System.out.println("¡Operación realizada con exito!\nVolviendo al menú principal...");
                    break;
                case "2":
                    System.out.println("Operación cancelada...\nVolviendo al menú principal...");
                    break;
            }
        }
        
       
    }
    
    public static void eliminarCliente(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String rut;
        int contador = 0;
        System.out.println("Ingrese el rut del usuario a eliminar:");
        do{
            if(contador != 0)
                System.out.println("El rut ingresado no se encuentra en nuestro registro, intenelo nuevamente\n(Ingrese \"0\" para cancelar)");
            rut = teclado.nextLine();
            contador++;
        }while(!x.containsRUT(rut) && !rut.equals("0"));
        if(!rut.equals("0")) {
            Cliente ay = x.getClientFromClientXRut(rut);
            System.out.println("¿Está seguro de eliminar al Sr(a) \"" + ay.getNombre()+ "\" de la base de datos?\n1)Sí\n2)No");
            
            switch(teclado.nextLine()){
                case "1":
                    x.delCliente(rut);
                    if(x.containsRUT(rut)) System.out.println("Operación Falló");//Same as the other
                    else System.out.println("¡Operación realizada con exito!\nVolviendo al menú principal...");
                    break;
                case "2":
                    System.out.println("Operación cancelada...\nVolviendo al menú principal...");
                    break;
            }
        }
    }
	
//-----------------------------ARRENDAR PELICULAS-------------------------------------------
    public static Arriendo nuevoArriendo (VideoClub tienda, String rut){
        String nombrePeli, id;
        Arriendo arriendo = new Arriendo();
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Ingrese nombre pelicula a arrendar['0' para terminar]: (Killer Bean Forever, Bob Esponja: La Pelicula, Shrek, Shrek 2, ¿Quien mató al Capitan Alex?)");
            nombrePeli = teclado.nextLine();
            id = tienda.obtenerIdXNombre(nombrePeli);
            if (!nombrePeli.equals("0")){
                if (id == null){
                    System.out.println("No se encuentra la película en catálogo.");
                }
                else{
                    if(tienda.getClientFromClientXRut(rut).existIDArriendo(id)){
                        System.out.println("Solo se puede arrendar una copia de la misma película.");
                    }
                    else{
                        if(tienda.getPeliFromPelisXId(id).getDisponibles() == 0){
                            System.out.println("No hay copias de esta película disponibles.");
                        }
                        else{
                            System.out.println("Ingrese fecha arriendo: yyyy-mm-dd Ej: 2021-09-06");
                            arriendo.setFechaArriendo(LocalDate.parse(teclado.nextLine()));
                            System.out.println("Ingrese fecha entrega: yyyy-mm-dd Ej: 2021-09-06");
                            arriendo.setFechaEntrega(LocalDate.parse(teclado.nextLine()));
                            arriendo.setId(id);
                            arriendo.setVecesArrendada(arriendo.getVecesArrendada()+1);
                            arriendo.setEntregado(false);
                            tienda.getPeliFromPelisXId(id).setDisponibles((short)(tienda.getPeliFromPelisXId(id).getDisponibles()-1));
                            return arriendo;
                        }
                    }
                }
            }
        }while (!nombrePeli.equals("0"));
        return null;
    }

    public static void arrendar(VideoClub tienda, String rut){
        Arriendo arriendo;
        int aux;
        Scanner teclado = new Scanner(System.in);

        if(tienda.getClientFromClientXRut(rut).getDeuda() > 0) {
            System.out.println("Primero debe pagar su deuda para poder arrendar otra película");
            return;
        }
        if(tienda.getClientFromClientXRut(rut).getSize(2) < 3){
            do{
                arriendo = nuevoArriendo(tienda,rut);
                if(arriendo != null){
                    tienda.getClientFromClientXRut(rut).addToArriendosActuales(arriendo);
                    tienda.getClientFromClientXRut(rut).addToArriendosXid(arriendo);
                    System.out.println("Película arrendada exitosamente.\n");
                    System.out.println("¿Desea arrendar otra película?[Ingrese 1 para seguir o 0 para terminar]");
                }
                else{
                    System.out.println("Arriendo no realizado.[Ingrese 0 para salir]");
                }
                aux = teclado.nextInt();

                if(tienda.getClientFromClientXRut(rut).getSize(2) == 3)
                    System.out.println("Limite de arriendos alcanzado, no se pueden arrendar más películas. \n");

            }while(tienda.getClientFromClientXRut(rut).getSize(2) < 3 && aux != 0  );
        }
        else
            System.out.println("Limite de arriendos alcanzado, no se pueden arrendar más películas. \n");
    }

    public static void arrendar(VideoClub tienda){
        Arriendo arriendo;
        int aux;
        String rut;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese rut cliente que va a arrendar['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
        rut = teclado.nextLine();
        if (!tienda.existRUT(rut)){
            System.out.println("rut no registrado.");
        }
        else{
            if(tienda.getClientFromClientXRut(rut).getDeuda() > 0) {
                System.out.println("Primero debe pagar su deuda para poder arrendar otra película \n.");
                return;
            }
            if(tienda.getClientFromClientXRut(rut).getSize(2) < 3){
                do{
                    arriendo = nuevoArriendo(tienda,rut);
                    if(arriendo != null){
                        tienda.getClientFromClientXRut(rut).addToArriendosActuales(arriendo);
                        tienda.getClientFromClientXRut(rut).addToArriendosXid(arriendo);
                        System.out.println("Película arrendada exitosamente.\n");
                        System.out.println("¿Desea arrendar otra película?[Ingrese 1 para seguir o 0 para terminar]");
                    }
                    else{
                        System.out.println("Arriendo no realizado.[Ingrese 0 para salir]");
                    }
                    aux = teclado.nextInt();

                    if(tienda.getClientFromClientXRut(rut).getSize(2) == 3)
                        System.out.println("Limite de arriendos alcanzado, no se pueden arrendar más películas. \n");

                }while(tienda.getClientFromClientXRut(rut).getSize(2) < 3 && aux != 0);
            }
            else
                System.out.println("Limite de arriendos alcanzado, no se pueden arrendar más películas. \n");
        }

    }
//-----------------------------DEVOLVER PELICULA----------------------------------------
    public static void devolverArriendo(VideoClub tienda, String rut){//Menu cliente
        Scanner teclado = new Scanner(System.in);
        long diasAtraso;
        String nombrePeli, id;
        Cliente cliente = tienda.getClientFromClientXRut(rut);
        Arriendo eliminado;
        if(cliente.isEmptyArriendos()){
            System.out.println("Usted no tiene películas arrendadas con nosotros.");
            return;
        }
        do {
            System.out.println("Ingrese el nombre del arriendo que desea devolver.[Ingrese 0 para salir]: " +
                    "(Killer Bean Forever, Bob Esponja: La Pelicula, Shrek, Shrek 2, ¿Quien mató al Capitan Alex?)");
            nombrePeli = teclado.nextLine();
            id = tienda.obtenerIdXNombre(nombrePeli);
            if(!cliente.existIDArriendo(id)){
                System.out.println("Esta película no se encuentra arrendada por usted.");
            }
            else{
                diasAtraso = ChronoUnit.DAYS.between(cliente.getArriendoXId(id).getFechaEntrega(),LocalDate.now());
                tienda.getPeliFromPelisXId(id).setDisponibles((short)(tienda.getPeliFromPelisXId(id).getDisponibles()+1));

                eliminado = cliente.delArriendo2(id);
                System.out.println("¿Qué valoración le da a la película?[de 0.0 a 5.0]");
                eliminado.setValoracion(Float.parseFloat(teclado.nextLine()));
                eliminado.setEntregado(true);
                if(!cliente.existIDHistorial(id)){
                    cliente.addToHistorial(eliminado);
                    cliente.addToArriendosXid(eliminado);
                }
                else{
                    System.out.println("Cliente ha arrendado la película antes, se actualizan los datos...");
                    cliente.getHistorialXId(id).setVecesArrendada(cliente.getHistorialXId(id).getVecesArrendada()+1);
                    cliente.getHistorialXId(id).setFechaArriendo(eliminado.getFechaArriendo());
                    cliente.getHistorialXId(id).setFechaEntrega(eliminado.getFechaEntrega());
                    cliente.getHistorialXId(id).setValoracion(eliminado.getValoracion());
                }

                System.out.println("Película devuelta exitosamente.");

                if(diasAtraso >0){
                    cliente.setDeuda((int)diasAtraso*500);
                }
            }
        }while(!cliente.isEmptyArriendos() && !nombrePeli.equals("0"));

        if(cliente.getDeuda() > 0)
            System.out.println("Debido a la entrega atrasada de una o más películas, ahora usted acumula una " +
                               "deuda de $"+ cliente.getDeuda()+" la cual debe cancelar.");

    }

    public static void devolverArriendo(VideoClub tienda){//Menu Admin
        Scanner teclado = new Scanner(System.in);
        long diasAtraso;
        String nombrePeli, id,rut;
        Cliente cliente;
        Arriendo eliminado;

        do {
            System.out.println("Ingrese rut cliente que va a arrendar['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            rut = teclado.nextLine();
            if (!tienda.existRUT(rut)){
                System.out.println("rut no registrado.");
            }
            else{
                cliente = tienda.getClientFromClientXRut(rut);
                if(cliente.isEmptyArriendos()){
                    System.out.println("Usted no tiene películas arrendadas con nosotros.");
                    return;
                }
                do{
                    System.out.println("Ingrese el nombre del arriendo que desea devolver.[Ingrese 0 para salir]: " +
                            "(Killer Bean Forever, Bob Esponja: La Pelicula, Shrek, Shrek 2, ¿Quien mató al Capitan Alex?)");
                    nombrePeli = teclado.nextLine();
                    id = tienda.obtenerIdXNombre(nombrePeli);
                    if(!cliente.existIDArriendo(id)){
                        System.out.println("Esta película no se encuentra arrendada por usted.");
                    }
                    else {
                        diasAtraso = ChronoUnit.DAYS.between(cliente.getArriendoXId(id).getFechaEntrega(),LocalDate.now());
                        tienda.getPeliFromPelisXId(id).setDisponibles((short)(tienda.getPeliFromPelisXId(id).getDisponibles()+1)); //Se agrega una copia más a las disponibles

                        eliminado = cliente.delArriendo2(id);
                        System.out.println("¿Qué valoración le da a la película?[de 0.0 a 5.0]");
                        eliminado.setValoracion(Float.parseFloat(teclado.nextLine()));
                        eliminado.setEntregado(true);
                        if (!cliente.existIDHistorial(id)) {
                            cliente.addToHistorial(eliminado);
                            cliente.addToArriendosXid(eliminado);
                        } else {
                            System.out.println("Cliente ha arrendado la película antes, se actualizan los datos...");
                            cliente.getHistorialXId(id).setVecesArrendada(cliente.getHistorialXId(id).getVecesArrendada() + 1);
                            cliente.getHistorialXId(id).setFechaArriendo(eliminado.getFechaArriendo());
                            cliente.getHistorialXId(id).setFechaEntrega(eliminado.getFechaEntrega());
                            cliente.getHistorialXId(id).setValoracion(eliminado.getValoracion());
                        }
                        System.out.println("Película devuelta exitosamente.");
                        if(diasAtraso >0){
                            cliente.setDeuda((int)diasAtraso*500);
                        }
                    }
                }while(!cliente.isEmptyArriendos() && !nombrePeli.equals("0"));
                rut = "0";
                if(cliente.getDeuda() > 0)
                    System.out.println("Debido a la entrega atrasada de una o más películas, ahora el cliente acumula una " +
                            "deuda de $"+ cliente.getDeuda()+" la cual debe cancelar.");
            }
        }while(!rut.equals("0"));
    }
//-------------------------------PAGAR DEUDA-----------------------------
    public static void pagarDeuda(Cliente cliente){//Menu cliente
        int monto;
        Scanner teclado = new Scanner(System.in);

        if(cliente.getDeuda()>0){
            System.out.println("Usted tiene una deuda de $"+cliente.getDeuda());
            do {
                System.out.println("Por favor, ingrese el monto exacto de la deuda a cancelar.");
                monto = teclado.nextInt();
            }while(cliente.getDeuda()-monto !=0);
            cliente.setDeuda(0);
            System.out.println("Su deuda ha sido cancelada exitosamente.");
        }
        else
            System.out.println("Usted no registra deuda con nosotros.");
    }

    public static void pagarDeuda(VideoClub tienda){//Menu Admin
        int monto;
        Scanner teclado = new Scanner(System.in);
        String rut;

        do {
            System.out.println("Ingrese rut cliente que va a cancelar deuda['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            rut = teclado.nextLine();
            if (!tienda.existRUT(rut)){
                System.out.println("rut no registrado.");
            }
            else{
                if(tienda.getClientFromClientXRut(rut).getDeuda()>0){
                    System.out.println("Cliente tiene una deuda de $"+tienda.getClientFromClientXRut(rut).getDeuda());
                    do {
                        System.out.println("Por favor, ingrese el monto exacto de la deuda a cancelar.");
                        monto = teclado.nextInt();
                    }while(tienda.getClientFromClientXRut(rut).getDeuda()-monto !=0);
                    tienda.getClientFromClientXRut(rut).setDeuda(0);
                    System.out.println("Deuda de cliente ha sido cancelada exitosamente.");
                }
                else
                    System.out.println("Cliente no registra deuda con nosotros.");
                rut = "0";
            }
        }while(!rut.equals("0"));
    }
//-----------------------------RECOMENDAR PELICULA----------------------------------
    public static void recomendarPelicula(VideoClub tienda, String rut){//No funcionando aun
        String genero,peli = null;
        ArrayList<String> ids = new ArrayList<String>();
        Scanner teclado = new Scanner(System.in);
        float valoracion;

        if(tienda.getClientFromClientXRut(rut).getSize(1) == 0) //Si no tiene historial de arriendos
            System.out.println("Le recomendamos arrendar la película mejor evaluada de la tienda: "+ tienda.peliMejorEvaluada());
        else{
            genero = tienda.getClientFromClientXRut(rut).generoMasVisto(tienda);
            System.out.println("Ingrese la valoración minima que debe tener la película recomendada. [0.0-5.0]");
            valoracion = Float.parseFloat(teclado.nextLine());
            do {
                if(tienda.getClientFromClientXRut(rut).existIDHistorial(tienda.obtenerIdXNombre(tienda.peliMejorEvaluada(genero,ids,valoracion)))){
                    //Si la pelicula ya esta registrada en historial, no se recomienda
                    ids.add(tienda.obtenerIdXNombre(tienda.peliMejorEvaluada(genero)));
                    //Y se descarta para ser la peli mejor evaluada
                }
                else
                    peli = tienda.peliMejorEvaluada(genero,ids,valoracion);
            }while(peli == null && tienda.peliMejorEvaluada(genero,ids,valoracion)!= null);

            if(peli == null || tienda.peliMejorEvaluada(genero,ids,valoracion)== null)
                System.out.println("No tenemos una película para recomendarle según los datos disponibles.");
        }
    }
}  
