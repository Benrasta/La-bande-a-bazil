package Ile;

import Elements.Personages.Personnage;

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
	private boolean estClef = false;
	private boolean estMine= false;
	private boolean mort;
	private boolean aArme;
	private boolean aClef;
	private boolean aTresor;
	private int nbMine;

	

	private int x, y;  // coordonnées de la parcelle; 
	
	/**
	 * @return la coordonnee X de la parcelle
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * change la coordonnee X de la parcelle
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @return la coordonnee Y de la parcelle
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * change la coordonnee Y de la parcelle
	 * 
	 * @param y
	 */
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
	
	/**
	 * Cree ou enleve un bateau sur la parcelle
	 * 
	 * @param b
	 */
	public void setEstBateau(boolean b){
		estbateau=b;
	}
	
	/**
	 * @return si il y a un coffre sur la parcelle
	 */
	public boolean getEstCoffre(){
		return this.estCoffre;
	}
	
	/**
	 * Cree ou enleve un coffre sur la parcelle
	 * 
	 * @param b
	 */
	public void setEstCoffre(boolean b){
		estCoffre=b;
	} 
	/**
	 * @return si il y a une clef sur la parcelle
	 */
	public boolean getEstClef(){
		return this.estClef;
	}
	
	/**
	 * Cree ou enleve une clef sur la parcelle
	 * 
	 * @param b
	 */
	public void setEstClef(boolean b){
		estClef=b;
	} 
	/**
	 * méthode qui permet de savoir si l'élément est un element
	 * @return
	 */
	public boolean getEstElement(){
		return this.estelement;
	}
	
	/**
	 * Cree ou enleve un element sur la parcelle
	 * 
	 * @param b
	 */
	public void setEstElement(boolean b){
		estelement=b;
	}
	
	/**
	 * méthode qui permet de savoir si l'élément est un personnage
	 * @return
	 */
	public boolean getEstPersonnage(){
		return this.estperso;
	}
	
	/**
	 * Met ou enleve un personnage sur la parcelle
	 * 
	 * @param b
	 */
	public void setEstPersonnage(boolean b){
		estperso=b;
	}
	
	/**
	 * @return si il y a une mine sur la parcelle
	 */
	public boolean getEstMine(){
		return this.estMine;
	}
	
	/**
	 * Cree ou enleve une mine sur la parcelle
	 * 
	 * @param b
	 */
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
	
	/**
	 * Depose de l'quipement sur la parcelle et y cree un mort
	 * 
	 * @param Arme
	 * @param Clef
	 * @param Tresor
	 * @param Mine
	 */
	public void setMort(boolean Arme, boolean Clef, boolean Tresor, int Mine){
		mort=true;
		aArme=Arme;
		aClef=Clef;
		aTresor=Tresor;
		nbMine=Mine;
	}
	
	/**
	 * @return si il y a un mort sur la parcelle
	 */
	public boolean getMort(){
		return mort;
	}
	
	/**
	 * Transefere l'quipement qui est sur la parcelle, dans l'quipement du personnage p
	 * 
	 * @param p
	 */
	public void setInventaire(Personnage p){
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
	
	
	

	
	

