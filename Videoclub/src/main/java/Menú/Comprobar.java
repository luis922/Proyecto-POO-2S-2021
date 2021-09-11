/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menú;
import java.util.*;
import Clases.*;
/**
 *
 * @author sebas
 */

public class Comprobar {
    public static String loginClientes(VideoClub x){
        Scanner teclado = new Scanner(System.in);
        String rutIngresado;
        System.out.println("Ingrese el rut con su respectivo '-' ['0' para terminar]: (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
        do{
            rutIngresado = teclado.nextLine();
            if(!formatoCorrectoRut(rutIngresado)){
               System.out.println("Formato de rut incorrecot ingrese nuevamente['0' para terminar]");
            }
            else if(!x.containsRUT(rutIngresado)){
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
}
