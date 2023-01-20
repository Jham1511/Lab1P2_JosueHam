package lab1p2_josueham;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Lab1P2_JosueHam {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        int opcion = Menu();

        while (opcion != 4) {

            switch (opcion) {

                case 1: {
                    System.out.println("Ingrese la cantidad de discos: ");
                    int cant = leer.nextInt();

                    hanoi(cant, 1, 2, 3);
                }//Fin case 1
                break;

                case 2: {

                    System.out.println("Ingrese la cadena: ");
                    String cadena = leer.next();

                    Fechas(cadena);
                }//Fin case 2
                break;

                case 3: {
                    System.out.println("Ingrese el limite de la sumatoria: ");
                    int k = leer.nextInt();
                    
                    System.out.println("El resultado de la sumatoria es de: " + numeroPi(k,0,0));
                }//Fin case 3
                break;

                default:
                    System.out.println("Saliendo...");

            }//Fin del switch
            opcion = Menu();
        }//Fin del while 

    }//Fin del main 

    public static int Menu() {
        String menu = "----- Bienvenido al menu del programa -----"
                + "\n1 -> Ejercicio 1 (Torres de Hanoi)"
                + "\n2 -> Ejercicio 2(Buscar Fechas)"
                + "\n3 -> Ejercicio 3 (pi)"
                + "\n4 -> Salir"
                + "\nIngrese la opcion que desea: ";
        System.out.println(menu);
        int opcion = leer.nextInt();
        leer.nextLine();
        return opcion;
    }//Metodo menu

    public static void hanoi(int n, int origen, int aux, int destino) {
        if (n == 1) {
            System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
            return;
        } else {
            hanoi(1, origen, destino, aux);
            System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
            hanoi(n-1,aux,origen,destino);
            return;
        }//Fin else

    }//Fin del metodo hanoi

    public static void Fechas(String cadena) throws ParseException {
        String[] tokens = cadena.split(",");
        
        for (int i = 0; i < tokens.length; i++) {
            
            if (tokens[i].contains("/")) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                
                Date fecha = sdf.parse(tokens[i]);
                System.out.println(fecha);
            }
            
        }
    }//Fin del metodo para encontrar fechas 
    
    
    public static double numeroPi (int k, int n, double ecua){
        double potencia = Math.pow(-1, n);
        ecua += potencia/(2*n+1);
        
        if (n == k) {
            double pi = 4 * ecua;
            return pi;
        } else {
            return numeroPi(k, n+1,ecua);
        }//Fin else
        
        
       
    }//Fin metodo de pi
}//Fin de la clase
