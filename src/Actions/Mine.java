package Actions;
import Ile.Parcelle;

public class Mine {
	private Parcelle pmine;
	private int tour;
	private int equipe;
	
	public Mine(Parcelle pmine,int equipe){
		this.pmine=pmine;
		this.equipe=equipe;
		tour=3;
	}

	public String toString(){
		if(this.getEquipe()==1){
			return "M";
		}else{
			return "m";
		}
	}
	
	
	public int getEquipe() {
		return equipe;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}

	public Parcelle getPmine() {
		return pmine;
	}

	public void setPmine(Parcelle pmine) {
		this.pmine = pmine;
	}
	
	public void setTour(){
		tour-=1;
	}
	
	public int getTour(){
		return tour;
	}
}
