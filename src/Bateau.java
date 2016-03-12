import java.util.ArrayList;

public class Bateau {
	private int equipe;
	private Parcelle p;
	private ArrayList<Personage> lp;
	
	
	public Bateau(int equipe,Parcelle p){
		this.p=p;
		this.equipe=equipe;
		this.lp=new ArrayList<Personage>();
	}

	public Parcelle getP() {
		return p;
	}

	public void setP(Parcelle p) {
		this.p = p;
	}
	
	
}
