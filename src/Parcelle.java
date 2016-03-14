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
	
	//constructeur de parcelle qui prend en paramètre des coordonnées et les affectent à une parcelle;
	public Parcelle (int x, int y){
		
		this.x = x;
		this.y = y;
			
	}
	//changer le SDD, passer en String et non en boolean !!
	//méthode qui permet de savoir si l'élément est un bateau 
	boolean EstBateau(){
		return this.estbateau;
		
	}
	boolean EstElement(){
		return this.estelement;
	}
	
	boolean EstPersonage(){
		return this.estperso;
	}
	
	
	
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
	
	
	

	
	

