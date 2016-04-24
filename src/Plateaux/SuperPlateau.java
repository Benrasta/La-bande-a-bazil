package Plateaux;
import java.util.Random;

import Ile.Ile;
public class SuperPlateau {
	private Plateau p1;

	
	SuperPlateau(String[] gifs, int taille){
		p1 = new Plateau(gifs, taille);
	}
	
	void affichage(){
		p1.affichage();
	}
	
	int[][] getJeu(){
		return p1.getJeu();
	}
	
	void paintComponent(java.awt.Graphics g){
		//p1.paintComponent(g); ???
	}
	
	void setJeu(int[][] jeu){
		p1.setJeu(jeu);
	}
	
	boolean deplacer(int x, int y, int a, int b){
		int[][] tab = p1.getJeu();
		
		if(tab[a][b]==0){
			tab[a][b] = tab[x][y];
			tab[x][y] = 0;
			setJeu(tab);
			return true;
		}
		else return false;
		
			
	}
	
	
	
	public static void main(String[] args){
		
		Random r=new Random();
		String[] gifs={"images/arbre.png","images/rocher.png","images/1.navire.png",
				"images/2.navire.png","images/mer.png","images/coffre.png"};
		Ile carte= new Ile();
		carte.initialized(10);
		int taille =carte.getCarte().length;
		SuperPlateau p1 = new SuperPlateau(gifs, taille);
		int[][] jeu=new int[taille][taille];
		
		
		// Remplissage aléatoire du tableau
		/*
		for (int i=0;i<taille;i++)
			for (int j=0;j<taille;j++)
				jeu[i][j]=r.nextInt(gifs.length+1);
		
		p1.setJeu(jeu);
		p1.affichage();
		
		*/
		for (int i=0;i<taille;i++){
			for (int j=0;j<taille;j++){
				
					if(carte.getCarte()[i][j].getEstBateau() && 
							carte.getlistbateau().get(0).getP().equals(carte.getCarte()[i][j])){
						jeu[i][j]=4;
					}
					if(carte.getCarte()[i][j].getEstBateau() && 
							carte.getlistbateau().get(1).getP().equals(carte.getCarte()[i][j])){
						jeu[i][j]=3;
					}
					if(carte.getCarte()[i][j].getEstElement()){
						jeu[i][j]=2;
						for(int m = 0;m < carte.getlistelement().size();m++){
							if(carte.getlistelement().get(m).EstCoffre()){
								jeu[i][j]=6;
							}
						}
						
					}
					if(!carte.getCarte()[i][j].getEstElement() && !carte.getCarte()[i][j].getEstBateau() ){
						jeu[i][j]=1;
					}
				
			}
		}
		p1.setJeu(jeu);
		p1.affichage();
		
	}
}
