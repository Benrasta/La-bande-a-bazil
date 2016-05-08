package Actions;
import Ile.Parcelle;

public class Mine {
	private Parcelle pmine;
	private int tour;
	private int equipe;
	
	
	/**
	 * Constructeur qui cree une mine appartenant a l'equipe
	 * 
	 * @param pmine
	 * @param equipe
	 */
	public Mine(Parcelle pmine,int equipe){
		this.pmine=pmine;
		this.equipe=equipe;
		tour=3;
	}
	
	/**
	 * affiche le mine en mode texte
	 * 
	 * @return 
	 */
	public String toString(){
		if(this.getEquipe()==1){
			return "M";
		}else{
			return "m";
		}
	}
	
	/**
	 * @return l'equipe de la mine
	 */
	public int getEquipe() {
		return equipe;
	}
	
	/**
	 * @return l'emplacement de la  mine
	 */
	public Parcelle getPmine() {
		return pmine;
	}
	
	/**
	 * retire un au nombre de tour ou la mine est encore présente
	 */
	public void setTour(){
		tour-=1;
	}
	
	/**
	 * @return le nombre de tour ou la mine est encore active
	 */
	public int getTour(){
		return tour;
	}
}
