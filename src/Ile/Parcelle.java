package Ile;

import Elements.Personages.Personage;

/**
 * classe parcelle
 * @author doudou
 *
 */

public class Parcelle {
	private boolean estbateau = false;
	private boolean estperso = false;
	private boolean estelement =false;
	private boolean estCoffre = false;
	private boolean estMine= false;
	private boolean mort;
	private boolean aArme;
	private boolean aClef;
	private boolean aTresor;
	private int nbMine;

	

	private int x, y;  // coordonnées de la parcelle; 
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * constructeur de parcelle qui prend en paramètre des coordonnées et les affectent à une parcelle;
	 * @param x
	 * @param y
	 */
	
	public Parcelle (int x, int y){
		
		this.x = x;
		this.y = y;
			
	}
	
	
	/**
	 * méthode qui permet de savoir si l'élément est un bateau 
	 * @return
	 */
	public boolean getEstBateau(){
		return this.estbateau;
		
	}
	
	public void setEstBateau(boolean b){
		estbateau=b;
	}
	
	public boolean getEstCoffre(){
		return this.estCoffre;
	}
	
	public void setEstCoffre(boolean b){
		estCoffre=b;
	} 
	
	/**
	 * méthode qui permet de savoir si l'élément est un element
	 * @return
	 */
	public boolean getEstElement(){
		return this.estelement;
	}
	
	public void setEstElement(boolean b){
		estelement=b;
	}
	
	/**
	 * méthode qui permet de savoir si l'élément est un personage
	 * @return
	 */
	public boolean getEstPersonage(){
		return this.estperso;
	}
	
	public void setEstPersonage(boolean b){
		estperso=b;
	}
	
	public boolean getEstMine(){
		return this.estMine;
	}
	
	public void setEstMine(boolean b){
		estMine=b;
	}
	
	/**
	 * revoie vrai si la parcelle courante et meme que celle passer en paramètre
	 * @param parcelle
	 * @return
	 */
	boolean equals(Parcelle parcelle){
		if(parcelle.x == this.x && parcelle.y == this.y)
			return true;
		else
			return false;
	}
	
	
	
	/**
	 * revoie sous forme de String la parcel courante
	 * @return
	 */
	public String toString(){
		String res =" " ;
			if(this.getEstElement()){
				res="R";
			}else {
				res =" " ;
			}
		
		if(this.estCoffre){
			res ="C";
		}
		return res;
	}
	
	public void setMort(boolean Arme, boolean Clef, boolean Tresor, int Mine){
		mort=true;
		aArme=Arme;
		aClef=Clef;
		aTresor=Tresor;
		nbMine=Mine;
	}
	
	public boolean getMort(){
		return mort;
	}
	
	public void setInventaire(Personage p){
		if (!p.isaArme()){
			p.setaArme(aArme);
		}
		if(!p.isaClef()){
			p.setaClef(aClef);
		}
		if(!p.isaTresor()){
			p.setaTresor(aTresor);
		}
		p.setNbMine(p.getNbMine()+nbMine);
		aArme=false;
		aClef=false;
		aTresor=false;
		nbMine=0;
		mort=false;
		System.out.println("Vous recuperez l'inventaire de la personne qui est morte ici.");
	}
		
	
}
	
	
	

	
	

