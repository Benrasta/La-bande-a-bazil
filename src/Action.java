
public abstract class Action {

	private Personage p;
	private Parcelle cible;
	
	
	public Action(Personage p,Parcelle cible){
		this.p=p;
		this.cible=cible;
	}
	
	
	public Parcelle getCible() {
		return cible;
	}
	public void setCible(Parcelle cible) {
		this.cible = cible;
	}
	public Personage getP() {
		return p;
	}
	public void setP(Personage p) {
		this.p = p;
	}

	
}
