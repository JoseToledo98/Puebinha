package app;
import java.util.*;
public class Laberinto {
private int[][] laberinto= new int[10][10];
static Random rd= new Random(System.currentTimeMillis());
Grafo grafo= new Grafo();

public void crearMatriz(int dimension, int porcentaje) {
	System.out.println("porcesando matriz con dimension: "+dimension+" * "+dimension+" un porcentaje de: "+porcentaje);
	int celdasPorcentaje=(porcentaje*(dimension*dimension))/100;
	int contador=1;
	System.out.println("el numero de celdas con pared es de: "+celdasPorcentaje);
	for(int i=0; i<dimension; i++) {
		for(int j=0; j<dimension; j++) {
			if( i==0 && j==0 ) {
				//marco la entrada en [0][0]
				laberinto[i][j]=-1;
				//hello bajaina
				
			}else {
				
			if(i==dimension-1 && j== dimension-1) {
				//marco la salida en [dimension][dimension]
				laberinto[i][j]=-2;
				
			}	else {
				//creo la ponderacion
				int ponderacion=rd.nextInt(10)+1;
				laberinto[i][j]=ponderacion;
				
			}
		
			}
			
			
		}
	}
	//creo las paredes
	for(int f=0; f<celdasPorcentaje; f++) {
		int fila=rd.nextInt(dimension);
		int columna=rd.nextInt(dimension);
		
		if(laberinto[fila][columna] !=-1 && laberinto[fila][columna] != -2) {
			laberinto[fila][columna]=0;
			
		}else {
			f--;
			
		}
	}
	System.out.println("\n");
	
	for(int h=0; h<dimension; h++) {
		for(int g=0; g<dimension; g++) {
			System.out.print("["+laberinto[h][g]+"] ");
		}
		System.out.println();
	}
	
	grafo.generarGrafo(laberinto, dimension);
	
	//holamunfo
}









}
