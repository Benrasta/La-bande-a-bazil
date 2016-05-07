package Elements.Personages;
import javax.swing.JOptionPane;

import Autre.Jeu;
import Ile.Ile;
import Ile.Parcelle;

public abstract class Personage {
	private boolean aArme;
	private boolean aClef;
	private boolean aTresor;
	private int nbMine;
	private int equipe;
	private int energie;
	private Parcelle p;
	private boolean action;
	private int tour;
	private boolean vie;
		
	public Personage(int equipe,int energie,Parcelle p){
		this.equipe=equipe;
		this.energie=energie;
		this.p=p;
		vie=true;	
	}
	
	public void echange(Parcelle cible, Jeu jeu){
		Ile ile = jeu.getIle();
		
		int px=p.getX();
		int py=p.getY();
		int cx=cible.getX();
		int cy=cible.getY();
		
		if( this instanceof Explorateur){
			if((py-1==cy && px==cx)|| (px-1==cx && py==cy) || (px+1==cx&&py==cy) || (py+1==cy && px==cx) ){
				if(cible.getEstPersonage()){
					int i=0;
					while(cible != ile.getlistperso().get(i).getP()){
						i++;
					}
					if(equipe == ile.getlistperso().get(i).getEquipe()) {
						// afficher joption pane menu déroulant
						// verifiant les boolean est afficher les trues
						//cliquer sur ce qui vuet
						// mettre les booleans à faux
						// lui mettre sur son stuff ile.getlistperso().get(i) passe a vrai
					}
				}
			
			}
		}else  {
			
		}
	}
	
	
	public int getEquipe() {
		return equipe;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		if (energie>100){
			energie=100;
		}
		if (energie<0){
			energie=0;
		}
		this.energie = energie;
		System.out.println(this.getnom()+" : "+this.energie+" energies.");
	}

	public Parcelle getP() {
		return p;
	}

	public void setP(Parcelle p) {
		this.p = p;
	}

	public String toString(){
		if(this.equipe ==1){
			if(this instanceof Guerrier){
				return "G";
			}else{
				if(this instanceof Piegeur){
					return "P";
				}else{
					if(this instanceof Voleur){
						return "V";
					}else{
						return "E";
					}
				}
			}
		}else{
			if(this instanceof Guerrier){
				return "g";
			}else{
				if(this instanceof Piegeur){
					return "p";
				}else{
					if(this instanceof Voleur){
						return "v";
					}else{
						return "e";
					}
				}
			}
		}
		
	}

	public abstract void Agit(Parcelle cible,Ile ile);

	public boolean isaTresor() {
		return aTresor;
	}

	public void setaTresor(boolean aTresor) {
		this.aTresor = aTresor;
	}

	public boolean isaClef() {
		return aClef;
	}

	public void setaClef(boolean aClef) {
		this.aClef = aClef;
	}

	public boolean isaArme() {
		return aArme;
	}

	public void setaArme(boolean aArme) {
		this.aArme = aArme;
	}

	public int getNbMine() {
		return nbMine;
	}

	public void setNbMine(int nbMine) {
		this.nbMine = nbMine;
	}
	
	public boolean getaction(){
		return action;
	}
	
	public void setaction(boolean b){
		action = b;
	}
	
	public int gettour(){
		return tour;
	}
	
	public void settour(){
		tour-=1;
	}
	
	public void dansMine(){
		tour=3;
	}
	
	public void mort(Ile ile){
		JOptionPane.showMessageDialog(new JOptionPane(), getnom() +" de l'equipe" +equipe+" est mort",null,JOptionPane.INFORMATION_MESSAGE);
		p.setEstPersonage(false);
		vie=false;
		p.setMort(aArme, aClef, aTresor, nbMine);
	}
	
	public boolean getVie(){
		return vie;
	}
		
	public abstract String getnom();
	
}
