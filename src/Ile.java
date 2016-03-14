import java.util.ArrayList;
import java.util.Random;

public class Ile {
	ArrayList<Personage> listperso;
	ArrayList<Element> listelement;
	private Parcelle [][] carte;
	 ArrayList<Bateau> listbateau;
	
	public Ile(){
		this.setCarte(new Parcelle[10][10]);
		this.listperso=new ArrayList<>();
		this.listelement=new ArrayList<>();
		this.listbateau=new ArrayList<>();
	}
	public Ile(int x,int y){
		this.setCarte(new Parcelle[x][y]);
		this.listperso=new ArrayList<>();
		this.listelement=new ArrayList<>();
		this.listbateau=new ArrayList<>();
	}
	
	
	public void initialized(){
		for(int i = 0; i<this.getCarte().length;i++ ){
			for(int j = 0; j < this.getCarte()[1].length;j++ ){
				this.carte[i][j]= new Parcelle(i,j);
			}
		}
		boolean [][] tmmp = new boolean[this.getCarte().length][this.getCarte()[1].length];
		int nbob = (int) ((this.getCarte().length * this.getCarte()[1].length) /10);
		int equi=2;
		while(equi >= 1){
			//coordoné aleatoire d'une parcel pour un bateau
			int j = new Random().nextInt(this.getCarte().length);
			int k = new Random().nextInt(this.getCarte()[1].length);
			if(tmmp[j][k] != true){
			this.listbateau.add(new Bateau(equi,new Parcelle(j,k)));
			carte[j][k].estbateau = true;
			tmmp[j][k] = true;
			equi --;
			}
		}
		//genere les Rochers élatoirement 
		while(nbob >0){
			int l = new Random().nextInt(this.getCarte().length);
			int m = new Random().nextInt(this.getCarte()[1].length);
			if(tmmp[l][m] != true){
				this.listelement.add(new Element(1,new Parcelle(l,m)));
				carte[l][m].estelement=true;
				tmmp[l][m]= true;
				nbob =nbob -1;
				}
				
			}
		}
		
	
	
	
	
	public String toString(){
		String res ="+-+-+-+-+-+-+-+-+-+-+"+"\n";
		for(int i = 0; i<this.getCarte().length;i++ ){
			res =res + "|";
			for(int j = 0; j < this.getCarte()[1].length;j++ ){
				
				if(carte[i][j].estbateau){
					if(this.listbateau.get(0).getP().getX()==i &&this.listbateau.get(0).getP().getY()== j ){
					char c =(char)((carte[i][j].tochar()-32));
					res = res +  c +"|";
					}
					else{
					res = res + carte[i][j].tochar()+  "|";
					}
				}else{
					res = res + carte[i][j].tochar()+  "|";
				}
			}
			res =res+"\n" +"+-+-+-+-+-+-+-+-+-+-+"+"\n";
		}
		return res;
	}
	
	
	
	public Parcelle [][] getCarte() {
		return carte;
	}
	public void setCarte(Parcelle [][] carte) {
		this.carte = carte;
	}
	
	
	
}
