
public abstract class Personage {
	private boolean aArme;
	private int equipe;
	private int energie;
	private Parcelle p;
	private boolean aClef;
	private boolean aTresor;
	private int nbMine;
		
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
			if(this instanceof Guerrier){
				return "G";
			}else{
				if(this instanceof Piegeur){
					return "P";
				}else{
					if(this instanceof Voleur){
						return "V";
					}else{
						return "E";
					}
				}
			}
		}else{
			if(this instanceof Guerrier){
				return "g";
			}else{
				if(this instanceof Piegeur){
					return "p";
				}else{
					if(this instanceof Voleur){
						return "v";
					}else{
						return "e";
					}
				}
			}
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

	public boolean isaArme() {
		return aArme;
	}

	public void setaArme(boolean aArme) {
		this.aArme = aArme;
	}

	public int getNbMine() {
		return nbMine;
	}

	public void setNbMine(int nbMine) {
		this.nbMine = nbMine;
	}
		
	
	
}
