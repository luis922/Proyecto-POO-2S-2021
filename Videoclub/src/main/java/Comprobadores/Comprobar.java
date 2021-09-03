/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comprobadores;
import java.util.*;
import Clases.*;
/**
 *
 * @author sebas
 */


public class Comprobar {
    public static String loginClientes(VideoClub x){
        Scanner aux = new Scanner(System.in);
        String rutIngresado;
        int i = 0;
        do{
            if(i != 0) System.out.println("El rut ingresado no se encuentra en el formato solicitado/es inexistente...");
            else System.out.println("Ingrese el rut con su respectivo \"-\": ");
            rutIngresado = aux.nextLine();
            i++;
        }while(formatoCorrectoRut(rutIngresado) != true || x.containsRUT(rutIngresado)==false);
        
        return rutIngresado;
    }
    
    public static boolean formatoCorrectoRut(String rut){
        int guión = 0;
        int letras = 0;
        for(int i = 0;i < rut.length();i++){
            if(rut.charAt(i) == '-') guión++;
            if(Character.isDigit(rut.charAt(i)) == false) letras ++;
        }
        if(guión == 1 && letras <= 1){
            return true;
        }
        else return false;
    }
}
