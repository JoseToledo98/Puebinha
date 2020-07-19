package app;
import java.util.*;
public class Principal {
static Scanner sc= new Scanner(System.in);
static Laberinto lab= new Laberinto(); 
	public static void main(String[] args) {
		int porcentaje;
		int dimension;
		
		do {
			System.out.println("ingresa la dimension de tu laberinto (fila*columna) < 11");
			dimension=sc.nextInt();
		}while(dimension<1 | dimension>10);
		
		
		do {
			System.out.println("su matriz sera de "+(dimension*dimension)+" celdas, que porcentaje(%) de paredes necesita 10-50");
			 porcentaje=sc.nextInt();
		}while(porcentaje <10 | porcentaje>50);
		
		lab.crearMatriz(dimension,porcentaje);
}
}
