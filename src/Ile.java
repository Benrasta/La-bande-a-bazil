import java.util.ArrayList;

public class Ile {
	ArrayList<Personage> listperso;
	//ArrayList<Element> listelement;
	private Parcelle [][] carte;
	public static ArrayList<Bateau> listbateau;
	
	public Ile(Parcelle[][] carte){
		this.carte=carte;
		this.listperso=new ArrayList<>();
		//this.listelement=new ArrayList<>();
	}
	boolean EstBateau(){
		if(this.equals(listbateau.get(0).getP())||this.equals(listbateau.get(1).getP())){  //getp return la parcel de la list debateau al'indice donné
			return true;
	}
		else return false;
	}
	
	
	
}
