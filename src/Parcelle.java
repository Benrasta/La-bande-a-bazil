import java.util.ArrayList;

/**
 * classe parcelle
 * @author doudou
 *
 */

public class Parcelle {

	private int x, y;  // coordonn�es de la parcelle; 
	private boolean Bateau, Element, Personnage;  // boolean qui peremet de savoir la pr�sence d'un bateau ou element ou personnage; 
	
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
	
	//constructeur de parcelle qui prend en param�tre des coordonn�es et les affectent � une parcelle;
	public Parcelle (int x, int y){
		
		this.x = x;
		this.y = y;
			
	}
	//changer le SDD, passer en String et non en boolean !!
	//m�thode qui permet de savoir si l'�l�ment est un bateau 
	boolean EstBateau(ArrayList<Bateau> listbateau){
		if(this.equals(listbateau.get(0).getP())||this.equals(listbateau.get(1).getP())){  //getp return la parcel de la list debateau al'indice donn�
			return true;
	}
		else return false;
	}
	
	//renvoie le contenu en String de la parcelle � l'indice x et y donn�, pour cela doit aller piocher l'indice dans la liste d'�l�ments
	String contenu(int x, int y, Parcelle[][] parcelle){
		if ( parcelle[x][y].equals(listElement.getPe()) )
			
		
	}
	
	
	
	
	//Essai perso pour comprendre l'h�ritage;
	class ParcelleVide extends Parcelle {
		
		private String vide;
		public ParcelleVide(int x, int y, String v){
			super(x,y);
			this.vide = v;
		}
	}
	
	
	
	
}
