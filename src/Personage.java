
public abstract class Personage {
	
	private int equipe;
	private int energie;
	private Parcelle p;
	private boolean aClef;
	private boolean aTresor;
		
	public Personage(int equipe,int energie,Parcelle p){
		this.equipe=equipe;
		this.energie=energie;
		this.p=p;
	
	}

	public int getEquipe() {
		return equipe;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public Parcelle getP() {
		return p;
	}

	public void setP(Parcelle p) {
		this.p = p;
	}

	public String toString(){
		if(this.equipe ==1){
			return "P";
		}else{
			return "p";
		}
		
	}

	public abstract void Agit(Parcelle cible,Ile ile);

	public boolean isaTresor() {
		return aTresor;
	}

	public void setaTresor(boolean aTresor) {
		this.aTresor = aTresor;
	}

	public boolean isaClef() {
		return aClef;
	}

	public void setaClef(boolean aClef) {
		this.aClef = aClef;
	}
		
	
	
}
