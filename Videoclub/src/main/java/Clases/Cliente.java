package Clases;


import Menu.Funciones;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Cliente extends Persona implements Transacciones{
    private ArrayList<Arriendo> historialArriendos; //Coleccion de objetos 1 anidación.
    private HashMap<String, Arriendo> historialXid;
    //Podria aplicarse un descuento al primer arriendo

    public Cliente() {
        super();
        historialArriendos = new ArrayList<>();
        historialXid = new HashMap<>();
    }
    
    public Cliente(String nombre, String rut){ //Para el ingreso de un cliente nuevo, no existente en la base de datos.
        super(nombre, rut);
        historialArriendos = new ArrayList<>();
        historialXid = new HashMap<>();
    }
    
//------------------SETTER/GETTER---------------------------------

    public Arriendo getHistorialXId(String id){
        return historialXid.get(id);
    }

//------------------AGREGA ELEMENTOS A HISTORIAL------------------
    public void addToHistorialXid(Arriendo arriendo) {
        this.historialXid.put(arriendo.getId(), arriendo);
    }
    
    public void addToHistorial(Arriendo arriendo) {
        historialArriendos.add(arriendo);
    }

//------------------MOSTRAR HISTORIAL------------------

    //Muestra todas las películas arrendadas y sus datos
    public void mostrarHistorial(VideoClub tienda){
        for (int i = 0; i < historialArriendos.size(); i++) {
            System.out.println("Nombre película: "+ tienda.getPeliFromPelisXId(historialArriendos.get(i).getId()).getNombre());
            System.out.println("ID película: "+historialArriendos.get(i).getId());
            System.out.print("Valoración : ");
            if(!historialArriendos.get(i).isEntregado())
                System.out.println("N0 REGISTRADA");
            else
                System.out.println(historialArriendos.get(i).getValoracion());
            System.out.println("Fecha de arriendo: "+historialArriendos.get(i).getFechaArriendo());
            System.out.println("Fecha de entrega: "+historialArriendos.get(i).getFechaEntrega());
            System.out.println("Veces arrendada: "+historialArriendos.get(i).getVecesArrendada());
            System.out.print("Estado de entrega: ");
            if(historialArriendos.get(i).isEntregado())
                System.out.println(" ENTREGADO");
            else
                System.out.println(" NO ENTREGADO");
            System.out.println();
        }
    }
    
    public String retornarHistorialCliente(VideoClub tienda){
        String datos = "";
        for (Arriendo arriendo : historialArriendos) {
            datos += "Nombre película: " + tienda.getPeliFromPelisXId(arriendo.getId()).getNombre();
            datos += "\nID película: " + arriendo.getId();
            datos += "\nValoración : ";
            if(!arriendo.isEntregado())
                datos += "N0 REGISTRADA";
            else
                datos += arriendo.getValoracion();
            datos += "\nFecha de arriendo: "+ arriendo.getFechaArriendo();
            datos += "\nFecha de entrega: " + arriendo.getFechaEntrega();
            datos += "\nVeces arrendada: "  + arriendo.getVecesArrendada();
            datos += "\nEstado de entrega: ";
            if(arriendo.isEntregado())
                datos += " ENTREGADO\n\n";
            else
                datos += " NO ENTREGADO\n\n";
        }
        return datos;
    }

    //Muestra el historial de arriendo de una película
    public void mostrarHistorial(String id){
        if(historialXid.containsKey(id)) {
            System.out.println("ID pelicula: "+historialXid.get(id).getId());
            System.out.print("Valoración : ");
            if(!historialXid.get(id).isEntregado())
                System.out.println("N0 REGISTRADA");
            else
                System.out.println(historialXid.get(id).getValoracion());
            System.out.println("Fecha de arriendo: "+historialXid.get(id).getFechaArriendo());
            System.out.println("Fecha de entrega: "+historialXid.get(id).getFechaEntrega());
            System.out.print("Estado de entrega: ");
            if(historialXid.get(id).isEntregado())
                System.out.println(" ENTREGADO");
            else
                System.out.println(" NO ENTREGADO");
        }
        else
            System.out.println("Ingrese una id valida");
    }
    
//------------------COMPRUEBA------------------

    public boolean existIDHistorial(String id){//Comprueba si la pelicula ya fue arrendada en base al ID otorgado
        return historialXid.containsKey(id);
    }

//-------------------IMPLEMENTACION METODO ABSTRACTO/SOBREESCRITURA---------------------------
    @Override
    public void identificacion() {
        System.out.print("Nombre: "+nombre+"\t Rut: "+rut+"\t Tipo Cliente: ");
        if (arriendosActuales.isEmpty() && historialArriendos.isEmpty())
            System.out.println("NUEVO");
        else
            System.out.println("ANTIGUO");
    }
    @Override
    public void arrendar(VideoClub tienda){
        Arriendo arriendo;
        int aux;
        Scanner teclado = new Scanner(System.in);

        if(getDeuda() > 0) {
            System.out.println("Primero debe pagar su deuda para poder arrendar otra película");
            return;
        }
        if(getSize(2) < 3){
            do{
                arriendo = Funciones.nuevoArriendo(tienda,rut);
                if(arriendo != null){
                    addToArriendosActuales(arriendo);
                    addToArriendosXid(arriendo);
                    System.out.println("Película arrendada exitosamente.\n");
                    System.out.println("¿Desea arrendar otra película?[Ingrese 1 para seguir o 0 para terminar]");
                }
                else{
                    System.out.println("Arriendo no realizado.[Ingrese 0 para salir]");
                }
                aux = teclado.nextInt();

                if(getSize(2) == 3)
                    System.out.println("Limite de arriendos alcanzado, no se pueden arrendar más películas. \n");

            }while(getSize(2) < 3 && aux != 0  );
        }
        else
            System.out.println("Limite de arriendos alcanzado, no se pueden arrendar más películas. \n");
    }
    @Override
    public void devolverArriendo(VideoClub tienda){
        Scanner teclado = new Scanner(System.in);
        long diasAtraso;
        String nombrePeli, id;
        Arriendo eliminado;
        if(isEmptyArriendos()){
            System.out.println("Usted no tiene películas arrendadas con nosotros.");
            return;
        }
        do {
            System.out.println("Ingrese el nombre del arriendo que desea devolver.[Ingrese 0 para salir]: " +
                    "(Killer Bean Forever, Bob Esponja: La Película, Shrek, Shrek 2, ¿Quien mató al Capitan Alex?)");
            nombrePeli = teclado.nextLine();
            id = tienda.obtenerIdXNombre(nombrePeli);
            if(!existIDArriendo(id)){
                System.out.println("Esta película no se encuentra arrendada por usted.");
            }
            else{
                diasAtraso = ChronoUnit.DAYS.between(getArriendoXId(id).getFechaEntrega(), LocalDate.now());
                //Calcula dias transcurridos entre dos fechas, puede ser un número positivo(no atraso)
                tienda.getPeliFromPelisXId(id).setDisponibles((short)(tienda.getPeliFromPelisXId(id).getDisponibles()+1));
                //Se agrega una copia más a las disponibles

                eliminado = delArriendo2(id);
                System.out.println("¿Qué valoración le da a la película?[de 0.0 a 5.0]");
                eliminado.setValoracion(Float.parseFloat(teclado.nextLine()));
                eliminado.setEntregado(true);
                if(!existIDHistorial(id)){
                    addToHistorial(eliminado);
                    addToArriendosXid(eliminado);
                }
                else{
                    System.out.println("Cliente ha arrendado la película antes, se actualizan los datos...");
                    getHistorialXId(id).setVecesArrendada(getHistorialXId(id).getVecesArrendada()+1);
                    getHistorialXId(id).setFechaArriendo(eliminado.getFechaArriendo());
                    getHistorialXId(id).setFechaEntrega(eliminado.getFechaEntrega());
                    getHistorialXId(id).setValoracion(eliminado.getValoracion());
                }

                System.out.println("Película devuelta exitosamente.");

                if(diasAtraso >0){
                    setDeuda((int)diasAtraso*500);
                }
            }
        }while(!isEmptyArriendos() && !nombrePeli.equals("0"));

        if(getDeuda() > 0)
            System.out.println("Debido a la entrega atrasada de una o más películas, ahora usted acumula una " +
                    "deuda de $"+ getDeuda()+" la cual debe cancelar.");

    }
    @Override
    public void pagarDeuda(VideoClub tienda){//Menu cliente
        int monto;
        Scanner teclado = new Scanner(System.in);

        if(getDeuda()>0){
            System.out.println("Usted tiene una deuda de $"+getDeuda());
            do {
                System.out.println("Por favor, ingrese el monto exacto de la deuda a cancelar.");
                monto = teclado.nextInt();
            }while(getDeuda()-monto !=0);
            setDeuda(0);
            System.out.println("Su deuda ha sido cancelada exitosamente.");
        }
        else
            System.out.println("Usted no registra deuda con nosotros.");
    }
//-----------------Otros-----------------------
    public int getSize(int modo){
        switch(modo){
            case 1: return historialArriendos.size();
            case 2: return arriendosActuales.size();
        }
        return 0;
    }

    public int contarGeneroEnHistorial(VideoClub tienda,String genero){
        //cuenta cuantas veces se ha visto una pelicula que contenga la categoria ingresada, esta puede ser la categoría principal o no
        int contador = 0;
        for (int i = 0; i <historialArriendos.size() ; i++) {
           if(tienda.containsGenero(historialArriendos.get(i).getId(),genero))
               contador += historialArriendos.get(i).getVecesArrendada();
        }
        return contador;
    }

    public String generoMasVisto(VideoClub tienda){
        String genero = null, generoPrincipal;
        int vecesVista = 0;
        for (int i = 0; i <historialArriendos.size() ; i++) {
            generoPrincipal = tienda.getPeliFromPelisXId(historialArriendos.get(i).getId()).getGeneros()[0];
            if (genero == null || contarGeneroEnHistorial(tienda,generoPrincipal) > vecesVista){
                genero = generoPrincipal;
                vecesVista = contarGeneroEnHistorial(tienda,generoPrincipal);
            }
        }
        return genero;
    }

}