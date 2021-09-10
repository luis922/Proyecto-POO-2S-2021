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
        int i = 0;
        do{
            if(i != 0) 
                System.out.println("El rut ingresado no se encuentra en el formato solicitado/es inexistente...");
            else 
                System.out.println("Ingrese el rut con su respectivo \"-\": (20844870-6, 15442310-9, 19034223-3, 10693359-1, 20378533-k)");
            
            rutIngresado = teclado.nextLine();
            i++;
        }while(!formatoCorrectoRut(rutIngresado) || !x.containsRUT(rutIngresado));        
        
        return rutIngresado;
    }
    
    public static boolean formatoCorrectoRut(String rut){
        int i;
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
