/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import java.util.Scanner;
/**
 *
 * @author sebas
 */


public class Interface {
    public static void login(){
        Scanner entrada = new Scanner(System.in);
        int i;
        
        do{
            System.out.println("Porfavor, seleccione tipo de Usuario: ");
            System.out.println("1)Cliente");
            System.out.println("2)Trabajador");
        
            i = entrada.nextInt();
            switch(i){
                case 1:
                    ;
                case 2:
                    ;
                default:
                    if(i != 0) System.out.println("Ingrese una opción válida...");
            }
            
        }while(i != 0);
    }
}
