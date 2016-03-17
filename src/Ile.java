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
		//initialize le tableau et creation des parcel;
		for(int i = 0; i<this.getCarte().length;i++ ){
			for(int j = 0; j < this.getCarte()[1].length;j++ ){
				this.carte[i][j]= new Parcelle(i,j);
			}
		}


		// fait un tableau de boolean de la même taille que l'ile 

		boolean [][] tmmp = new boolean[this.getCarte().length][this.getCarte()[1].length];

		// désigne le nombre de rocher qu'il y aura

		int nbob = (int) ((this.getCarte().length * this.getCarte()[1].length) /10);

		//nombre d'equipe

		int equi=2;

		while(equi >= 1){
			//coordoné aleatoire d'une parcelle pour un bateau sur le contour
			
			// je comprend pas comment ca marche...
				
			int j=0;
			int k =0;
			int pl= new Random().nextInt(4);
			if(pl == 0){
				j = new Random().nextInt(this.getCarte().length);
			}
			if(pl==1){
				k = new Random().nextInt(this.getCarte()[1].length);
			}
			if(pl==2){
				j=this.getCarte().length-1;
				k = new Random().nextInt(this.getCarte()[1].length);
			}
			if(pl==3){
				j = new Random().nextInt(this.getCarte().length);
				k=this.getCarte()[1].length-1;
			}

			// s'il n'y a pas deja un element sur la parcelle
			if(tmmp[j][k] != true){
			this.listbateau.add(new Bateau(equi,new Parcelle(j,k)));			
			carte[j][k].estbateau = true;	// met la parcelle en estBateau 
			tmmp[j][k] = true;		// il y a un bateau sur la parcelle
			equi --;			// passe à la deuxieme equipe
			}
		}

		//genere les Rochers élatoirement 
		while(nbob >0){
			int l = new Random().nextInt(this.getCarte().length);
			int m = new Random().nextInt(this.getCarte()[1].length);
			if(tmmp[l][m] != true){
				this.listelement.add(new Element(1,new Parcelle(l,m)));
				carte[l][m].estelement=true; 	// met le boolean de parcelle en element
				tmmp[l][m]= true;		// la parcelle est prise
				nbob =nbob -1;			// nombre de rocher -1
				}
				
			}
			//genere la cle et le coffre
			this.listelement.get(2).setElement(3);
			this.listelement.get(1).setElement(1);
		}
		
	
	
	
	// mode texte

	public String toString(){
		String res ="+-+-+-+-+-+-+-+-+-+-+"+"\n";
		for(int i = 0; i<this.getCarte().length;i++ ){
			res =res + "|";
			for(int j = 0; j < this.getCarte()[1].length;j++ ){
				
				if(carte[i][j].estbateau){
					if(carte[i][j].equals(this.listbateau.get(0).getP())){
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
