/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

public class Trabajador extends Persona implements Transacciones{
    String cargo;
    int sueldo;
    int vecesArriendosAtrasados;
    
    public void arrendar(){
    }
    public void devolverArriendo(){
    }
    public void pagarDeuda(){
    }

//-------------------IMPLEMENTACION METODO ABSTRACTO---------------------------
    @Override
    public void identificacion() {
        System.out.println("Nombre: "+nombre+" Rut: "+rut+" Cargo de empleado: "+cargo);
    }

}
