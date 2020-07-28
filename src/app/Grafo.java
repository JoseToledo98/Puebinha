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
	grafo.get(grafo.size()-1).setRuta(0);
	System.out.println(grafo.size());
	for( int i=0; i<grafo.size();i++) {
		for( int j=0; j<grafo.get(i).getVerticesAdyacentes().size(); j++) {
			if(grafo.get(i).getPeso() != -2) {
			//cuando no tiene una ruta aun : (se suma la ruta del padre mas el peso que tiene ese vertice)
			if(grafo.get(i).getVerticesAdyacentes().get(j).getRuta()==1000) {
				int ruta= grafo.get(i).getRuta()+grafo.get(i).getVerticesAdyacentes().get(j).getPeso();
				grafo.get(i).getVerticesAdyacentes().get(j).setRuta(ruta);
			}else {
				//si la ruta que trae es mayor a la ruta que se genera atravez del vertice padre en la iteracion, se pone la ruta que se acab de generar 
				if(grafo.get(i).getVerticesAdyacentes().get(j).getRuta()> grafo.get(i).getRuta()+grafo.get(i).getVerticesAdyacentes().get(j).getPeso()) {
					grafo.get(i).getVerticesAdyacentes().get(j).setRuta(grafo.get(i).getRuta()+grafo.get(i).getVerticesAdyacentes().get(j).getPeso());
				}
			}
			}//asta aca
		}
	}
	
	System.out.println("VERTICE");
	for(int h=0; h<grafo.size();h++) {
		System.out.print(grafo.get(h)+"---PASO---"+(h+1)+" :");
		for( int g=0; g<grafo.get(h).getVerticesAdyacentes().size(); g++) {
			System.out.print("[ "+grafo.get(h).getVerticesAdyacentes().get(g).getId() +" ,"+grafo.get(h).getVerticesAdyacentes().get(g).getRuta()+"]");
		}
		System.out.println();
	}
	//
	boolean salida= false;
	int indice=grafo.size()-1;
	Vertice menor=null;
	int u=0;
	List<Vertice> rutaCorta= new ArrayList<>();
	while(salida== false ) {
		//asigno el menor ha el primer vertice adyacente del vertic padre grafo.get(indice);
		menor=grafo.get(indice).getVerticesAdyacentes().get(0);
		System.out.println("indice entrando despues del while: "+indice);
		//recorrere toda la lista de vertices adyaacentes del vertice padre, para checar cual tiene menor ruta , i= la posicion del vertice adyacente
		for( int i=0; i< grafo.get(indice).getVerticesAdyacentes().size(); i++) {
			//si el peso del vertice adyacente es -2 no se toma en cuenta
			if(grafo.get(indice).getVerticesAdyacentes().get(i).getPeso() != -2) {
				//verifico si el vertice es menor que el asignado al menor
			if(grafo.get(indice).getVerticesAdyacentes().get(i).getPeso()< menor.getPeso()) {
				//agrego al menor el vertice verificado
				menor=grafo.get(indice).getVerticesAdyacentes().get(i);
				//ingreso el vertice menor a mi lista de ruta
				rutaCorta.add(menor);
				//guardo el id del vertice menor para volver hacer el mismo procedimiento con el
				
				System.out.println(menor);
				indice=menor.getId();
				
			}else {
				if(grafo.get(indice).getVerticesAdyacentes().get(i).getPeso() == menor.getPeso()){
				//pasar el indice del primer vertice adyacente del vertice menor
				if(menor.getVerticesAdyacentes().get(0).getPeso() != -2) {
				indice=menor.getVerticesAdyacentes().get(0).getId();
				System.out.println("se corto el curso por que no hay menor que el primer vertice adyacente indice=");
				System.out.println(menor);
				System.out.println("adyacente 0: "+menor.getVerticesAdyacentes().get(0));
				System.out.println("indice saliendo del for "+indice);
				rutaCorta.add(menor);
				
				//salida=true;
				}
				}else {
					
				}
			}
			
			//si encuentro un vertice con indice -1 es la salida y acaba el programa
			
			
			}
		}
		u++;
		if(u==10) {
			salida=true;
		}
	}
	System.out.println(rutaCorta);
	
	
}
}

