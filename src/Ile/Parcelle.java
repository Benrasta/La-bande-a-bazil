package Ile;

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

	

	private int x, y;  // coordonn�es de la parcelle; 
	
	
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
	 * constructeur de parcelle qui prend en param�tre des coordonn�es et les affectent � une parcelle;
	 * @param x
	 * @param y
	 */
	
	public Parcelle (int x, int y){
		
		this.x = x;
		this.y = y;
			
	}
	
	
	/**
	 * m�thode qui permet de savoir si l'�l�ment est un bateau 
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
	 * m�thode qui permet de savoir si l'�l�ment est un element
	 * @return
	 */
	public boolean getEstElement(){
		return this.estelement;
	}
	
	public void setEstElement(boolean b){
		estelement=b;
	}
	
	/**
	 * m�thode qui permet de savoir si l'�l�ment est un personage
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
	 * revoie vrai si la parcelle courante et meme que celle passer en param�tre
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
	

	

	
	}
	
	
	

	
	
