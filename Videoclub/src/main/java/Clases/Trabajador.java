package Clases;

import Menú.Funciones;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Trabajador extends Persona implements Transacciones{
    String cargo;
    int sueldo;
    int vecesArriendosAtrasados;
    
    public Trabajador(){
        cargo = null;
        sueldo = 0;
        vecesArriendosAtrasados = 0;
    }
    
//----------------------SETTER/GETTER---------------------
    public void setCargo(String cargo){
        this.cargo = cargo; 
    }
    public void setSueldo(int sueldo){
        this.sueldo = sueldo; 
    }
    public void setVecesArriendosAtrasados(int veces){
        vecesArriendosAtrasados = veces;
    }
    public String getCargo(){
        return cargo; 
    }
    public int getSueldo(){
        return sueldo; 
    }
    public int setVecesArriendosAtrasados(){
        return vecesArriendosAtrasados;
    }
//-------------------IMPREMENTACION FUNCIONES INTERFACE TRANSACCIONES------------------------
    @Override
    public void arrendar(VideoClub tienda){
        Arriendo arriendo;
        int aux;
        String rutCliente;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese rut cliente que va a arrendar['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
        rutCliente = teclado.nextLine();
        if (!tienda.containsRutClientes(rutCliente)){
            System.out.println("rut no registrado.");
        }
        else{
            Funciones.llenarPresentes(tienda, rutCliente);
            if(tienda.getClientFromClientXRut(rutCliente).getDeuda() > 0) {
                System.out.println("Primero debe pagar su deuda para poder arrendar otra película \n.");
                return;
            }
            if(tienda.getClientFromClientXRut(rutCliente).getSize(2) < 3){
                do{
                    arriendo = Funciones.nuevoArriendo(tienda,rutCliente);
                    if(arriendo != null){
                        tienda.getClientFromClientXRut(rutCliente).addToArriendosActuales(arriendo);
                        tienda.getClientFromClientXRut(rutCliente).addToArriendosXid(arriendo);
                        System.out.println("Película arrendada exitosamente.\n");
                        System.out.println("¿Desea arrendar otra película?[Ingrese 1 para seguir o 0 para terminar]");
                    }
                    else{
                        System.out.println("Arriendo no realizado.[Ingrese 0 para salir]");
                    }
                    aux = teclado.nextInt();

                    if(tienda.getClientFromClientXRut(rutCliente).getSize(2) == 3)
                        System.out.println("Limite de arriendos alcanzado, no se pueden arrendar más películas. \n");

                }while(tienda.getClientFromClientXRut(rutCliente).getSize(2) < 3 && aux != 0);
            }
            else
                System.out.println("Limite de arriendos alcanzado, no se pueden arrendar más películas. \n");
        }

    }
    @Override
    public void devolverArriendo(VideoClub tienda){//Menu Admin
        Scanner teclado = new Scanner(System.in);
        long diasAtraso;
        String nombrePeli, id, rutCliente;
        Cliente cliente;
        Arriendo eliminado;
        do {
            System.out.println("Ingrese rut cliente que va a arrendar['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            rutCliente = teclado.nextLine();
            if (!tienda.containsRutClientes(rutCliente)){
                System.out.println("rut no registrado.");
            }
            else{
                Funciones.llenarPresentes(tienda, rutCliente);
                cliente = tienda.getClientFromClientXRut(rutCliente);
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
                        //Calcula dias transcurridos entre dos fechas
                        tienda.getPeliFromPelisXId(id).setDisponibles((short)(tienda.getPeliFromPelisXId(id).getDisponibles()+1));
                        //Se agrega una copia más a las disponibles

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
                rutCliente = "0";
                if(cliente.getDeuda() > 0)
                    System.out.println("Debido a la entrega atrasada de una o más películas, ahora el cliente acumula una " +
                            "deuda de $"+ cliente.getDeuda()+" la cual debe cancelar.");
            }
        }while(!rutCliente.equals("0"));
    }
    @Override
    public void pagarDeuda(VideoClub tienda){//Menu Admin
        int monto;
        Scanner teclado = new Scanner(System.in);
        String rutCliente;
        do {
            System.out.println("Ingrese rut cliente que va a cancelar deuda['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            rutCliente = teclado.nextLine();
            if (!tienda.containsRutClientes(rutCliente)){
                System.out.println("rut no registrado.");
            }
            else{
                Funciones.llenarPresentes(tienda, rutCliente);
                if(tienda.getClientFromClientXRut(rutCliente).getDeuda()>0){
                    System.out.println("Cliente tiene una deuda de $"+tienda.getClientFromClientXRut(rutCliente).getDeuda());
                    do {
                        System.out.println("Por favor, ingrese el monto exacto de la deuda a cancelar.");
                        monto = teclado.nextInt();
                    }while(tienda.getClientFromClientXRut(rutCliente).getDeuda()-monto !=0);
                    tienda.getClientFromClientXRut(rutCliente).setDeuda(0);
                    System.out.println("Deuda de cliente ha sido cancelada exitosamente.");
                }
                else
                    System.out.println("Cliente no registra deuda con nosotros.");
                rutCliente = "0";
            }
        }while(!rutCliente.equals("0"));
    }

//-------------------IMPLEMENTACION METODO ABSTRACTO---------------------------
    @Override
    public void identificacion() {
        System.out.println("Nombre: "+nombre+"\t Rut: "+rut+"\t Cargo de empleado: "+cargo);
    }
}
