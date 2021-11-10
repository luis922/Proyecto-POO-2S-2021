/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Clases.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;



public class Funciones {

    
    public static void listaPeliculas(VideoClub x){
        System.out.println("Listado de películas: ");
        x.mostrarDatosPeliculas();
        
    }
    
    public static void listaClientes(VideoClub x){
        System.out.println("Listado de Clientes: ");
        x.mostrarDatosClientes();
    }

//-----------------COMPROBAR-----------------------------------
    public static String loginTrabajadores(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String rutIngresado;
        System.out.println("Ingrese el rut con su respectivo '-' ['0' para terminar]: rut (1-1, 2-2, 3-3, 4-4)");
        do{
            rutIngresado = teclado.nextLine();
            if(!formatoCorrectoRut(rutIngresado)){
                System.out.println("Formato de rut incorrecot ingrese nuevamente['0' para terminar]");
            }
            else if(!x.containsRutTrabajadores(rutIngresado)){
                System.out.println("Usuario no se encuentra registrado, ingrese nuevamente['0' para terminar]");
            }
            else
                return rutIngresado;
        }while(!rutIngresado.equals("0"));
        return null;
    }
    public static String loginClientes(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String rutIngresado;
        System.out.println("Ingrese el rut con su respectivo '-' ['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
        do{
            rutIngresado = teclado.nextLine();
            if(!formatoCorrectoRut(rutIngresado)){
                System.out.println("Formato de rut incorrecot ingrese nuevamente['0' para terminar]");
            }
            else if(!x.containsRutClientes(rutIngresado)){
                System.out.println("Usuario no se encuentra registrado, ingrese nuevamente['0' para terminar]");
            }
            else
                return rutIngresado;
        }while(!rutIngresado.equals("0"));
        return null;
    }

    public static boolean formatoCorrectoRut(String rut){
        int i;
        if (rut.equals("0"))
            return true;
        for(i=0; i<rut.length(); i++){
            if(i<rut.length()-2 && !Character.isDigit(rut.charAt(i)))
                return false;
            else if(i == rut.length()-2 && rut.charAt(i) != '-'){
                return false;
            }
            else if(i == rut.length()-1 && !Character.isDigit(rut.charAt(i)) && rut.charAt(i) != 'k' ){
                return false;
            }
        }
        return true;
    }

    public static boolean formatoCorrectoValuacion(float Valuacion){
        return (Valuacion <= 5 && Valuacion >= 1);
    }

    public static String loginPelicula(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String nombre;
        int contador = 0;
        System.out.println("Ingrese el nombre de la película que desea editar:");

        do{

            if(contador != 0) System.out.println("La pelicula ingresada no se encuentra en nuestro registro, intentelo nuevamente\n(ingrese \"0\" para cancelar)");
            nombre = teclado.nextLine();
            contador++;

        }while(x.containsIdPeliculas(x.obtenerIdXNombre(nombre)) == false && nombre.equals("0"));

        if(nombre.equals("0")) return nombre;

        return x.obtenerIdXNombre(nombre);
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
            if(x.containsRutClientes(rut)){
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
    
//------------------REGISTRO NUEVO CLIENTE----------------------
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
        }while(!formatoCorrectoRut(nuevo.getRut()));
        
        x.addClientToListaClients(nuevo);
        x.addClientToClientXRut(nuevo.getRut(), nuevo);
        System.out.println("¡Cliente registrado exitosamente!");
    }
    
//------------------REGISTRO NUEVA PELICULA----------------------
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
    
//------------------REGISTRO NUEVO HISTORIAL---------------------
    public static void registrarHistorial(VideoClub x){
        String rut, nombrePeli, id;
        Arriendo arriendo;
        Scanner teclado = new Scanner(System.in);
        LocalDate fechaEntrega, fechaArriendo;
        do{
            System.out.println("Ingrese rut cliente que va a registrar['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            rut = teclado.nextLine();
            if (!x.containsRutClientes(rut)){
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
    
///-----------------INGRESOS---------------------------------------
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
        }while(!formatoCorrectoValuacion(valuacion));
        
        return valuacion;
        
    }
    
//------------------BUSQUEDA---------------------------------------
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
            if(x.containsRutClientes(rut)){
                x.mostrarDatosClientes(rut);
                break;
            }
            else if (!rut.equals("0")){
                System.out.println("Cliente no se encuentra registrado.");
                System.out.println("Ingrese rut nuevamente o '0' para terminar: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            }
        }while(!rut.equals("0"));
    }
    
//------------------LECTURA DE DATOS DESDE ARCHIVO-----------------
    public static void LeerArchivoClientes(VideoClub videoClub)throws FileNotFoundException{
        File flClientes = new File("./src/main/java/data/clientes.tsv"); //Abre el archivo a leer
        Scanner scCli = new Scanner(flClientes);
        String linea; //Almacena la linea que se esta leyendo
        String[] arrayLineaClientes; //Lista almacena la linea leida separados por tabulaciones
        scCli.nextLine(); //Salta la primera linea
        Arriendo arriendo;
        Cliente cliente;
        int i;
	while(scCli.hasNextLine()){
            linea = scCli.nextLine(); //Lee la linea siguiente
            arrayLineaClientes = linea.split("\t"); //Separa la linea en base a las tabulaciones
            //Guardar Datos en array de Clientes: [0]=nombre, [1]=rut, [2]=historial arriendos , [3]=pelPosesion, [4]=Deuda
            cliente = new Cliente();
            cliente.setNombre(arrayLineaClientes[0]);
            cliente.setRut(arrayLineaClientes[1]);
            for(i=0; i<arrayLineaClientes[2].split("_").length; i++){ //Recorre la lista de de los sarriendos separados por "_"
                arriendo = new Arriendo();
                arriendo.setId(arrayLineaClientes[2].split("_")[i]);
                cliente.addToHistorial(arriendo); //Agrega el arriendo a la lista
                cliente.addToHistorialXid(arriendo); //Agrega el arriendo al hashmap
            }
            cliente.setDeuda(Integer.parseInt(arrayLineaClientes[4]));
            videoClub.addClientToListaClients(cliente); //Agrega cliente a la lista de clientes
            videoClub.addClientToClientXRut(arrayLineaClientes[1], cliente); //Agrega el cliente al hashmap
            }
    }
    
    public static void LeerArchivoPeliculas(VideoClub videoClub) throws FileNotFoundException{
        File flPeliculas = new File("./src/main/java/data/peliculas.tsv"); //Abre archivo a leer
	Scanner scPel = new Scanner(flPeliculas);
        String linea; //Almacena la linea que se esta leyendo
        String[] arrayLineaPeliculas; //Lista almacena la linea leida separados por tabulaciones
        scPel.nextLine(); //Salta la primera linea
        Pelicula pelicula;
        while(scPel.hasNextLine()){
                linea = scPel.nextLine(); //Lee la linea siguiente
                arrayLineaPeliculas = linea.split("\t"); //Separa la linea en base a las tabulaciones
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
                videoClub.addPeliToListaPelis(pelicula); //Agrega la pelicula a la lista de peliculas
                videoClub.addPeliToPelisXId(pelicula.getId(),pelicula); //Agrega la pelicula al hashmap
        }
    }
    public static void LeerArchivoTrabajadores(VideoClub tienda) throws FileNotFoundException{
        File flTrabajadores = new File("./src/main/java/data/trabajadores.tsv"); //Abre archivo a leer
	Scanner scTra = new Scanner(flTrabajadores);
        String linea; //Almacena la linea que se esta leyendo
        String[] arrayLineaTrabajadores; //Lista almacena la linea leida separados por tabulaciones
        scTra.nextLine(); //Salta la primera linea
        Trabajador trabajador;
        while(scTra.hasNextLine()){
                linea = scTra.nextLine(); //Lee la linea siguiente
                arrayLineaTrabajadores = linea.split("\t"); //Separa la linea en base a las tabulaciones
                //Guardar Datos en array de Peliculas
                trabajador = new Trabajador();
                trabajador.setNombre(arrayLineaTrabajadores[0]);
                trabajador.setRut(arrayLineaTrabajadores[1]);
                trabajador.setCargo(arrayLineaTrabajadores[2]);
                trabajador.setSueldo(Integer.parseInt(arrayLineaTrabajadores[3]));
                trabajador.setVecesArriendosAtrasados(Integer.parseInt(arrayLineaTrabajadores[4]));
                trabajador.setDeuda(Integer.parseInt(arrayLineaTrabajadores[5]));
                tienda.addTrabajadorToTrabajadoresXRut(trabajador.getRut(),trabajador); //Agrega la pelicula al hashmap
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
        }while(!x.containsIdPeliculas(x.obtenerIdXNombre(nombre)) && !nombre.equals("0"));
        if(!nombre.equals("0")){
            Pelicula ay = x.getPeliFromPelisXId(x.obtenerIdXNombre(nombre));
            System.out.println("¿Está seguro de eliminar la película \"" + ay.getNombre() + "\" de la base de datos?\n1)Sí\n2)No");
            
            switch(teclado.nextLine()){
                case "1":
                    x.delPelicula(ay.getId());
                    if(x.containsIdPeliculas(x.obtenerIdXNombre(nombre))) System.out.println("Operación Falló");//Dudo que se use pero podría ahorrarnos un dolor de cabeza
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
        }while(!x.containsRutClientes(rut) && !rut.equals("0"));
        if(!rut.equals("0")) {
            Cliente ay = x.getClientFromClientXRut(rut);
            System.out.println("¿Está seguro de eliminar al Sr(a) \"" + ay.getNombre()+ "\" de la base de datos?\n1)Sí\n2)No");
            
            switch(teclado.nextLine()){
                case "1":
                    x.delCliente(rut);
                    if(x.containsRutClientes(rut)) System.out.println("Operación Falló");//Same as the other
                    else System.out.println("¡Operación realizada con exito!\nVolviendo al menú principal...");
                    break;
                case "2":
                    System.out.println("Operación cancelada...\nVolviendo al menú principal...");
                    break;
            }
        }
    }
	
//-----------------------------ARRENDAR PELICULAS--------------------------------------
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
                            //Agregar comprobación para evitar que se ingresen fechas de entregas anteriores a la de arriendo
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
//-------------------------------PAGAR DEUDA-------------------------------------------

    public static void pagarDeuda(VideoClub tienda){//Menu Admin
        int monto;
        Scanner teclado = new Scanner(System.in);
        String rut;

        do {
            System.out.println("Ingrese rut cliente que va a cancelar deuda['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            rut = teclado.nextLine();
            if (!tienda.containsRutClientes(rut)){
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

//-----------------------------FILTRAR PELÍCULAS---------------------------------------
    
    public static void filtradoPorAño(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        int i = 0,aux = 0;
        short desde, hasta,año;

        do{
            if(i != 0) System.out.println("Ingrese un rango valido");
            System.out.println("Ingrese el añó de inicio:");
            desde = teclado.nextShort();
            System.out.println("Ingrese el añó de termino:");
            hasta = teclado.nextShort();
            teclado.nextLine();
            i++;
        }while(desde > hasta);

        for (i = 0;i < tienda.getSize(2); i++){
            año = tienda.getPeliFromPelisXId(Integer.toString(i)).getAñoEstreno();
            if(año <= hasta && año >= desde){
                tienda.mostrarDatosPeliculas(Integer.toString(i));
                aux++;
            }
        }
        System.out.println("Se encontraron " + aux + " peliculas con el parametro ingresado");
    }

    public static void filtradoPorValuación(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        int i = 0,aux = 0;
        float desde, hasta,valuación;

        do{
            if(i != 0) System.out.println("Ingrese un rango valido");
            System.out.println("**El sistema de Valuación funciona entre 0.1 y 5.0**");
            System.out.println("Ingrese la menor valuación a buscar:");
            desde = teclado.nextFloat();
            System.out.println("Ingrese la mayor valuación a buscar:");
            hasta = teclado.nextFloat();
            teclado.nextLine();
            i++;
        }while(desde > hasta && desde > 5 && desde < 0 && hasta > 5 && hasta < 0 );

        for(i = 0; i < tienda.getSize(1); i++){
            valuación = tienda.getPeliFromPelisXId(Integer.toString(i)).getValuacion();
            if(valuación <= hasta && valuación >= desde){
                tienda.mostrarDatosPeliculas(Integer.toString(i));
                aux++;
            }
        }
        
        System.out.println("Se encontraron " + aux + " peliculas con el parametro ingresado");
    }

    public static void filtradoPorGénero(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        int cont = 0;
        byte iteraciones = 0;
        String género;
        String [] generos;
        do{
            if(iteraciones != 0) System.out.println("El género no se encuentra en nuestro catálogo, intentelo nuevamente");
            System.out.println("Ingrese el Género que desea buscar: **Ingrese 0 para salir**");
            género = teclado.nextLine();
            System.out.println("leído");
            
            if(!género.equals("0")){
                for(int i = 0; i < tienda.getSize(2); i++){
                    generos = tienda.getPeliFromPelisXId(Integer.toString(i)).getGeneros();
                    for(int j = 0; j < generos.length;j++){
                        if(género.equals(generos[j])){
                            cont++;
                            tienda.mostrarDatosPeliculas(Integer.toString(i));
                        }
                    }
                }
            }
            
            iteraciones++; 
        }while(cont == 0 && !género.equals("0"));
        if(cont != 0) System.out.println("Se encontraron " + cont + " peliculas con el parametro ingresado");
    }
    
    public static void filtradoDisponibles(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        byte opción,aux = 0;
        int i = 0;
        do{
            if(i != 0) System.out.println("Ingrese una opción valida...");
            System.out.println("Seleccione Disponibilidad:");
            System.out.println("1)Disponibles\n2)No disponibles");
            opción = teclado.nextByte();
            teclado.nextLine();
            i++;
        }while(opción != 1 && opción != 2);
        
        for(i = 0; i < tienda.getSize(2); i++){
            
            switch(opción){
                
                case 1:
                    if(tienda.getPeliFromPelisXId(Integer.toString(i)).getExistencias() > 0){
                        tienda.mostrarDatosPeliculas(Integer.toString(i));
                        aux++;
                    }
                    break;
                case 2:
                    if(tienda.getPeliFromPelisXId(Integer.toString(i)).getExistencias() == 0){
                        tienda.mostrarDatosPeliculas(Integer.toString(i));
                        aux++;
                    }
                    break;     
            }
        }
        System.out.println("Se encontraron " + aux + " peliculas con el parametro ingresado");
    }
    
    public static void filtradoDirector(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        int cont = 0,i = 0,j;
        String []directores;
        String director;
        do{
            if(i != 0) System.out.println("El director no se encuentra en nuestro catálogo, inténtelo nuevamente");
            System.out.println("Ingrese el director a buscar: **Ingrese 0 para salir**");
            director = teclado.nextLine();
            
            for(i = 0; i < tienda.getSize(2); i++){
                directores = tienda.getPeliFromPelisXId(Integer.toString(i)).getDirector();
                
                for(j = 0; j < directores.length; j++){
                    if(director.equals(directores[j])){
                        tienda.mostrarDatosPeliculas(Integer.toString(i));
                        cont++;
                    }
                }
            }
            i++;
        }while(cont == 0 && !director.equals("0"));
        
        if(cont != 0) System.out.println("Se encontraron " + cont + " pelicula con el parametro ingresado");
    }
    
    public static void filtradoCalidad(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        int cont = 0,i = 0;
        String calidad;
        
        do{
            if(i != 0) System.out.println("La calidad no se encuentra en nuestro catalogo, intentelo nuevamente");
            System.out.println("Ingrese la calidad a buscar **Ingrese 0 para salir**");
            calidad = teclado.nextLine();
            
            for(i = 0; i < tienda.getSize(2); i++){
                
                if(calidad.equals(tienda.getPeliFromPelisXId(Integer.toString(i)).getCalidad())){
                    cont++;
                    tienda.mostrarDatosPeliculas(Integer.toString(i));
                }
            }
            i++;
        }while(cont == 0 && !calidad.equals("0"));
        
        if(cont != 0) System.out.println("Se encontraron " + cont + " pelicula con el parametro ingresado");
    }
    
    public static void filtradoDuración(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        int i = 0, cont = 0;
        short desde,hasta,minutos;
        
        do{
            if( i != 0) System.out.println("Introduzca un rango valido");
            System.out.println("Ingrese la menor cantidad de minutos:");
            desde = teclado.nextShort();
            System.out.println("Ingrese la mayor cantidad de minutos:");
            hasta = teclado.nextShort();
            
        }while(desde > hasta);
        
        for(i = 0; i < tienda.getSize(2); i++){
            minutos = tienda.getPeliFromPelisXId(Integer.toString(i)).getDuraciónMin();
            
            if(minutos <= hasta && minutos >= desde){
                cont++;
                tienda.mostrarDatosPeliculas(Integer.toString(i));
            }
        }
        System.out.println("Se encontraron " + cont + " pelicula con el parametro ingresado");
    }

//-----------------------------OTROS------------------------------------------------
    public static void llenarPresentes (VideoClub tienda, String rut){

        if(tienda.containsRutTrabajadores(rut) && !tienda.containsRutPresentes(rut))
            tienda.addPersonaToPresentesXRut(rut,tienda.getTrabajadorFromTrabajadoresXRut(rut));
        else
            if(tienda.containsRutClientes(rut) && !tienda.containsRutPresentes(rut))
                tienda.addPersonaToPresentesXRut(rut,tienda.getClientFromClientXRut(rut));
    }

//-----------------------------RECOMENDAR PELICULA----------------------------------
    //Por implementar
   /* public static void recomendarPelicula(VideoClub tienda, String rut){//No funcionando aun
        String genero,peli = null;
        ArrayList<String> ids = new ArrayList<>();
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
    }*/

}  

