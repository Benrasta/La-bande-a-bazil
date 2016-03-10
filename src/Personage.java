
public abstract class Personage {
	
	private int equipe;
	private int energie;
	private Parcelle p;
		
	public Personage(int equipe,int energie,Parcelle p){
		this.setEquipe(equipe);
		this.setEnergie(energie);
		this.setP(p);
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
	
}
