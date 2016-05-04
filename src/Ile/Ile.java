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
import Elements.Personages.Personage;
import Elements.Personages.Voleur;
import Plateaux.SuperPlateauIterable;

public class Ile {


	private ArrayList<Personage> listperso;
	private ArrayList<Element> listelement;
	private Parcelle [][] carte;
	private ArrayList<Bateau> listbateau;
	private ArrayList<Mine> listmine;
	private SuperPlateauIterable p1;
	private int taille;
	private int[][] jeu;
	private String[] gifs={"Chemin.png","Rocher.png","Eau.png","Brouillard","Coffre.png",
			"BateauBleu.png","ExplorateurBleu.png","VoleurBleu.png","GuerrierBleu.png","PiegeurBleu.png","TrouBleu.png",
			"BateauRouge.png","ExplorateurRouge.png","VoleurRouge.png","GuerrierRouge.png","PiegeurRouge.png","TrouRouge.png"};
	/**
	 * constructeur sans param�tre qui construit une carte de 10 sur 10
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
	 * initialisation de l'Ile avec placement des el�ments et des bateaux
	 */
	public void initialized(int po){

		taille=carte.length+2;
		p1 = new SuperPlateauIterable(gifs, taille);
		jeu=new int[taille][taille];

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
				equi --;			// passe � la deuxieme equipe
			}
		}

		//cr�tion du chemin
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
		while(id>0){
			int i= new Random().nextInt(this.getCarte().length);
			int j= new Random().nextInt(this.getCarte().length);
			if( i!=0 && j!=0 && i!=this.getCarte().length-1 && j!=this.getCarte().length-1 && tmmp[i][j]!=true){
				if(tmmp[i][j] || tmmp[i][j+1] || tmmp[i-1][j] || tmmp[i][j-1]){
					this.listelement.add(new Element(id,new Parcelle(i,j)));
					id--;
					tmmp[i][j]=true;
					carte[i][j].setEstElement(true);
					//System.out.println(i +" " + j);
				}
			}
		}
		//System.out.println(this.listelement.get(0).getPe().getX()+" "+this.listelement.get(0).getPe().getY());
		//genere les Rochers �latoirement 
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
					if(carte[i][j].getEstPersonage()){
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

	public void affichagebrouillard(){
		for (int i=0;i<taille;i++){
			for (int j=0;j<taille;j++){
				jeu[i][j]=4;
			}
		}
	}

	public void affichagehumain(int equipe){
		affichagebrouillard();
		for(Personage perso: listperso){
			if(perso.getEquipe()==equipe){
				for(int i=-1; i<=1; i++){
					for(int j=-1; j<=1; j++){
						if(perso.getP().getX()+i+1>0 && perso.getP().getY()+j+1>0 && perso.getP().getX()+i+1<=carte.length && perso.getP().getY()+j+1<=carte.length){

							if(carte[perso.getP().getX()+i][perso.getP().getY()+j].getEstBateau() && 
									listbateau.get(0).getP().equals(carte[perso.getP().getX()+i][perso.getP().getY()+j])){
								jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=6;
							}else if(carte[perso.getP().getX()+i][perso.getP().getY()+j].getEstBateau()){
								jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=12;
							}else if(carte[perso.getP().getX()+i][perso.getP().getY()+j].getEstPersonage()){
								int l=0;
								while (!listperso.get(l).getP().equals(carte[perso.getP().getX()+i][perso.getP().getY()+j])){
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
							}else if(carte[perso.getP().getX()+i][perso.getP().getY()+j].getEstElement()){
								jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=2;
								if(listelement.get(0).getPe().equals(carte[perso.getP().getX()+i][perso.getP().getY()+j])&& perso.isaTresor()){
									jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=5;

								}
							}else if (carte[perso.getP().getX()+i][perso.getP().getY()+j].getEstMine()){
								int l=0;
								while (!listmine.get(l).getPmine().equals(carte[perso.getP().getX()+i][perso.getP().getY()+j])){
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
							}else{
								jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=1;
							}

						}else{
							jeu[perso.getP().getX()+i+1][perso.getP().getY()+j+1]=3;
						}
					}
				}
			}
		}

	}

	public void affichageIA(){
		for(int i=0; i<jeu.length; i++){
			for(int j=0; j<jeu.length; j++){
				if(i>0 && j>0 && i<=carte.length && j<=carte.length){

					if(carte[i-1][j-1].getEstBateau() && 
							listbateau.get(0).getP().equals(carte[i-1][j-1])){
						jeu[i][j]=6;
					}else if(carte[i-1][j-1].getEstBateau()){
						jeu[i][j]=12;
					}else if(carte[i-1][j-1].getEstPersonage()){
						int l=0;
						while (!listperso.get(l).getP().equals(carte[i-1][j-1])){
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
					}else if(carte[i-1][j-1].getEstElement()){
						jeu[i][j]=2;
						if(listelement.get(0).getPe().equals(carte[i-1][j-1])){
							jeu[i][j]=5;

						}
					}else if (carte[i-1][j-1].getEstMine()){
						int l=0;
						while (!listmine.get(l).getPmine().equals(carte[i-1][j-1])){
							l++;
						}
						if(listmine.get(l).getEquipe()==1){
							jeu[i][j]=11;
						}else{
							jeu[i][j]=17;
						}
					}else{
						jeu[i][j]=1;
					}

				}else{
					jeu[i][j]=3;
				}
			}
		}
	}

	public void affichage(int equipe, Jeu j){
		//affectation de la carte dans un tableau d'entiers
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
	 ecrase la carte courante par celle donner en param�tre
	 * @param carte
	 */
	public void setCarte(Parcelle [][] carte) {
		this.carte = carte;
	}

	public ArrayList<Personage> getlistperso(){
		return listperso;
	}

	public void setlistperso (ArrayList<Personage> list){
		listperso=list;
	}

	public ArrayList<Element> getlistelement(){
		return listelement;
	}

	public void setlistelement (ArrayList<Element> list){
		listelement=list;
	}

	public ArrayList<Bateau> getlistbateau(){
		return listbateau;
	}

	public void setlistbateau (ArrayList<Bateau> list){
		listbateau=list;
	}

	public ArrayList<Mine> getlistmine(){
		return listmine;
	}

	public void setlistmine (ArrayList<Mine> list){
		listmine=list;
	}

	public SuperPlateauIterable getPlateau(){
		return p1;
	}

	public void FinDeJeu(int equipe){
		p1.close();
		JOptionPane op=new JOptionPane();
		op.showMessageDialog(op, "Fin Du Jeu, Equipe " + equipe+ " a gagn�",null,JOptionPane.INFORMATION_MESSAGE);
	}
}
