package app;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ratad
 */
public class Grafo {
    List<Vertice> grafo= new ArrayList<Vertice>();
    List<Integer> pesos= new ArrayList<Integer>();
Vertice vertice;
public  void generarGrafo(int[][] laberinto,int dimension) {
	
	int contador=0;
	for(int i=0; i<dimension; i++) {
		for(int j=0; j<dimension; j++) {
			
			vertice= new Vertice(contador,laberinto[i][j]);
			contador++;
			grafo.add(vertice);
            pesos.add(laberinto[i][j]);
		}
	}
	
	
	for(int h=0; h<contador; h++) {
		System.out.println(grafo.get(h).toString());
	}
	
	vertice.encontarAdyacentes(laberinto, grafo, dimension,pesos);
}


public Vertice getVertice(int indice,List<Vertice> grafo1) {
for(int i=0; i<grafo1.size(); i++) {
	if(indice== grafo1.get(i).getId()) {
		vertice= grafo1.get(i);
	}
}

return vertice;
}
}

