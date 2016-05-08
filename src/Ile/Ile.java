package Ile;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import Actions.Mine;
import Autre.Jeu;
import Elements.Bateau;
import Elements.Element;
import Elements.Personages.Explorateur;
import Elements.Personages.Guerrier;
import Elements.Personages.Personnage;
import Elements.Personages.Voleur;
import Plateaux.SuperPlateauIterable;

public class Ile {


	private ArrayList<Personnage> listperso;
	private ArrayList<Element> listelement;
	private Parcelle [][] carte;
	private ArrayList<Bateau> listbateau;
	private ArrayList<Mine> listmine;
	private SuperPlateauIterable p1;
	private int coffre;
	private int taille;
	private int[][] jeu;
	private String[] gifs={"Chemin.png","Rocher.png","Eau.png","Brouillard","Coffre.png", //1à5
			"BateauBleu.png","ExplorateurBleu.png","VoleurBleu.png","GuerrierBleu.png","PiegeurBleu.png","TrouBleu.png", //6à11
			"BateauRouge.png","ExplorateurRouge.png","VoleurRouge.png","GuerrierRouge.png","PiegeurRouge.png","TrouRouge.png",//12à17
			"Mort.png","X.png","Y.png",//18à20
			"0.png","1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png","9.png",//21 à 30
			"10.png","11.png","12.png","13.png","14.png","15.png",};// 31 à 36
	/**
	 * constructeur sans parametre qui construit une carte de 10 sur 10
	 */
	public Ile(){
		this.setCarte(new Parcelle[10][10]);
		this.listperso=new ArrayList<>();
		this.listelement=new ArrayList<>();
		this.listbateau=new ArrayList<>();
		this.listmine=new ArrayList<>();
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
		this.listmine=new ArrayList<>();
	}

	/**
	 * initialisation de l'Ile avec placement des elements et des bateaux
	 */
	public void initialized(int po){

		taille=carte.length+4;
		p1 = new SuperPlateauIterable(gifs, taille);
		jeu=new int[taille][taille];

		//initialize le tableau et creation des parcel;
		for(int i = 0; i<this.getCarte().length;i++ ){
			for(int j = 0; j < this.getCarte()[1].length;j++ ){
				this.carte[i][j]= new Parcelle(i,j);
			}
		}


		// fait un tableau de boolean de la meme taille que l'ile 

		boolean [][] tmmp = new boolean[this.getCarte().length][this.getCarte()[1].length];

		// dï¿½signe le nombre de rocher qu'il y aura


		int nbob =(int) ((this.getCarte().length * this.getCarte()[1].length)* po/100);


		//nombre d'equipe

		int equi=2;

		while(equi >= 1){
			//coordonï¿½ aleatoire d'une parcelle pour un bateau sur le contour

			// je comprend pas comment ca marche...

			int j=0;
			int k =1;
			if(equi ==2){
				k  = new Random().nextInt(this.getCarte()[1].length-1)+1;
			} else {
				j=this.getCarte()[1].length-1;
				k  = new Random().nextInt(this.getCarte()[1].length-1)+1;
			}

			// s'il n'y a pas deja un element sur la parcelle
			if(tmmp[j][k] != true){
				this.listbateau.add(new Bateau(equi,new Parcelle(j,k)));			
				carte[j][k].setEstBateau(true);	// met la parcelle en estBateau 
				tmmp[j][k] = true;		// il y a un bateau sur la parcelle
				equi --;			// passe ï¿½ la deuxieme equipe
			}
		}

		//crï¿½tion du chemin
		Parcelle p = new Parcelle(this.listbateau.get(0).getP().getX(),this.listbateau.get(0).getP().getY());
		int largeur =this.listbateau.get(1).getP().getX();
		int hauteur = this.listbateau.get(1).getP().getY();
		//genere une parti du chemin en x
		while (p.getX() != largeur){
			if(p.getX()!= largeur){
				if(p.getX()< largeur){
					p.setX(p.getX()+1);
				} else{
					if(p.getX() >largeur){
						p.setX(p.getX()-1);
					} 
				}
			}
			tmmp[p.getX()][p.getY()] = true;
		}
		//genere une parti du chemin en y
		while (p.getY() != hauteur){
			if(p.getX()==largeur && p.getY() != hauteur){
				if( p.getY() < hauteur){
					p.setY(p.getY()+1);
				} else{
					if( p.getY()> hauteur){
						p.setY(p.getY()-1);
					}
				}
			}
			tmmp[p.getX()][p.getY()] = true;
		}

		//generation de la clef et du coffre a coter du chemin

		int id =3;
		while(id>1){
			int i= new Random().nextInt(this.getCarte().length);
			int j= new Random().nextInt(this.getCarte().length);
			if( i!=0 && j!=0 && i!=this.getCarte().length-1 && j!=this.getCarte().length-1 && tmmp[i][j]!=true){
				if(tmmp[i][j] || tmmp[i][j+1] || tmmp[i-1][j] || tmmp[i][j-1]){
					this.listelement.add(new Element(id,new Parcelle(i,j)));
					id--;
					tmmp[i][j]=true;
					carte[i][j].setEstElement(true);
					if (id==2){
						System.out.println(this.listelement.get(0).getPe().getX()+" / "+this.listelement.get(0).getPe().getY());
						carte[i][j].setEstCoffre(true);
					}else{
						System.out.println(this.listelement.get(1).getPe().getX()+" + "+this.listelement.get(1).getPe().getY());
						carte[i][j].setEstClef(true);
					}
				}
			}
		}
		//genere les Rochers ï¿½latoirement 
		while(nbob >0){
			int l = new Random().nextInt(this.getCarte().length);
			int m = new Random().nextInt(this.getCarte()[1].length);
			if(tmmp[l][m] != true ){
				this.listelement.add(new Element(1,new Parcelle(l,m)));
				carte[l][m].setEstElement(true); 	// met le boolean de parcelle en element
				tmmp[l][m]= true;		// la parcelle est prise
				nbob =nbob -1;			// nombre de rocher -1
			}

		}


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

				if(carte[i][j].getEstBateau()){
					for(int x= 0 ;x <this.listbateau.size(); x++){
						if(carte[i][j].equals(this.listbateau.get(x).getP())){
							res= res +this.listbateau.get(x).toString() + "|";
						}
					}
				}else{
					if(carte[i][j].getEstPersonnage()){
						for(int x =0;  x < this.listperso.size(); x++){
							if(carte[i][j].equals(this.listperso.get(x).getP())){
								res= res + this.listperso.get(x).toString();
							}
						}

					} else{
						if(carte[i][j].getEstMine()){
							for(int x = 0; x < this.listmine.size();x++){
								if(carte[i][j].equals(this.listmine.get(x).getPmine())){
									res= res + this.listmine.get(x).toString();
								}
							}
						} else{
							res = res + carte[i][j].toString()+  "|";
						}
					}



				}
			}
			res =res+"\n" +"+-+-+-+-+-+-+-+-+-+-+"+"\n";
		}
		return res;
	}

	/**
	 * remplit le tableau de jeu avec l'image du brouillard
	 */
	public void affichagebrouillard(){
		for (int i=0;i<taille;i++){
			for (int j=0;j<taille;j++){
				if (!(i==0 || i==jeu.length-1 || j==0 || j==jeu.length-1)){
					jeu[i][j]=4;
				}
			}
		}
	}

	/**
	 * affiche le plateau avec le brouillard de guerre
	 * 
	 * @param equipe
	 */
	public void affichagehumain(int equipe){
		affichagebrouillard();
		for(Personnage perso: listperso){
			if(perso.getEquipe()==equipe){
				for(int i=0; i<=2; i++){
					for(int j=0; j<=2; j++){
						if(perso.getP().getX()+i+1>1 && perso.getP().getY()+j+1>1 && perso.getP().getX()+i+1<=carte.length+1 && perso.getP().getY()+j+1<=carte.length+1){

							if(carte[perso.getP().getX()+i-1][perso.getP().getY()+j-1].getEstBateau() && 
									listbateau.get(0).getP().equals(carte[perso.getP().getX()+i-1][perso.getP().getY()+j-1])){
								jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=6;
							}else if(carte[perso.getP().getX()+i-1][perso.getP().getY()+j-1].getEstBateau()){
								jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=12;
							}else if(carte[perso.getP().getX()+i-1][perso.getP().getY()+j-1].getEstPersonnage()){
								int l=0;
								while (!listperso.get(l).getP().equals(carte[perso.getP().getX()+i-1][perso.getP().getY()+j-1])){
									l++;
								}
								int k=6;
								if(listperso.get(l).getEquipe()==2){
									k+=6;
								}
								if(listperso.get(l) instanceof Explorateur){
									k+=1;
								}else if(listperso.get(l) instanceof Voleur){
									k+=2;
								}else if(listperso.get(l) instanceof Guerrier){
									k+=3;
								}else{
									k+=4;
								}
								jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=k;
							}else if(carte[perso.getP().getX()+i-1][perso.getP().getY()+j-1].getEstElement()){
								jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=2;
								if(carte[perso.getP().getX()+i-1][perso.getP().getY()+j-1].getEstCoffre() && (coffre==3|| coffre==perso.getEquipe())){
									jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=5;

								}
							}else if (carte[perso.getP().getX()+i-1][perso.getP().getY()+j-1].getEstMine()){
								int l=0;
								while (!listmine.get(l).getPmine().equals(carte[perso.getP().getX()+i-1][perso.getP().getY()+j-1])){
									l++;
								}
								if (listmine.get(l).getEquipe()==equipe){
									if(listmine.get(l).getEquipe()==1){
										jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=11;
									}else{
										jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=17;
									}
								}else{
									jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=3;
								}
							}else if (carte[perso.getP().getX()+i-1][perso.getP().getY()+j-1].getMort()){
								jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=18;
							}else{
								jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=1;
							}

						}else if (!(perso.getP().getX()+i+1==0 || perso.getP().getY()+j+1==0 || perso.getP().getX()+i+1==jeu.length-1 || perso.getP().getY()+j+1==jeu.length-1)){
							jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=3;
						}
					}
				}
			}
		}

	}

	/**
	 * affiche le plateau de jeu sans brouillard
	 */
	public void affichageIA(){
		for(int i=0; i<jeu.length; i++){
			for(int j=0; j<jeu.length; j++){
				if(i>1 && j>1 && i<=carte.length+1 && j<=carte.length+1){

					if(carte[i-2][j-2].getEstBateau() && 
							listbateau.get(0).getP().equals(carte[i-2][j-2])){
						jeu[i][j]=6;
					}else if(carte[i-2][j-2].getEstBateau()){
						jeu[i][j]=12;
					}else if(carte[i-2][j-2].getEstPersonnage()){
						int l=0;
						while (!listperso.get(l).getP().equals(carte[i-2][j-2])){
							l++;
						}
						int k=6;
						if(listperso.get(l).getEquipe()==2){
							k+=6;
						}
						if(listperso.get(l) instanceof Explorateur){
							k+=1;
						}else if(listperso.get(l) instanceof Voleur){
							k+=2;
						}else if(listperso.get(l) instanceof Guerrier){
							k+=3;
						}else{
							k+=4;
						}
						jeu[i][j]=k;
					}else if(carte[i-2][j-2].getEstElement()){
						jeu[i][j]=2;
						if(listelement.get(0).getPe().equals(carte[i-2][j-2])){
							jeu[i][j]=5;

						}
					}else if (carte[i-2][j-2].getEstMine()){
						int l=0;
						while (!listmine.get(l).getPmine().equals(carte[i-2][j-2])){
							l++;
						}
						if(listmine.get(l).getEquipe()==1){
							jeu[i][j]=11;
						}else{
							jeu[i][j]=17;
						}
					}else if(carte[i-2][j-2].getMort()){
						jeu[i][j]=18;
					}else{
						jeu[i][j]=1;
					}

				}else if(!(i==0 || i==jeu.length-1 || j==0 || j==jeu.length-1)){
					jeu[i][j]=3;
				}
			}
		}
	}

	/**
	 * remplit les bords du plateau avec les chiffre
	 * permet de lancer l'affichage correct (IA ou Humain)
	 * 
	 * @param equipe
	 * @param j
	 */
	public void affichage(int equipe, Jeu j){
		//affectation de la carte dans un tableau d'entiers
		int k=19;
		for(int i=0; i<jeu.length; i++){
			for(int l=0; l<jeu.length; l++){
				if((i==0 && l==0)||(i==0 && l==jeu.length-1) || (l==0 && i==jeu.length-1)||(i==jeu.length-1 && l==jeu.length-1)){
					jeu[i][l]=5;
				}else if(i==0 || i==jeu.length-1 ){
					if(l==1 || l==jeu.length-2 ){
						jeu[i][l]=20;
					}else{
						jeu[i][l]=k+l;
					}
				}else if(l==0 || l==jeu.length-1){
					if(i==1|| i==jeu.length-2){
						jeu[i][l]=19;
					}else{
						jeu[i][l]=k+i;
					}
				}
			}
		}
		if(j.getHumain()){
			affichagehumain(equipe);
		}else{
			affichageIA();
		}


		p1.setJeu(jeu);
		p1.affichage();
	}

	// 

	/**
	 * revoie la carte courante
	 * @return
	 */
	public Parcelle [][] getCarte() {
		return carte;
	}
	/**
	 ecrase la carte courante par celle donner en paramï¿½tre
	 * @param carte
	 */
	public void setCarte(Parcelle [][] carte) {
		this.carte = carte;
	}

	/**
	 * revoie la liste des personnages
	 * 
	 * @return
	 */
	public ArrayList<Personnage> getlistperso(){
		return listperso;
	}

	/**
	 * revoie la liste des element
	 * 
	 * @return
	 */
	public ArrayList<Element> getlistelement(){
		return listelement;
	}

	/**
	 * revoie la liste des bateaux
	 * 
	 * @return
	 */
	public ArrayList<Bateau> getlistbateau(){
		return listbateau;
	}

	/**
	 * revoie la liste des mines
	 * 
	 * @return
	 */
	public ArrayList<Mine> getlistmine(){
		return listmine;
	}

	/**
	 * quitte le jeu et affiche qui a gagné
	 * 
	 * @param equipe
	 */
	public void FinDeJeu(int equipe){
		p1.close();
		JOptionPane.showMessageDialog(new JOptionPane(), "Fin Du Jeu, Equipe " + equipe+ " a gagne",null,JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * prend le numéro de l'equipe qui a trouver le coffre
	 * 
	 * @param equipe
	 */
	public void setCoffre(int equipe) {
		coffre+=equipe;
	}
	
}
