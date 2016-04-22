package Autre;
import java.util.Random;

import javax.swing.JOptionPane;

import Elements.Personages.Explorateur;
import Elements.Personages.Personage;
import Ile.Ile;
import Plateaux.SuperPlateauIterable;

public class mainIHM {
//test
	
	
	
	
	
	
	public static void main(String args[]){
		//boite de dialogue 
		JOptionPane d = new JOptionPane();
		String tailtab="";
		//tand que l'entrer et inferieure a 6 relancer la boite dialogue
		while(tailtab==""){
			tailtab= d.showInputDialog(d,"Entrer la taille ( minimum 7 )","taille",JOptionPane.INFORMATION_MESSAGE);
			int tcarte= Integer.parseInt(tailtab);
			if(tcarte <=6){
				d.showMessageDialog(d, "Le nombre est inferieure à 7","erreur",JOptionPane.WARNING_MESSAGE);
				tailtab="";
			}
		}
		//tand que l'entrer et inferieure a 10  ou superieure a 50 relancer la boite dialogue 
		String pourcent= "";
		int p=0;
		while(pourcent==""){
			pourcent= d.showInputDialog(d,"Entrer le pourcentage d'obstacle( minimum 10 et maximum 50 )","%",JOptionPane.INFORMATION_MESSAGE);
			p= Integer.parseInt(pourcent);
			if(p <=9||p >=51){
				d.showMessageDialog(d, "Le nombre est inferieure à 100 ou superieure a 50","erreur",JOptionPane.WARNING_MESSAGE);
				pourcent="";
			}
		}
		
		//initialisation de la carte et du superplateau
		Random r=new Random();
		String[] gifs={"images/arbre.png","images/rocher.png","images/1.navire.png",
				"images/2.navire.png","images/mer.png","images/coffre.png",
				"images/1.explorateur.png","images/.explorateur.png"};
		int tcarte= Integer.parseInt(tailtab);
		
		Ile carte= new Ile(tcarte,tcarte);
		carte.initialized(p);
		int taille =carte.getCarte().length+2;
		SuperPlateauIterable p1 = new SuperPlateauIterable(gifs, taille,true);
		int[][] jeu=new int[taille][taille];
		//affectation de la carte dans un tableau d'entiers
		for (int i=0;i<taille;i++){
			for (int j=0;j<taille;j++){
				if(i>0 && j>0 && i<=carte.getCarte().length && j<=carte.getCarte().length){
					
					if(carte.getCarte()[i-1][j-1].getEstBateau() && 
							carte.getlistbateau().get(0).getP().equals(carte.getCarte()[i-1][j-1])){
						jeu[i][j]=4;
					}
					if(carte.getCarte()[i-1][j-1].getEstBateau() && 
							carte.getlistbateau().get(1).getP().equals(carte.getCarte()[i-1][j-1])){
						jeu[i][j]=3;
					}
					if(carte.getCarte()[i-1][j-1].getEstElement()){
						jeu[i][j]=2;
						if(carte.getlistelement().get(0).getPe().equals(carte.getCarte()[i-1][j-1])){
							jeu[i][j]=6;
							
						}
					}
					
					
					
					if(!carte.getCarte()[i-1][j-1].getEstElement() && !carte.getCarte()[i-1][j-1].getEstBateau()){
						jeu[i][j]=1;
					}
					
				}else{
					jeu[i][j]=5;
				}
			}
		}
		
		Personage pe1 = new Explorateur(1, 100, carte.getlistbateau().get(0).getP());
		Personage pe2 = new Explorateur(2, 100, carte.getlistbateau().get(1).getP());
		carte.getlistperso().add(pe1);
		carte.getlistperso().add(pe2);
		
		
		
		
		
		p1.setJeu(jeu);
		p1.affichage();
		/*
		while(true){
		MouseEvent m1 =new MouseEvent();
				
		}
		*/
		
		
	}
}
