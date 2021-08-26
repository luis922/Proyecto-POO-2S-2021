/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author sebas
 */
public class Main {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opción;
        
        do{
            Interfaz.Interface.login();
            opción = entrada.nextInt();
            switch(opción){
                 case 1:
                    ;//Se llama a una función que verifique si el rut a ingresar está en la base de datos
                case 2:
                    ;
                default:
                    if(opción != 0) System.out.println("Ingrese una opción válida...");
            }
        
            
        }while(opción != 0);
        
        
    }
    
}
