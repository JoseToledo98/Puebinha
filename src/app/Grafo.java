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
	algoritmoDijkstra(grafo);
}


public Vertice getVertice(int indice,List<Vertice> grafo1) {
for(int i=0; i<grafo1.size(); i++) {
	if(indice== grafo1.get(i).getId()) {
		vertice= grafo1.get(i);
	}
}

return vertice;
}

public void algoritmoDijkstra(List<Vertice> grafo) {
	grafo.get(0).setRuta(0);
	grafo.get(grafo.size()-1).setPeso(0);
	
	for(int i=0; i<grafo.size(); i++) {
		System.out.print("vertice "+i+" ");
		for( int j=0; j<grafo.get(i).getVerticesAdyacentes().size(); j++) {
			
			if(grafo.get(i).getRuta()==0) {
				
				grafo.get(i).getVerticesAdyacentes().get(j).setRuta(grafo.get(i).getVerticesAdyacentes().get(j).getPeso());
				
			}else {
				if(grafo.get(i).getRuta() != 100) {
					//cuando ya tiene un peso de ruta, se compara la suma del padre y su peso con el peso de ruta que ya tenia establecido
					
					int rutaTemporal=grafo.get(i).getRuta()+ grafo.get(i).getVerticesAdyacentes().get(j).getPeso();
					if(rutaTemporal<grafo.get(i).getVerticesAdyacentes().get(j).getRuta()) {
						grafo.get(i).getVerticesAdyacentes().get(j).setRuta(rutaTemporal);
					}
					
				}else{
					//cuando no tiene peso de ruta, se suma su peso, con el peso de ruta del padre
					int rutaNueva=grafo.get(i).getRuta()+grafo.get(i).getVerticesAdyacentes().get(j).getPeso();
					grafo.get(i).getVerticesAdyacentes().get(j).setRuta(rutaNueva);
				}
			}
			System.out.print(" "+grafo.get(i).getVerticesAdyacentes().get(j).toString());
		}
		System.out.println();
	}
}
}

