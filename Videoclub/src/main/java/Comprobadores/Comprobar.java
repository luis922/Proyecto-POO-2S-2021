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

/*
public class Comprobar {
    public static void loginClientes(VideoClub x){
        Scanner aux = new Scanner(System.in);
        String rutIngresado;
        ArrayList<Cliente> Lista = x.getListaClientes();
        do{
            rutIngresado = aux.nextLine();
        }while(formatoCorrectoRut(rutIngresado) != true);
        
        for(int i = 0;i < Lista.size();i++){
            if(rutIngresado.equals(Lista.get(i).getRut()));
        }
    }
    public static boolean formatoCorrectoRut(String rut){
        int puntos = 0;
        int guión = 0;
        int letras = 0;
        for(int i = 0;i < rut.length();i++){
            if(rut.charAt(i) == '.') puntos++;
            if(rut.charAt(i) == '-') guión++;
            if(Character.isDigit(rut.charAt(i)) == false) letras ++;
        }
        if(puntos == 3 && guión == 1 && letras == 1){
            return true;
        }
        return false;
    }
}
*/