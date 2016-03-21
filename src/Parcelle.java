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
	boolean EstBateau(){
		return this.estbateau;
		
	}
	/**
	 * méthode qui permet de savoir si l'élément est un element
	 * @return
	 */
	boolean EstElement(){
		return this.estelement;
	}
	/**
	 * méthode qui permet de savoir si l'élément est un personage
	 * @return
	 */
	boolean EstPersonage(){
		return this.estperso;
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
	
	
	

	
	

