package app;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ratad
 */
public class Vertice {
    private List<Vertice> verticesAdyacentes= new ArrayList<Vertice>();
private int[][] indices;
Vertice vertice;
private int id;
private int peso;
private int ruta=10000;
Grafo gra= new Grafo();


public void encontarAdyacentes(int[][] laberinto, List<Vertice> grafo,int dimension,List<Integer> pesos) {
	indices= new int[dimension][dimension];
	int indice=0;
	//genero mi matriz de indices
	for(int i=0; i<dimension; i++) {
		for ( int j=0; j<dimension; j++) {
			indices[i][j]=indice;
			indice++;
		}
	}
	
	for(int i=0; i<dimension; i++) {
		for ( int j=0; j<dimension; j++) {
			if(pesos.get(indices[i][j])!=0){      
				if((i-1)>=0) {
					int idAd=indices[i-1][j];
					//extraigo adyascente arriba
										  //esta parte es la que modifique
										if(pesos.get(idAd)!=0){
										grafo.get(indices[i][j]).verticesAdyacentes.add(gra.getVertice(idAd, grafo));
										}
					if((i+1) < dimension) {
						//adyacente abajo
						int idArriba=indices[i+1][j];
										   if(pesos.get(idArriba)!=0 ){		
												grafo.get(indices[i][j]).verticesAdyacentes.add(gra.getVertice(idArriba, grafo));
											}
									}	
				}else {
					if((i+1) < dimension) {
						int idArriba=indices[i+1][j];
												 if(pesos.get(idArriba)!=0){
												//se añade los adya
												grafo.get(indices[i][j]).verticesAdyacentes.add(gra.getVertice(idArriba, grafo));
											}
					}
				}
				if((j-1)>=0) {
					int idIzquierda=indices[i][j-1];
									if(pesos.get(idIzquierda)!=0){
										//System.out.print(" , "+gra.getVertice(idIzquierda, grafo).toString());
										grafo.get(indices[i][j]).verticesAdyacentes.add(gra.getVertice(idIzquierda, grafo));
									}
					
					if((j+1)<dimension) {
						int id3=indices[i][j+1];
											if(pesos.get(id3)!=0){
												//System.out.println(" , "+gra.getVertice(id3, grafo).toString());
												grafo.get(indices[i][j]).verticesAdyacentes.add(gra.getVertice(id3, grafo));
											}
						
					}else {
						//System.out.println();
					}
				}else {
					if((j+1)<dimension) {
						int id2=indices[i][j+1];
											if(pesos.get(id2)!=0){
												//System.out.println(" , "+gra.getVertice(id2, grafo).toString());
											   grafo.get(indices[i][j]).verticesAdyacentes.add(gra.getVertice(id2, grafo));
											}
						
					}else {
						//System.out.println();
					}
				}
				
							}
			
		}
		//System.out.println();
	}

	
	
}






public Vertice(int id, int peso) {
	
	this.id = id;
	this.peso = peso;
}
public Vertice() {
	// TODO Auto-generated constructor stub
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
	return "Vertice [id=" + id + ", peso=" + peso + ", ruta=" + ruta + "]";
}






public int getRuta() {
	return ruta;
}

public void setRuta(int ruta) {
	this.ruta = ruta;
}



}
