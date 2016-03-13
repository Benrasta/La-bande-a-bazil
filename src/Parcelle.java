import java.util.ArrayList;
public class Parcelle {
	
	private int x;
	private int y;

	
	Parcelle(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	boolean equals(Parcelle parcelle){
		if(parcelle.x == this.x && parcelle.y == this.y)
			return true;
		else
			return false;
	}
	
	boolean estPersonnage(Personnage personnage){ 			// comment est nommé le type personnage ? j'ai mis "valeur"
		if(personnage.valeur != 0)
			return true;
		else
			return false;
	}
	
	boolean estElement(Element element){
		if(element.type != 0)								// Si le type n'est pas egal a 0, alors c'est un element
			return true;
		else 
			return false;
	}
	
	boolean estBateau(ArrayList <Bateau> listeBateau){		// Regarde si la parcelle est presente dans la Array ou se trouve les bateaux	
		return( listeBateau.contains(new Parcelle(this.x,this.y)));
	}
	
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
	
}
