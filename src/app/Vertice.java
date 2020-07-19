package app;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
private List<Vertice> verticesAdyacentes= new ArrayList<Vertice>();
private int[][] indices;
Vertice vertice;
private int id;
private int peso;
Grafo gra= new Grafo();

public void encontarAdyacentes(int[][] laberinto, List<Vertice> grafo,int dimension) {
	indices= new int[dimension][dimension];
	int indice=0;
	//genero mi matriz de indices
	for(int i=0; i<dimension; i++) {
		for ( int j=0; j<dimension; j++) {
			indices[i][j]=indice;
			indice++;
		}
	}
	
	System.out.println("tabla con los indices");
	for(int i=0; i<dimension; i++) {
		for ( int j=0; j<dimension; j++) {
			System.out.print("["+indices[i][j]+"] ");
			
		}
		System.out.println();
	}
	
	System.out.println("lista de adyacencia: ");
	
	for(int i=0; i<dimension; i++) {
		
		
		for ( int j=0; j<dimension; j++) {
			
			if((i-1)>=0) {
				int idAd=indices[i-1][j];
				//extraigo adyascente arriba
				System.out.print("Vertice numero: "+indices[i][j]+" Vertice Adyacente: "+gra.getVertice(idAd, grafo).toString());
				if((i+1) < dimension) {
					//adyacente abajo
					int idArriba=indices[i+1][j];
					System.out.print(", "+gra.getVertice(idArriba, grafo).toString());
				}
			}else {
				if((i+1) < dimension) {
					int idArriba=indices[i+1][j];
					System.out.print("Vertice numero: "+indices[i][j]+" Vertice Adyacente: "+gra.getVertice(idArriba, grafo).toString());
				}
			}
			
			
			if((j-1)>=0) {
				int idIzquierda=indices[i][j-1];
				System.out.print(" , "+gra.getVertice(idIzquierda, grafo).toString());
				if((j+1)<dimension) {
					int id3=indices[i][j+1];
					System.out.println(" , "+gra.getVertice(id3, grafo).toString());
				}else {
					System.out.println();
				}
			}else {
				if((j+1)<dimension) {
					int id2=indices[i][j+1];
					System.out.println(" , "+gra.getVertice(id2, grafo).toString());
				}else {
					System.out.println();
				}
			}
			
			
			
		}
		System.out.println();
	}
	
	
	
}

public Vertice() {
	
}
public Vertice(int id, int peso) {
	
	this.id = id;
	this.peso = peso;
}
public List<Vertice> getVerticesAdyacentes() {
	return verticesAdyacentes;
}
public void setVerticesAdyacentes(List<Vertice> verticesAdyacentes) {
	this.verticesAdyacentes = verticesAdyacentes;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getPeso() {
	return peso;
}
public void setPeso(int peso) {
	this.peso = peso;
}
@Override
public String toString() {
	return "Vertice [id=" + id + ", peso=" + peso + "]";
}


}
