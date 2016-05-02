package Autre;
import java.util.Scanner;

import Actions.Action;
import Actions.Deplacement;
import Elements.Personages.Explorateur;
import Elements.Personages.Guerrier;
import Elements.Personages.Piegeur;
import Elements.Personages.Voleur;
import Ile.Ile;

public class Main {

	public static int saisie(){
		Scanner sc = new Scanner(System.in);
		int i =0;
		while (sc.hasNextInt()) {
	          i = sc.nextInt();
	          return i;
		}
		return  i;
	}
	
	
	
	public static void main(String[] args) {
		
		Ile laplaya = new Ile();
		laplaya.initialized(10);
		System.out.println(laplaya.toString());
		int i=1;
		
		
		//initialisation des équipes
		laplaya.getlistperso().add(new Explorateur(1, 100, laplaya.getlistbateau().get(0).getP()));
		laplaya.getlistperso().add(new Voleur(1, 100, laplaya.getlistbateau().get(0).getP()));
		laplaya.getlistperso().add(new Guerrier(1, 100, laplaya.getlistbateau().get(0).getP()));
		laplaya.getlistperso().add(new Piegeur(1, 100, laplaya.getlistbateau().get(0).getP()));
		
		laplaya.getlistperso().add(new Explorateur(2, 100, laplaya.getlistbateau().get(1).getP()));
		laplaya.getlistperso().add(new Voleur(2, 100, laplaya.getlistbateau().get(1).getP()));
		laplaya.getlistperso().add(new Guerrier(2, 100, laplaya.getlistbateau().get(1).getP()));
		laplaya.getlistperso().add(new Piegeur(2, 100, laplaya.getlistbateau().get(1).getP()));

		
		boolean fini = false;
		
		while(!fini){
			System.out.println("joueur " + i + " qui veut tu utiliser ?");
			
			for(int x = 0; x < laplaya.getlistbateau().size();x ++){
				if(laplaya.getlistbateau().get(x).getEquipe()==i ){
					System.out.println("le perso à id "+ x+ " : " +laplaya.getlistbateau().get(x).toString()+ "  vie: "+laplaya.getlistperso().get(x).getEnergie());
					
				}
			}
			
			int choixPerso = saisie();
			if(laplaya.getlistperso().get(choixPerso).getEquipe()==i){
				if(laplaya.getlistperso().get(choixPerso) instanceof Guerrier){
					System.out.println(" a épée : "+laplaya.getlistperso().get(choixPerso).isaArme() );
				}else{
					if(laplaya.getlistperso().get(choixPerso) instanceof Piegeur){
						System.out.println(" mine en stock : "+laplaya.getlistperso().get(choixPerso).getNbMine() );
					}else{
						System.out.println(" a la clef : "+laplaya.getlistperso().get(choixPerso).isaClef() );
						System.out.println(" a le tresor : " +laplaya.getlistperso().get(choixPerso).isaTresor());
					}
				}

			System.out.println("joueur " + i + " que veut tu faire ?");
			System.out.println("1: deplacement?");
			System.out.println("2 agir?");
			int choix =saisie();
			if(i==1){
				System.out.println(laplaya.getlistperso().get(choixPerso).getP().getX()+";"+laplaya.getlistperso().get(choixPerso).getP().getY());
	
				System.out.println("joueur" + i + "ou veut tu te deplacer ?");
				System.out.println("x:");
				int x=saisie();
				System.out.println("y:");
				int y=saisie();
				
				if(x >=0 && y>=0 && x <laplaya.getCarte().length && y < laplaya.getCarte().length ){
					Action tmp = new Deplacement(laplaya.getlistperso().get(choixPerso),laplaya.getCarte()[x][y],new Jeu(laplaya));
					}
			}
				 if(choix ==2){
					System.out.println("ou agit tu?");
					System.out.println("x:");
					int x=saisie();
					System.out.println("y:");
					int y=saisie();
					if(x >=0 && y>=0 && x <laplaya.getCarte().length && y < laplaya.getCarte().length ){
						laplaya.getlistperso().get(choixPerso).Agit(laplaya.getCarte()[x][y],laplaya);
					}
				}
				
			
			}
			if(i==1){
				i=2;
			}else{
				i=1;
			}
			System.out.println(laplaya.toString());
			
			
			if(laplaya.getlistbateau().get(i-1).isTresor()){
				fini = true;
				System.out.println("le joueur"+ i +"a gagné");
				
			} else{
				int nbr1=0;
				int nbr2=0;
				for(int x = 0; x < laplaya.getlistperso().size(); x ++){
					if(laplaya.getlistperso().get(x).getEquipe()==1){
						nbr1 ++;
					}else{
						nbr2 ++;
					}
				}
				if( nbr1 == 0 || nbr2 == 0){
					fini =true;
					
				}
				
			}
			
			
		}	
	}

}
