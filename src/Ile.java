import java.util.ArrayList;
import java.util.Random;

public class Ile {


	ArrayList<Personage> listperso;
	ArrayList<Element> listelement;
	private Parcelle [][] carte;
	 ArrayList<Bateau> listbateau;
	/**
	 * constructeur sans param�tre qui construit une carte de 10 sur 10
	 */
	public Ile(){
		this.setCarte(new Parcelle[10][10]);
		this.listperso=new ArrayList<>();
		this.listelement=new ArrayList<>();
		this.listbateau=new ArrayList<>();
	}
	/**
	 * contruit une carte de taille x,y
	 * @param x
	 * @param y
	 */
	public Ile(int x,int y){
		this.setCarte(new Parcelle[x][y]);
		this.listperso=new ArrayList<>();
		this.listelement=new ArrayList<>();
		this.listbateau=new ArrayList<>();
	}
	
	/**
	 * initialisation de l'Ile avec placement des el�ments et des bateaux
	 */
	public void initialized(int po){
		//initialize le tableau et creation des parcel;
		for(int i = 0; i<this.getCarte().length;i++ ){
			for(int j = 0; j < this.getCarte()[1].length;j++ ){
				this.carte[i][j]= new Parcelle(i,j);
			}
		}


		// fait un tableau de boolean de la m�me taille que l'ile 

		boolean [][] tmmp = new boolean[this.getCarte().length][this.getCarte()[1].length];

		// d�signe le nombre de rocher qu'il y aura

		int nbob =(int) ((this.getCarte().length * this.getCarte()[1].length)* po/100);

		//nombre d'equipe

		int equi=2;

		while(equi >= 1){
			//coordon� aleatoire d'une parcelle pour un bateau sur le contour
			
			// je comprend pas comment ca marche...
				
			int j=0;
			int k =0;
			int pl= new Random().nextInt(4);
			if(pl == 0){
				j = new Random().nextInt(this.getCarte().length-1)+1;
			}
			if(pl==1){
				k = new Random().nextInt(this.getCarte()[1].length-1)+1;
			}
			if(pl==2){
				j=this.getCarte().length-1;
				k = new Random().nextInt(this.getCarte()[1].length-1)+1;
			}
			if(pl==3){
				j = new Random().nextInt(this.getCarte().length-1)+1;
				k=this.getCarte()[1].length-1;
			}

			// s'il n'y a pas deja un element sur la parcelle
			if(tmmp[j][k] != true){
			this.listbateau.add(new Bateau(equi,new Parcelle(j,k)));			
			carte[j][k].estbateau = true;	// met la parcelle en estBateau 
			tmmp[j][k] = true;		// il y a un bateau sur la parcelle
			equi --;			// passe � la deuxieme equipe
			}
		}
		/*
		//cr�tion du chemin
		Random r= new Random();
		Parcelle p = new Parcelle(this.listbateau.get(0).getP().getX(),this.listbateau.get(0).getP().getY());
		int largeur =carte.length;
		int hauteur = carte[1].length;
		//bug boucle infini;
		while (p.getX() != largeur - 1 || p.getY() != hauteur - 1) {
			Parcelle init = p;
			if (r.nextBoolean()) {
				if (p.getX() + 1 <= largeur - 1) {
					p = new Parcelle(p.getX() + 1, p.getY());
				} else {
					if (p.getY() + 1 <= hauteur - 1) {
						p = new Parcelle(p.getX(), p.getY() + 1);
					}
				}
			} else {
				if (p.getY() + 1 <= hauteur - 1) {
					p = new Parcelle(p.getX(), p.getY() + 1);
				} else {
					if (p.getX() + 1 <= largeur - 1) {
						p = new Parcelle(p.getX() + 1, p.getY());
					}
				}
			}
			if (tmmp[p.getX()][p.getY()] != true) {
				tmmp[p.getX()][p.getY()] = true;
			} else {
				p = init;
			}
		}
		*/
		

		//genere les Rochers �latoirement 
		while(nbob >0){
			int l = new Random().nextInt(this.getCarte().length);
			int m = new Random().nextInt(this.getCarte()[1].length);
			if(tmmp[l][m] != true && l !=0 && m !=0 
					&& l !=this.getCarte().length-1 && m!=this.getCarte()[1].length-1 ){
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
	/**
	 * retourne la carte en mode texte;
	 */
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
	
	
	/**
	 * revoie la carte courante
	 * @return
	 */
	public Parcelle [][] getCarte() {
		return carte;
	}
	/**
	 ecrase la carte courante par celle donner en param�tre
	 * @param carte
	 */
	public void setCarte(Parcelle [][] carte) {
		this.carte = carte;
	}
	
	
	
}
