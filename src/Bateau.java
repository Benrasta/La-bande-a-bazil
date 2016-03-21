import java.util.ArrayList;

public class Bateau {
	private int equipe;
	private Parcelle p;
	private ArrayList<Personage> lp;
	
	/**
	 * contruit un bateau
	 * @param equipe
	 * @param p
	 */
	public Bateau(int equipe,Parcelle p){
		this.p=p;
		this.equipe=equipe;
		this.lp= new ArrayList<Personage>();
	}
	/**
	 * revoie la parcelle courante 
	 * @return
	 */
	public Parcelle getP() {
		return p;
	}

	/**
	 * revoie la liste des personnage contenue dans le bateau
	 * @return
	 */
	public ArrayList<Personage> getLp() {
		return lp;
	}
	/**
	 * revoie l'equipe a qui apartien le bateau
	 * @return
	 */
	public int getEquipe() {
		return equipe;
	}
	/**
	 * remplace l'équipe courante par celle entré en paramètre 
	 * @param equipe
	 */
	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}
	
	
}
