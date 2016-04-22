package Elements;
import java.util.ArrayList;

import Elements.Personages.Personage;
import Ile.Parcelle;

public class Bateau {
	private int equipe;
	private Parcelle p;
	public ArrayList<Personage> lp;
	private boolean tresor;
	
	/**
	 * contruit un bateau
	 * @param equipe
	 * @param p
	 */
	public Bateau(int equipe,Parcelle p){
		this.setTresor(false);
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
	
	public String toString(){
		if(this.getEquipe()==1){
			return "B";
		}else{
			return "b";
		}
	}
	public boolean isTresor() {
		return tresor;
	}
	public void setTresor(boolean tresor) {
		this.tresor = tresor;
	}
	
	
}
