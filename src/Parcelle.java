import java.util.ArrayList;

/**
 * classe parcelle
 * @author doudou
 *
 */

public class Parcelle {
	boolean estbateau = false;
	boolean estperso = false;
	boolean estelement =false;


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
	boolean EstBateau(){
		return this.estbateau;
		
	}
	/**
	 * m�thode qui permet de savoir si l'�l�ment est un element
	 * @return
	 */
	boolean EstElement(){
		return this.estelement;
	}
	/**
	 * m�thode qui permet de savoir si l'�l�ment est un personage
	 * @return
	 */
	boolean EstPersonage(){
		return this.estperso;
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
	 * revoie sous forme de charactaire la parcel courante
	 * @return
	 */
	public char tochar(){
		char res =' ';
		if(this.EstBateau()){
			res='b'; 
		}else {
			if(this.EstElement()){
				res='R';
			}else {
				res =' ';
			}
		}
		
		return res;
	}
	
	
}
	
	
	

	
	

