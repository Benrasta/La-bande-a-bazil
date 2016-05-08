package Actions;
import Elements.Personages.Personnage;
import Ile.Parcelle;

public abstract class Action {

	private Personnage p;
	private Parcelle cible;
	
	
	public Action(Personnage p,Parcelle cible){
		this.p=p;
		this.cible=cible;
	}
	
	
	public Parcelle getCible() {
		return cible;
	}
	public void setCible(Parcelle cible) {
		this.cible = cible;
	}
	public Personnage getP() {
		return p;
	}
	public void setP(Personnage p) {
		this.p = p;
	}

	
}
